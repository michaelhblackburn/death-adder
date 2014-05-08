//FILE			:operateElevator.cpp
//PROGRAMMER	:Michael Blackburn
//PURPOSE		:test the operation/function of classElevator

#include <iostream>
using namespace std;

#include "classElevator.h"

int main()
{
	Elevator elevator1(18, 1, 99, 1);
	
	elevator1.getMaximumCapacity();
	elevator1.getMaximumFloor();
	elevator1.getMinimumFloor();
	elevator1.getCurrentFloor();
	elevator1.getNumberOnBoard();
	elevator1.loadElevator(40);
	elevator1.getNumberOnBoard();
	elevator1.moveElevator(16);
	elevator1.getNumberOnBoard();
	elevator1.pressRequestButton(10);
	elevator1.unloadElevator(10);
	elevator1.loadElevator(4);
	elevator1.getNumberOnBoard();
	elevator1.handleRequest(20);
	elevator1.moveElevator(4);
	elevator1.getNumberOnBoard();
	elevator1.unloadElevator(8);
	elevator1.loadElevator(20);
	elevator1.getNumberOnBoard();
	elevator1.handleRequest(20);
	elevator1.moveElevator(29);
	elevator1.getNumberOnBoard();
	elevator1.unloadElevator(20);
	elevator1.loadElevator(8);
	elevator1.getNumberOnBoard();
	elevator1.handleRequest(20);
	elevator1.moveElevator(110);
	elevator1.moveElevator(35);
	elevator1.getNumberOnBoard();
	elevator1.unloadElevator(30);
	elevator1.loadElevator(0);
	elevator1.getNumberOnBoard();
	elevator1.handleRequest(20);
	elevator1.moveElevator(0);
	elevator1.moveElevator(1);
	elevator1.getNumberOnBoard();
	elevator1.unloadElevator(5);
	elevator1.loadElevator(25);
	elevator1.getNumberOnBoard();
	elevator1.moveElevator(45);
	elevator1.unloadElevator(20);
	elevator1.getNumberOnBoard();
	elevator1.returnToBottom();
	elevator1.getNumberOnBoard();

	system("pause");
	return 0;
}//end of main, end of testing for classElevator
	