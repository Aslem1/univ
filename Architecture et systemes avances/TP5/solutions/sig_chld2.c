#include <signal.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>
#include <fcntl.h>


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
      if (signal(SIGCHLD, SIG_IGN) == SIG_ERR)
        fprintf(stdout, "Je ne peux pas ignorer le signal no %d\n", SIGCHLD);
      sleep(100); // supprimer le pause sinon il ne s'arréte jamais (plus de signal reçu)
  }
  exit(EXIT_SUCCESS);
}

