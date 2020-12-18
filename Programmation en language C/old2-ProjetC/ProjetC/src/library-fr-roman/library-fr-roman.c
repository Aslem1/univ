#include "library-fr-roman.h"

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct {
    int value;
    char roman_dgts[3];
} roman_table[] = {{1000, "M"},
                   {900,  "CM"},
                   {500,  "D"},
                   {400,  "CD"},
                   {100,  "C"},
                   {90,   "XC"},
                   {50,   "L"},
                   {40,   "XL"},
                   {10,   "X"},
                   {9,    "IX"},
                   {5,    "V"},
                   {4,    "IV"},
                   {1,    "I"}};

char *int_to_roman(int n) {
    char *roman_numerals;
    int i = 0;

    roman_numerals = (char *) malloc(sizeof(char) * 10);

    while (n) {
        while (n < roman_table[i].value)
            i++;
        while (n >= roman_table[i].value) {
            strcat(roman_numerals, roman_table[i].roman_dgts);
            n -= roman_table[i].value;
        }
    }

    return roman_numerals;
}

int main(int argc, char *argv[]) {
    int number;
    char *result;

    printf("Input a decimal number: ");
    scanf("%d", &number);

    if (number < 0 || number > 3999) {
        printf("Input must be within the range from 1 to 3999.\n");
        return -1;
    }

    result = int_to_roman(number);
    puts(result);

    free(result);

    return 0;
}