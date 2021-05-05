#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <unistd.h>
#include <ctype.h>

int position = 0;

int nbMinuscules = 0;
int nbMajuscules = 0;
int nbAutres = 0;

pthread_mutex_t mutexPosition=PTHREAD_MUTEX_INITIALIZER;

// Contrairement au mutex précédent, ceux-ci ne sont pas indispensables :
// le mutex précedent protégera toutes les variables dans la section critique.
pthread_mutex_t mutexMinuscules=PTHREAD_MUTEX_INITIALIZER;
pthread_mutex_t mutexMajuscules=PTHREAD_MUTEX_INITIALIZER;
pthread_mutex_t mutexAutres=PTHREAD_MUTEX_INITIALIZER;


void* compteMinuscules(void * ch){
    char * texte = (char*) ch;
    while(1){
        pthread_mutex_lock(&mutexPosition);
            if(texte[position]=='\0') {
                pthread_mutex_unlock(&mutexPosition);
                pthread_exit(NULL);
            }
            if(islower(texte[position])){
                pthread_mutex_lock(&mutexMinuscules);
                nbMinuscules++;
                pthread_mutex_unlock(&mutexMinuscules);
                position++;
            }
        pthread_mutex_unlock(&mutexPosition);
    }
}

void* compteMajuscules(void * ch){
    char * texte = (char*) ch;
    while(1){
        
        pthread_mutex_lock(&mutexPosition);
            if(texte[position]=='\0') {
                pthread_mutex_unlock(&mutexPosition);
                pthread_exit(NULL);
            }
            if(isupper(texte[position])){
                //pthread_mutex_lock(&mutexMajuscules);
                nbMajuscules++;
                //pthread_mutex_unlock(&mutexMajuscules);
                position++;               
            }
        pthread_mutex_unlock(&mutexPosition);
    }    
}

void* compteAutres(void * ch){
    char * texte = (char*) ch;
    while(1){
        pthread_mutex_lock(&mutexPosition);
            if(texte[position]=='\0') {
                pthread_mutex_unlock(&mutexPosition);
                pthread_exit(NULL);
            }
            if(!islower(texte[position])&&!isupper(texte[position])){
                //pthread_mutex_lock(&mutexAutres);
                nbAutres++;
                //pthread_mutex_unlock(&mutexAutres);
                position++; 
            }
        pthread_mutex_unlock(&mutexPosition);
    }    
}

int main (void){
    
    char * texte="Lorem ipsum dolor sit amet, consectetur\
adipiscing elit.  Proin neque sapien,\
facilisis eget tincidunt ut, porttitor\
laoreet lacus. Class aptent taciti\
sociosqu ad litora torquent per conubia\
nostra, per inceptos himenaeos.  Etiam\
semper elementum congue.";
    
    pthread_t thr[3];
    
    if(pthread_create(thr, NULL, compteMinuscules, (void*) texte )){
            fprintf(stderr, "Erreur dans pthread_create\n");
        }
    if(pthread_create(thr+1, NULL, compteMajuscules, (void*) texte )){
            fprintf(stderr, "Erreur dans pthread_create\n");
        }
    if(pthread_create(thr+2, NULL, compteAutres, (void*) texte )){
            fprintf(stderr, "Erreur dans pthread_create\n");
        }
        
    pthread_join(thr[0], NULL);
    pthread_join(thr[1], NULL);
    pthread_join(thr[2], NULL);
    

    printf("Nombre de minuscules : %d\n",nbMinuscules);

    printf("Nombre de majuscules : %d\n",nbMajuscules);

    printf("Nombre d'autres caracteres : %d\n",nbAutres);
 
}

