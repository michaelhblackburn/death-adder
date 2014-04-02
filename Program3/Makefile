CC=gcc
CFLAGS=-Wall -g 
LIBS=-lpthread

prog3Blackburn:	prog3Blackburn.o timing.o sizing.o
		$(CC) $(CFLAGS) -o prog3Blackburn prog3Blackburn.o timing.o sizing.o $(LIBS)

prog3Blackburn.o:	prog3Blackburn.c
		$(CC) $(CFLAGS) -c prog3Blackburn.c 

timing.o:	timing.c
		$(CC) $(CFLAGS) -c timing.c

sizing.o:	sizing.c
		$(CC) $(CFLAGS) -c sizing.c

clean:
	rm -f *~ prog3Blackburn prog3Blackburn.o timing.o sizing.o
