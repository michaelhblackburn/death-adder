/* fork.c - example of a fork in a program. The program asks for UNIX
commands to be typed and inputted to a string.  The string is then
"parsed" by locating blanks etc.  Each command and corresponding
arguments are put in a args array.  execvp is called to execute these
commands in child process spawned by fork() */

/* cc -Wall -o fork fork.c */

#include <stdio.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <sys/time.h>

/*
 * parse--split the command in buf into
 *         individual arguments.
 */
void parse (char *buf, char **args)
{
   while (*buf) {
      /*
       * Strip whitespace.  Use nulls, so
       * that the previous argument is terminated
       * automatically.
       */
      while ((*buf == ' ') || (*buf == '\t'))
	 *buf++ = '\0';

      /*
       * Save the argument.
       */
      *args++ = buf;

      /*
       * Skip over the argument.
       */
      while (*buf && (*buf != ' ') && (*buf != '\t'))
	 buf++;
   }

   *args = NULL;
}

/*
 * execute--spawn a child process and execute the program.
 */
void execute (char **args)
{
   int pid, status, sec1, sec2, usec1, usec2, time1, time2;
   struct timeval t1, t2;

   /*
    * Get a child process.
    */
   gettimeofday(&t1, NULL);
   sec1 = t1.tv_sec * 1000000;
   usec1 = t1.tv_usec;
   time1 = sec1 + usec1;
    
   if ((pid = fork ()) < 0) {
      perror ("fork");
      exit (1);

      /* NOTE: perror() produces a short error message on the standard
         error describing the last error encountered during a call to
         a system or library function.
      */
   }
   gettimeofday(&t2, NULL);
   sec2 = t2.tv_sec * 1000000;
   usec2 = t2.tv_usec;
   time2 = sec2 + usec2;

   /*
    * The child executes the code inside the if.
    */
   if (pid == 0) {
      execvp (*args, args);
      perror (*args);
      exit (1);

      /* NOTE: The execv() and execvp versions of execl() are useful
         when the number of arguments is unknown in advance; The
         arguments to execv() and execvp() are the name of the file to
         be executed and a vector of strings containing the arguments.
         The last argument string must be followed by a 0 pointer.

         execlp() and execvp() are called with the same arguments as
         execl()  and  execv(),  but duplicate the shell's actions in
         searching for an executable file in a list  of  directories.
         The directory list is obtained from the environment.  */
   }
   printf("%d \n", time2 - time1);
   //printf("Dif time is %d \n", t2.tv_sec - t1.tv_sec);
   /*
    * The parent executes the wait.
    */
   while (wait (&status) != pid)
      /* empty */ ;
}

int main ()
{
   char buf[1024];
   char *args[64];
   int i;

   for (;;) {
      /*
       * Prompt for and read a command.
       */
      printf ("Command: ");

      if (fgets (buf, 1024, stdin) == NULL) {
	       printf ("\n");
	       exit (0);
      }


      buf[strlen(buf)-1] = '\0';   // get rid of newline

      /*
       * Split the string into arguments.
       */
      parse (buf, args);
      printf("The time differential (in microseconds) for the executed command is:\n");

      /*
       * Execute the command.
       */
      for (i = 0; i < 200; i++){
          execute (args);
      }
   }

   return 0;
}
