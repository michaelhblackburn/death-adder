//FILENAME			:InventoryOrders.h
//PROGRAMMER		:Michael Blackburn
//PURPOSE			:class for array loading, searching, and processing of orders involving inventory data

#include <iostream>
#include <fstream>
#include <iomanip>
#include <string>
using namespace std;

class InventoryOrders
{
	private:
		int recordNum;
		int orderNum;
		int invPartNum;
		int totalNum;
		int sumNum;
		double ordersTotal;
		int seqPartsFound;
		int binPartsFound;
		int seqPartNotFound;
		int binPartNotFound;
		int itemNum[300];
		double itemPrice[300];
		int orderPart[300];
		int orderQuantity[300];
		double totalOrder[300];
		int invalidParts[300];
		int sumItemNum[1000];
		double sumItemPrice[1000];

	public:
		InventoryOrders();
		void loadDataArrays(string);
		void loadOrderArrays(string);
		void displayDataArrays();
		void displayOrderArrays();
		void displaySeqSearchResult(int);
		void displayBinSearchResult(int);
		int getRecordNum();
		int getOrderNum();
		int getInvPartNum();
		int getTotalNum();
		double getOrdersTotal();
		int getItemNum(int);
		double getItemPrice(int);
		int getOrderPart(int);
		int getOrderQuantity(int);
		int getInvalidParts(int);
		int getSeqPartsFound();
		int getBinPartsFound();
		int getSeqPartNotFound();
		int getBinPartNotFound();
		int seqSearch(int);
		int binSearch(int);
		void bubbleSort();
		void loadSumArray(int, double);
		void displaySearchSummary(int, int, int);
		int calcSearchResult(int, int);
		int calcPartsFound(int, int);
		int calcPartsNotFound(int, int);
		void orderProcessing();
		void processingSummary();
};

InventoryOrders::InventoryOrders()
{
	recordNum = 0;
	orderNum = 0;
	invPartNum = 0;
	totalNum = 0;
	sumNum = 0;
	ordersTotal = 0.0;
	seqPartsFound = 0;
	binPartsFound = 0;
	seqPartNotFound = 0;
	binPartNotFound = 0;

	for(int ct = 0; ct < 300; ++ ct) recordNum = 0;
	for(int ct = 0; ct < 300; ++ ct) orderNum = 0;
	for(int ct = 0; ct < 300; ++ ct) invPartNum = 0;
	for(int ct = 0; ct < 300; ++ ct) totalNum = 0;
	for(int ct = 0; ct < 1000; ++ ct) sumNum = 0;
}//end InventoryData

void InventoryOrders::loadDataArrays(string datafile)
{
	ifstream recordsIn;

	recordsIn.open(datafile);

	if(recordsIn.is_open())
	{
		recordsIn >> itemNum[recordNum];
		recordsIn >> itemPrice[recordNum];

		while(!recordsIn.eof())
		{
			++recordNum;
			recordsIn >> itemNum[recordNum];
			recordsIn >> itemPrice[recordNum];
		}//end while
	}
	else
	{
		recordNum = -1;
		cout << "File did not open. " <<endl;
	}
}//end loadDataArrays

void InventoryOrders::loadOrderArrays(string datafile)
{
	ifstream recordsIn;

	recordsIn.open(datafile);

	if(recordsIn.is_open())
	{
		recordsIn >> orderPart[orderNum];
		recordsIn >> orderQuantity[orderNum];

		while(!recordsIn.eof())
		{
			++orderNum;
			recordsIn >> orderPart[orderNum];
			recordsIn >> orderQuantity[orderNum];
		}//end while
	}
	else
	{
		orderNum = -1;
		cout << "File did not open. " <<endl;
	}
}//end loadOrderArrays

void InventoryOrders::displayDataArrays()
{
	cout << "Displaying records from data file. " <<endl;
	cout << endl;
	for(int ct = 0; ct < recordNum; ++ct)
	{
		cout << itemNum[ct] <<"   "<< itemPrice[ct] <<endl;
	}
}//end displayArrays

void InventoryOrders::displayOrderArrays()
{
	cout << "Displaying records from data file. " <<endl;
	cout << endl;
	for(int ct = 0; ct < orderNum; ++ct)
	{
		cout << orderPart[ct] <<"   "<< orderQuantity[ct] <<endl;
	}
}//end displayArrays

