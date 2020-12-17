#include "./main.h"

#include <stdio.h>
#include <stdlib.h>

int main(void) {
    int end = 0;

    while (!end) {
        long choice = 0;

        printf("Bienvenue dans ce programme de traduction d'une valeur numéral à un texte \n");
        printf("1 - en Francais\n"
               "2 - en Belge\n"
               "3 - en Francais Africain (Désactivée)\n"
               "4 - en Francais Date\n"
               "5 - en Roman (Désactivée)\n"
               "6 - Quitter\n");
        printf("Quel est vote choix?\n");
        scanf("%ld", &choice);;

        switch (choice) {
            case 1:
                found("library-fr-FR.h", "Francais");
                break;
            case 2:
                found("librairy-fr-belgium.c", "Belge");
                break;
            case 3:
                //found("library-fr-african.c", "Francais Africain");
                break;
            case 4:
                found("library-fr-date.c", "Francais Date");
                break;
            case 5:
                //found("library-fr-roman.c", "Roman");
                break;
            case 6:
                end = 1;
                break;
            default:
                printf("Entrez un nombre correct SVP\n");
        }
    }
    return 0;
}

void found(char string[16], char string1[9]) {

}
