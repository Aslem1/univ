#include <Servo.h>
#define T4 13
#define T1 2
#define X 50 //Si cette valeur est dépassée, le servo bouge

static const int servoPin = 25;

Servo servo1;

void setup() {
    Serial.begin(115200);
    servo1.attach(servoPin);
    analogSetPinAttenuation(A4, ADC_0db);
}

void loop() {
    int valA4 = analogRead(A4); // resultat de la conversion A->N, correspondant a la tension sur A4
    int val0 = touchRead(T4);
    int val1 = touchRead(T1);
    int posDegrees = 0;
    if(val0 >= X) {
        Serial.println(touchRead(13));
        Serial.print(" Luminosite : ");
        Serial.println(valA4);
        servo1.write(posDegrees++);
        Serial.println(posDegrees);
        delay(20);
    }

    if(val1 >= X) {
        Serial.print(" Luminosite : ");
        Serial.println(valA4);
        servo1.write(posDegrees--);
        Serial.println(posDegrees);
        delay(20);
    }
}
