/**
 * @file main.c
 * @author NIVET Marie, NTSAMA Estelle, PERRIN Agathe, PEARSON Nicole
 * @brief test file for main.
 * @version 0.1
 * @date 2022-01-10
 */
#include <assert.h>
#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <time.h>

#include "treeBicolor.h"

#define NEW_LINE printf("\n")
#define INTEGER sizeof(int)

#define NUMBER 10000
#define MODULO 10000
#define RANDOM rand() % MODULO + 1

void delete (void *k) {} //Pas besoin de 'free(k)' puisque les données des 'nodes' sont des entiers (Donc pas d'allocation de mémoire)

int compare(void *i, void *j) {
    assert(i != NULL && j != NULL);

    int x = *(int *)i;
    int y = *(int *)j;
    if (x == y) {
        return 0;
    } else if (x > y) {
        return 1;
    } else {
        return -1;
    }
}

void print(void *i) {
    int x = *(int *)i;
    printf(" int vaut %i", x);
}


int main() {

    // Pour les nombres aléatoires
    srand(time(NULL));

    int i = RANDOM;
    Tree *root = tree_new(&i, sizeof(int));

	clock_t temps_initial, temps_final; /* Temps final en micro-secondes */
	float temps_cpu; /* Temps total en secondes */
	
	temps_initial = clock ();
	
    for (unsigned int i = 0; i < NUMBER; i++) {
        int random = RANDOM;
        root = tree_insert(root, &random, &compare, sizeof(int));

        // tree_show_pre(root, &print);
        if (search(root, &random, &compare) == NULL) {
            printf("err\n");
        }

        assert(search(root, &random, &compare) != NULL);
    }

	
	temps_final = clock ();
	temps_cpu = (temps_final - temps_initial) * 1e-6;
	
	printf("%d value(s) inserted !\n", NUMBER);
    printf( "Finished in %f ms\n", temps_cpu );  
    tree_destroy(root, &delete);

    return EXIT_SUCCESS;
}

