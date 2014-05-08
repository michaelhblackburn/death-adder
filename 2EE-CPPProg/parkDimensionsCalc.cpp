/********************************************************************************
 *FILENAME		:parkDimensionsCalc.cpp											*
 *PROGRAMMER	:Michael Blackburn												*
 *PURPOSE		:to calculate values associated with a new theme park's grounds *
 ********************************************************************************/

#define _USE_MATH_DEFINES
#include <cmath>
#include <iostream>
#include <string>
using namespace std;

int main()
{
	//declare variables and constants
	string userName						   ="";
	int seatNumber						   =0;
	double pondDiameter					   =0.0;
	double domeDiameter					   =0.0;
	double pondRadius					   =0.0;
	double domeRadius					   =0.0;
	double pondArea						   =0.0;
	double domeArea						   =0.0;
	double pondVolume					   =0.0;
	double domeVolume					   =0.0;
	double seatingArea					   =0.0;
	double reinforcedConcreteCost		   =0.0;
	double concreteCost					   =0.0;
	const double SEAT					   =5.5;
	const double WATER_HEIGHT			   =11.0;
	const double REINFORCED_CONCRETE_PRICE =37.00;
	const double CONCRETE_PRICE			   =27.50;

	//enter input items
	cout << "Dimension Calculator for Porpoise Pond, Summerville Sea World, v3.0 " << endl;
	cout << "Written for Summerville Sea World by Michael Blackburn " << endl;
	cout << "\n\nHello, and welcome to our interface for calculating the dimensions " << endl;
	cout << "of the Porpoise Pond, the main attraction at the all new Summerville " << endl;
	cout << "Sea World!. Before we get to calculating the dimensions, I'll need to get " << endl;
	cout << "a few things from you first. Let's start with your first name: ";
	cin >> userName;
	cout << "\n"<< userName <<", thank you for using our calculator. I'll be getting " << endl;
	cout << "several values for you today, including the floor areas of the pond itself and " << endl;
	cout << "the dome surrounding it, concrete costs for the pond and dome, the seating " << endl;
	cout << "area and seating total for the dome, the total amount of water, in cubic feet, " << endl;
	cout << "to fill the pond, and the air volume of the dome, also in cubic feet. To get " << endl;
	cout << "started, "<< userName <<", I'll need the diameter that we're going to use for " << endl;
	cout << "the pond itself: ";
	cin >> pondDiameter;
	cout << "\nOkay, "<< userName <<", with a pond diameter of "<< pondDiameter <<" feet, we can figure out " << endl;
	cout << "everything we need to know about the new Porpoise Pond! " << endl;

	//calculate dimensions/information associated with Porpoise Pond
	domeDiameter = pondDiameter * 3;
	pondRadius = pondDiameter / 2;
	domeRadius = domeDiameter / 2;
	pondArea = M_PI * pondRadius * pondRadius;
	domeArea = (M_PI * domeRadius * domeRadius) - pondArea;
	seatingArea = domeArea / 2;
	seatNumber = seatingArea / 5.5;
	reinforcedConcreteCost = pondArea * REINFORCED_CONCRETE_PRICE;
	concreteCost = domeArea * CONCRETE_PRICE;
	pondVolume = (M_PI * pondRadius * pondRadius) * WATER_HEIGHT;
	domeVolume = ((2.0 / 3.0) * (M_PI * domeRadius * domeRadius * domeRadius)) - pondVolume;

	//display user inputs and results of calculations
	cout << "\n\n"<< userName <<", with a pond diameter of "<< pondDiameter <<" feet, the diameter of the " << endl;
	cout << "surrounding dome is "<< domeDiameter <<" feet. This means, "<< userName <<", that the total " << endl;
	cout << "area of the new Porpoise Pond is "<< pondArea <<" square feet. The floor area around " << endl;
	cout << "the Porpoise Pond will be "<< domeArea <<" square feet. " << endl;
	system("pause");
	cout << "\n"<< userName <<", we're going to have to used a special, super-reinforced " << endl;
	cout << "concrete for the flooring under the pond, which will cost $"<< reinforcedConcreteCost <<". " << endl;
	cout << "The floor for the rest of the dome can be poured with a standard, reinforced " << endl;
	cout << "concrete, which will cost $"<< concreteCost <<". " << endl;
	system("pause");
	cout << "\n"<< userName <<", with these numbers, you're looking at a seating area of " << endl;
	cout << ""<< seatingArea <<" square feet. This will allow you to install about "<< seatNumber <<" " << endl;
	cout << "seats around the pond for visitors. " << endl;
	system("pause");
	cout << "\n"<< userName <<", to fill the Porpoise Pond to a height of 11 feet will require " << endl;
	cout << ""<< pondVolume <<" cubic feet of water.  Also of note, "<< userName <<", is the volume " << endl;
	cout << "of the dome itself.  The area inside the dome will have to be air-conditioned " << endl;
	cout << "for most of the year. The volume of the dome, subtracting for the pond space " << endl;
	cout << "that will be full of water, is "<< domeVolume <<" cubic feet. " << endl;
	cout << "\n\n"<< userName <<", thank you for using our calculator today. I hope the values " << endl;
	cout << "obtained herein give you a good amount of data with which to better plan the " << endl;
	cout << "attraction. Should you have to revise your numbers, come back, and I'll be " << endl;
	cout << "happy to help you recalculate everything to get the data you need. Good day, " << endl;
	cout << "and good luck with the park! " << endl;

	system("pause");
	return 0;
}	//end of main function


