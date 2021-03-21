#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <fcntl.h>
 
int main(int argc, char *argv[])
{
    int fdIn;
    int fdOut;
    int nbRead;
    char buffer[1000];
   
    /* Vérification des arguments */
    if (argc != 3) {
        printf("Cette commande nécessite deux arguments");
        exit(EXIT_FAILURE);
    }
 
    /* Ouverture du fichier source */
    fdIn = open(argv[1], O_RDONLY, 0);
 
    if ( -1 == fdIn  ) {
        printf("Erreur dans l'ouverture du fichier \n");
        exit(EXIT_FAILURE);
    }
 
    /* Ouverture du fichier destination */
    fdOut = open(argv[2], O_WRONLY | O_CREAT, 0666);
 
    if (-1 == fdOut) {
        printf("Erreur dans l'ouverture du fichier de destination");
        close(fdIn);
        exit(EXIT_FAILURE);
    }
 
 
    /* On utilise read pour envoyer le contenu du fichier1 vers le buffer */
    nbRead = read(fdIn, buffer, sizeof(buffer));
    while (nbRead > 0) {
        write(fdOut, buffer, nbRead);
        nbRead = read(fdIn, buffer, sizeof(buffer));
    }
 
    printf("La copie a du s'effectuer, verifiez le fichier de destination");
 
    close(fdIn);
    close(fdOut);
    exit(EXIT_SUCCESS);
}