void InventoryOrders::displaySeqSearchResult(int result)
{
	if(result != -1)
	{
		cout << "Sequential search found item number "<<itemNum[result]<<", and it's price is $"<<itemPrice[result]<<"." <<endl;
	}
	else
	{
		cout << "The item was not found. " <<endl;
	}
}//end displaySeqSearchResults

void InventoryOrders::displayBinSearchResult(int result)
{
	if(result != -1)
	{
		cout << "Binary search found item number "<<itemNum[result]<<", and it's price is $"<<itemPrice[result]<<"." <<endl;
	}
	else
	{
		cout << "The item was not found. " <<endl;
	}
}//end displayBinSearchResults

int InventoryOrders::getRecordNum()
{
	return recordNum;
}//end getRecordNum

int InventoryOrders::getOrderNum()
{
	return orderNum;
}//end getOrderNum

int InventoryOrders::getInvPartNum()
{
	return invPartNum;
}//end getInvPartNum

int InventoryOrders::getTotalNum()
{
	return totalNum;
}//end getTotalNum

double InventoryOrders::getOrdersTotal()
{
	return ordersTotal;
}//end getOrdersTotal

int InventoryOrders::getItemNum(int record)
{
	return itemNum[record];
}//end getItemNum

double InventoryOrders::getItemPrice(int record)
{
	return itemPrice[record];
}//end getItemPrice

int InventoryOrders::getOrderPart(int part)
{
	return orderPart[part];
}//end getOrderPart

int InventoryOrders::getOrderQuantity(int part)
{
	return orderQuantity[part];
}//end getOrderQuantity

int InventoryOrders::getInvalidParts(int part)
{
	return invalidParts[part];
}//end getInvalidParts

int InventoryOrders::getSeqPartsFound()
{
	return seqPartsFound;
}//end getSeqPartsFound

int InventoryOrders::getBinPartsFound()
{
	return binPartsFound;
}//end getBinPartsFound

int InventoryOrders::getSeqPartNotFound()
{
	return seqPartNotFound;
}//end getSeqPartNotFound

int InventoryOrders::getBinPartNotFound()
{
	return binPartNotFound;
}//end getBinPartNotFound


int InventoryOrders::seqSearch(int item)
{
	int count = 0;
	int recFound = -1;
	int loopCounter = 0;

	while(count < recordNum)
	{
		if(item == itemNum[count])
		{
			recFound = count;
			count = recordNum;
		}
		else 
		{
			++ count;
		}
		++loopCounter;
	}
	if(recFound == -1)
	{
		++seqPartNotFound;
	}
	else
	{
		++seqPartsFound;
	}
		
	
	cout << "The sequential search made "<<loopCounter<<" attempts to find the item. " <<endl;
	return recFound;
}//end seqSearch

int InventoryOrders::binSearch(int item)
{
	int first = 0;
	int last = recordNum - 1;
	int recFound = 0;
	int middle = 0;
	int loopCounter = 0;

	while(first <= last && recFound == 0)
	{
		middle = (first + last) / 2;
		if(itemNum[middle] == item)
		{
			recFound = 1;
		}
		else if(itemNum[middle] < item)
		{
			first = middle + 1;
		}
		else
		{
			last = middle - 1;
		}// end if
		++loopCounter;
	}// end while
	if(recFound == 0)
	{
		middle = -1;
	}
	if(middle == -1)
	{
		++binPartNotFound;
	}
	else
	{
		++binPartsFound;
	}
	//cout << "The binary search made "<<loopCounter<<" attempts to find the item. " <<endl;
	return middle;
}//end binSearch

void InventoryOrders::bubbleSort()
{
	int last = recordNum - 1;
	int temp1;
	int index;
	int swap;
	int numSwaps = 0;
	double temp2;

	while(last > 0)
	{
		index = 0;
		swap = 0;
		while(index < last)
		{
			if(itemNum[index] > itemNum[index + 1])
			{
				temp1 = itemNum[index];
				temp2 = itemPrice[index];
				itemNum[index] = itemNum[index + 1];
				itemPrice[index] = itemPrice[index + 1];
				itemNum[index + 1] = temp1;
				itemPrice[index + 1] = temp2;
				swap = 1;
				++ index;
				++ numSwaps;
			}
			else
			{
				++index;
			}
		}
		if(swap == 0)
		{
			last = 0;
		}
		else
		{
		last = last - 1;
		}
	}
	return;
}

void InventoryOrders::loadSumArray(int result1, double result2)
{
	sumItemNum[sumNum] = result1;
	sumItemPrice[sumNum] = result2;
	++ sumNum;
}

