#include<stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <unistd.h>
#include <sys/wait.h>

int main(void)
{  pid_t pid;

   if ((pid = fork()) == -1)
   {  
       perror("fork"); exit(1);
   }
   if (pid == 0)
   {  execlp("who", "who", NULL);
      exit(1);
   }
   


   if ((pid = fork()) == -1)
   {  
       perror("fork"); exit(1);
   }
   if (pid == 0)
   {  
    
      execlp("ps", "ps", NULL);
      exit(1);
   }

   execlp("ls", "ls", "-l", NULL);
   perror("execlp");
   exit(1);
}

