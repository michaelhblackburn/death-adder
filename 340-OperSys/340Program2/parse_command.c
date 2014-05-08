#include <stdio.h>

void parse_command(char *buf, char **args){
  while (*buf){
    while ((*buf == ' ') || (*buf == '\t'))
      *buf++ = '\0';
    *args++ = buf;
    while (*buf && (*buf != ' ') && (*buf != '\t') && (*buf != '<') && (*buf != '>'))
  	 buf++;
  }
  *args = NULL;
}
