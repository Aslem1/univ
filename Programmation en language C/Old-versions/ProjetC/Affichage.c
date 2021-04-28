#include <stdio.h>
#include <stdlib.h>
#include "src/LibraryFr/library-fr-FR.h"

void found(char string[16], char string1[9]);

int main(void) {
    int end = 0;
    char * res = "";

    while (!end) {
        long choice = 0;
        long value = 0;

        printf("Bienvenue dans ce programme de traduction d'une valeur numérique en texte. Choisissez votre langue : \n");
        printf("1 - en Francais\n"
               "2 - en Belge\n"
               "3 - en Francais Africain\n"
               "4 - en Francais Date\n"
               "5 - en Roman\n"
               "6 - Quitter\n");
        printf("Quel est vote choix ?\n");
        scanf("%ld", &choice);

        printf("Quelle valeur voulez-vous traduire ?\n");
        scanf("%ld", &value);
        switch (choice) {
            case 1:
                res = conv_letter_number(value);
                // appel à la lib en passant value en param
                // found("library-fr-FR.c", "Francais");
                break;
            case 2:
                // appel à la lib en passant value en param
                found("library-fr-BE.c", "Belge");
                break;
            case 3:
                // appel à la lib en passant value en param
                found("library-fr-african.c", "Francais Africain");
                break;
            case 4:
                // appel à la lib en passant value en param
                found("library-fr-date.c", "Francais Date");
                break;
            case 5:
                // appel à la lib en passant value en param
                found("library-fr-roman.c", "Roman");
                break;
            case 6:
                end = 1;
                break;
            default:
                printf("Entrez un nombre correct SVP\n");
        }
    }
    printf("%s", res);
    return 0;
}

void found(char string[16], char string1[9]) {

}
