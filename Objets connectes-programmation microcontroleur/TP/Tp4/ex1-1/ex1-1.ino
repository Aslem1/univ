//Code de test pour vérifier que tout fonctionne

void setup() {
  Serial.begin(115200);
  analogSetPinAttenuation(A3, ADC_0db); // eventuellement, pour le capteur de luminosite
  // ne rien faire sur l’entrée A4 : 1V = valeur 1088
}
float convert2Temp(int val) {
  // a écrire, à la fin TP. Pour l’instant, la valeur est transmise sans modification
return ((float) val);
}
void loop() {
  int valA3 = analogRead(A3); // resultat de la conversion A->N, correspondant a la tension sur A3
  int valA4 = analogRead(A4); // resultat de la conversion A->N, correspondant a la tension sur A4
  float temp = convert2Temp(valA4);
  Serial.print("Temperature :");
  Serial.print(temp);
  Serial.print(" Luminosite : ");
  Serial.println(valA3);
  delay(1000);
}
