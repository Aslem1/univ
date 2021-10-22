#include <WiFiUdp.h>
// #include <NTPClient.h> // si requete NTP
#include <HTTPClient.h>
const char *networkName = "Plouf"; // SSID de votre access point Wifi (ou plouf si connection avec portable)
//const char *networkPswd = "22670e2e8e16"; //Si connection avec portable mettre mdp

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
    WiFi.begin(networkName, networkPswd); //Si on utilise le telephone, utiliser cette ligne
    WiFi.begin(networkName);
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
    
}

void loop(){
  //On est maintenant connecté à internet donc on prepare une requête HTTP
    char request[] = "http://bbessere.lpmiaw.univ-lr.fr/collecte/test.php?name=PERRIN" // ou alors collecte.php
    // ? à la place d'un espace pour donner name en paramètre à la requête
    // & entre chaque params pour ajouter plusieurs paramètres
    HTTPClient http;
    // mettre ici votre code pour completer la chaine de caractères request, rajoutez au moins name=NNNNNNN
    http.begin(request);
    //On exécute la requête
    int httpResponseCode = http.GET(); // send request
  }

//https://bbessere.lpmiaw.univ-lr.fr/collecte/test.php <- aller voir ce site pour vérifier que tout à fonctionné
