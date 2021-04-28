#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>

void
usage(void){
  fprintf(stderr, "fork_loop [nbFork]\n");
  exit(EXIT_FAILURE);
}

int
main(int argc, char* argv[]){
  int nbFork;

  if (argc != 2){
    usage();
  }

  nbFork = atoi(argv[1]);

  for(int i=0; i<nbFork; i++){
    int pid_f;
    if(pid_f=fork()) printf("pid = %8d, pid_f = %8d, i = %8d\n", getpid(),pid_f, i);
    
  }
}
