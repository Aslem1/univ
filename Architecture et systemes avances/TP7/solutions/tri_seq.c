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

void mergesort(int n, int t[])
{
   if (n == 1) return;

   mergesort(n/2, t);
   mergesort(n/2, t + n/2);
   merge(n/2, t, t+n/2);
}

int main()
{

   int i;
   int n = 4096;
    int t[n];

   for (i=0; i < n; i++)
       t[i] = rand()%1000;
   printf("Avant :\n");
   if (is_sorted(n, t))  printf("Pas trié !\n");
   else               printf("Trié !\n");

   mergesort(n, t);
   printf("Après :\n");
   if (is_sorted(n, t)) printf("Pas trié!\n");
   else               printf("Trié !\n");

}
