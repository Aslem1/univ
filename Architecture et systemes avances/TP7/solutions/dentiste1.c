#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <pthread.h>
#include <semaphore.h>

/* Nonbre de sieges de la salle d'attente */
#define NB_PLACES 2

/* Les trois semaphores */
sem_t mutex;
sem_t patients;
sem_t dentiste;

int en_attente=0;

void* fonction_dentiste(void *ptr);
void* fonction_patient(void *ptr);

void main(void)
{
    /* Thread du dentiste */
    pthread_t t_dentiste;
    /* Ptr sur thread pour les patients */
    pthread_t *pt_patients;

    /* Init des semaphores */
    sem_init(&patients, 0, 0);
    sem_init(&dentiste, 0, 0);
    sem_init(&mutex, 0, 1);

    /* On demarre le dentiste */
    pthread_create(&t_dentiste, NULL, fonction_dentiste, NULL);

    /* Quand l'utilisateur user fait un retour de chariot, on lance un client */
    while(1)
    {
        getchar();
        printf("> Arrivé d'un patient.\n");
        pt_patients=malloc(sizeof(pthread_t));
        pthread_create(pt_patients, NULL, fonction_patient, NULL);
    }

    /* Quand le dentiste termine, on quitte */
    pthread_join(t_dentiste, NULL);
}

void* fonction_dentiste(void *ptr)
{
    int i;
    printf("Ouverture du cabinet.\n");
    while(1)
    {
        sem_wait(&patients);
        sem_wait(&mutex);
        en_attente--;
        sem_post(&mutex);
        sem_post(&dentiste);

        printf("Dentiste : je reçois un nouveau patient\n");
        sleep(2);
        printf("Dentiste : Au suivant !\n");
    }
}

void* fonction_patient(void *ptr)
{
    sem_wait(&mutex);
    if(en_attente<NB_PLACES){
        en_attente++;
        printf("Patient : Il reste %i places de libre.\n", NB_PLACES-en_attente);
        sem_post(&mutex);
        sem_post(&patients);

        sem_wait(&dentiste);
        printf("Patient : Je rentre dans la piece et me fait soigner.\n");

    } else {
        sem_post(&mutex);
        printf("Patient : Plus de place, je rentre chez moi.\n");
    }
}
