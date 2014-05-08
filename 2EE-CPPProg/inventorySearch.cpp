//FILE			:inventorySearch.cpp
//PROGRAMMER	:Michael Blackburn
//PURPOSE		:use calls to InventoryData class to search arrays for item numbers and prices

#include <iostream>
#include <iomanip>
#include <fstream>
#include <string>
using namespace std;

#include "InventoryData.h"

int main()
{
	InventoryData array1;
	string datafile1 = "";
	int recordNum = 0;
	int itemNum = 0;
	int seqSearchResult = 0;
	int binSearchResult = 0;
	double itemPrice = 0;

	cout << fixed << setprecision(2);
	datafile1 = "inventory.dat";
	array1.loadArrays(datafile1);
	cout << endl;
	cout << setw(65) << "Welcome to Blackburn's Inventory Search System. " << endl;
	cout << endl;
	cout << endl;
	cout << "Our inventory search system will help you search for part "
		 << "numbers in the\ninventory, and return the price for that part "
		 << "using two separate search methods to ensure accuracy. " <<endl;
	cout << endl;
	cout << "Please enter a part number, or -1 to quit: ";
	cin >> itemNum;
	cout << endl;

	while(itemNum != -1)
	{
		seqSearchResult = array1.seqSearch(itemNum);
		array1.displaySeqSearchResult(seqSearchResult);
		cout << endl;
		binSearchResult = array1.binSearch(itemNum);
		array1.displayBinSearchResult(binSearchResult);
		cout << "\nPlease enter a part number, or -1 to quit: ";
		cin >> itemNum;
		cout << endl;
	}

	cout << "Thank you for using our inventory search system! We hope you found "
		 << "what you\nneeded today."<<endl;
	system("pause");
	return 0;
}// end main