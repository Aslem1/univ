#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>


int
main(int argc, char** argv){
     execlp("ps", "ps", "aux", NULL);
     fprintf(stderr, "Something bad happenned\n");
     exit(EXIT_FAILURE);
}
