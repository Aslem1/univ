#define Ca 17
#define Cb 18
#define D 14
#define G 15
#define M 16

void setup() {
  pinMode(M, INPUT); //On met le bouton entrée
  pinMode(Ca, INPUT);
  pinMode(Cb, INPUT);
  pinMode(D, OUTPUT);
  pinMode(G, OUTPUT);
}

void loop() {
  val = digitalRead(M);
  valCa = digitalRead(Ca);
  valCb = digitalRead(Cb);
  if (val == HIGH){ //Si on appuie sur le bouton
    digitalWrite (D,HIGH); //On va à droite
  }
  if (valCb == HIGH){ //Si le chariot touche Cb
    digitalWrite (D,LOW); //On coupe le moteur de droite
    digitalWrite (G,HIGH); //On va à gauche
  }
  if (valCa == HIGH){ //Si le chariot touche Ca
    digitalWrite (G,LOW); //On va à droite
  }
}
