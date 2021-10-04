#define X 14
#define LOW 0
#define HIGH 1
void setup() {
  pinMode(LED_BUILTIN, OUTPUT);
  pinMode(X, INPUT_PULLUP);
}

void loop() {
  int value = digitalRead(X);
  int etat = digitalRead(LED_BUILTIN);

  if (value == LOW) {
    unsigned long tempsDebut = millis(); // Temps au moment ou on appuie sur le bouton
    unsigned long intervalle = tempsDebut + 5000; // Temps de début + 5 sec
    unsigned long tempsActuel = millis();// Temps actuel

    while (tempsActuel != intervalle) {
      digitalWrite(LED_BUILTIN, HIGH); // Le bouton reste allumé tant que le 5 sec sont pas écoulées
      tempsActuel = millis(); // On réactualise le temps
    }
    digitalWrite(LED_BUILTIN, LOW); // Après les 5 sec la LED s'éteint
  }
}
