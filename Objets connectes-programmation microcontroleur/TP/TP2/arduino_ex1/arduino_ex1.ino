void setup() {
 Serial.begin(115200);
}

int n = 20, nbr1 = 1, nbr2 = 1, value, i; 
void loop() {
  for (i = 0; i < n; i++) {
    if (i <= 1)
    value = i;
    else {
      value = nbr1 + nbr2;
      nbr1 = nbr2;
      nbr2 = value;
    }
    Serial.print(value);
    delay(500);
  }
}
