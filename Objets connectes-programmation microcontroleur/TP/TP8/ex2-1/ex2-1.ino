#define PIN_DATA 12
#define PIN_CLOCK 13

void setup() {
  pinMode(PIN_DATA, OUTPUT);
  pinMode(PIN_CLOCK, OUTPUT);
  
  digitalWrite(PIN_DATA, HIGH);
  digitalWrite(PIN_CLOCK, LOW); //Force à zero
}

void loop() {
  for(int i = 1; i <= 7; i++){ //On décale les LED jusqu'a la derniere
    SetValue(i); //On termine la boucle à 7 pour éviter la repetition du 8 avec la 2nd boucle
    delay(200);
  }
  for (int i = 8; i>= 2; i--) { //On fait le chemin inverse
    SetValue(i); //On va de 8 à 2 pour éviter la répétition du 1 avec la 1ere boucle
    delay(200);
  }
}

void BargraphClear() {
  digitalWrite(PIN_DATA,LOW); //On remet à 0

  for(unsigned int i = 0; i < 8 ; i++){
    digitalWrite(PIN_CLOCK, HIGH); //Top d'horloge
    delay(20); //Pour éviter les rebonds (si pas de rebond enlever ou mettre 1ms)
    digitalWrite(PIN_CLOCK, LOW);
    delay(20);
  }
}

void SetValue(unsigned char x) {
  BargraphClear(); //On appelle la fonction pour tout remettre à 0
  digitalWrite(PIN_DATA, HIGH); //On allume la 1ere LED
  for (int i = 0; i < x; i++) { //On decale x fois cette LED
    digitalWrite(PIN_CLOCK, HIGH); //Top d'horloge
    delay(20); //Si pas de rebond enlever ou mettre 1ms
    digitalWrite(PIN_CLOCK, LOW);
    delay(20);
    if (i == 0){ //Si on est au 1er tour
      digitalWrite(PIN_DATA, LOW); //On charge des 0
    }
  } 
}
