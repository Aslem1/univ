void setup() {
Serial.begin(115200);

}

void loop() {
  
  int n, nbr1 = 1, nbr2 = 1, value, i;
  
  Serial.println("Saisir le rang :");
  
  while (Serial.available() == 0) {} //Tant que l'utilisateur n'a rien rentré dans l'input on attend
  Serial.setTimeout(5000); // attente de 5sec max pour Serial.parseInt, puis on passe à la suite
  do {
    n = Serial.parseInt(); // Serial.parseInt detecte les caractères qui ne sont pas des chiffres
    if (Serial.read() == '\n') // si le caractère est un retour à la ligne (touche ‘‘entrée’’)
    break; // alors on quitte la boucle
    }
    while(Serial.available() > 0); // tant qu’il y a des caractères dans le buffer
    for (i = 0; i < n; i++){
      {
        value = nbr1 + nbr2;
        nbr1 = nbr2;
        nbr2 = value;
        }
        Serial.println(value);
        delay(500);
        }
}
