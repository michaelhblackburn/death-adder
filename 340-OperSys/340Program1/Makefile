CC=gcc
CFLAGS=-Wall -g
LIBS=-lpthread

prog1Blackburn:	prog1Blackburn.o
		$(CC) $(CFLAGS) -o prog1Blackburn prog1Blackburn.o $(LIBS)

prog1Blackburn.o:	prog1Blackburn.c
		$(CC) $(CFLAGS) -c prog1Blackburn.c 

clean:
	rm -f *~ prog1Blackburn prog1Blackburn.o