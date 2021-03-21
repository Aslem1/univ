#include <stdlib.h>
#include <stdio.h>
#include <unistd.h>
#include <fcntl.h>

// trois fils avec 3 exec + wait dans le père. 
int
main(void){
  int pipeA[2]; // tableaux pour les pipes 
  int pipeB[2];
  int ret;
  pid_t pid; // retour du fork

  // premier pipe
  ret = pipe(pipeA);
  if (ret == -1){
    fprintf(stderr, "Can not create the pipe\n");
    exit(EXIT_FAILURE);
  }

  // Premier fils + exec
  pid = fork();
  if( pid == 0 ) { // fils
    close(pipeA[0]); // on utilise que l'entree du pipeA dans ce processus
                     // donc  on clot la sortie

    close(1); // sortie standard fermée, 1 = STDIN_FILENO
    dup(pipeA[1]); // et remplacée par celle du pipeA
    close(pipeA[1]);

    execlp("ps", "ps", "aux" ,  NULL);
  }
  else if (pid == -1){ // gestion de l'erreur sur fork
    fprintf(stderr, "Can not fork\n"); // mieux perror
    close(pipeA[0]); // liberation des ressources allouées
    close(pipeA[1]);
    exit(EXIT_FAILURE);
  }

  close(pipeA[1]);

    // second pipe
  ret = pipe(pipeB);
  if (ret == -1){
    fprintf(stderr, "Can not create the pipe\n");
    close(pipeA[0]);
    exit(EXIT_FAILURE);
  }
  
  // Second fils + exec
  pid = fork();
  if( pid == 0 ) {
    close(pipeB[0]); // inutilisé donc fermé.

    close(0); // Stdin remplacé par le pipeA
    dup(pipeA[0]);
    close(pipeA[0]);

    close(1); // stdout : pipeB
    dup(pipeB[1]);
    close(pipeB[1]);

    execlp("grep", "grep", "root", NULL);
  }
  else if (pid == -1){ // erreur
    fprintf(stderr, "Can not fork\n");
    close(pipeA[0]);
    close(pipeB[1]);
    close(pipeB[0]);
    exit(EXIT_FAILURE);
  }

  close(pipeA[0]);
  close(pipeB[1]);

  // troisieme fils 
  pid = fork();
  if( pid == 0 ) {
    // sortie standard non modifiée
    close(0); // redirection de l'entrée
    dup(pipeB[0]);
    close(pipeB[0]);

    execlp("wc", "wc", "-l", NULL);
  }
  else if (pid == -1){
    fprintf(stderr, "Can not fork\n");
    close(pipeB[0]);
    exit(EXIT_FAILURE);
  }

  close(pipeB[0]);
  wait(NULL); // attente la terminaison du dernier fils.
  // on peut utiliser un waitpid avec le dernier pid (3eme fils).
  return 0;
}
