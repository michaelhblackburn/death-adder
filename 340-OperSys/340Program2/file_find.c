#include <stdio.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <string.h>
#include <stdlib.h>

//static char paths[200];

void file_find(char *arg_cmd, char *full_arg_cmd) {
	char *env_path;
	char *args[64];
	char paths[200];
	char fullcmd[100];
	int i = 0;
	int j = 0;

	env_path = getenv("PATH");
	strcpy(paths, env_path);
	args[0] = &paths[0];
	while(paths[i] != '\0'){
		if(paths[i] == ':'){
			j++;
			args[j] = &paths[i+1];
			paths[i] = '\0';
		}
		i++;
	}
	args[j+1] = NULL;

	j = 0;
	while(args[j] != NULL){
		strcpy(fullcmd, args[j]);
		strcat(fullcmd, "/");
		strcat(fullcmd, arg_cmd);

		if(open(fullcmd, O_RDONLY) >= 0){
			break;
		}
		j++;
	}
	full_arg_cmd[0] = '\0';

	if(args[j] != NULL) {
		strcpy(full_arg_cmd, fullcmd);
	}
		
}