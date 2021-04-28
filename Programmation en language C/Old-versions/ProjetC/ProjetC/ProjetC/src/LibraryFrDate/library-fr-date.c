//
// Created by Martin Ehlinger on 01/12/2020.
//

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

#include "library-fr-date.h"

#define MILLION 1000000
#define MILLE 1000
#define MAX_CHAR_CONV 1024

/* tables specific to the French language */
static char unit[10][16] = {"zero", "un", "deux", "trois", "quatre", "cinq", "six", "sept", "huit", "neuf"};
static char tens[10][16] = {"", ""/* for convenience */, "vingt", "trente", "quarante", "cinquante", "soixante",
                            ""/* we use sixty */, "quatre-vingt", ""/* we use eighty */};
static char ten[10][16] = {"dix", "onze", "douze", "treize", "quatorze", "quinze", "seize", "dix-sept", "dix-huit",
                           "dix-neuf"}; /* so complicated ... */

typedef struct _nbre {
    char integer[256]; /* string of the whole part of the number */
    char comma[256]; /* for its decimal part */
    char *str; /* string including both parts and the semicolon */
    int neg; /* to know if the number is negative */
    int comm; /* to find out if there is a comma in the number */
} nbr;

/* Function returning a character string */
/* Take care of converting number-> letter numbers from 0 to 999 */
static char *hundred(long number) {
    char *str_hundred = malloc(MAX_CHAR_CONV / 2 * sizeof(char));

    if (str_hundred == NULL) {
        printf("Memory allocation error\n");
        return NULL;
    }
    memset(str_hundred, 0, sizeof(str_hundred));
    int h, t, u; /* hundred, ten, unit */
    h = number / 100;
    t = (number - h * 100) / 10;
    u = (number - h * 100 - t * 10);

    /* we make the hundreds */
    if (h == 1) {/* If there are only "hundred" we write it */
        strcat(str_hundred, "cent");
    } else if (h > 1) /* If it is greater than 0 */
    {
        strcat(str_hundred, unit[h]); /* we write the number of hundred (s) */
        strcat(str_hundred, " cent");

        if ((t == 0) && (u == 0)) /* if after there is no number */
            strcat(str_hundred, "s"); /* we add the 's' */
        else
            strcat(str_hundred, " "); /* otherwise we add a space */
    }

    /* we do the tens and the units */
    /* we could use switches too ... */
    if (t == 0) /* if the tens are equal to 0 we write the units directly */
    {
        if (u > 0)
            strcat(str_hundred, unit[u]);
    } else if (t == 1) /* if it is 1, we write the units of the ten */
    {
        strcat(str_hundred, ten[u]);
    }
        /* special case of the "twenty"*/
    else if (t == 2) {
        if (u == 0) /* if 0, we write twenty */
            strcat(str_hundred, tens[t]);
        else if (u == 1) /* if 1, we write twenty-one */
        {
            strcat(str_hundred, tens[t]);
            strcat(str_hundred, "-et-un");
        } else /* otherwise we write normally with the hyphen */
        {
            strcat(str_hundred, tens[t]);
            strcat(str_hundred, "-");
            strcat(str_hundred, unit[u]);
        }
    } else if (t == 8) /* the same as for twenty */
    {
        if (u == 0) {
            strcat(str_hundred, tens[t]); /* with plural agreement */
            strcat(str_hundred, "s");
        } else if (u == 1) {
            strcat(str_hundred, tens[t]);
            strcat(str_hundred, "-un");
        } else {
            strcat(str_hundred, tens[t]); /* with plural agreement */
            strcat(str_hundred, "-");
            strcat(str_hundred, unit[u]);
        }

    }
        /* French particular case of the 90s and 70s */
    else if ((t == 9) || (t == 7)) {
        strcat(str_hundred, tens[t - 1]); /* add the ten below with the units of the ten 77 = 60 + 17 seventy-seven */
        strcat(str_hundred, "-");
        strcat(str_hundred, ten[u]);
    } else /* otherwise the "standard" case ... */
    {
        if (u == 0)
            strcat(str_hundred, tens[t]);
        else if (u == 1) {
            strcat(str_hundred, tens[t]);
            strcat(str_hundred, "-et-un");
        } else {
            strcat(str_hundred, tens[t]);
            strcat(str_hundred, "-");
            strcat(str_hundred, unit[u]);
        }
    }

    return str_hundred;
}

