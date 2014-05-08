/********************************************************************
 *FILENAME		:lawnCareCalc.cpp									*
 *PROGRAMMER	:Michael Blackburn									*
 *PURPOSE		:to calculate costs associated with lawn maintenance*
 ********************************************************************/

#include <iostream>
#include <string>
using namespace std;

int main()
{
	//declare variables and constants
	string name					 ="";
	int length					 =0.0;
	int width					 =0.0;
	int area					 =0.0;
	double houseArea			 =0.0;
	double totalArea			 =0.0;
	double lawnManPay			 =0.0;
	double lawnTime				 =0.0;
	double breakTime			 =0.0;
	double totalTime			 =0.0;
	double lawnManCost			 =0.0;
	double fuelCost				 =0.0;
	const double HOUSE_SIZE      =.40;
	const double LAWN_CUT_RATE   =2.0;
	const double FUEL_BURN_RATE  =1.2;

	//enter input items
	cout << "Michael's Lawn Care Calculator 2010, v1.3M " << endl;
	cout << "\n\nWelcome to Michael's Lawn Care Calculator 2010.  We're going to help " << endl;
	cout << "you figure out some of the costs associated with maintaining your lawn, " << endl;
	cout << "but first we'll need some information from you.\n\n " << endl;
	cout << "User, please enter your first name: ";
	cin >> name;
	cout << "Please enter the length of your yard in feet: ";
	cin >> length;
	cout << "Please enter the width of you yard in feet: ";
	cin >> width;
	cout << "Please enter the rate which your lawn care professional charges you\n ";
	cout << "in dollars per hour: ";
	cin >> lawnManPay;

	//calculate yard area, lawn time, fuel cost, worker cost
	area = length * width;
	houseArea = area * HOUSE_SIZE;
	totalArea = area - houseArea;
	lawnTime = (totalArea / LAWN_CUT_RATE) / 60;
	breakTime = (1 / 12) * lawnTime;
	totalTime = lawnTime + breakTime;
	fuelCost = (FUEL_BURN_RATE / 60) * lawnTime;
	lawnManCost = (lawnManPay /60) * totalTime;

	//display user inputs, results of calculations
	cout << "\n\n"<< name <<", based on your yard length of "<< length <<" feet and the width of "<< width <<" " << endl;
	cout << "feet, the total area of grass covering your yard is "<< totalArea <<" square feet. Based " << endl;
	cout << "on your yard size, it should take your lawn care professional "<< totalTime <<" minutes to " << endl;
	cout << "cut the grass, including both cutting time and a 5 minute break for every hour " << endl;
	cout << "of cutting. Mowing your lawn should require about "<< fuelCost <<" gallons of fuel, " << endl;
	cout << "depending on the fuel efficiency of your mower. The total cost of your lawn " << endl;
	cout << "care professional will be $"<< lawnManCost <<", paying him for both time spent cutting and break time. " << endl;
	cout << "\n\nThank you for using our Lawn Care Calculator! We hope we can help again in " << endl;
	cout << "the future. Be sure to check out our Hardware Discount finder, currently " << endl;
	cout << "in version 1.2. " << endl;

	system("pause");
	return 0;
}   //end of main function




