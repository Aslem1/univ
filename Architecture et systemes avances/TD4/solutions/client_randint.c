#include <fcntl.h>
#include <mqueue.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/time.h>

int main(int argc,char * argv[])
{
    mqd_t mq;
    int taille;
    struct mq_attr attr;
    char * buffer;
    
    if (argc != 2) {
        fprintf(stderr, "usage: %s nom_file_message", argv[0]);
        exit(EXIT_FAILURE);
    }

    mq = mq_open(argv[1], O_RDONLY | O_CREAT, 0600, NULL);
    if (mq == (mqd_t) -1) {
        perror(argv[1]);
        exit(EXIT_FAILURE);
    }

    if (mq_getattr(mq, & attr) != 0) {
        perror("mq_getattr");
        exit(EXIT_FAILURE);
    }
    taille = attr.mq_msgsize;
    buffer = malloc(taille);

    if (buffer == NULL) {
        perror("malloc");
        exit(EXIT_FAILURE);
    }

    
    while (1) {
        mq_receive(mq, buffer, taille, NULL);
        fprintf(stdout, "%d \n", *((int*)buffer));
    }
    return EXIT_SUCCESS;
}
