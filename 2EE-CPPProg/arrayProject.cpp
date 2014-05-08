//FILE			:arrayProject.cpp
//PROGRAMMER	:Michael Blackburn
//PURPOSE		:use calls to class methods to test class and use of data in array

#include <iostream>
#include <iomanip>
#include <fstream>
#include <string>
using namespace std;

#include "IntegerArray.h"

int main()
{	
	IntegerArray myArray1;
	double average = 0.0;
	int numBelowAvg = 0;
	int maxInteger = 0;
	int recordCount = 0;
	string dataFile1 = "";

	cout << fixed << setprecision(2);
	dataFile1 = "program5.dat";
	myArray1.loadArray(dataFile1);
	myArray1.displayArray();
	cout << endl;
	recordCount = myArray1.getRecordCount();
	if(recordCount != -1)
	{
		myArray1.calcAverage();
		myArray1.countBelowAvg();
		myArray1.findMaxInteger();
		average = myArray1.getAverage();
		numBelowAvg = myArray1.getNumBelowAvg();
		maxInteger = myArray1.getMaxInteger();
		cout << "The average of the array is "<<average<<". "<<endl;
		cout << "There are "<<numBelowAvg<<" records below the average. "<<endl;
		cout << "The value of the largest record is "<<maxInteger<<". "<<endl;
	}//end if
	system("pause");
	return 0;
}//end main