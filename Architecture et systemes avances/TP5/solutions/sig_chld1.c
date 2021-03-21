#include <signal.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>
#include <fcntl.h>

void handler_chld(int s) {
    printf("Signal %d reçu\n", s);
    wait(NULL); // permet de recupérer le code retour du fils : pas de zombies
}


int
main(void){
  pid_t pid;

  pid = fork();

  switch (pid) {
    case -1:
      fprintf(stderr, "Probleme de fork()\n");
      exit(EXIT_FAILURE);
      break;
    case 0:
      printf("Fils: pid %ld, parent pid %ld\n", (long)getpid(), (long)getppid());
      sleep(1);
      exit(0);
      break;
    default:
      if (signal(SIGCHLD, handler_chld) == SIG_ERR)
        fprintf(stdout, "Je ne peux pas attraper le signal no %d\n", SIGCHLD);
      pause();
      sleep(100);
  }
  exit(EXIT_SUCCESS);
}

