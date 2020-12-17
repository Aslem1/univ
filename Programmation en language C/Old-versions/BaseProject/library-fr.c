//
// Created by Martin Ehlinger on 07/12/2020.
//

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>
#include <stdbool.h>


#define MILLION 1000000
#define MILLE 1000
#define MAX_CHAR_CONV 1024

/* les tableaux propres à la langue française */
static char unite[10][16] = {"zero", "un", "deux", "trois", "quatre", "cinq", "six", "sept", "huit", "neuf"};
static char dizaine[10][16] = {"", ""/*par commodité*/, "vingt", "trente", "quarante", "cinquante", "soixante",
                               ""/*on utilise soixante */, "quatre-vingt", ""/*on utilise quatre-vingt*/};
static char dix[10][16] = {"dix", "onze", "douze", "treize", "quatorze", "quinze", "seize", "dix-sept", "dix-huit",
                           "dix-neuf"}; /* tellement compliqué... */

static bool isnumber(char i);

typedef struct _nbre {
    char entier[256]; /* chaîne de la partière entière du nombre */
    char virgule[256]; /* pour sa partie décimale */
    char *str; /* chaîne incluant les deux parties et le point/virgule */
    int neg; /* pour savoir si le nombre est négatif */
    int virg; /* pour savoir s'il y a une virgule dans le nombre */
} nbre;

/* Fonction retournant une chaîne de caractères */
/* S'occupe de faire la conversion nombre->lettre des nombres de 0 à 999 */
static char *centaine(long number) {

    char *str_centaine = malloc(MAX_CHAR_CONV / 2 * sizeof(char));
    if (str_centaine == NULL) {
        printf("Erreur d'allocation mémoire\n");
        return NULL;
    }
    memset(str_centaine, 0, sizeof(str_centaine));
    int c, d, u; /* centaine, dizaine, unité */
    c = number / 100;
    d = (number - c * 100) / 10;
    u = (number - c * 100 - d * 10);

    /* on fait les centaines */
    if (c == 1) /* Si il n'y a que "cent" on l'écrit */
        strcat(str_centaine, "cent ");
    else if (c > 0) /* Si c'est supérieur à 0 */
    {
        strcat(str_centaine, unite[c]); /*on écrit le nombre de cent(s) */
        strcat(str_centaine, " cent");

        if ((d == 0) && (u == 0)) /* si après il n'y a pas de nombre */
            strcat(str_centaine, "s"); /* on ajoute le 's' */
        else
            strcat(str_centaine, " "); /* sinon on ajoute un espace */
    }

    /* on fait les dizaines et les unités */
    /* on pourrait utiliser des switchs aussi... */
    if (d == 0) /* si les dizaines valent 0 on écrit directement les unités */
    {
        if (u > 0)
            strcat(str_centaine, unite[u]);
    } else if (d == 1) /* si cela vaut 1, on écrit les unités de la dizaine */
    {
        strcat(str_centaine, dix[u]);
    }
        /* cas particulier des "vingts" */
    else if (d == 2) {
        if (u == 0) /* si 0, on écrit vingt */
            strcat(str_centaine, dizaine[d]);
        else if (u == 1) /* si 1, on écrit vingt et un */
        {
            strcat(str_centaine, dizaine[d]);
            strcat(str_centaine, " et un");
        } else /* sinon on écrit normalement avec le tiret */
        {
            strcat(str_centaine, dizaine[d]);
            strcat(str_centaine, "-");
            strcat(str_centaine, unite[u]);
        }
    } else if (d == 8) /* de même que pour vingt */
    {
        if (u == 0) {
            strcat(str_centaine, dizaine[d]); /* avec l'accord pluriel */
            strcat(str_centaine, "s");
        } else if (u == 1) {
            strcat(str_centaine, dizaine[d]);
            strcat(str_centaine, "-un");
        } else {
            strcat(str_centaine, dizaine[d]); /* avec l'accord pluriel */
            strcat(str_centaine, "s ");
            strcat(str_centaine, unite[u]);
        }
    }
        /* cas particulier français des 90 et 70 */
    else if ((d == 9) || (d == 7)) {
        strcat(str_centaine, dizaine[d -
                                     1]); /* on ajoute la dizaine du dessous avec les unités de la dizaine 77 = 60+17 soixante-dix-sept */
        strcat(str_centaine, "-");
        strcat(str_centaine, dix[u]);
    } else /* sinon le cas "standard"... */
    {
        if (u == 0)
            strcat(str_centaine, dizaine[d]);
        else if (u == 1) {
            strcat(str_centaine, dizaine[d]);
            strcat(str_centaine, " et un");
        } else {
            strcat(str_centaine, dizaine[d]);
            strcat(str_centaine, "-");
            strcat(str_centaine, unite[u]);
        }
    }

    return str_centaine;
}

