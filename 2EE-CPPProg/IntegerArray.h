//FILE			:IntegerArray.h
//PPROGRAMMER	:Michael Blackburn
//PURPOSE		:class for practicing use of arrays

#include <iostream>
#include <iomanip>
#include <fstream>
#include <string>
using namespace std;

class IntegerArray
{
	private:
		int records[100];
		int recordCount;
		int numBelowAvg;
		int maxInteger;
		double average;
		
	public:
		IntegerArray();
		int getRecordCount();
		int getNumBelowAvg();
		int getMaxInteger();
		double getAverage();
		void loadArray(string);
		void displayArray();
		double calcAverage();
		int countBelowAvg();
		int findMaxInteger();
};

IntegerArray::IntegerArray()
{
	recordCount		= 0;
	numBelowAvg		= 0;
	maxInteger		= 0;
	average			= 0.0;
	
	for(int ct = 0; ct < 100; ++ct) records[ct] = 0;
}

int IntegerArray::getRecordCount()
{
	return recordCount;
}//end getRecordCount

int IntegerArray::getNumBelowAvg()
{
	return numBelowAvg;
}//end getNumBelowAvg

int IntegerArray::getMaxInteger()
{
	return maxInteger;
}//end getMaxRecord

double IntegerArray::getAverage()
{
	return average;
}//end getAverage

void IntegerArray::loadArray(string dataFile)
{
	ifstream recordsIn;

	recordsIn.open(dataFile);
	if(recordsIn.is_open())
	{
		recordsIn >> records[recordCount];
		
		while(!recordsIn.eof())
		{
			++recordCount;
			recordsIn >> records[recordCount];
		}//end while

		recordsIn.close();
	}//end if file opened
	else
	{
		recordCount = -1;
		cout << "File did not open."<<endl;
	}
}//end loadArray

void IntegerArray::displayArray()
{
	for(int ct = 0; ct < recordCount; ++ct)
	{
		cout << records[ct] <<endl;
	}
}//end displayArray

double IntegerArray::calcAverage()
{
	int recordSum = 0;
	for(int ct = 0; ct < recordCount; ++ct)
	{
		recordSum += records[ct];
	}
	average = static_cast<double>(recordSum) / static_cast<double>(recordCount);
	return average;
}//end calcAverage

int IntegerArray::countBelowAvg()
{
	int belowAvg = 0;
	for(int ct = 0; ct < recordCount; ++ct)
	{
		if(records[ct] < average)
		{
			++ belowAvg;
		}//end if
	}
	numBelowAvg = belowAvg;
	return numBelowAvg;
}//end countBelowAvg

int IntegerArray::findMaxInteger()
{
	int maxVal = 0;
	for(int ct = 0; ct < recordCount; ++ct)
	{
		if(records[ct] > maxVal)
		{
			maxVal = records[ct];
		}
	}
	maxInteger = maxVal;
	return maxInteger;
}//end findMaxRecord

