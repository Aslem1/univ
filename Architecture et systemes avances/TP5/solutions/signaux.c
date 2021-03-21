#include <stdio.h>
#include <signal.h>
#include <unistd.h>


int nsig[NSIG]; // tableau pour compter les signaux reçus

// mise en place du gestionnaire de signal
void handler(int s) {
    printf("Signal %d recu %d fois\n", s, ++nsig[s]);
}


int main(void) {
    int numero;

    for (numero = 1; numero < NSIG; numero++) {
        if (signal(numero, handler) == SIG_ERR)
            fprintf(stderr, "Je ne peux pas attraper le signal no %d\n", numero);
        nsig[numero] = 0;
    }

    while (1) pause();
}