/* Fonction retournant une chaîne de caractères */
/* Reçoit un nombre et s'occupe des opérations de conversions nombre->lettre */
static char *convLettreChiffre(long number) {
    char *str_lettre = malloc(MAX_CHAR_CONV * sizeof(char));

    if (str_lettre == NULL) {
        printf("Erreur d'allocation mémoire\n");
        return NULL;
    }

    memset(str_lettre, 0, sizeof(str_lettre));
    /* on fractionne le tout en centaine */
    if (labs(number) < 1000000000) {
        if (number != 0) {
            while (number != 0) {
                if (number > MILLION) {
                    long nb = number / MILLION;
                    strcat(str_lettre, centaine(nb));
                    if (nb == 1)
                        strcat(str_lettre, " million");
                    else
                        strcat(str_lettre, " millions");
                    number = number % (nb * MILLION);
                    if (number > 0)
                        strcat(str_lettre, " ");
                } else if (number > MILLE) {
                    long nb = number / MILLE;
                    if (nb == 1)
                        strcat(str_lettre, "mille");
                    else {
                        strcat(str_lettre, centaine(nb));
                        strcat(str_lettre, " mille");
                    }
                    number = number % (nb * MILLE);
                    if (number > 0)
                        strcat(str_lettre, " ");

                } else {
                    strcat(str_lettre, centaine(number));
                    number = 0;
                }
            }

        }

            /* cas exceptionnel du 0 */
        else if (number == 0) {
            strcat(str_lettre, "zero");

        }

        return str_lettre;

    } else {

        printf("Veuillez insérer un nombre inférieur à un milliard (1 000 000 000)\n");
        return NULL;
    }
    return str_lettre;
}


static nbre convStr(char *orig) {


    size_t i, j, ent = 0, virg = 0;
    int virgule = 0; /* pour savoir s'il y a une virgule */
    int debut = 0; /* on cherche à savoir si on a déjà commencé à trouver des chiffres : utile pour le test négatif */
    nbre nombre;

    nombre.str = malloc(strlen(orig) * sizeof(char));
    if (nombre.str == NULL) {
        printf("Erreur d'allocation mémoire\n");
        return nombre;
    }

    memset(nombre.str, 0, sizeof(nombre.str));
    memset(nombre.entier, 0, sizeof(nombre.entier));
    memset(nombre.virgule, 0, sizeof(nombre.virgule));

    for (i = 0, j = 0; i < strlen(orig); i++) {

        if ((orig[i] == '-') && (debut == 0))
            nombre.neg = 1; /* si on trouve le signe '-' et que l'on a pas commencé à trouver de chiffre, alors le nombre est négatif */
        if ((orig[i] == ',') ||
            (orig[i] == '.')) /* on prend en compte la première virgule ou le premier point trouvé */
        {

            if (virgule == 0) /* si c'est la première */
            {
                debut = 1; /* on considère que l'on peut commencer même si on a pas trouvé de partie entière : .5 = 0.5 */
                nombre.virg = 1;
                nombre.str[j] = '.'; /* on ajoute le point qui va bien pour le strtol futur */
                virgule = 1;
                j++;
            }
        } else if (isnumber(orig[i])) {
            debut = 1;
            if (virgule == 0) /* si on a pas trouvé de virgule */
            {
                nombre.entier[ent] = orig[i]; /* on copie le nombre dans sa partie entière*/
                ent++;
            } else {
                nombre.virgule[virg] = orig[i]; /* on copie le nombre dans sa partie décimale */
                virg++;
            }
            nombre.str[j] = orig[i]; /* on fait une copie de la chaîne débarassée des caractères superflus */
            j++;
        }

    }
    nombre.str[j++] = '\0';

    return nombre;

}


int main(int argc, char *argv[]) {

    /* on regarde si le preogramme est bien lancé */
    if (argc != 2) {
        printf("Usage : %s <nombre à convertir en lettres>\n", argv[0]);
        exit(EXIT_FAILURE);
    }

    char *str = malloc(
            MAX_CHAR_CONV * sizeof(char)); /* création de la chaîne qui accueillera le résultat des opérations */
    if (str == NULL) {
        printf("Erreur d'allocation mémoire\n");
        free(str);
        str = NULL;
        exit(EXIT_FAILURE);
    }
    memset(str, 0, (size_t) MAX_CHAR_CONV);

    nbre nombre;

    nombre = convStr(
            argv[1]); /* on demande à convertir l'entrée dans une structure accueillant les différents paramètres */

    if (nombre.str == NULL) /* on vérifie que cela a bien fonctionné */
    {
        free(nombre.str);
        nombre.str = NULL;
        exit(EXIT_FAILURE);
    }

    if (nombre.neg == 1) /* Si le nombre est négatif on écrit "moins" */
        strcat(str, "moins ");

    char *tmp = NULL; /* création d'un pointeur qui pointera sur les résultats des opérations */
    tmp = convLettreChiffre(strtol(nombre.entier, NULL, 10)); /* on récupère la conversion de la partie entière */
    if (tmp != NULL) {

        strcat(str, tmp); /* si ce n'est pas null on ajoute cela dans la chaîne finale */

        if (nombre.virg == 1) /* si il y a une virgule dans le nombre */
        {

            tmp = convLettreChiffre(
                    strtol(nombre.virgule, NULL, 10)); /* on récupère la conversion de la partie décimale */
            if (tmp != NULL) {
                strcat(str, " virgule "); /* de même, si ce n'est pas null on ajoute virgule */
                strcat(str, tmp);   /* et le résultat */
            } else {
                /* sinon cela veut dire que l'on a fournit une partie supérieur à un milliard */
                printf("Partie décimale : %s > 1 000 000 000\n", nombre.virgule);
            }
        }

        if ((str != NULL) && (tmp != NULL)) {
            /* si c'est tout bon, on écrit le résultat */
            printf("%s%s s'écrit : %s\n", (nombre.neg == 1 ? "-> -" : "-> "), nombre.str, str);
        }

    } else {
        /* sinon cela veut dire que l'on a fournit une partie supérieur à un milliard */
        printf("Partie entière : %s > 1 000 000 000\n", nombre.entier);
    }

    free(str);
    str = NULL;
    free(tmp);
    tmp = NULL;

    return 0;
}