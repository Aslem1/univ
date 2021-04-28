#include "conversion.h"
#include <stdio.h>
#include <string.h>

const char *convert_date(char *num) {
    unsigned long len = strlen(num);
    printf("-------------\n");
    printf("%s\n", num);
    printf("bbbbbbbbbbbbb\n");

    //The year must not exceed 4 digits
    if (len == 0L) {
        return "Aucune date renseignée, veuillez réessayer.";
    }
    printf("++++++++");
    if (len > 4L) {
        return "Longueur supérieure à quatre, veuillez réessayer.";
    }
    printf("++++++++");

    //One digit
    char *single_digits[] = {
        "zero", "un", "deux",
        "trois", "quatre", "cinq",
        "six", "sept", "huit", "neuf"
    };

    //Two digits
    char *two_digits[] = {
        "", "dix", "onze", "douze",
        "treize", "quatorze", "quinze",
        "seize", "dix-sept", "dix-huit", "dix-neuf"
    };

    //Ten multiples
    char *ten_multiple[] = {
        "", "", "vingt", "trente", "quarante",
        "cinquante", "soixante", "soixante-dix",
        "quatre-vingts", "quatre-vingt-dix"
    };

    //Ten power
    char *ten_power[] = {
        "cent", "mille"
    };

    printf("++++++++");
    //Code for one digit
    if (len == 1L) {
        return single_digits[*num - '0'];
    }

    printf("+++++++++");
    //Iteration if the number is not 0
    char result[256] = "";
    while (*num != '\0') {
        printf("---------+++--------");
        //Code for two digits
        if (len >= 3L) {
            if (*num - '0' != 0) {
                strcat(result, single_digits[*num - '0']);
                strcat(result, " ");
                strcat(result, ten_power[len-3]);
                strcat(result, " ");
            }
            --len;
        }

        //Code for the last two digits
        if (*num == '1') {
            int sum = *num - '0' + *(num + 1)- '0';
            strcat(result, two_digits[sum]);
            return result;
        }

            //Code to manage the twenty
        else if (*num == '2' && * (num+1) == '0') {
            strcat(result, "vingt");
        }

            //Remaining digits from twenty-one to ninety-nine
        else {
            int i = *num - '0';
            if (i) {
                strcat(result, ten_multiple[i]);
                strcat(result, " ");
            }
            ++num;

            if (*num != '0') {
                strcat(result, single_digits[*num - 0]);
                strcat(result, " ");
            }
        }
        ++num;
    }
    return result;
}

