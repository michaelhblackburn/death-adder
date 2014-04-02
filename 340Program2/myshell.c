/*
 *myshell.c
 *Michael Blackburn
 *CSCI 340
 *This version does not perform i/o redirection ***
 */

#include <stdio.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include "print_prompt.h"
#include "read_command.h"
#include "parse_command.h"
#include "file_find.h"
#include "fork_and_exec.h"

#define TRUE 1

int main(){

	char *command_args[64];
	char full_arg_cmd[100];
	char redir_in[100];
	char redir_out[100];
	
	while(TRUE){
		redir_in[0] = '\0';
		redir_out[0] = '\0';
		print_prompt();
		read_command(command_args, redir_in, redir_out);
		printf("%s\n", redir_in);
		if (command_args[0] == NULL)
			break;
		file_find(command_args[0], full_arg_cmd);
		if(full_arg_cmd[0] != '\0'){
			fork_and_exec(command_args, full_arg_cmd, redir_in, redir_out);
		}
		
	}
	return 0;
}