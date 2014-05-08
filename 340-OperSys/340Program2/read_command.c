#include <stdio.h>
#include <string.h>
#include "parse_command.h"

static char cmdline[100];

void read_command(char **command_args, char *redir_in, char *redir_out){
	char redir[100];
	command_args[0] = NULL;Les
	int i = 0;// j = 0, k = 0;

	if (fgets(cmdline, 100, stdin) != NULL) {
		cmdline[strlen(cmdline)-1] = '\0';  // strip newline
		/*strcpy(redir, cmdline);
		while (redir[i] != '\0'){
			printf("%s\n",redir[i] );
			i++;
		}*/
		parse_command(cmdline, command_args);
	}
}
