#define uS_TO_S_FACTOR 1000000  // Convertir les secondes en microsecondes
#define TIME_TO_SLEEP  10       // Le temps durant lequel le microcontroleur va dormir (en seconde)


void setup() {
    Serial.begin(115200);
    esp_sleep_enable_timer_wakeup(TIME_TO_SLEEP * uS_TO_S_FACTOR);
    analogSetPinAttenuation(A3, ADC_0db); // eventuellement, pour le capteur de luminosite
    // ne rien faire sur l’entrée A4 : 1V = valeur 1088
    int valA3 = analogRead(A3); // resultat de la conversion A->N, correspondant a la tension sur A3
    int valA4 = analogRead(A4); // resultat de la conversion A->N, correspondant a la tension sur A4
    float temp = convert2Temp(valA4);
    Serial.print("Temperature :");
    Serial.print(temp);
    Serial.print(" Luminosite : ");
    Serial.println(valA3);
    delay(100); //0,1s
    esp_deep_sleep_start(); //On s'endort après le 1er tour de boucle, après cette ligne on attend TIME_TO_SLEEP secondes
}

float convert2Temp(int val) {
    // a écrire, à la fin TP. Pour l’instant, la valeur est transmise sans modification
    return ((float) val);
}

void loop() {
}

//On fait un tour de boucle puis on dors pendant 10s
//Après 10s on se réveille
