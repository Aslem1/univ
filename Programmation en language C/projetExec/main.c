#include <stdio.h>
#include "conversion.h"

int main() {
    char year;
    printf("Entrez une date(YYYY): ");
    scanf("%s", &year);
    printf ("%s", "-------------\n");
    printf ("%s\n", &year);
    printf ("%s", "aaaaaaaaaaaaa\n");
    printf ("%s", convert_date(&year));
    return 0;
}
