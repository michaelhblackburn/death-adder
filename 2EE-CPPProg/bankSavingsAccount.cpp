//FILE			:bankSavingsAccount.cpp
//PROGRAMMER	:Michael Blackburn
//PURPOSE		:enter, display, and calculate various values associated with a savings account

#include <iostream>
#include <iomanip>
#include <string>
using namespace std;

#include "SavingsAccount.h"
void tellerHeader();
void deposit_to_account(SavingsAccount &, double);
void withdrawl_from_account(SavingsAccount &, double);
void display_final_report(int, double, double, double, double);

int main()
{
	SavingsAccount myAccount;
	double deposit = 0.0;
	double withdrawl = 0.0;
	double currentBalance = 0.0;
	double currentRate = 0.0;
	double endingBalance = 0.0;
	double earnedInterest = 0.0;
	double startingBalance = 0.0;
	double rate = 0.0;
	char newCust = 'A';
	char response = 'A';
	int month = 1;
	string acctNumber;

	cout << fixed << setprecision(2);
	tellerHeader();
	cout << endl;
	cout << "Are you a new customer? Enter N if you are a new customer "<< endl;
	cout << "or R for returning customers: ";
	cin >> newCust;
	newCust = toupper(newCust);
	while(newCust != 'N' && newCust != 'R')
	{
		cout << "Please enter N for new customer or R for returning customers: ";
		cin >> newCust;
		newCust = toupper(newCust);
	}//end while
	cout << endl;
	if(newCust == 'N')
	{
		cout << "Please enter the amount of your initial deposit: $ ";
		cin >> deposit;
		myAccount.setNewAccountValues(deposit);
	}//end if 
	cout << endl;

	acctNumber = myAccount.getAccountNumber();
	currentBalance = myAccount.getBalance();
	currentRate = (myAccount.getInterestRate())*100;
	rate = myAccount.getInterestRate();
	
	cout << "Your account number is: "
		 << acctNumber <<endl
		 << "Your current acount balance is: $"
		 << currentBalance <<endl
		 << "Your current monthly interest rate is: "
		 << currentRate << "%" <<endl
		 << endl;
		
	if(newCust == 'R')
	{
		cout << "Would you like to make a deposit today? Y for yes or N for no: " <<endl;
		cin >> response;
		response = toupper(response);
		while(response != 'Y' && response != 'N')
		{
			cout << "Please enter Y for yes or N for no: ";
			cin >> response;
			response = toupper(response);
		}//end while
		if(response == 'Y')
		{
			cout << "\nPlease enter the amount of your deposit: $";
			cin >> deposit;
			deposit_to_account(myAccount, deposit);
			cout << "\nYour new balance after deposit is: $" 
				 << myAccount.getBalance();
		}
	
		cout << endl;
		cout << "\nWould you like to make a withdrawal today? Y for yes or N for no: " <<endl;
		cin >> response;
		response = toupper(response);
		while(response != 'Y' && response != 'N')
		{
			cout << "Please enter Y for yes or N for no: ";
			cin >> response;
			response = toupper(response);
		}//end while
		if(response == 'Y')
		{
			cout << "\nPlease enter the amount of your withdrawl: $";
			cin >> withdrawl;
			withdrawl_from_account(myAccount, withdrawl);
			cout << "\nYour new balance after withdrawl is: $"
				 << myAccount.getBalance();
		}
	}//end if
	cout << endl;
	startingBalance = myAccount.getBalance();
	earnedInterest = startingBalance * myAccount.getInterestRate();
	endingBalance = startingBalance + earnedInterest;
	cout << "\nYour final balance today is: $ " << startingBalance << endl;
	system("pause");
	system("cls");
	display_final_report(month, startingBalance, earnedInterest, endingBalance, rate);

cout << endl;	
system("pause");
return 0;
}

//tellerHeader function
//PURPOSE		:display teller header at start of program
//PASSED IN		:nothing
//RETURNED		:nothing

void tellerHeader()
{
	cout << setw(50) << "Blackburn Community Bank " <<endl;
	cout << setw(50) << "Automated Teller Service " <<endl;
	cout << "\n\n\nWelcome to Blackburn Community Bank, your local financial leader for " 
		 << "\nover 30 days. We're grateful for the opportunity to service your financial " 
		 << "\nneeds, and look forward to serving you in the future. " <<endl
		 << endl;
	cout << setw(55) << "How may we be of help today? " <<endl;
}//end function tellerHeader

//deposit_to_account function
//PURPOSE		:call method to deposit funds in myAccount
//PASSED IN		:myAccount object, deposit
//RETURNED		:nothing

void deposit_to_account(SavingsAccount &myAccount, double deposit)

{
	myAccount.addToBalance(deposit);
}//end function deposit_to_account

//withdrawl_from_account function
//PURPOSE		:call method to withdrawl funds from myAccount
//PASSED IN		:myAccount object, withdrawl
//RETURNED		:nothing

void withdrawl_from_account(SavingsAccount &myAccount, double withdrawl)

{
	myAccount.subtractFromBalance(withdrawl);
}//end function withdrawl_from_account

//display_final_report function
//PURPOSE		:display 12-month account summary using loop structure to calculate acount growth from interest
//PASSED IN		:month, startingBalance, earnedInterest, endingBalance, rate
//RETURNED		:nothing

void display_final_report(int month, double startingBalance, double earnedInterest, double endingBalance, double rate)

{
	cout << "This is a 12-month summary of your account growth based on your current " 
		 << "\ninterest rate. " << endl
		 << endl;
	cout << "Month # " << setw(20) << "Starting Balance " << setw(22) << "Interest Earned " << setw(23) << "Ending Balance "<< endl;
	while(month > 0 && month < 13)
	{
		if(month < 10)
		{
			cout << setw(4) << month << setw(11)<< "$" << startingBalance << setw(18) << "$" << earnedInterest << setw(18) << "$" << endingBalance << endl;
		}
		else 
		{
			cout << setw(4) << month << setw(11)<< "$" << startingBalance << setw(18) << "$" << earnedInterest << setw(18) << "$" << endingBalance << endl;
		}//end if

		month +=1;
		startingBalance = endingBalance;
		earnedInterest = startingBalance * rate;
		endingBalance = startingBalance + earnedInterest;
	}//end while
	cout << "\n\n\nThank you for choosing Blackburn Community Bank for your financial needs. We "
		 << "\nlook forward to our continuing relationship with you, and will be here for all "
		 << "\nof your banking needs in the future. Have a wonderful day! " <<endl;
}//end display_final_report

