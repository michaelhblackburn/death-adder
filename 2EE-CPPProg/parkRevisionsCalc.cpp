/******************************************************************************
 *FILENAME		:parkRevisionsCalc.cpp										  *
 *PROGRAMMER	:Michael Blackburn											  *
 *PURPOSE		:calculator for revisions to proposed Porpoise Pond attraction*
 ******************************************************************************/

#define _USE_MATH_DEFINES
#include <cmath>
#include <iostream>
#include <iomanip>
#include <string>
using namespace std;

int main()
{
	//declare variables and constants
	string userName					="";
	char seat						='A';
	int woodSeatNumber				=0;
	int plasticSeatNumber			=0;
	int selContractor				=0;
	int chairContractor				=0;
	double pondVolGal				=0.0;
	double pondVolCuFt				=0.0;
	double pondRadius				=0.0;
	double pondDiameter				=0.0;
	double domeRadius				=0.0;
	double domeDiameter				=0.0;
	double pondArea					=0.0;
	double domeArea					=0.0;
	double cont1Total				=0.0;
	double cont2Total				=0.0;
	double cont3Total				=0.0;
	double cont4Total				=0.0;
	double cont5Total				=0.0;
	double finalContTotal			=0.0;
	double seatingArea				=0.0;
	double woodPrice1				=0.0;
	double woodPrice2				=0.0;
	double woodPrice3				=0.0;
	double plasticPrice1			=0.0;
	double plasticPrice2			=0.0;
	double plasticPrice3			=0.0;
	double finalChairTotal			=0.0;
	double finalSeatCost			=0.0;
	const int WATER_HEIGHT			=11;
	const double WOOD_SEAT_AREA		=5.5;
	const double PLASTIC_SEAT_AREA	=4.8;
	const double CONT_1_PRICE		=37.75;
	const double CONT_2_PRICE		=38.95;
	const double CONT_3_PRICE		=44.99;
	const double CONT_4_PRICE		=45.35;
	const double CONT_5_PRICE		=22.85;
	const double SEAT_CONT_PRICE1	=39.95;
	const double SEAT_CONT_PRICE2	=34.50;
	const double SEAT_CONT_PRICE3	=43.95;

	//enter initial input items
	cout << setw(60) << "Blackburn Industrial Projects, Inc. " <<endl;
	cout << setw(68) << "Revised Calculator for the Summerville Porpoise Pond " <<endl;
	cout << "\nGood day to you! We're going to help you get some base estimates " <<endl;
	cout << "for the porpoise pond today, but we need some input to get started. " <<endl;
	cout << "We'll be asking you to make a few decisions along the way, as well, " <<endl;
	cout << "so be sure to enter what's asked when prompted. Make sure you use " <<endl;
	cout << "numbers and letters only in the prompts when directed-no symbols " <<endl;
	cout << "such as commas or periods, please. " <<endl;
	cout << "\nCan I please have your name: ";
	cin >> userName;
	cout << "\nOkay, "<< userName <<", now I need for you to enter how many GALLONS " <<endl;
	cout << "of water you'd like to use in the pond: ";
	cin >> pondVolGal;
	//calculations based on initial input
	pondVolCuFt = pondVolGal * .13368;
	pondRadius = sqrt(pondVolCuFt / (M_PI * WATER_HEIGHT));
	pondDiameter = pondRadius * 2;
	domeDiameter = pondDiameter * 3;
	domeRadius = domeDiameter / 2;
	pondArea = M_PI * (pondRadius * pondRadius);
	domeArea = (M_PI * (domeRadius * domeRadius)) - pondArea;
	seatingArea = domeArea / 2;
	woodSeatNumber = static_cast<int>(seatingArea / WOOD_SEAT_AREA);
	plasticSeatNumber = static_cast<int>(seatingArea / PLASTIC_SEAT_AREA);
	cont1Total = CONT_1_PRICE * pondArea;
	cont2Total = CONT_2_PRICE * pondArea;
	cont3Total = CONT_3_PRICE * pondArea;
	cont4Total = CONT_4_PRICE * pondArea;
	cont5Total = CONT_5_PRICE * pondArea;

	//output based on initial input, calculations
	cout << fixed << setprecision(0);
	cout << "\n\nOkay, "<< userName <<", if you use "<< pondVolGal <<" gallons of " <<endl;
	cout << "water, with a water depth of 11 feet, the pond's diameter will " <<endl;
	cout << fixed << setprecision(1);
	cout << "be "<< pondDiameter <<" feet. Be sure that, should you round this figure " <<endl;
	cout << "to a whole number, that you round it down. Rounding up will cause " <<endl;
	cout << "an excessive amount of water-a headache that we don't need. " <<endl;
	system("pause");
	system("cls");

	//enter next group of inputs
	cout << "\n\nNow we need to decide what type of chairs we're going to use, " <<endl;
	cout << ""<< userName <<". We have two options here-a wooden deck chair that is " <<endl;
	cout << "cheaper, but takes up more space, and a plastic chair that is " <<endl;
	cout << "bolted to the floor. It is more expensive, but takes up less " <<endl;
	cout << "space. Below are your options, with the number of seats you could " <<endl;
	cout << "install depending on your choice: " <<endl;
	cout << endl;
	cout << "1" << setw(15) << "Wooden Chairs" << setw(8) << ""<<woodSeatNumber<<"" <<endl;
	cout << "2" << setw(16) << "Plastic Chairs" << setw(7) << ""<<plasticSeatNumber<<"" <<endl;
	cout << "\nPlease select a seat type-enter W for wooden chairs and P for " <<endl;
	cout << "plastic chairs: ";
	cin >> seat;
	seat = toupper(seat);
	{	
	if(seat == 'W')
		cout << "Okay, we'll go with the wooden chairs. " <<endl;
	else if(seat == 'P') 
		cout << "Okay, we'll use the plastic chairs. " <<endl;
	else  //default
		cout << "Invalid entry. Please enter W or P. ";
	}
	//end if
	system("pause");
	system("cls");

	//next input set
	cout << fixed << setprecision(2);
	cout << "\n\nAlright, "<< userName <<", we have three different contractors " <<endl;
	cout << "with bids in for the chair installation. Below you'll find the bids, " <<endl;
	cout << "with their price per seat and total cost: " <<endl;
	cout << endl;
	woodPrice1 = woodSeatNumber * SEAT_CONT_PRICE1;
	woodPrice2 = woodSeatNumber * SEAT_CONT_PRICE2;
	woodPrice3 = woodSeatNumber * SEAT_CONT_PRICE3;
	plasticPrice1 = plasticSeatNumber * SEAT_CONT_PRICE1;
	plasticPrice2 = plasticSeatNumber * SEAT_CONT_PRICE2;
	plasticPrice3 = plasticSeatNumber * SEAT_CONT_PRICE3;
	{	
	if(seat == 'W')
	{
		cout << "Contractor #1 will charge $39.95 per seat, for a total of $"<< woodPrice1 <<". " <<endl;
		cout << "Contractor #2 will charge $34.50 per seat, for a total of $"<< woodPrice2 <<". " <<endl;
		cout << "Contractor #3 will charge $43.95 per seat, for a total of $"<< woodPrice3 <<". " <<endl;
	}
	else
	{
		cout << "Contractor #1 will charge $39.95 per seat, for a total of $"<< plasticPrice1 <<". " <<endl;
		cout << "Contractor #2 will charge $34.50 per seat, for a total of $"<< plasticPrice2 <<". " <<endl;
		cout << "Contractor #3 will charge $43.95 per seat, for a total of $"<< plasticPrice3 <<". " <<endl;
	}
	}
	//end if
	cout << "\nPlease choose a contractor for the chairs-1, 2, or 3: ";
	cin >> chairContractor;
	{
	if(chairContractor == 1)
		cout << "Okay, we'll go with contractor #1. " <<endl;
	else if(chairContractor == 2)
		cout << "Okay, we'll go with contractor #2. " <<endl;
	else if(chairContractor == 3)
		cout << "Okay, we'll go with contractor #3. " <<endl;
	else //default
		cout << "Invalid entry. Please enter the number 1, 2, or 3. " <<endl;
	}	
	//end if
	system("pause");
	system("cls");

	//display contractor data, input contractor option
	cout << "\n\nNow, "<< userName <<", we're going to look at some contractor bids. " <<endl;
	cout << "We've received five different bids from contractors in the area that " <<endl;
	cout << "are interested in the building the base for the porpoise pond. Below " <<endl;
	cout << "you'll see each bid, with both cost per square foot and total cost " <<endl;
	cout << "displayed. Review the bids, and decide which contractor you'd like to " <<endl;
	cout << "use. You'll input your decision below. " <<endl;
	cout << endl;
	cout << "Bid" << setw(15) << "Contractor ID" << setw(26) << "Bid Amount($ per Sqft)" << setw(23) << "Total for bid" <<endl;
	cout << setw(2) << "1" << setw(11) << "11237" << setw(22) << "37.75" << setw(23) << "$"<< cont1Total << "" <<endl;
	cout << setw(2) << "2" << setw(11) << "10979" << setw(22) << "38.95" << setw(23) << "$"<< cont2Total << "" <<endl;
	cout << setw(2) << "3" << setw(11) << "21352" << setw(22) << "44.99" << setw(23) << "$"<< cont3Total << "" <<endl;
	cout << setw(2) << "4" << setw(11) << "22976" << setw(22) << "45.35" << setw(23) << "$"<< cont4Total << "" <<endl;
	cout << setw(2) << "5" << setw(11) << "33209" << setw(22) << "22.85" << setw(23) << "$"<< cont5Total << "" <<endl;
	cout << "\n\n"<< userName <<", please pick a contractor for the selected list by entering " <<endl;
	cout << "a number, 1-5, that corresponds to the contractor you would like to " <<endl;
	cout << "use: ";
	cin >> selContractor;
	{
	if(selContractor == 1)
		cout << "Okay, we'll use contractor #1. " <<endl;
	else if(selContractor ==2)
		cout << "Okay, we'll use contractor #2. " <<endl;
	else if(selContractor == 3)
		cout << "Okay, we'll use contractor #3. " <<endl;
	else if(selContractor == 4)
		cout << "Okay, we'll use contractor #4. " <<endl;
	else if(selContractor == 5)
		cout << "Okay, we'll use contractor #5. " <<endl;
	else //default
		cout << "Invalid entry. Please enter a number 1, 2, 3, 4, or 5. " <<endl;
	}	
	//end if

	cout << "\n\nOkay, "<< userName <<", now that we have all the information we need, " <<endl;
	cout << "we're ready to give you a report on your inputs and show you some " <<endl;
	cout << "values associated with them. " <<endl;
	system("pause");
	system("cls");

	//display final outputs
	cout << setw(60) << "Blackburn Industrial Projects, Inc. " <<endl;
	cout << setw(65) << "Porpoise Pond Values for Summerville Sea World " <<endl;
	cout << "\n\nPOND VALUES " <<endl;
	cout << "----------- " <<endl;
	cout << fixed << setprecision(1);
	cout << "Pond diameter: " << setw(26) << ""<< pondDiameter <<" feet " <<endl;
	cout << "Pond area: " << setw(30) << ""<< pondArea <<" square feet " <<endl;
	cout << "Gallons of water for tank: " << setw(14) << ""<< pondVolGal <<" gallons " <<endl;
	cout << fixed << setprecision(2);
	{
	if(selContractor == 1)
		finalContTotal = cont1Total;
	else if(selContractor == 2)
		finalContTotal = cont2Total;
	else if(selContractor == 3)
		finalContTotal = cont3Total;
	else if(selContractor == 4)
		finalContTotal = cont4Total;
	else 
		finalContTotal = cont5Total;
	}
	//end if
	cout << "Concrete cost for tank base: " <<setw(13) << "$"<< finalContTotal <<"" <<endl;
	cout << "\n\nDOME VALUES " <<endl;
	cout << "----------- " <<endl;
	cout << fixed << setprecision(1);
	cout << "Dome diameter: " << setw(26) << ""<< domeDiameter <<" feet " <<endl;
	cout << "Open area under the dome: " << setw(15) << ""<< domeArea <<" square feet " <<endl;
	cout << fixed << setprecision(0);
	{
	if(seat == 'W')
		finalChairTotal = woodSeatNumber;
	else 
		finalChairTotal = plasticSeatNumber;
	}
	//end if
	cout << "Number of seats: " << setw(24) << ""<< finalChairTotal <<"" <<endl;
	{
	if(chairContractor == 1 && seat == 'W')
		finalSeatCost = woodPrice1;
	else if(chairContractor == 2 && seat == 'W')
		finalSeatCost = woodPrice2;
	else if(chairContractor == 3 && seat == 'W')
		finalSeatCost = woodPrice3;
	else if(chairContractor == 1 && seat == 'P')
		finalSeatCost = plasticPrice1;
	else if(chairContractor == 2 && seat == 'P')
		finalSeatCost = plasticPrice2;
	else
		finalSeatCost = plasticPrice3;
	}
	//end if
	cout << fixed << setprecision(2);
	cout << "Seating cost: " << setw(28) << "$"<< finalSeatCost <<"" <<endl;
	cout << "\n\nThank you for allowing us to serve you today! " <<endl;
	cout << "Please let us know if there is anything else we can do for you. " <<endl;

	system("pause");
	return 0;
}	//end of main function

