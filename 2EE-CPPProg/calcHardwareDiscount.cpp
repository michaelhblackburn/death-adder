/********************************************************************
 *FILENAME		:calcHardwareDiscount.cpp							*
 *PROGRAMMER	:Michael Blackburn									*
 *PURPOSE		:Interactive hardware store item discount calculator*
 ********************************************************************/

#include <iostream>
#include <string>
using namespace std;

int main()
{
	//declare variables and constants
	string customerName		="";
	string item				="";
	int yearsInResidence	=0;
	int itemQuantity		=0;
	double itemPrice		=0.0;
	double salePrice		=0.0;
	double totalSale		=0.0;
	const double DISCOUNT	=.35;

	//enter input items
	cout << "Michael's Hardware Discount Finder v1.2 " << endl;
	cout << "\n\nWelcome to Michael's Hardware! Thank you for coming in today for our " << endl;
	cout << "storewide sale, where everything in the store is 35% off today only. We're " << endl;
	cout << "going to help you to see your savings before you make your purchase today, " << endl;
	cout << "but we'll need you to give us some information first.\n\n " << endl;
	cout << "Please enter your first name: ";
	cin >> customerName;
	cout << "Please enter the number of years you've lived in the community: ";
	cin >> yearsInResidence;
	cout << "Please enter the name of the item you're interested in purchasing\n ";
	cout << "today: ";
	cin.ignore(100, '\n');
	getline (cin, item); 
	cout << "Please enter the original price of the item adverstised in our\n ";
	cout << "circular: $ ";
	cin >> itemPrice;
	cout << "Please enter the number of this item you'd like to purchase today: ";
	cin >> itemQuantity;

	//calculate salePrice and totalSale
	salePrice = itemPrice - (itemPrice * DISCOUNT);
	totalSale = salePrice * itemQuantity;

	//display user input and sale information
	cout << "\n\nThank you for coming in today, "<< customerName <<", to purchase a " << endl;
	cout << "new "<< item <<". With our 35% STOREWIDE discount, our "<< item <<" has been " << endl;
	cout << "marked down from $"<< itemPrice <<" to $"<< salePrice <<". Since you're interested in purchasing "<< itemQuantity <<" of " << endl;
	cout << "these, your total will come to $"<< totalSale <<". After "<< yearsInResidence <<" years in our community, we're" << endl;
	cout << "glad to have you as a loyal customer. Thank you for shopping at Michael's" << endl;
	cout << "Hardware during our storewide sale! Michael's Hardware, serving your hardware" << endl;
	cout << "needs for 50 years and counting. We hope to see you again soon! " << endl;	

	system("pause");
	return 0;
}   //end of main function

