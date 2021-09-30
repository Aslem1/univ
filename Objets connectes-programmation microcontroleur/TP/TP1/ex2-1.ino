int compteur = 0;
void setup() {
  // put your setup code here, to run once:
  Serial.begin(115200);
  Serial.println("Blink !");
  pinMode(LED_BUILTIN,OUTPUT);
  pinMode(14, OUTPUT); //Configure le port 23 en sortie
}

void loop() {
  // put your main code here, to run repeatedly:
  digitalWrite(LED_BUILTIN,HIGH); //La led s'allume
  delay(500);
  digitalWrite(LED_BUILTIN,LOW); //La led s'éteint
  delay(500);
  digitalWrite(14,HIGH); //La led rectangulaire s'allume
  delay(500);
  digitalWrite(14,LOW); //La led rectangulaire s'éteint
  //Serial.print("Loop number :");
  //compteur++;
  //Serial.println(compteur);
}
