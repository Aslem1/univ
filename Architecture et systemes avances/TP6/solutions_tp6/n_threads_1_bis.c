#include <pthread.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define N 20

long s = 0; 
pthread_mutex_t mutex;

void *compte(void *arg) {
    printf("%ld\n",(long)arg);
    pthread_exit(arg);
}

int main() {
    pthread_t tid[N];
    int ret;
    for (long i = 0; i < N; i++) {
        if (ret=pthread_create(&tid[i], NULL, compte, (void *) i)) {
            fprintf(stderr, "%s", strerror(ret));
            exit(1);
        }
    }
    
    for (long i = 0; i < N; i++) {
        long resultat;
        if (ret=pthread_join(tid[i], (void*)&resultat))      
        {
            fprintf(stderr, "%s", strerror(ret));
            exit(1);
        } else {
            s+=resultat;
        }
    }


    if (s != (N*(N-1))/2)
        printf("\n Erreur! s vaut : %d, au lieu de %d\n", s, (N*(N-1))/2);
    else
        printf("\n OK!  s vaut : %d\n", s);

    
    pthread_exit(NULL);
}
