#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <pthread.h>
#include <semaphore.h>

sem_t s1,s2;

void *threads_fils(void *argument){
    for(int i=1;i<=100;i+=2){
        sem_wait(&s2);
        printf("%d\n",i);
        sem_post(&s1);
    }
    pthread_exit(0);
}
int main() {
    pthread_t thread;
    int ret;
    sem_init(&s1, 0, 1);
    sem_init(&s2, 0, 0);
    if ((ret = pthread_create(&thread, NULL, threads_fils, NULL)) != 0) {
        fprintf(stderr, "%s\n", strerror(ret));
        exit(EXIT_FAILURE);
    }
    for(int i=0;i<=100;i+=2){
        sem_wait(&s1);
        printf("%d\n",i);
        sem_post(&s2);
    }
    pthread_exit(0);
}
