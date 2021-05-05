//
// Created by lmascari on 22/04/18.
//

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/types.h>
#include <unistd.h>
#include <fcntl.h>
#include <sys/stat.h>
#include <mqueue.h>

#define SERVER_NAME "/serveur_mdp"
#define MSG_BUFFER_SIZE 256

int main(int argc, char **argv) {
  char client_queue_name[64];
  mqd_t qd_server, qd_client;
  char in_buffer[MSG_BUFFER_SIZE]; //buffer reception mdp
  struct mq_attr attr; //attribut queue serveur
  char temp_buf[10]; //buffer input clavier
  int n;
  
  // creation de la file du client queue pour recevoir des messages du serveur
  sprintf(client_queue_name, "/client_mdp_%d", getpid());
  

  if ((qd_client = mq_open(client_queue_name, O_RDONLY | O_CREAT, 0600, NULL)) == -1) {
    perror("Client: mq_open (client)");
    exit(1);
  }
  if ((qd_server = mq_open(SERVER_NAME, O_WRONLY)) == -1) {
    perror("Client: mq_open (serveur)");
    exit(1);
  }

  printf("Demande de MdP (Pressez <ENTREE>): ");
  
  while (fgets(temp_buf, 2, stdin)) { // envoi du messag vers le serveur
    if (mq_send(qd_server, client_queue_name, strlen(client_queue_name), 0) == -1) {
      perror("Client: pb lors de l'envoi du message");
      continue;
    } // reception de la reponse
    if (mq_getattr(qd_client, & attr) != 0) {
      perror("Client: mq_getattr");
      exit(EXIT_FAILURE);
    }
    if ((n=mq_receive(qd_client, in_buffer, attr.mq_msgsize, NULL)) == -1) {
      perror("Client: mq_receive");
      exit(1);
    }

    // affichage
    in_buffer[n] = '\0';
    printf("Client: MdP reçu du serveur: %s\n\n", in_buffer);
    printf("Demande de MdP (Pressez <ENTREE>): ");
  }


  if (mq_close(qd_client) == -1){ 
    perror("Client: mq_close");
    exit(1);
  }

  if (mq_unlink(client_queue_name) == -1) {
    perror("Client: mq_unlink");
    exit(1);
  }
  printf("Client: bye\n");

  exit(0);
}
