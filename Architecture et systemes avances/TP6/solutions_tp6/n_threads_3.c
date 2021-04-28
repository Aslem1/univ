#include <pthread.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define N 20

long s = 0;

void *compte(void *arg) {
    printf("%ld\n",*(long*) arg);
    return(arg);
}
int main(int argc, char *argv[]) {
    pthread_t tid[N];
    int ret;
    long it[N];
    for (long i = 0; i < N; i++) {
        it[i]=i;
        if (ret=pthread_create(&tid[i], NULL, compte, (void *) & it[i])) {
            fprintf(stderr, "%s", strerror(ret));
            exit(1);
        }
    }
    for (int i = 0; i < N; i++) {
        long * resultat;
        if (ret=pthread_join(tid[i], (void*)&resultat))      
        {
            fprintf(stderr, "%s", strerror(ret));
            exit(1);
        }
        s+=*resultat;
    }
    if (s != (N*(N-1))/2)
        printf("\n Erreur! s vaut : %d, au lieu de %d\n", s, (N*(N-1))/2);
    else
        printf("\n OK!  s vaut : %d\n", s);
    pthread_exit(NULL);
}
