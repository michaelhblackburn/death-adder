CC=gcc
CFLAGS=-Wall -g
LIBS=-lpthread

myshell:	myshell.o   file_find.o   fork_and_exec.o   parse_command.o   read_command.o   print_prompt.o
		$(CC) $(CFLAGS) -o myshell myshell.o file_find.o fork_and_exec.o parse_command.o read_command.o print_prompt.o $(LIBS)

myshell.o:	myshell.c
		$(CC) $(CFLAGS) -c myshell.c 

file_find.o: file_find.c
		$(CC) $(CFLAGS) -c file_find.c

fork_and_exec.o: fork_and_exec.c
		$(CC) $(CFLAGS) -c fork_and_exec.c

parse_command.o: parse_command.c
		$(CC) $(CFLAGS) -c parse_command.c

read_command.o: read_command.c   
		$(CC) $(CFLAGS) -c read_command.c 

print_prompt.o: print_prompt.c
		$(CC) $(CFLAGS) -c print_prompt.c

clean:
	rm -f *~ myshell myshell.o file_find.o fork_and_exec.o parse_command.o read_command.o print_prompt.o