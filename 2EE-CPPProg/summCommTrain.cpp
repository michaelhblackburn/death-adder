//FILE			: CommuterTrain.cpp
//PROGREAMMER	: Michael Blackburn, with initial work prepared by Dave Jones
//PURPOSE		: Simulate operation of a high speed railway train

#include <iostream>
#include <string>
using namespace std;
#include "CommuterTrain.h"

int main()
{
	//Make a train with 20 stops,130 max pax, and starts at station #1
	CommuterTrain myTrain(30, 200, 1);
	
	myTrain.runTheRoute();

	system("pause");
	return 0;
}//end main