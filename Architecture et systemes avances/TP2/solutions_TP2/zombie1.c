#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>


int
main(void){
  pid_t pid;

  pid = fork();

  switch (pid) {
    case -1:
      fprintf(stderr, "Something bad happend\n");
      exit(EXIT_FAILURE);
      break;
    case 0:
      printf("Child Code: pid %ld, parent pid %ld\n", (long)getpid(), (long)getppid());
      break;
    default:
      printf("Parent Code: pid %ld, parent pid %ld\n", (long)getpid(), (long)getppid());
      while (1){
        sleep(10);
      }
  }
  exit(EXIT_SUCCESS);
}
