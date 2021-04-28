#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>

int
main(void){
      execl("/usr/bin/ps", "ps", "aux", NULL);
      fprintf(stderr, "Something bad happenned\n");
      exit(EXIT_FAILURE);
}
