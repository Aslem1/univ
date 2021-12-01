void setup() {
}

void loop() {
}

class Bargraph {
  public: //Ce que la classe va "montrer/exposer"
    //Ici on déclare le constructeur
    bargraph(unsigned int DisplayMode = 0, unsigned int pinClk=13, unsigned int pinData=12);
    
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

void Bargraph::bargraph(unsigned int DisplayMode = 0, unsigned int pinClk=13, unsigned int pinData=12) {
  // Ici on "fait" le constructeur
  class_displayMode = DisplayMode; // 0 : mode colonne -- 1: mode trait
  class_pinData = pinData;
  class_pinClk = pinClk;
}

//On fait les méthodes
void Bargraph::Clear(){
  digitalWrite(class_pinData,LOW); //On remet à 0

  for(unsigned int i = 0; i < 8 ; i++){
    digitalWrite(class_pinClk, HIGH); //Top d'horloge
    delay(20); //Pour éviter les rebonds (si pas de rebond enlever ou mettre 1ms)
    digitalWrite(class_pinClk, LOW);
    delay(20);
  }
}

void Bargraph::SetValue(unsigned char value){
  Clear(); //On appelle la fonction pour tout remettre à 0
  digitalWrite(class_pinData, HIGH); //On allume la 1ere LED
  
  for (int i = 0; i < x; i++) { //On decale x fois cette LED
    digitalWrite(class_pinClk, HIGH); //Top d'horloge
    delay(20); //Si pas de rebond enlever ou mettre 1ms
    digitalWrite(class_pinClk, LOW);
    delay(20);
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
