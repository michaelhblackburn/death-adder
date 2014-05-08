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
		int sumNum;
		int seqPartsFound;
		int binPartsFound;
		int seqPartNotFound;
		int binPartNotFound;
		int itemNum[200];
		double itemPrice[200];
		int sumItemNum[1000];
		double sumItemPrice[1000];

	public:
		InventoryData();
		void loadArrays(string);
		void displayArrays();
		void displaySeqSearchResult(int);
		void displayBinSearchResult(int);
		int getRecordNum();
		int getItemNum(int);
		double getItemPrice(int);
		int getSeqPartsFound();
		int getBinPartsFound();
		int getSeqPartNotFound();
		int getBinPartNotFound();
		int seqSearch(int);
		int binSearch(int);
		void bubbleSort();
		void loadSumArray(int, double);
		void displaySummary(int, int, int);
		int calcSearchResult(int, int);
		int calcPartsFound(int, int);
		int calcPartsNotFound(int, int);
};

InventoryData::InventoryData()
{
	recordNum = 0;
	sumNum = 0;
	seqPartsFound = 0;
	binPartsFound = 0;
	seqPartNotFound = 0;
	binPartNotFound = 0;

	for(int ct = 0; ct < 200; ++ ct) recordNum = 0;
	for(int ct = 0; ct < 1000; ++ ct) sumNum = 0;
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
	if(result != -1)
	{
		cout << "Sequential search found item number "<<itemNum[result]<<", and it's price is $"<<itemPrice[result]<<"." <<endl;
	}
	else
	{
		cout << "The item was not found. " <<endl;
	}
}//end displaySeqSearchResults

void InventoryData::displayBinSearchResult(int result)
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

int InventoryData::getRecordNum()
{
	return recordNum;
}//end getRecordNum

int InventoryData::getItemNum(int record)
{
	return itemNum[record];
}//end getItemNum

double InventoryData::getItemPrice(int record)
{
	return itemPrice[record];
}//end getItemPrice

int InventoryData::getSeqPartsFound()
{
	return seqPartsFound;
}//end getSeqPartsFound

int InventoryData::getBinPartsFound()
{
	return binPartsFound;
}//end getBinPartsFound

int InventoryData::getSeqPartNotFound()
{
	return seqPartNotFound;
}//end getSeqPartNotFound

int InventoryData::getBinPartNotFound()
{
	return binPartNotFound;
}//end getBinPartNotFound


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
	if(middle == -1)
	{
		++binPartNotFound;
	}
	else
	{
		++binPartsFound;
	}
	cout << "The binary search made "<<loopCounter<<" attempts to find the item. " <<endl;
	return middle;
}//end binSearch

void InventoryData::bubbleSort()
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

void InventoryData::loadSumArray(int result1, double result2)
{
	sumItemNum[sumNum] = result1;
	sumItemPrice[sumNum] = result2;
	++ sumNum;
}

void InventoryData::displaySummary(int totQuer, int partFound, int partNot)
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

int InventoryData::calcSearchResult(int seqSearchResult, int binSearchResult)
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

int InventoryData::calcPartsFound(int seqPartsFound, int binPartsFound)
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

int InventoryData::calcPartsNotFound(int seqPartsNotFound, int binPartsNotFound)
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