#include <stdlib.h>
#include <stdio.h>
#include <sys/types.h>
#include <sys/stat.h>

#include <unistd.h>
#include <fcntl.h>

#define BUFF_SIZE 3



int
main(int argc, char **argv){

    char buf[BUFF_SIZE];
    int fd;
    int n;
  if (argc > 2){
    fprintf(stderr, "Usage : %s [file.txt]\n",argv[0]);
    exit(EXIT_FAILURE);
  }

  if (argc == 2){
    if((fd = open(argv[1],O_WRONLY|O_CREAT|O_TRUNC,0600)) == 0){
        perror("Open ");
        exit(EXIT_FAILURE);
    }
    /*close(STDOUT_FILENO);
    dup(fd);*/
    dup2(fd,STDOUT_FILENO);
  } else {
      fd =STDOUT_FILENO;
  }
  
  while((n=read(STDIN_FILENO,buf,BUFF_SIZE) )>0){
    if(write(STDOUT_FILENO,buf,n)==0){
        perror("Write ");
        exit(EXIT_FAILURE);
    }
  }

 
  close(fd);

  exit(EXIT_SUCCESS);
}
