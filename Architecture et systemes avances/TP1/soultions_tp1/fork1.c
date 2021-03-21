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
      fprintf(stderr, "Something bad happened\n");
      exit(EXIT_FAILURE);
      break;
    case 0: // fils
      printf("Child Code: pid %ld, parent pid %ld\n", (long)getpid(), (long)getppid());
      break;
    default: // pere
      printf("Parent Code: pid %ld, parent pid %ld\n", (long)getpid(), (long)getppid());
      wait(NULL);
  }
  exit(EXIT_SUCCESS);
}
