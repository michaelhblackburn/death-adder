//FILE			:inventorySearch.cpp
//PROGRAMMER	:Michael Blackburn
//PURPOSE		:use calls to InventoryData class to search arrays for item numbers and prices

#include <iostream>
#include <iomanip>
#include <fstream>
#include <string>
using namespace std;

#include "InventoryOrders.h"

int main()
{
	InventoryOrders array1;
	string datafile1 = "";
	string datafile2 = "";
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
	datafile2 = "orders.dat";
	array1.loadDataArrays(datafile1);
	array1.loadOrderArrays(datafile2);
	array1.bubbleSort();
	cout << setw(59) << "Welcome to Blackburn's Order Processing System" << endl;
	cout << endl;
	cout << endl;
	cout << "Our inventory management system will help you search order "
		 << "numbers for the\nappropriate part and process the orders, returning "
		 << "a summary after processing \nall orders provided. " <<endl;
	cout << endl;
	system("pause");
	//array1.displayDataArrays();
	//cout << endl;
	//cout << array1.getRecordNum();
	//cout << endl;
	//array1.displayOrderArrays();
	//cout << endl;
	//cout << array1.getOrderNum();
	cout << endl;
	array1.orderProcessing();
	cout << endl;
	cout << "To see the processing summary, " <<endl;
	system("pause");
	system("cls");
	array1.processingSummary();
	cout << endl;
	system("pause");
	return 0;
}// end main