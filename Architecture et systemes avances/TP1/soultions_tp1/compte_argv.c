#include <stdio.h>
#include <stdlib.h>

int
main(int argc, char** argv){
  int res = 0;

  for(int i=1; i<argc; i++){
    res += atoi(argv[i]);
  }
  printf("Somme = %d\n", res);
  exit(EXIT_SUCCESS);
}
