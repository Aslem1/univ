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
      while (1){
        printf("Child Code: pid %ld, parent pid %ld\n", (long)getpid(), (long)getppid());
        sleep(1);
      }
      break;
    default:
      printf("Parent Code: pid %ld, parent pid %ld, child pid %ld\n", (long)getpid(), (long)getppid(), pid);
  }
  exit(EXIT_SUCCESS);
}
printf("pid_t: %u\n", sizeof(pid_t));
