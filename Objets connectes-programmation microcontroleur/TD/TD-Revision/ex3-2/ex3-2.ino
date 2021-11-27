#define Ca 17
#define Cb 18
#define D 14
#define G 15

//on considère qu’il y les fichiers .h nécéssaires, y compris page.h
AsyncWebServer server(80);

const char* ssid = "OCPM"; // nom du hotspot qui sera créé
void notFound(AsyncWebServerRequest *request) { // callback pour navigation non conforme
request->send(404, "text/plain", "Not found");
}

void setup() {
  Serial.begin(115200);
  pinMode(Ca, INPUT);
  pinMode(Cb, INPUT);
  pinMode(D, OUTPUT);
  pinMode(G, OUTPUT);
  Serial.print("Setting AP (Access Point)...");
  WiFi.softAP(ssid); // Creation d’un réseau ouvert, pas de mot de passe
  IPAddress IP = WiFi.softAPIP();
  Serial.print("AP IP address: ");
  Serial.println(IP);
  // mise en place des callbacks
  server.onNotFound(notFound);
  server.on("/marche",HTTP_GET, handleMarche); // Configuration du serveur pour la route /marche
  server.begin();
}

loop() { 
  valCa = digitalRead(Ca);
  valCb = digitalRead(Cb);
  if (valCb == HIGH){ //Si le chariot touche Cb
    digitalWrite (D,LOW); //On coupe le moteur de droite
    digitalWrite (G,HIGH); //On va à gauche
  }
  if (valCa == HIGH){ //Si le chariot touche Ca
    digitalWrite (G,LOW); //On va à droite
  }
}

void handleMarche() {
  digitalWrite (D,HIGH); //On va à droite
}
