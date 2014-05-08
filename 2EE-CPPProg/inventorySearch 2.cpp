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
	InventoryData array1, array2;
	string datafile1 = "";
	int recordNum = 0;
	int itemNum = 0;
	int searchResult = 0;
	int seqSearchResult = 0;
	int binSearchResult = 0;
	int seqPartsFound = 0;
	int binPartsFound = 0;
	int seqPartsNotFound = 0;
	int binPartsNotFound = 0;
	int partsFound = 0;
	int partsNotFound = 0;
	int totalQueries = 0;
	double itemPrice = 0;
	

	cout << fixed << setprecision(2);
	datafile1 = "masterInventory.dat";
	array1.loadArrays(datafile1);
	//array1.displayArrays();
	array1.bubbleSort();
	//array1.displayArrays();
	//cout << array1.getRecordNum();
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
		searchResult = array1.calcSearchResult(seqSearchResult, binSearchResult);
		if(searchResult != -1)
		{
			itemPrice = array1.getItemPrice(searchResult);
			array2.loadSumArray(itemNum, itemPrice);
		}
		cout << "\nPlease enter a part number, or -1 to quit: ";
		cin >> itemNum;
		cout << endl;
	}
	//cout << array1.getBinPartsFound();
	//cout << array1.getSeqPartsFound();
	seqPartsFound = array1.getSeqPartsFound();
	binPartsFound = array1.getBinPartsFound();
	seqPartsNotFound = array1.getSeqPartNotFound();
	binPartsNotFound = array1.getBinPartNotFound();
	partsFound = array1.calcPartsFound(seqPartsFound, binPartsFound);
	partsNotFound = array1.calcPartsNotFound(seqPartsNotFound, binPartsNotFound);
	totalQueries = partsFound + partsNotFound;
	cout << endl;
	cout << endl;
	array2.displaySummary(totalQueries, partsFound, partsNotFound);
	cout << endl;
	cout << "Thank you for using our inventory search system! We hope you found "
		 << "what you\nneeded today."<<endl<<endl;
	system("pause");
	return 0;
}// end main