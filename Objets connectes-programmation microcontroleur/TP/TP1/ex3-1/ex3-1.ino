#define X 14
#define LOW 0
#define HIGH 1
void setup() {
  pinMode(LED_BUILTIN,OUTPUT);
  pinMode(X,INPUT);
}

void loop() {
  int value = digitalRead(X);
  int etat = digitalRead(LED_BUILTIN);
  if (value == LOW){ // le bouton est appuyé
    digitalWrite(LED_BUILTIN, !etat); //on change l'état de la LED
    }
    while(value == LOW){ //Tant qu'on appuie sur le bouton
      value = digitalRead(X); //On vérifie l'etat du bouton
    }

}
