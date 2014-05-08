/***********************************************************************************
 *PROGRAM		:gradeAverageCalc.cpp											   *
 *PROGRAMMER	:Michael Blackburn												   *
 *PURPOSE		:calculate the averages and other data associated with class grades*
 ***********************************************************************************/

#include <iostream>
#include <iomanip>
using namespace std;

//function prototypes
int get_grade();
char get_letter_grade(int);
double get_average(int, int);
void display_final_results(int, int, double, int, int, int, int, int);

int main()
{
	//declare variables
	int grade = 0;//counter
	double average = 0.0;
	char letterGrade ='A';
	int totalValidGrades = 0;//accumulator
	int totalGrades = 0;//accumulator
	int gradeTotal = 0;//accumulator
	int totalA = 0;//accumulator
	int totalB = 0;//accumulator
	int totalC = 0;//accumulator
	int totalD = 0;//accumulator
	int totalF = 0;//accumulator

	//display header, welcome message, get initial grade input
	cout << setw(50) << "Trident Technical College" <<endl;
	cout << setw(50) << "Student Grade Calculator" <<endl;
	cout << endl;
	cout << endl;
	cout << "\nThank you for using Trident Technical College's student written grade " <<endl;
	cout << "average calculator! We hope this helps your final grade calculations. " <<endl;
	cout << endl;
	grade = get_grade();
	//begin if to check initial value for quit value
	if(grade != -1)
	{//begin while loop
		while(grade >= 0)
		{
			letterGrade = get_letter_grade(grade);
			if(grade > 0)
			{
				totalValidGrades += 1;
				gradeTotal += grade;
			}//end if
			if(letterGrade == 'A')
			{
				totalA += 1;
			}
			else if(letterGrade == 'B')
			{
				totalB += 1;
			}
			else if(letterGrade == 'C')
			{
				totalC += 1;
			}
			else if(letterGrade == 'D')
			{
				totalD += 1;
			}
			else
			{
				totalF += 1;
			}//end if

			totalGrades += 1;
			//output letter grade to user
			cout << letterGrade << endl;
			grade = get_grade();
			}//end while
		//calculate average of all valid grades
		average = get_average(gradeTotal, totalValidGrades);
	}//end if
		//pause and clear screen for final results
		cout << endl;
		system("pause");
		system("cls");
		//dispaly final results
		display_final_results(totalGrades, totalValidGrades, average, totalA, totalB, totalC, totalD, totalF);
	
	system("pause");
	return 0;
}//end MAIN function

//function definitions

/***********************************************************************************
 *PURPOSE		:receive grade entry from user and return value to MAIN			   *
 *PASSED IN		:nothing														   *
 *RETURNED		:grade															   *
 ***********************************************************************************/

int get_grade()
{
	int grade = 0;
	
	cout << "Please enter an integer grade greater than or equal to 0. " <<endl;
	cout << "(Enter -1 to quit): ";
	cin >> grade;
	return grade;
}//end get_grade

/***********************************************************************************
 *PURPOSE		:receive grade value from MAIN and test value to obtain letterGrade*
 *				 value and return to value to MAIN								   *
 *PASSED IN		:grade															   *
 *RETURNED		:letterGrade													   *
 ***********************************************************************************/


char get_letter_grade(int grade)
{
	char letterGrade ='A';
	
	if(grade >= 91)
	{
		letterGrade = 'A';
	}
	else if(grade >= 81)
	{
		letterGrade = 'B';
	}
	else if(grade >= 71)
	{
		letterGrade = 'C';
	}
	else if(grade >= 65)
	{
		letterGrade = 'D';
	}
	else if(grade >= 0)
	{
		letterGrade = 'F';
	}//end if
	return letterGrade;
}//end get_letter_grade

/***********************************************************************************
 *PURPOSE		:calculate grade average after receiving gradeTotal and			   *
 *				 totalValidGrades from MAIN										   *
 *PASSED IN		:gradeTotal and totalValidGrades								   *
 *RETURNED		:average														   *
 ***********************************************************************************/


double get_average(int gradeTotal, int totalValidGrades)
{
	double average = 0.0;
	cout << fixed << setprecision(2);
	average = gradeTotal / totalValidGrades;
	return average;
}//end get_average

/***********************************************************************************
 *PURPOSE		:display final ouputs and resluts of all counts/calculations	   *
 *PASSED IN		:totalGrades, totalValidGrades, average, totalA, totalB, totalC,   *
 *				 totalD, totalF													   *
 *RETURNED		:nothing														   *
 ***********************************************************************************/


void display_final_results(int totalGrades, int totalValidGrades, double average, int totalA, int totalB, int totalC, int totalD, int totalF)
{
	cout << setw(52) << "Trident Technical College" <<endl;
	cout << setw(49) << "Final Grade Report " <<endl;
	cout << endl;
	cout << endl;
	cout << setw(55) << "Total number of grades inputted: " << totalGrades << endl;
	cout << setw(55) << "Total number of grades above 0: " << totalValidGrades << endl;
	cout << setw(55) << "Grade average of the class: " << average << endl;
	cout << setw(55) << "Total number of A's: " << totalA << endl;
	cout << setw(55) << "Total number of B's: " << totalB << endl;
	cout << setw(55) << "Total number of C's: " << totalC << endl;
	cout << setw(55) << "Total number of D's: " << totalD << endl;
	cout << setw(55) << "Total number of F's: " << totalF << endl;
	cout << endl;
	cout << "Thanks again for using this student written calculator! We look forward to " << endl;
	cout << "writing more software for you in the future." << endl;
}//end display_final_results