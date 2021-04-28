/* gcc tri_thread2.c -o tri_thread2 -lr -lpthread */
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
#include <pthread.h>


#define N  4096 /* taille du tableau : puissance de 2 */

int t[N];

int is_sorted(int n, int t[])
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
       t1[k] = t[k],
       t2[k] = t[k+n];
}

/*  parametre du thread */
typedef struct {
  int n; /* taille à trier */
  int * t; /* @ de debut */
} atrier;

void* threaded_mergesort(void * tn)
{
  pthread_t tid_gauche, tid_droit;
  atrier * at=(atrier *) tn;
  int n=at->n;
  int * t=at->t;
  atrier gauche,droit;
   if (n == 1) return(NULL);
   //   mergesort(n/2, t);
   //   mergesort(n/2, t + n/2);
   gauche.n=n/2;
   gauche.t=t;
   droit.n=n/2;
   droit.t=t + n/2;

    pthread_create(&tid_gauche, NULL, threaded_mergesort, (void *)&gauche);
    pthread_create(&tid_droit, NULL, threaded_mergesort, (void *)&droit);
    pthread_join(tid_gauche, NULL);
    pthread_join(tid_droit, NULL);

   merge(n/2, t, t+n/2);
   pthread_exit(NULL) ; // ou return(NULL); pour appel "direct" 
}

int main()
{

   int i;
   atrier at;
 
  pthread_t tid_sort;
  
   for (i=0; i < N; i++)
       t[i] = rand()%1000;
   printf("Avant :\n");
   if (is_sorted(N, t))  printf("Pas trié !\n");
   else               printf("Trié !\n");
   
   at.n=N;
   at.t=t;
   //mergesort(n, t);
   pthread_create(&tid_sort, NULL, threaded_mergesort, (void *)&at);
   pthread_join(tid_sort, NULL);
   //ou threaded_mergesort((void *)&at); mais sans pthread_exit dans la fonction  threadee  (ou return)

   printf("Après :\n");
   if (is_sorted(N, t)) printf("Pas trié!\n");
   else               printf("Trié !\n");
   
  
  pthread_exit(NULL); 
}
