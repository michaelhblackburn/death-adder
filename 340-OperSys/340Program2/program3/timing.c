/*
 *timing.c
 *Michael Blackburn
 *determines cache line size using iteration
 */

 #include <stdlib.h>
 #include <stdio.h>
 #include <sys/time.h>

 #define SIZE 64 * 1024

 double timing(int jump){
 	int test_array[SIZE];
 	struct timeval t1, t2;
 	int i, value = 0;
 	double avg = 0.0, sec1, sec2, usec1, usec2, total, time1, time2;
 	gettimeofday(&t1, NULL);
 	for(i = 0; i < SIZE; i += jump){
 		value = test_array[i];
 	}
 	gettimeofday(&t2, NULL);
	sec1 = t1.tv_sec * 1000000;
   	usec1 = t1.tv_usec;
   	time1 = (sec1 + usec1) * 1000;
   	sec2 = t2.tv_sec * 1000000;
	usec2 = t2.tv_usec;
	time2 = (sec2 + usec2) * 1000;
	total = (time2 - time1);
	printf("total = %.2f\n", total);
	avg = total / (SIZE / jump);
 	return avg;
 }
