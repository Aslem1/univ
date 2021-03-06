#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

#define MILLION 1000000
#define MILLE 1000
#define MAX_CHAR_CONV 1024

/* tables specific Roman numeration */
static char unite[10][16] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
static char tens[10][16] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
static char hundreds[10][16] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
static char thousands[10][16] = {"", "M", "MM", "MMM", "MV*", "V*", "V*M", "V*MM", "V*MMM",
                                 "MX*"}; /* we are using * to represent the bar above the number */
static char tensofthousands[10][16] = {"", "X*X*", "X*X*X*", "X*L*", "L*", "L*X*", "L*X*X*", "L*X*X*X*", "X*C*"};
static char hundredsofthousands[10][16] = {"", "C*", "C*C*", "C*C*C*", "C*D*", "D*", "D*C*", "D*C*C*", "D*C*C*C*",
                                           "C*M*"};
static char millions[10][16] = {"", "M*", "M*M*", "M*M*M*", "M*V**", "V**M*", "V**M*M*", "V**M*M*M*", "M*X**"};
static char tensofmillions[10][16] = {"", "X**", "X**X**", "X**X**X**", "X**L**", "L**", "L**X**", "L**X**X**",
                                      "L**X**X**X**", "X**C**"};
static char hundredsofmillions[10][16] = {"", "C**", "C**C**", "C**C**C**", "C**D**", "D**", "D**C**", "D**C**C**",
                                          "D**C**C**C**", "C**M**"};

typedef struct _nber {
    char integer[256]; /* character chain about the number */
    char *str; /**/
} nbr;

/* Function returning a character string */
/* Take care of converting number-> letter numbers from 0 to 999 */
static char *hundred(long number) {

    char *str_hundred = malloc(MAX_CHAR_CONV / 2 * sizeof(char));
    if (str_hundred == NULL) {
        printf("Memory Allocation Error\n");
        return NULL;
    }
    memset(str_hundred, 0, sizeof(str_hundred));
    int h, t, u; /* hundreds, tens, unit */
    h = number / 100;
    t = (number - h * 100) / 10;
    u = (number - h * 100 - t * 10);

    /* we make the hundreds */
    if (h == 1) /* If it is greater than 0 */
    {
        strcat(str_hundred, hundreds[h]); /* we write the number of hundred (s) */
    }

    /* we do the tens and the units */
    /* we could use switches too ... */
    if (t == 0) /* if the tens are equal to 0 we write the units directly */
    {
        if (u > 0)
            strcat(str_hundred, unite[u]);
    } else /* otherwise the "standard" case ... */
    {
        if (u == 0)
            strcat(str_hundred, tens[t]);

        else {
            strcat(str_hundred, tens[t]);
            strcat(str_hundred, unite[u]);
        }
    }

    return str_hundred;
}

/* Function returning a character string */
/* Receive a number and take care of number-> letter conversions */
static char *conv_french_roman(long number) {
    char *str_roman = malloc(MAX_CHAR_CONV * sizeof(char));

    if (str_roman == NULL) {
        printf("Memory allocation error\n");
        return NULL;
    }

    memset(str_roman, 0, sizeof(str_roman));
    /* We split whole into hundred */
    if (labs(number) < 1000000000) {
        if (number != 0) {
            while (number != 0) {
                if (number > MILLION) {
                    long nb = number / MILLION;
                    strcat(str_roman, hundred(nb));
                    if (nb == 1)
                        strcat(str_roman, "M*");
                    number = number % (nb * MILLION);
                    if (number > 0)
                        strcat(str_roman, " ");
                } else if (number > MILLE) {
                    long nb = number / MILLE;
                    if (nb == 1)
                        strcat(str_roman, "M");
                    else {
                        strcat(str_roman, hundred(nb));
                        strcat(str_roman, "mille");
                    }
                    number = number % (nb * MILLE);
                    if (number > 0)
                        strcat(str_roman, " ");
                } else {
                    strcat(str_roman, hundred(number));
                    number = 0;
                }
            }
        }
    } else {
        printf("Please insert a number less than one billion (1,000,000,000)\n");
        return NULL;
    }
    return str_roman;
}

int main(int argc, char *argv[]) {

    /* we see if the program is launched */
    if (argc != 2) {
        printf("Usage : %s <number to convert into roman number>\n", argv[0]);
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

    number = conv_french_roman(
            argv[1]); /* we ask to convert the entry into a structure accommodating the different parameters */

    if (number.str == NULL) /* we check that it worked well */
    {
        free(number.str);
        number.str = NULL;
        exit(EXIT_FAILURE);
    } else {
        /* otherwise it means that we provided a part greater than a billion */
        printf("Number : %s > 1 000 000 000\n", number.integer);
    }

    free(str);
    str = NULL;

    return 0;
}

