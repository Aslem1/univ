#include <fcntl.h>
#include <mqueue.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/time.h>

int main(int argc,char * argv[])
{
    mqd_t mq;

    if (argc != 2) {
        fprintf(stderr, "usage: %s nom_file_message", argv[0]);
        exit(EXIT_FAILURE);
    }

    mq = mq_open(argv[1], O_WRONLY | O_CREAT, 0600, NULL);
    if (mq == (mqd_t) -1) {
        perror(argv[1]);
        exit(EXIT_FAILURE);
    }
    while (1) {
      int alea;
        alea=rand();
        fprintf(stdout, "%d \n", alea);
        mq_send(mq,(const char *) & alea, sizeof(int), 1);
        sleep(1);
    }
    return EXIT_SUCCESS;
}









