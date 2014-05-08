/************************************************************
 *FILENAME			:calcCommission.cpp						*
 *PROGRAMMER		:Michael Blackburn						*
 *PURPOSE			:to calculate simple sales interest		*
 ************************************************************/

#include <iostream>
using namespace std;

int main()
{
	//declare variables
	double sale1		 =0.0;
	double sale2		 =0.0;
	double commissionRate=0.0;
	double totalSales	 =0.0;
	double commission	 =0.0;

	//enter input items
	cout << "BBenterprise's Commission Calculator version 1.0 " << endl;
	cout << "Welcome to the Commission Calculator by BBenterprises " << endl;
	cout << "Your one-stop shop for all your calculation needs! " << endl;
	cout << "First sale? " << endl;
	cin >> sale1;
	cout << "Second sale? ";
	cin >> sale2;
	cout << "Commission rate in decimal format? ";
	cin >> commissionRate;

	//calculate total sales and commission
	totalSales = sale1 + sale2;
	commission = totalSales * commissionRate;

	//display the commission
	cout << "Commission: $" <<commission << endl;

	cout << "Thank you for using Commission Calculator! " << endl;
	cout << "We hope we can serve you again soon! ";
	
	system("pause");
	return 0;
}	//end of main function
