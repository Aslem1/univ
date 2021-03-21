#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <unistd.h>
#include <sys/stat.h>
#include <string.h>
#include <sys/file.h>

// version avec 2 fork + exec dans le pere
// version "+ astucieuse"
int main(void) {
    int p[2]; // la variable sera réutilisée
    pid_t pid; // retour du fork

    if (pipe(p) == -1) {
        perror("pipe"); // erreur
        exit(1);
    }
    if ((pid = fork()) == -1) {
        perror("fork");
        exit(1);
    }
    if (pid == 0) {
        close(p[0]);
        dup2(p[1], STDOUT_FILENO); // close(1)+dup,STDOUT_FILENO==1
        close(p[1]);

        execlp("ps", "ps", "-edf", NULL);
        perror("execlp"); // jamais exécuté sauf en cas d'erreur
        exit(1);
    }
    close(p[1]);
    
    dup2(p[0], STDIN_FILENO);

    if (pipe(p) == -1) {
        perror("pipe");
        exit(1);
    }
    if ((pid = fork()) == -1) {
        perror("fork");
        exit(1);
    }
    if (pid == 0) {
        close(p[0]);
        dup2(p[1], STDOUT_FILENO);

        execlp("grep", "grep", "root", NULL);
        perror("execlp");
        exit(1);
    }
    // ici pas de 3eme fork mais utilisation du processus père
    close(p[1]);
    dup2(p[0], STDIN_FILENO);

    execlp("wc", "wc", "-l", NULL);
    perror("execlp");
    exit(1);
} 
