class Bargraph {
  public: //Ce que la classe va "montrer/exposer"
    //Ici on déclare le constructeur
    Bargraph(unsigned int DisplayMode = 0, unsigned int pinClk=13, unsigned int pinData=12);
    
    //Methodes
    void Clear ();
    void SetValue(unsigned char value);
    void SetMode(unsigned int mode);

  private:
    // ici methodes privées et variables membres de la classe
    unsigned int class_displayMode;
    unsigned int class_pinData;
    unsigned int class_pinClk;
};

Bargraph::Bargraph(unsigned int DisplayMode, unsigned int pinClk, unsigned int pinData) {
  // Ici on "fait" le constructeur
  class_displayMode = DisplayMode; // 0 : mode colonne -- 1: mode trait
  class_pinData = pinData;
  class_pinClk = pinClk;
  
  pinMode(class_pinData, OUTPUT);
  pinMode(class_pinClk, OUTPUT);

  digitalWrite(class_pinData, HIGH);
  digitalWrite(class_pinClk, LOW);
}

//On fait les méthodes
void Bargraph::Clear(){
  digitalWrite(class_pinData,LOW); //On remet à 0

  for(unsigned int i = 0; i < 8 ; i++){
    digitalWrite(class_pinClk, HIGH); //Top d'horloge
    digitalWrite(class_pinClk, LOW);
  }
   for(unsigned int i = 0; i < 8 ; i--){
    digitalWrite(class_pinClk, HIGH); //Top d'horloge
    digitalWrite(class_pinClk, LOW);
  }
}

void Bargraph::SetValue(unsigned char value){
  Clear(); //On appelle la fonction pour tout remettre à 0
  digitalWrite(class_pinData, HIGH); //On allume la 1ere LED
  
  for (int i = 0; i < value; i++) { //On decale x fois cette LED
    digitalWrite(class_pinClk, HIGH); //Top d'horloge
    digitalWrite(class_pinClk, LOW);
    if (class_displayMode && i == 0){ //Si on est en mode trait donc class_displayMode = 1 et si on est au 1er tour
      digitalWrite(class_pinData, LOW); //On charge des 0
    }
  }
}

//Set mode : permet de passer du mode colonne au mode trait
void Bargraph::SetMode(unsigned int mode){
  if (mode == 0 || mode == 1){ //On vérifie si mode rentre dans les spécifications
    class_displayMode = mode;
  }
}

Bargraph monbargraph; //Créer un objet monbargraph de la classe bargraphe

void setup() {
}

void loop() {
  for(int i = 1; i <= 7; i++){ //On décale les LED jusqu'a la derniere
    monbargraph.SetValue(i); //On termine la boucle à 7 pour éviter la repetition du 8 avec la 2nd boucle
    delay(200);
  }
  for (int i = 8; i>= 2; i--) { //On fait le chemin inverse
    monbargraph.SetValue(i); //On va de 8 à 2 pour éviter la répétition du 1 avec la 1ere boucle
    delay(200);
  }
}
