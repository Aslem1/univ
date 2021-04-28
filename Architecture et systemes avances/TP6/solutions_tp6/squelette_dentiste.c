#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <pthread.h>
#include <semaphore.h>

/* pour dentiste1 : Nonbre de sieges de la salle d'attente */
#define NB_PLACES 2




void main(void)
{
    /* Thread du dentiste */
    pthread_t t_dentiste;
    /* Pointeur sur thread pour les patients */
    pthread_t *pt_patients;

    /* On crée le dentiste */
    /* creation du thread dentiste */
    // A COMPLETER
    
    /* Quand l'utilisateur fait un retour de chariot, on lance un client */
    while(1)
    {
        getchar(); // Attend l'appui sur une touche
        printf("> Arrivé d'un patient.\n");
         /* On crée le patient */
        pt_patients=// allocation de la place mémoire pour un thread
        /* creation d'un thread patient */
        // A COMPLETER
    }

    /* Quand le dentiste termine, on quitte */
    pthread_join(t_dentiste, NULL);
}
