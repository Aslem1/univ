// Question 1 - En utilisant les branchements direct comme sur la photo on ne pourra pas allumer les 3 canaux de couleurs.
// Le bleu ne fonctionnera pas car il est relié à un port input seulement.
const int PIN_LED_RED =  25;
const int PIN_LED_GREEN =  26;

void setup() {
  // On allume la LED rouge
  digitalWrite(PIN_LED_RED,HIGH);
  delay(500);
  
  // On allume la LED verte
  digitalWrite(PIN_LED_GREEN,HIGH);
  delay(500);

  // On éteint la LED rouge
  digitalWrite(PIN_LED_RED,LOW);
  delay(500);

  //On éteint la LED verte
  digitalWrite(PIN_LED_GREEN,LOW);
}

void loop() {
}
