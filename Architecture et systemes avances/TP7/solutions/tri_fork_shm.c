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

int is_sort(int n, int t[])
{
    int i;
    for (i=1; i < n; i++)
        if( t[i] < t[i-1] )
            return 1;
    return 0;
}


void merge(int n, int t1[], int t2[])
{
    int i=0, j=0, k=0;
    int t[2*n];

    while (i < n && j < n) 
        t[k++] = (t1[i] <= t2[j])? t1[i++] : t2[j++];

    while (i < n) 
        t[k++] = t1[i++];

    while (j < n)
        t[k++] = t2[j++];

    for (k=0; k < n; k++)
        t1[k] = t[k  ],
        t2[k] = t[k+n];
}

void mergesort(int n, int t[])
{
    if (n == 1) return;


// Pas Parallel version
    /*
    mergesort(n/2, t);
    mergesort(n/2, t + n/2);
    merge(n/2, t, t+n/2);
    */

// Parallel version
    sem_t * sem = mmap(NULL, sizeof(sem_t), PROT_READ | PROT_WRITE, MAP_SHARED | MAP_ANONYMOUS, -1, 0);

    sem_init(sem, 1, 0);
    if (fork() == 0)
    {
        mergesort(n/2, t + n/2);
        sem_post(sem);
        exit(0);
    }
    else
    {
        mergesort(n/2, t);
        sem_wait(sem);
        merge(n/2, t, t+n/2);
    }

    sem_close(sem);
    sem_destroy(sem);
}

int main()
{

    int i;
    int n = 256;
//  int t[n];
    int fd;
    if ((fd = shm_open("/sem_fork", O_RDWR | O_CREAT, 0600)) ==-1) {
        perror("/sem_fork");
        exit(EXIT_FAILURE);
    }
    if (ftruncate(fd, sizeof(int)*n) != 0) {
        perror("ftruncate");
        exit(EXIT_FAILURE);
    }

    int * t = mmap(NULL, sizeof(int)*n, PROT_READ | PROT_WRITE, MAP_SHARED , fd, 0);

    for (i=0; i < n; i++)
        t[i] = rand()%1000;

    if (is_sort(n, t))  printf("Pas OK !\n");
    else                printf("OK !\n");

    mergesort(n, t);

    if (is_sort(n, t))  printf("Pas OK !\n");
    else                printf("OK !\n");

    close(fd);
    shm_unlink("/sem_fork");
    

}
 
