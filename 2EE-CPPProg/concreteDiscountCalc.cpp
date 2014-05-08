/*************************************************************************************
 *PROGRAM			:concreteDiscountCalc.cpp										 *
 *PROGRAMMER		:Michael Blackburn												 *
 *PURPOSE			:calculate costs and discounts associate with purchasing concrete*
 *************************************************************************************/

#include <iostream>
#include <iomanip>
#include <string>
#include <ctime>
using namespace std;

int main()
{
	//declare variables and constants
	char tmpbuf[128];
	int weight				   =0;
	double cost				   =0.0;
	double discountCost		   =0.0;
	double savings			   =0.0;
	double tier1Rate		   =0.0;
	double tier2Rate		   =0.0;
	double tier3Rate		   =0.0;
	double tier4Rate		   =0.0;
	double discount			   =0.0;
	const double price		   =1.13;
	const double tier1Discount =0.02;
	const double tier2Discount =0.04;
	const double tier3Discount =0.05;
	const double tier4Discount =0.09;

	//display introduction and input weight for calculations
	cout << fixed << setprecision(2);
	tier1Rate = price - (price * tier1Discount);
	tier2Rate = price - (price * tier2Discount);
	tier3Rate = price - (price * tier3Discount);
	tier4Rate = price - (price * tier4Discount);
	cout << setw(50) << "ACME Cement Company " <<endl;
	cout << setw(65) << "Ac me no questions, and I'll sell you no lye! " <<endl;
	cout << "\n\n\nWelcome to ACME's concrete calculator. Here at ACME, we believe that " <<endl;
	cout << "passing our savings on to our customers is very important, and because " <<endl;
	cout << "we want you to save, we're giving all concrete purchases a discount, " <<endl;
	cout << "based on purchase weight. To get started, please enter the amount " <<endl;
	cout << "of concrete you'd like to purchase, in pounds: ";
	cin >> weight;
	cout << endl;
	cost = weight * price;

	//begin purchase if 
	if(weight > 15000)
	{
		discountCost = weight * tier4Rate;
		discount = tier4Discount * 100;
	}
	else if(weight >= 9001 && weight <= 15000)
	{
		discountCost = weight * tier3Rate;
		discount = tier3Discount * 100;
	}
	else if(weight >=501 && weight <= 9000)
	{
		discountCost = weight * tier2Rate;
		discount = tier2Discount * 100;
	}
	else if(weight > 0 && weight <= 500)
	{
		discountCost = weight * tier1Rate;
		discount = tier1Discount * 100;
	}
	else 
	{
		cout << "Invalid entry" <<endl;
		system("pause");
		return 0;
	}//end if

	savings = cost - discountCost;
	_strdate_s(tmpbuf);
	system("pause");
	system("cls");

	//display final output	
	cout << setw(48) << "ACME Cement Company" <<endl;
	cout << setw(62) << "Ac me no questions, and I'll sell you no lye! " <<endl;
	cout << setw(62) << "============================================= " <<endl;
	cout << endl;
	cout << setw(45) << "INVOICE FOR PURCHASE ON: "<< tmpbuf <<" " <<endl;
	cout << setw(41) << "Purchased weight: "<< weight <<" lbs. " <<endl;
	cout << endl;
	cout << "Price before discounts are applied: " << setw(25) << "$"<< cost <<"" <<endl;
	cout << "Discount rate applied to purchase: " << setw(28) << ""<< discount <<"% " <<endl;
	cout << "Your cost after the discount: " << setw(31) << "$"<< discountCost <<"" <<endl;
	cout << "Your savings today: " << setw(42) << "$"<< savings <<"" <<endl;
	cout << "=============================================================================== " <<endl;
	cout << endl;
	cout << endl;
	cout << setw(73) << "Thank you for choosing ACME for your concrete needs. We hope to be " <<endl;
	cout << setw(52) << "able to serve you again soon! " <<endl;
	cout << endl;
	cout << endl;
	
	system("pause");
	return 0;
}//end of main function
