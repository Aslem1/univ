#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>

void
secondFork(void){
  pid_t pid;

  pid = fork();

  switch (pid) {
    case -1:
      fprintf(stderr, "Something bad happend\n");
      exit(EXIT_FAILURE);
      break;
    case 0:
      printf("Double fork : pid %ld, parent pid %ld\n", (long)getpid(), (long)getppid());
      printf("Don't talk, think that's a good rule of thumb for life. (Rick Grimes)\n");
      sleep(10);
      printf("Double fork : pid %ld, parent pid %ld\n", (long)getpid(), (long)getppid());
      break;
    default:
      return;
  }
}

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
      secondFork();
      break;
    default:
      printf("Parent Code: pid %ld, parent pid %ld\n", (long)getpid(), (long)getppid());
      wait(NULL);
  }
  exit(EXIT_SUCCESS);
}
