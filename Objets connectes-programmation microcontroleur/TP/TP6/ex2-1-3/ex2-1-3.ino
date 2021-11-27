const int PIN_LED_RED =  25;
const int PIN_LED_GREEN =  26;

void setup() {
  // On commence avec les LED éteintes
  // On allule progressivement la LED rouge
  for (int i = 0; i <= 255; i++) { //Tant que i n'a pas atteint le max, on incrémente
    dacWrite(PIN_LED_RED, i) // DAC 8 bits, donc valeur entre 0 et 255
    delay (10);
  }

  // On allume progressivement la LED verte pour avoir le mélange
  for (int i = 0; i <= 255; i++) { //Tant que i n'a pas atteint le max, on incrémente
    dacWrite(PIN_LED_GREEN, i) // DAC 8 bits, donc valeur entre 0 et 255
    delay (10);
  }

  // On éteint progressivement la LED rouge
  for (int i = 255; i >= 0; i--) { //Tant que i n'a pas atteint le max, on décrémente
    dacWrite(PIN_LED_RED, i) // DAC 8 bits, donc valeur entre 0 et 255
    delay (10);
  }

  // On éteint progressivement la LED verte
  for (int i = 255; i >= 0; i--) { //Tant que i n'a pas atteint le max, on décrémente
    dacWrite(PIN_LED_GREEN, i) // DAC 8 bits, donc valeur entre 0 et 255
    delay (10);
  }

  // Pause
  delay(500);
}

void loop() {
}
