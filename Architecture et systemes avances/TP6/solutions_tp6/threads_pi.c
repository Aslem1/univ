#include <pthread.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>

#define N 1000

long s = 0;


void *compte(void *arg) {
/* le probleme vient de la taille d’un double qui ne peut être casté en void *
 il faut donc passer par un pointeur pour la valeur de retour...
 */
    double *s=malloc(sizeof(double));
    long v=(long)arg;
    *s=1.0/(v*v);
    printf("%f\n",*s);
    pthread_exit((double*)s);
}

int main(int argc, char *argv[]) {
    pthread_t tid[N];
    int ret;
    for (long i = 0; i < N; i++) {
        if (ret=pthread_create(&tid[i], NULL, compte, (void *) (i+1))) {
            fprintf(stderr, "%s", strerror(ret));
            exit(1);
        }
    }
    double somme=0.0;
    for (long i = 0; i < N; i++) {
        void *sp;
        if (ret=pthread_join(tid[i], &sp))        
        {
            fprintf(stderr, "%s", strerror(ret));
            exit(1);
        }
        if (sp != PTHREAD_CANCELED) {
            somme += *(double *) sp;
        }
        free(sp);
    }
            printf("\n Approximation de pi : %f\n", sqrt(6*somme));
    pthread_exit(NULL);
}