/* Function returning a character string */
/* Receive a number and take care of number-> letter conversions */
static char *conv_letter_number(long number) {
    char *str_letter = malloc(MAX_CHAR_CONV * sizeof(char));

    if (str_letter == NULL) {
        printf("Memory allocation error\n");
        return NULL;
    }

    memset(str_letter, 0, sizeof(str_letter));
    /* we split the whole into hundreds */
    if (labs(number) < 1000000000) {
        if (number != 0) {
            while (number != 0) {
                if (number > MILLION) {
                    long nb = number / MILLION;
                    strcat(str_letter, hundred(nb));
                    if (nb == 1)
                        strcat(str_letter, " million");
                    else
                        strcat(str_letter, " millions");
                    number = number % (nb * MILLION);
                    if (number > 0)
                        strcat(str_letter, " ");
                } else if (number >= MILLE) {
                    long nb = number / MILLE;
                    if (nb == 1)
                        strcat(str_letter, "mille");
                    else {
                        strcat(str_letter, hundred(nb));
                        strcat(str_letter, " mille");
                    }
                    number = number % (nb * MILLE);
                    if (number > 0)
                        strcat(str_letter, " ");

                } else {
                    strcat(str_letter, hundred(number));
                    number = 0;
                }
            }

        }
            /* exceptional case of 0 */
        else if (number == 0) {
            strcat(str_letter, "zero");

        }

        return str_letter;

    } else {

        printf("Please insert a number less than one billion (1,000,000,000)\n");
        return NULL;
    }
    return str_letter;
}


static nbr convStr(char *orig) {


    size_t i, j, ent = 0, comm = 0;
    int comma = 0; /* to know if there is a comma */
    int start = 0; /* we want to know if we have already started to find numbers: useful for the negative test */
    nbr number;

    number.str = malloc(strlen(orig) * sizeof(char));
    if (number.str == NULL) {
        printf("Memory allocation error\n");
        return number;
    }

    memset(number.str, 0, sizeof(number.str));
    memset(number.integer, 0, sizeof(number.integer));
    memset(number.comma, 0, sizeof(number.comma));

    for (i = 0, j = 0; i < strlen(orig); i++) {

        if ((orig[i] == '-') && (start == 0))
            number.neg = 1; /* if we find the sign '-' and we have not started to find a number, then the number is negative */
        if ((orig[i] == ',') ||
            (orig[i] == '.')) /* we take into account the first comma or the first point found */
        {

            if (comma == 0) /* if it's the first */
            {
                start = 1; /* we consider that we can start even if we have not found an integer part: .5 = 0.5 */
                number.comm = 1;
                number.str[j] = '.'; /* we add the point that goes well for the future strtol */
                comma = 1;
                j++;
            }
        } else if (isnumber(orig[i])) {
            start = 1;
            if (comma == 0) /* if we did not find a comma */
            {
                number.integer[ent] = orig[i]; /* we copy the number in its entire part */
                ent++;
            } else {
                number.comma[comm] = orig[i]; /* we copy the number in its decimal part */
                comm++;
            }
            number.str[j] = orig[i]; /* we make a copy of the string without unnecessary characters */
            j++;
        }

    }
    number.str[j++] = '\0';

    return number;

}


int main(int argc, char *argv[]) {

    /* we see if the program is launched */
    if (argc != 2) {
        printf("Usage : %s <number to convert to letters>\n", argv[0]);
        exit(EXIT_FAILURE);
    }

    char *str = malloc(
            MAX_CHAR_CONV * sizeof(char)); /* creation of the chain that will host the results of the operations */
    if (str == NULL) {
        printf("Memory allocation error\n");
        free(str);
        str = NULL;
        exit(EXIT_FAILURE);
    }
    memset(str, 0, (size_t) MAX_CHAR_CONV);

    nbr number;

    number = convStr(
            argv[1]); /* we ask to convert the entry into a structure accommodating the different parameters */

    if (number.str == NULL) /* we check that it worked well */
    {
        free(number.str);
        number.str = NULL;
        exit(EXIT_FAILURE);
    }

    if (number.neg == 1) /* If the number is negative we write "less" */
        strcat(str, "moins ");

    char *tmp = NULL; /* creation of a pointer that will point to the results of operations */
    tmp = conv_letter_number(strtol(number.integer, NULL, 10)); /* we get the conversion of the whole part */
    if (tmp != NULL) {

        strcat(str, tmp); /* if it is not null we add this in the final string */

        if (number.comm == 1) /* if there is a comma in the number */
        {

            tmp = conv_letter_number(
                    strtol(number.comma, NULL, 10)); /* we get the conversion of the decimal part */
            if (tmp != NULL) {
                strcat(str, " virgule "); /* similarly, if it is not null we add comma */
                strcat(str, tmp);   /* and the result */
            } else {
                /* otherwise it means that we provided a part greater than a billion */
                printf("Decimal part : %s > 1 000 000 000\n", number.comma);
            }
        }

        if ((str != NULL) && (tmp != NULL)) {
            /* if it's all good, we write the result */
            if (number.neg == 1) {
                printf("%s%s is written : %s", "-> -", number.str, str);
                printf(" AV JC\n");
            } else
                printf("%s%s is written : %s\n", "-> ", number.str, str);

        }

    } else {
        /* otherwise it means that we provided a part greater than a billion */
        printf("Whole part : %s > 1 000 000 000\n", number.integer);
    }

    free(str);
    str = NULL;
    free(tmp);
    tmp = NULL;

    return 0;
}