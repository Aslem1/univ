#include <signal.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>
#include <fcntl.h>


void handler_hup(int s) {
    int fdOut;
    char* ch="Signal SIGHUP reçu";

    fdOut = open("sighup.txt", O_WRONLY | O_CREAT, 0666);
    write(fdOut, ch, strlen(ch));
    close(fdOut);
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

