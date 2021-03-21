#include <signal.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>
#include <fcntl.h>


void handler_hup(int s) {
    FILE * f;

    f = fopen("sighup.txt", "w");
    fprintf(f,"Signal SIGHUP reçu");
    fclose(f);
    exit(EXIT_SUCCESS);
}

int
main(void){
  pid_t pid;

    if (signal(SIGHUP, handler_hup) == SIG_ERR)
        fprintf(stdout, "Je ne peux pas attraper le signal no %d\n", SIGHUP);
    pause();
  exit(EXIT_SUCCESS);
}

