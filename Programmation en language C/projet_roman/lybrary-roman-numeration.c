#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>
 

#define MAX_CHAR_CONV 1024
 
/* table about roman numeration */
static char unite[10][16] = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
static char tens[10][16] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
static char hundreds[10][16] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
static char thousands[10][16] = {"", "M", "MM", "MMM", "MV*", "V*", "V*M", "V*MM", "V*MMM", "MX*"}; /* we are using * to represent the bar above the number */
static char tensofthousands[10][16] = {"", "X*X*", "X*X*X*", "X*L*", "L*", "L*X*", "L*X*X*", "L*X*X*X*", "X*C*"}; 
static char hundredsofthousands[10][16] = {"", "C*", "C*C*", "C*C*C*", "C*D*", "D*", "D*C*", "D*C*C*", "C*M*"};
 
typedef struct _nber
{
    char entier[256]; /* chaîne de la partière entière du nombre */
    
} nbre;
 

