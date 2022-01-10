#define X 14
#define LOW 0
void setup() {
  pinMode(LED_BUILTIN,OUTPUT);
  pinMode(X,INPUT_PULLUP); //Configure le port x
}

void loop() {
  int value = digitalRead(X);
  if (value == LOW){
    digitalWrite(LED_BUILTIN,HIGH);
    delay(400); //On attend 400ms
    digitalWrite(LED_BUILTIN,LOW);
    delay(400);
    digitalWrite(LED_BUILTIN,HIGH); //La LED s'allume
    delay(200);
    digitalWrite(LED_BUILTIN,LOW);
  }
}
