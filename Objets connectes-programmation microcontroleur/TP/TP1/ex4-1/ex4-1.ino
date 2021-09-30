#define X 14
#define LOW 0
#define HIGH 1

void setup() {
  pinMode(LED_BUILTIN,OUTPUT);
  pinMode(X,INPUT);
}

void loop() {
  int nombre;
  while(!Serial.available()); // attente bloquante d’une frappe clavier dans le terminal
  nombre = Serial.parseInt(); // si le code ASCII saisi est un entier, alors il est converti
  myFlash(2000,nombre); // appel de la fonction
}

void myFlash(int period, int nb) {
  for(int i = 0; i < nb; i++){ 
    digitalWrite(LED_BUILTIN, HIGH); // On allume la LED
    delay(period/2); // On attend 1 demie periode
    digitalWrite(LED_BUILTIN, LOW); // On éteint la LED
    delay(period/2); // On attend 1 demie periode
  }
}
