//FILE			:chasFerry.cpp
//PROGRAMMER	:Michael Blackburn
//PURPOSE		:simulator for operation of the Charleston Ferry Service

#include <iostream>
#include <string>
using namespace std;
#include "FerryBoat.h"

int main()
{
	FerryBoat ferry1(20, 'A');
	int carsA, carsB;

	carsA = ferry1.getCarsPortA();		//call funtion to receive values 
	carsB = ferry1.getCarsPortB();		//for cars at ports A and B

	cout << "Cars to transport at Port A = "<< carsA <<endl;	//display values for cars
	cout << "Cars to transport at Port B = "<<carsB <<endl;		//at ports A and B

	ferry1.runTwoWayFerryRoute();
	cout <<endl;
	system("pause");
	return 0;
}