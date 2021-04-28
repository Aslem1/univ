#include <stdio.h> 
#include <stdlib.h> 
#include <unistd.h> 
#include <sys/wait.h>
#include <sys/types.h>
#include <fcntl.h>

int main(int argc, char** argv) {
   pid_t pid, pid2;
   int wstatus;
   pid = fork();

   switch(pid) {
      case -1:
         fprintf(stderr, "Il y a un problème avec le processus père\n");
         exit(EXIT_FAILURE);
         break;
      case 0:         
         if(getpid()%2 != 0) {

             switch(pid2 = fork()) {
                case -1 :
                   fprintf(stderr, "Il y a un problème avec le processus fils 1\n");
                   exit(EXIT_FAILURE);
                   break;
                case 0 :
                   printf("Processus fils 2 : pid %ld, ppid %ld\n", (long)getpid(), (long)getppid());
                   break;
                default:
                   printf("Processus fils 1 : pid %ld, ppid %ld, fils %ld\n", (long)getpid(), (long)getppid(), (long)pid2);
             }

          } 
          else {
              printf("Processus fils 1 : pid %ld, ppid %ld, fils %ld\n", (long)getpid(), (long)getppid(), (long)pid2);
          }
       default:
          printf("Processus père : pid %ld, ppid %ld, fils %ld\n", (long)getpid(), (long)getppid(), (long)pid);
          wait(&wstatus);
   }

   exit(EXIT_SUCCESS);
}
