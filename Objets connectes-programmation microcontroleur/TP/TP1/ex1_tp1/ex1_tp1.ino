int compteur = 0;
void setup() {
  // put your setup code here, to run once:
  Serial.begin(115200);
  Serial.println("Blink !");
  pinMode(LED_BUILTIN,OUTPUT);
}

void loop() {
  // put your main code here, to run repeatedly:
  digitalWrite(LED_BUILTIN,HIGH);
    
  digitalWrite(LED_BUILTIN,LOW);
  delay(500);
  Serial.println("Loop number :");
  compteur++;
  Serial.println(compteur);
}
