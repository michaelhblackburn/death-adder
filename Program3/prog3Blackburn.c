/*
 *prog3Blackburn.c
 *Michael Blackburn
 *ascertain the speed of calls to cache and main memory using loops through arrays
 */

#include <stdio.h> 
#include <stdlib.h>
#include <sys/time.h>
#include "timing.h"
#include "sizing.h"

//define constants for use in loops
#define SM_COL 10
#define LG_COL 256
#define ROW 5000

int main(){
	int time1, time2, sec1, sec2, usec1, usec2, total1 = 0, total2 = 0, value1 = 0, value2 = 0, i, jump, cacheSize;
	double avg1 = 0.0, avg2 = 0.0, total3 = 0.0;
	struct timeval t1, t2;
	int array1[ROW][SM_COL];
	int array2[ROW][LG_COL];

	gettimeofday(&t1, NULL);
	for(i = 0; i < ROW; i++){
		value1 = array1[i][SM_COL - 1];		   	
	}
	gettimeofday(&t2, NULL);

	sec1 = t1.tv_sec * 1000000;
	usec1 = t1.tv_usec;
	time1 = (sec1 + usec1) * 1000;
	sec2 = t2.tv_sec * 1000000;
	usec2 = t2.tv_usec;
	time2 = (sec2 + usec2) * 1000;
	total1 = (time2 - time1);

	avg1 = (total1) / ROW;
	printf("\n");
	printf("Average access time for array1 = %f ns\n", avg1);

	gettimeofday(&t1, NULL);
	for(i = 0; i < ROW; i++){
		value2 = array2[i][LG_COL - 1];
	}
	gettimeofday(&t2, NULL);

	sec1 = t1.tv_sec * 1000000;
   	usec1 = t1.tv_usec;
   	time1 = (sec1 + usec1) * 1000;
   	sec2 = t2.tv_sec * 1000000;
	usec2 = t2.tv_usec;
	time2 = (sec2 + usec2) * 1000;
	total2 = (time2 - time1);

	avg2 = (total2) / ROW;
	printf("\n");
	printf("Average access time for array2 = %f ns\n", avg2);
	printf("\n");

	jump = 1;
	while(jump < 512){
		total3 = timing(jump);
		printf("Avg time for %d = %.2f ns\n", jump, total3);
		jump = jump * 2;
	}
	//experiment shows a 64-bit line size on stono - results inconsistent on local machine
	jump = 1; 
	while(jump < 256){
		total3 = 0;
		cacheSize = jump * 1024;
		total3 = sizing(cacheSize);
		printf("time at %d = %.2f\n", cacheSize, total3);
		jump = jump * 2;
	}

	return 0;
}

