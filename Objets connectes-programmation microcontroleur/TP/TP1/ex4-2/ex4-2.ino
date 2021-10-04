//Code pour le mytone
#define X 14
#define LOW 0
#define HIGH 1

#define BUZZER1 32
#define BUZZER2 15

void setup() {
  pinMode(X,INPUT);
  pinMode(BUZZER1,OUTPUT);
  pinMode(BUZZER2,OUTPUT);
}

void loop() {
  int value = digitalRead(X);
  if (value == LOW){ // le bouton est appuyé
    //while(!Serial.available()); // attente bloquante d’une frappe clavier dans le terminal
    //nombre = Serial.parseInt(); // si le code ASCII saisi est un entier, alors il est converti
    myTone(370,4000000); // appel de la fonction
    myTone(293,3000000);
    myTone(440,1000000);
  }
}

void myTone(int frequence, int duration) {
  int period = 1000000/frequence;
  int nb = duration/period;
  for(int i = 0; i < frequence; i++){ 
    digitalWrite(BUZZER1, HIGH); // On allume le buzzer 1
    digitalWrite(BUZZER2, LOW); // On allume le buzzer 2
    delayMicroseconds(period/2); // On attend 1 demie periode
    digitalWrite(BUZZER1, LOW);
    digitalWrite(BUZZER2, HIGH);
    delayMicroseconds(period/2); // On attend 1 demie periode
  }
}
