//Exercice 3 - partie 1
#include <WiFiUdp.h>
#include <NTPClient.h> // si requete NTP
#include <HTTPClient.h>
#define uS_TO_S_FACTOR 1000000  // Convertir les secondes en microsecondes
#define TIME_TO_SLEEP  10       // Le temps durant lequel le microcontroleur va dormir (en seconde)
const char *networkName = "XXX"; // SSID de votre access point Wifi
const char *networkPswd = "YYY"; //Si connection avec portable mettre mdp
const char * ntpAdress = "80.67.184.129";  // OVH NTP server ntp.midway.ovh
const int ntpOffset = 7200;                // UTC+2 summer time (3600 x 2). Set to 3600 if winter time
const unsigned int ntpInterval = 60*1000;  // refresh interval
WiFiUDP ntpUDP;
// instanciation d'un objet de type NTPClient
NTPClient timeClient(ntpUDP, ntpAdress, ntpOffset, ntpInterval);


void setup() {
    Serial.begin(115200);
    pinMode(GPIO_NUM_12, INPUT_PULLUP);
    esp_sleep_enable_timer_wakeup(TIME_TO_SLEEP * uS_TO_S_FACTOR);
    esp_sleep_enable_ext0_wakeup(GPIO_NUM_12, LOW); //Quand on appuie sur le bouton, le microcontroleur se réveille
    analogSetPinAttenuation(A3, ADC_0db); // eventuellement, pour le capteur de luminosite
    // ne rien faire sur l’entrée A4 : 1V = valeur 1088
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

    //On est maintenant connecté à internet donc on prepare une requête HTTP
    String request = "https://bbessere.lpmiaw.univ-lr.fr/collecte/test.php?name=PEARSON"; // ou alors collecte.php
    String temps = timeClient.getFormattedTime();
    int valA3 = analogRead(A3); // resultat de la conversion A->N, correspondant a la tension sur A3
    int valA4 = analogRead(A4); // resultat de la conversion A->N, correspondant a la tension sur A4
    float temp = convert2Temp(valA4);
    Serial.print("Temperature :");
    Serial.print(temp);
    Serial.print(" Luminosite : ");
    Serial.println(valA3);
    delay(100); //0,1s
    // ? à la place d'un espace pour donner name en paramètre à la requête
    // & entre chaque params pour ajouter plusieurs paramètres
    HTTPClient http;
    request = request+"&time="+temps+"&temp="+temp+"&lum="+valA3;
    Serial.println(request);
    http.begin(request);
    //On exécute la requête
    int httpResponseCode = http.GET(); // send request
    Serial.println(httpResponseCode);
    esp_deep_sleep_start();
    
}

float convert2Temp(int val) {
    float tension = 0.25*3.3+0.028*val;
    //tension = tension/1024.0;
    //float temp = (tension - 0.028)*100;
    return ((float) tension);
}

void loop(){}

//https://bbessere.lpmiaw.univ-lr.fr/collecte/test.php <- aller voir ce site pour vérifier que tout à fonctionné
