void setup() {}

void loop() {}

int GetRfromHTML(char* ColorCode) {
  char elem1;
  char elem2;
  if(ColorCode[0] == '#') { // Si le 1er elément du tableau est #
     elem 1 = ColorCode[1]; // Vert : 3 / Bleu : 5 // On recupère le premier caractère utile du tableau
     elem 2 = ColorCode[2]; // Vert : 4 / Bleu : 6
  }
  else {
    elem 1 = ColorCode[0]; // Vert : 2 / Bleu : 4
    elem 2 = ColorCode[1]; // Vert : 3 / Bleu : 5
  }
  // FF
  byte resultat = charToByte(elem1); //Renvoie la "traduction" de elem1 en byte
  resultat = resultat << 4; // On décale résultat de 4 bits
  resultat = resultat + charToByte(elem2); // On additionne les 2 elements après décalage
}

// On se sert de la conversion en chiffre des char
// cf image "tableau-char-to-int.png"
byte charToByte(char c) {
  if (c >= '0' && c <= '9') // Si le caractère est un chiffre entre 0 et 9, on prend la différence entre le caractère et '0'
    return c - '0';

  if (c >= 'a' && c <= 'f') // Idem pour les caractères entre 'a' et 'z'
    return c - 'a' + 10;

  if (c >= 'A' && c <= 'F') // Idem pour les caractères entre 'A' et 'Z'
    return c - 'A' + 10;

  return 0;  // Caractère hexadecimal non reconnu
}
