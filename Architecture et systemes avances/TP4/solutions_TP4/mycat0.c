#include <stdlib.h>
#include <stdio.h>
#include <sys/types.h>
#include <sys/stat.h>

#include <unistd.h>
#include <fcntl.h>

#define BUFF_SIZE 3



int
main(){

    char buf[BUFF_SIZE];
    int n;

  while((n=read(STDIN_FILENO,buf,BUFF_SIZE) )>0){
    if(write(STDOUT_FILENO,buf,n)==0){
        perror("Write ");
        exit(EXIT_FAILURE);
    }
  }

 


  exit(EXIT_SUCCESS);
}
