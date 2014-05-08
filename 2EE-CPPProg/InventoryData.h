//FILENAME			:InventoryData.h
//PROGRAMMER		:Michael Blackburn
//PURPOSE			:class for array loading and searching involving inventory data

#include <iostream>
#include <fstream>
#include <iomanip>
#include <string>
using namespace std;

class InventoryData
{
	private:
		int recordNum;
		int itemNum[200];
		double itemPrice[200];

	public:
		InventoryData();
		void loadArrays(string);
		void displayArrays();
		void displaySeqSearchResult(int);
		void displayBinSearchResult(int);
		int getRecordNum();
		int seqSearch(int);
		int binSearch(int);
};

InventoryData::InventoryData()
{
	recordNum = 0;

	for(int ct = 0; ct < 200; ++ ct) recordNum = 0;
}//end InventoryData

void InventoryData::loadArrays(string datafile)
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
}//end loadArrays

void InventoryData::displayArrays()
{
	cout << "Displaying records from data file. " <<endl;
	cout << endl;
	for(int ct = 0; ct < recordNum; ++ct)
	{
		cout << itemNum[ct] <<"   "<< itemPrice[ct] <<endl;
	}
}//end displayArrays

void InventoryData::displaySeqSearchResult(int result)
{
	int item = itemNum[result];
	double price = itemPrice[result];
	if(result != -1)
	{
		cout << "Sequential search found item number "<<item<<", and it's price is $"<<price<<"." <<endl;
	}
	else
	{
		cout << "The item was not found. " <<endl;
	}
}//end displaySeqSearchResults

void InventoryData::displayBinSearchResult(int result)
{
	int item = itemNum[result];
	double price = itemPrice[result];
	if(result != -1)
	{
		cout << "Binary search found item number "<<item<<", and it's price is $"<<price<<"." <<endl;
	}
	else
	{
		cout << "The item was not found. " <<endl;
	}
}//end displayBinSearchResults

int InventoryData::getRecordNum()
{
	return recordNum;
}//end getRecordNum

int InventoryData::seqSearch(int item)
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
	cout << "The sequential search made "<<loopCounter<<" attempts to find the item. " <<endl;
	return recFound;
}//end seqSearch

int InventoryData::binSearch(int item)
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
	cout << "The binary search made "<<loopCounter<<" attempts to find the item. " <<endl;
	return middle;
}//end binSearch
