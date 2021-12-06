#define PIN_DATA 12
#define PIN_CLOCK 13

int nb_tours = 0;

void setup() {
  pinMode(PIN_DATA, OUTPUT);
  pinMode(PIN_CLOCK, OUTPUT);
  
  digitalWrite(PIN_DATA, HIGH);
  digitalWrite(PIN_CLOCK, LOW);
}

void loop() {
  if (nb_tours < 8){
    digitalWrite(PIN_CLOCK, HIGH); //Top d'horloge
    digitalWrite(PIN_CLOCK, LOW);
    delay(500);
    nb_tours ++;
  }
}
