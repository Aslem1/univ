/**********************************************************************
   Contrôle d'un servomoteur au moyen d'une page Web.
   ESP32 et ESP8266
   https://electroniqueamateur.blogspot.com/2018/09/servomoteur-controle-par-wi-fi-esp8266.html
***********************************************************************/

// inclusion des bibliothèques utiles
#if defined ARDUINO_ARCH_ESP32  // s'il s'agit d'un ESP32
#include "WiFi.h"
#include <WebServer.h>
#endif

/*#include <Servo.h>  // s'il s'agit d'un ESP32, il faut installer une version spéciale
                    // de la bibliothèque servo: 
                    // https://github.com/RoboticsBrno/ESP32-Arduino-Servo-Library
*/

//#include <ServoTimers.h> //https://github.com/arduino-libraries/Servo/blob/master/src/stm32f4/ServoTimers.h
#include <Servo.h>

// modifiez ces deux constantes pour qu'elles contiennent les caractéristiques de
// votre réseau Wifi
#define ssid      "***"       // le nom (SSID) de votre réseau WiFi
#define password  "****"  // votre mot de passe WiFi

// le servomoteur est contrôlé par les GPIO 25 de l'ESP32
#define pinServo 25

#if defined ARDUINO_ARCH_ESP32  // s'il s'agit d'un ESP32
WebServer server(80);
#endif

Servo monServo;  //création de l'objet servo

// La variable qui indique la position désirée pour le servomoteur (dépend du bouton coché sur la page web)
String positionSTR = "1";          // peut prendre les valeurs 1, 2 ou 3.

/* La fonction construitPage retourne un string qui contient toute notre page web  */

String construitPage() {

  String bouton1Str, bouton2Str, bouton3Str;

  // pour que le bon bouton demeure coché:

  if (positionSTR == "1") {
    bouton1Str = "checked";
  }
  if (positionSTR == "2") {
    bouton2Str = "checked";
  }
  if (positionSTR == "3") {
    bouton3Str = "checked";
  }

  String page = "<html lang=fr-FR><head>";
  page += "<title>ESP8266 Servomoteur</title>";
  page += "<style> body { background-color: #fffff; font-family: Arial, Helvetica, Sans-Serif; Color: #000088; }</style>";
  page += "</head><body><h1>ESP8266 Servomoteur</h1>";
  page += "<form action='/' method='POST'>";
  page += "<h3>Position du servomoteur:</h3>";
  page += "<p><INPUT type='radio' name='position' value='1' " + bouton1Str + ">A";
  page += "<INPUT type='radio' name='position' value='2' " + bouton2Str + ">B";
  page += "<INPUT type='radio' name='position' value='3' " + bouton3Str + ">C</p>";

  page += "<INPUT type='submit' value='Appliquer'><br><br>";
  page += "</body></html>";
  return page;
}

/*  La fonction gestionPage modifie les caractéristiques du moteur si le bouton
    Appliquer a été cliqué. */
void gestionPage() {
  if ( server.hasArg("position") ) {
    positionSTR = server.arg("position");

    Serial.print("Commande recue.  Position: ");
    Serial.println(positionSTR);

    gestionMoteur();
  }
  server.send ( 200, "text/html", construitPage() );

}

/* Contrôle du servomoteur */
void gestionMoteur() {

  int laPosition;

  if (positionSTR == "1") {
    laPosition = 30;
  }

  if (positionSTR == "2") {
    laPosition = 90;
  }

  if (positionSTR == "3") {
    laPosition = 150;
  }

  monServo.write(laPosition);
}

void setup() {

  monServo.attach(pinServo);

  // pour affichage dans le moniteur série
  Serial.begin ( 115200 );

  // initialisation de la communication WiFi
  WiFi.begin ( ssid, password );
  while ( WiFi.status() != WL_CONNECTED ) {
    delay ( 500 ); Serial.print ( "." );
  }
  Serial.println ( "" );
  Serial.print ( "Maintenant connecte a " );
  Serial.println ( ssid );
  Serial.print ( "Adresse IP: " );
  Serial.println ( WiFi.localIP() );

  // On indique le nom de la fonction qui gère l'interraction avec la page web
  server.on ( "/",  gestionPage );

  server.begin();
  Serial.println ( "Serveur HTTP en fonction" );
}

void loop() {

  server.handleClient();
}
