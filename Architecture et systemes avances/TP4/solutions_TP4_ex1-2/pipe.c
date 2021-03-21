#include <stdlib.h>
#include <stdio.h>
#include <unistd.h>
#include <fcntl.h>

#define BUFF_SIZE 1000

void
child1(char *fileIn, int pipe[]){
  int nbRead, fin;
  char buffer[BUFF_SIZE];

  fin = open(fileIn, O_RDONLY, 0666);
  if (fin == -1) {
      fprintf(stderr, "Can not open the file %s (READ)\n", fileIn);
      exit(EXIT_FAILURE);
  }

  // Je n'utilise pas la lecture, pipe[0], sur ce processus donc je le ferme
  close(pipe[0]);

  nbRead = read(fin, buffer, sizeof(buffer));
  while (nbRead > 0) {
    write(pipe[1], buffer, nbRead);
    nbRead = read(fin, buffer, sizeof(buffer));
  }

  close(fin);

  // Je n'utilise plus l'écriture, pipe[1], sur ce processus donc je le ferme
  close(pipe[1]);

  return;
}

void
child2(char *fileOut, int pipe[]){
  int nbRead, fou;
  char buffer[BUFF_SIZE];

  fou = open(fileOut, O_WRONLY|O_CREAT|O_TRUNC, 0666);
  if (fou == -1) {
      fprintf(stderr, "Can not open the file %s (WRITE)\n", fileOut);
      exit(EXIT_FAILURE);
  }

  // Je n'utilise pas l'écriture, pipe[1], sur ce processus donc je le ferme
  close(pipe[1]);

  nbRead = read(pipe[0], buffer, sizeof(buffer));
  while (nbRead > 0) {
      write(fou, buffer, nbRead);
      nbRead = read(pipe[0], buffer, sizeof(buffer));
  }
  close(fou);

  // Je n'utilise plus la lecture, pipe[0], sur ce processus donc je le ferme
  close(pipe[0]);

  return;
}

int
main(int argc, char **argv){
  pid_t pid;
  int fd[2];

  if (argc != 3){
    fprintf(stderr, "You need two arguments, file in and file out\n");
    exit(EXIT_FAILURE);
  }

  if (pipe(fd) == -1){
    fprintf(stderr, "Can not create the pipe\n");
    exit(EXIT_FAILURE);
  }

  if ((pid=fork()) == -1){
    fprintf(stderr, "Can not fork\n");
    exit(EXIT_FAILURE);
  }
  if (pid == 0){
    child1(argv[1], fd);
    exit(EXIT_SUCCESS);
  }

  if ((pid=fork()) == -1){
    fprintf(stderr, "Can not fork\n");
    exit(EXIT_FAILURE);
  }
  if (pid == 0){
    child2(argv[2], fd);
    exit(EXIT_SUCCESS);
  }

  // Après le dernier fork() du fils qui va utiliser le pipe, on ferme le pipe sur le père car on ne l'utilise pas
  close(fd[0]);
  close(fd[1]);

  exit(EXIT_SUCCESS);
}
