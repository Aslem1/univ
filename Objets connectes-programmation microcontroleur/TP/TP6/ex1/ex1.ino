WiFi.softAP("PERRIN"); // No password parameter, if you want the AP (Access Point) to be open
IPAddress IP = WiFi.softAPIP(); // Créer le hotspot wifi
String ipString = ipToString(IP);
String PAGE_LED_ON = "<!doctype html><html lang="fr"><head><meta charset="utf-8"><title>Commande LED</title><style>body{zoom: 200%;}</style><script></script></head><body><h1>Commande LED</h1><p>La LED est allumée</p><a href=\"http://" + ipString + "/off\">Eteindre</a></body></html>";
String PAGE_LED_OFF = "<!doctype html><html lang="fr"><head><meta charset="utf-8"><title>Commande LED</title><style>body {zoom: 200%;}</style><script></script></head><body><h1>Commande LED</h1><p>La LED est éteinte</p><a href=\"http://" + ipString + "/on\">Allumer</a></body></html>";

void setup() {
  Serial.begin(115200);
  pinMode(LED_BUILTIN,OUTPUT);
  WiFiServer server(80); // Lance le serveur HTTP sur le port 80
  // Quand on ira sur l'ip de l'ESP32/on ça renverra ce qu'on a mis dans la fonction "callback_to_call"
  server.on("/on",HTTP_GET, handleOn); // Configuration du serveur pour la route /on
  server.on("/off",HTTP_GET, handleOff); // Configuration du serveur pour la route /off 
}

void loop(){
  WiFiClient client = server.available();   // Listen for clients
  while (client.connected()) {              // loop while thenclient's connected
    if (client.available()) {               // if there's bytes to read from the client,
      char c = client.read();                      
    }
  }
}

// fonctions appelées lors des appels HTTP
void handleOn() {
  // allumer la LED
  digitalWrite(LED_BUILTIN,HIGH);
  Serial.println("fonction on appelée");
  server.send(200, "text/html", PAGE_LED_ON); 
}

void handleOff() {
  // éteindre la LED
  digitalWrite(LED_BUILTIN,LOW);
  Serial.println("fonction off appelée");
  server.send(200, "text/html", PAGE_LED_OFF); 
}

// Conversion octet par octet d'un objet IPAdress en String correspondant
// 1 octet = 8 bits / 1Mo = 8Mb
// 1 octet = 1 byte / 1Mo = 1MB
String ipToString(IPAddress ip){
  String s="";
  // IP = 192.168.1.13
  // 0em tour : ""
  // 1er tour : "192"
  // 2nd tour : "192.168"
  // 3em tour : "192.168.1.13"
  for (int i=0; i<4; i++)
    // condition ternaire : c'est un if.
    // "si i" veut dire "si i != 0"
    // condition ? action si vrai : action si faux
    s += i  ? "." + String(ip[i]) : String(ip[i]);
  return s;
}
