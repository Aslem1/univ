#include <fcntl.h>
#include <mqueue.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/time.h>

int main(int argc,char * argv[])
{
    mqd_t mq;
    int i;
    if (argc != 2) {
        fprintf(stderr, "usage: %s nom_file_message", argv[0]);
        exit(EXIT_FAILURE);
    }

    mq = mq_open(argv[1], O_WRONLY | O_CREAT, 0600, NULL);
    if (mq == (mqd_t) -1) {
        perror(argv[1]);
        exit(EXIT_FAILURE);
    }
    for(i=0;i<10;i++){
      int alea;
        alea=rand();
        fprintf(stdout, "%d \n", alea);
        mq_send(mq,(const char *) & alea, sizeof(int), 1);
        sleep(1);
    }
    
    if (mq_close(mq) == -1) {
        perror("Serveur: mq_close");
        exit(1);
    }

    if (mq_unlink(argv[1]) == -1) {
        perror("Serveur: mq_unlink");
        exit(1);
    }
    printf("Serveur: bye\n");
    return EXIT_SUCCESS;
}
