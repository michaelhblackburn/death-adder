#include <stdlib.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <unistd.h>
#include <stdio.h>
#include <fcntl.h>

void fork_and_exec (char **args, char *full_arg_cmd, char *redir_in, char *redir_out){
   int pid, status;

   if ((pid = fork ()) < 0){
      perror ("fork");
      exit (1);
   }
   if (pid == 0){
      //redirect goes here!!!
      fflush(0);
      if (redir_in[0] != '\0'){
        int fd0 = open(redir_in, O_RDONLY, 0);
        dup2(fd0, STDIN_FILENO);
        close(fd0);
      }

      if (redir_out[0] != '\0'){
        int fd1 = creat(redir_out, 0644);
        dup2(fd1, STDOUT_FILENO);
        close(fd1);
      }
      execv (full_arg_cmd, args);
      perror (*args);
      exit (1);
   }
   while (wait (&status) != pid)
      /* empty */ ;
}
