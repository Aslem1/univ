//
// Created by lmascari on 22/04/18.
//

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/types.h>
#include <fcntl.h>
#include <sys/stat.h>
#include <mqueue.h>

#define SERVER_NAME "/serveur_mdp"
#define MSG_BUFFER_SIZE 256

void rand_str(char *dest, size_t length) {
    char charset[] = "0123456789"
                     "abcdefghijklmnopqrstuvwxyz"
                     "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    while (length-- > 0) {
        size_t index = (double) rand() / RAND_MAX * (sizeof charset - 1);
        *dest++ = charset[index];
    }
    *dest = '\0';
}

int main(int argc, char **argv) {
    mqd_t qd_server, qd_client;
    struct mq_attr attr;
    
    printf("Serveur: Hello, World!\n");


    attr.mq_flags = 0;
    attr.mq_maxmsg = 10;
    attr.mq_msgsize = MSG_BUFFER_SIZE-10; // la taille du buffer doit etre supérieure à celle de mq_msgsize 
    attr.mq_curmsgs = 0;
    
    if ((qd_server = mq_open(SERVER_NAME, O_RDONLY | O_CREAT, 0600, &attr)) == -1) {
        perror("Serveur: mq_open (server)");
        exit(1);
    }
    char in_buffer[MSG_BUFFER_SIZE];
    char out_buffer[MSG_BUFFER_SIZE];
    while (1) {
        int n;
        if ((n=mq_receive(qd_server, in_buffer, MSG_BUFFER_SIZE, NULL)) == -1) {
            perror("Serveur: mq_receive");
            exit(1);
        }
        in_buffer[n]='\0';
        printf("Serveur: message reçu : %s\n",in_buffer);
        if ((qd_client = mq_open(in_buffer, O_WRONLY)) == 1) {
            perror("Serveur: mq_open (client)");
            continue;
        }
        rand_str(out_buffer, random()%13+8);
        printf("%s\n",out_buffer);
        if (mq_send(qd_client, out_buffer, strlen(out_buffer), 0) == -1) {
            perror("Serveur: pb envoi de message au client");
            continue;
        }
        printf("Serveur: reponse envoyée au client.\n");

    }
}
