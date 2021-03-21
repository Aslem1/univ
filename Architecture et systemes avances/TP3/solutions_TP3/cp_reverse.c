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
        fprintf(stderr,"Cette commande nécessite deux arguments");
        exit(EXIT_FAILURE);
    }
 
    /* Ouverture du fichier source */
    fdIn = open(argv[1], O_RDONLY, 0);
 
    if (-1 == fdIn) {
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
    long offset = nbRead;
    while (nbRead > 0) {
        
        // inversion du buffer en mémoire
        for(int i=0; i < nbRead/2;i++){
            char c=buffer[i];
            buffer[i]=buffer[nbRead-i-1];
            buffer[nbRead-i-1]=c;
        }
   
        // déplacement à partir de la fin du fichier du nombre d'octets lus 
        lseek(fdOut, -offset, SEEK_END);
        write(fdOut, buffer, nbRead);
        nbRead = read(fdIn, buffer, sizeof(buffer));
        offset += nbRead;
    }
  
    close(fdIn);
    close(fdOut);
    exit(EXIT_SUCCESS);
}
