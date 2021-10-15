int cumul;
int count;
int value;

//variables pour les 4 dernieres mesures
int nbr1;
int nbr2;
int nbr3;
int nbr4;
int moyenne;

void setup() {
  Serial.begin(115200);
}

void loop() {
  cumul = 0;
  for(count =0; count < 8 ; count++) { // do 8 measures, compute average to reduce noise
    value = analogRead(A0);
    delay(1); // short delay because A-D conversion need time
    cumul = cumul + value;
}
cumul = cumul >> 3;
nbr4 = nbr3;
nbr3= nbr2;
nbr2= nbr1;
nbr1= value;

moyenne = (nbr1+nbr2+nbr3+nbr4)/4;

//On affiche les 4 valeurs utilisées pour le calcul
Serial.print(value);
Serial.print(";");
Serial.print(nbr2);
Serial.print(";");
Serial.print(nbr3);
Serial.print(";");
Serial.print(nbr4);
Serial.print(" ");
Serial.print("Moyenne mobile :");
Serial.println(moyenne); //On affiche la moyenne
delay(1000);
}
