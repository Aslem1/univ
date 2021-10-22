```//Exercice 3 - partie 1
#include <WiFiUdp.h>
#include <NTPClient.h> // si requete NTP
#include <HTTPClient.h>
const char *networkName = "Nikki's Galaxy S10+"; // SSID de votre access point Wifi
const char *networkPswd = "nikki4848"; //Si connection avec portable mettre mdp
const char * ntpAdress = "80.67.184.129";  // OVH NTP server ntp.midway.ovh
const int ntpOffset = 7200;                // UTC+2 summer time (3600 x 2). Set to 3600 if winter time
const unsigned int ntpInterval = 60*1000;  // refresh interval
WiFiUDP ntpUDP;
// instanciation d'un objet de type NTPClient
NTPClient timeClient(ntpUDP, ntpAdress, ntpOffset, ntpInterval);

void setup() {
    Serial.begin(115200);
    //DO NOT TOUCH
    // This is here to force the ESP32 to reset the WiFi and initialise correctly.
    WiFi.disconnect(true);
    delay(1000);
    WiFi.mode(WIFI_STA);
    delay(1000);
    // End silly stuff !!
    // connect to Access Point with password
    //WiFi.begin(networkName, networkPswd); //Si on utilise le telephone, utiliser cette ligne
    WiFi.begin(networkName, networkPswd);
    // connect to Open Access Point without password
    // WiFi.begin(networkName);
    Serial.printf("Try connexion to %s\n", networkName);
    long signalStrength;
    while (WiFi.status() != WL_CONNECTED) {
        delay(1000);
        signalStrength = WiFi.RSSI();
        Serial.printf("RSSi: %ld dBm\n",signalStrength);
    }

    // now connected to WiFi, got IP from DHCP
    Serial.println("IP address: ");
    Serial.println(WiFi.localIP());
    timeClient.begin();
    timeClient.update(); 
}

void loop(){
    //On est maintenant connecté à internet donc on prepare une requête HTTP
    String request = "https://bbessere.lpmiaw.univ-lr.fr/collecte/test.php?name=NIVET"; // ou alors collecte.php
    String temps = timeClient.getFormattedTime();
    // ? à la place d'un espace pour donner name en paramètre à la requête
    // & entre chaque params pour ajouter plusieurs paramètres
    HTTPClient http;
    request = request+"&time="+temps;
    Serial.println(request);
    http.begin(request);
    //On exécute la requête
    int httpResponseCode = http.GET(); // send request
    Serial.println(httpResponseCode);

}

//https://bbessere.lpmiaw.univ-lr.fr/collecte/test.php <- aller voir ce site pour vérifier que tout à fonctionné```
