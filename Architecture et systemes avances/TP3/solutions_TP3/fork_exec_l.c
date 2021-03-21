#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>

int
main(void){
  pid_t pid;
  int wstatus;

  pid = fork();

  switch (pid) {
    case -1:
      fprintf(stderr, "Something bad happenned\n");
      exit(EXIT_FAILURE);
      break;
    case 0:
      execl("/usr/bin/ps", "ps", "aux", NULL);
      break;
    default:
      printf("Parent Code: pid %ld, parent pid %ld\n", (long)getpid(), (long)getppid());
      wait(&wstatus);
      if (WIFEXITED(wstatus)) {
          printf("Process %ld exit with code: %d\n",(long) pid,WEXITSTATUS(wstatus));
      }
  }
  exit(EXIT_SUCCESS);
}