void InventoryOrders::displaySearchSummary(int totQuer, int partFound, int partNot)
{
	int totalQueries = totQuer;
	int partsFound = partFound;
	int partsNotFound = partNot;
	cout << setw(45) << "Search Summary" <<endl<<endl;
	cout << "You made a total of "<<totalQueries<<" searches today. " <<endl;
	cout << "You found a total of "<<partsFound<<" parts in the system today. "<<endl;
	cout << "You made a total of "<<partsNotFound<<" searches that yielded no results. "<<endl;
	cout << endl;
	cout << setw(19) << "Item Number" << setw(35) << "Item Price" <<endl;
	for(int lineNum = 1; lineNum <= sumNum ; ++lineNum)
	{
		cout << lineNum << setw(15) << sumItemNum[lineNum - 1] << setw(30) <<"$"<< sumItemPrice[lineNum - 1] <<endl;
	}
}

int InventoryOrders::calcSearchResult(int seqSearchResult, int binSearchResult)
{
	int searchResult;
	if( seqSearchResult == binSearchResult)
	{
		searchResult = (seqSearchResult + binSearchResult) / 2;
	}
	else
	{
		searchResult = -1;
	}
	return searchResult;
}//end calcSearchResult

int InventoryOrders::calcPartsFound(int seqPartsFound, int binPartsFound)
{
	int partsFound;
	if(seqPartsFound == binPartsFound)
	{
		partsFound = (seqPartsFound + binPartsFound) / 2;
	}
	else
	{
		partsFound = 0;
	}//end if
	return partsFound;
}//end calcPartsFound

int InventoryOrders::calcPartsNotFound(int seqPartsNotFound, int binPartsNotFound)
{
	int partsNotFound;
	if(seqPartsNotFound == binPartsNotFound)
	{
		partsNotFound = (seqPartsNotFound + binPartsNotFound) / 2;
	}
	else
	{
		partsNotFound = 0;
	}//end if
	return partsNotFound;
}//end calcPartsNotFound

void InventoryOrders::orderProcessing()
{
	int result;
	int lineNum = 1;
	double totalPrice;
	cout << setw(45) << "Order Processing Summary" <<endl;
	cout << endl;
	cout << "No." << setw(16) << "Part Number" << setw(13) << "Quantity" 
				 << setw(18) << "Unit Price" << setw(20) << "Order Total" <<endl;
	for(int ct = 0; ct < orderNum; ++ ct)
	{
		//int item = orderPart[ct];
		result = binSearch(orderPart[ct]);
		if(result != -1)
		{
			totalPrice = static_cast<double>(orderQuantity[ct]) * itemPrice[ct];
			totalOrder[totalNum] = totalPrice;
			ordersTotal += totalPrice;
			++ totalNum;
			if(lineNum < 10)
			{
				cout << lineNum << setw(15) << orderPart[ct] << setw(12) << orderQuantity[ct] 
					 << setw(15) <<"$"<<itemPrice[ct] << setw(15) <<"$"<<totalPrice <<endl;
				++ lineNum;
			}
			else
			{
				cout << lineNum << setw(14) << orderPart[ct] << setw(12) << orderQuantity[ct] 
					 << setw(15) <<"$"<<itemPrice[ct] << setw(15) <<"$"<<totalPrice <<endl;
				++ lineNum;
			}

		}
		else
		{
			//cout << "Invalid part number. Unable to process order. " <<endl;
			invalidParts[invPartNum] = orderPart[ct];
			++ invPartNum;
		}
	}
}//end orderProcessing

void InventoryOrders::processingSummary()
{
	cout << setw(46) << "Processing Summary" <<endl;
	cout << endl;
	cout << setw(46) << "Total Number of orders: " << orderNum << endl;
	cout << setw(46) << "Total Number of valid orders: " << totalNum << endl;
	cout << setw(47) << "Total order cost: $" << ordersTotal << endl;
	cout << setw(46) << "Total Number of invalid orders: " << invPartNum << endl;
	cout << endl;
	cout << "List of invlid part numbers found during processing. Please have a " <<endl;
	cout << "sales associate review these order numbers. " <<endl; 
	cout << endl;
	for(int lineNum = 1; lineNum <= invPartNum; ++ lineNum)
	{
		if(lineNum < 10)
		{
			cout << lineNum << setw(10) << invalidParts[lineNum - 1] << endl;
		}
		else
		{
			cout << lineNum << setw(9) << invalidParts[lineNum - 1] << endl;
		}
	}
}//end processingSummary