#include "library.h"
#include <stdio.h>
#include <stdlib.h>

int main(){
    int day, month, year;

    char *months[] = {
            "Janvier", "Février", "Mars", "Avril",
            "Mai", "Juin", "Juillet", "Août",
            "Septembre", "Octobre", "Novembre", "Decembre",
    };

    printf("Entrez une date(MM/DD/YYY): ");
    scanf("%d/%d/%d", &month, &day, &year);

    printf("%d", day);

    printf("%s, %d", months[month - 1], year);

    return EXIT_SUCCESS;
}
