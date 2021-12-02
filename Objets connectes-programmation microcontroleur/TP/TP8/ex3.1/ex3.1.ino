#include <Wire.h>
...
setup()
{
...
Wire.begin(); // On ne specifie pas les broches, alors broches par defaut SCL=22, SDA=23
}
loop()
{
...
Wire.beginTransmission(112); // initialisation d’une transmission vers le module à l’adresse #112 (0x70)
Wire.write(byte(0x00)); // on specifie que l’on envoie une commande
Wire.write(byte(0x52)); // commande 0x52 : effectuer une mesure du temps de vol (duree jusqu’à reception de l’echo
Wire.endTransmission(); // fin transmission
delay(70); // Il est suggèré dans la doc d’attendre au moins 65 millisecondes que la mesure se fasse
Wire.beginTransmission(112); // initialisation d’une transmission vers le module à l’adresse #112 (0x70)
Wire.write(byte(0x02)); // on souhaite lire le registre correspondant à echo #1 (0x02)
Wire.endTransmission(); // fin transmission
Wire.requestFrom(112, 2); // demande de lecture : 2 octets de la part du module esclave #112
if (2 <= Wire.available()) // 2 octets ont été reçus
{
reading = Wire.read(); // recuperation de l’octet MSB
reading = reading << 8; // on décale
reading |= Wire.read(); // recupération de l’octet LSB et on combine
Serial.print(reading); // affichage valeur
Serial.println("microsec"); // affichage unite
}
}
