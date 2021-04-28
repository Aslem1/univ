#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>

int
main(void){
  char *cmd = "ps";
  char *cmd_argv[3];
  cmd_argv[0] = "ps";
  cmd_argv[1] = "aux";
  cmd_argv[2] = NULL;
      
  execvp(cmd, cmd_argv);
      
  fprintf(stderr, "Something bad happenned\n");
  exit(EXIT_FAILURE);
}
