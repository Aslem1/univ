#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <fcntl.h>
#include <sys/types.h>
#include <sys/shm.h>
#include <sys/stat.h>
#include <sys/mman.h>
#include <time.h>
#include <semaphore.h>
#include <pthread.h>


#define N 5 /* nombre de places dans l'ascenseur */
#define NOMBRE_VISITEURS 10 /* nombre de visiteurs */

int en_attente = 0;
pthread_mutex_t mutex=PTHREAD_MUTEX_INITIALIZER;

sem_t ascenseur;
sem_t monte;


void * fonction_ascenseur(void* arg){
    
    while(1){
        
        printf("Ascenseur : J'ouvre les portes\n");
        pthread_mutex_lock(&mutex);
        if(en_attente == 0){
            printf("Ascenseur : Personne, je ferme les portes\n");
            pthread_mutex_unlock(&mutex);
            printf("Ascenseur : J'attends\n");
            sleep(1);
        }
        else{
            int dans_ascenseur = 0;
            while(en_attente > 0 && dans_ascenseur < N){
                sem_post(&ascenseur);
                sem_wait(&monte);
                dans_ascenseur++;
                en_attente--;
            }
            printf("Ascenseur : Je ferme les portes\n");
            printf("Ascenseur : Depart avec %d personnes\n",dans_ascenseur);
            pthread_mutex_unlock(&mutex);
        }
    }   
}

void * fonction_visiteur(void* arg){
    pthread_mutex_lock(&mutex);
    usleep(rand()%500);
    en_attente++;
    pthread_mutex_unlock(&mutex);
    
    sem_wait(&ascenseur);
    printf("\t\tVisiteur : Je monte dans l'ascenceur\n");
    sem_post(&monte);
}

int main(void){
    sem_init(&ascenseur,0,0);
    sem_init(&monte,0,0);
    
    pthread_t thread_ascenseur, thread_visiteurs[NOMBRE_VISITEURS];
    
    if(pthread_create(&thread_ascenseur, NULL, fonction_ascenseur, NULL)){
            fprintf(stderr, "Erreur dans pthread_create\n");
        }
        
    for(int i=0;i<NOMBRE_VISITEURS;i++){
        if(pthread_create(&thread_visiteurs[i], NULL, fonction_visiteur, NULL)){
                fprintf(stderr, "Erreur dans pthread_create\n");
            }
    }
    
    
    pthread_join(thread_ascenseur, NULL);  
    
    // Inutile dans la version actuelle : boucles infinies sur l'ascenseur
    for(int j=0;j<NOMBRE_VISITEURS;j++){       
        pthread_join(thread_visiteurs[j], NULL);       
    }
    
    pthread_exit(EXIT_SUCCESS);
    
}
