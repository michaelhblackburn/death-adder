/********************************************************************************
 *FILENAME		 : Analyze SSW Daily Sales.cpp									*
 *PROGRAMMER	 : Michael Blackburn											*
 *PURPOSE		 : Analyze sales/transaction data from SSW Porpoise Pond		*
 ********************************************************************************/

#include <iostream>
#include <iomanip>
#include <fstream>
#include <string>
using namespace std;

//Function prototypes
void program_header();
void display_trans_columns();
void display_output(int, string, int, string, double, double);
double calc_delta(char, char, int, double);
string get_ticket_type(char);
string get_coupon(char);
string get_highSellerType(int, int, int);
int get_highSellerNum(string , int, int, int);
void transaction_report_header();
void display_final_report(string, int, int, double, int, double, int, double, int, double, int, double, double, string, int);
double get_discount_profit_loss(char, char, int);


int main()
{
	//Input file stream object to read the data file
	ifstream salesIn;

	//Variables for the incoming fields
	string ticketDate;
	string ticket ="";
	string coup ="";
	string highSellerType ="";
	char ticketType = 'A';
	char coupon = 'A';
	int ticketQty = 0;//counter
	int lineNum = 1;//counter
	int totalChild = 0;//accumulator
	int totalJunior = 0;//accumulator
	int totalAdult = 0;//accumulator
	int totalRegJunior = 0;//accumulator
	int totalRegAdult = 0;//accumulator
	int totalDisJunior = 0;//accumulator
	int totalDisAdult = 0;//accumulator
	int transactions = 0;//accumulator
	int highSellerNum = 0;
	double regAdultSales = 0.0;//accumulator
	double regJuniorSales = 0.0;//accumulator
	double disAdultSales = 0.0;//accumulator
	double disJuniorSales = 0.0;//accumulator
	double ticketCost = 0.0;//counter
	double totalSales = 0.0;//accumulator
	double delta = 0.0;//counter
	double totalDelta = 0.0;//accumulator
	double profitLost = 0.0;//counter
	double totalProfitLost = 0.0;//accumulator
	
	//display program header
	program_header();
	cout << endl;
	
	//Set up the output specs
	cout << fixed << setprecision(2);

	//Open the data file
	salesIn.open("ssw-sales.dat");
	if (salesIn.is_open())
	{
		//Prime read:  read the first record of the data file
		salesIn		>>	ticketDate
					>>	ticketType
					>>	ticketQty
					>>	coupon
					>>	ticketCost;

		//display column headers for transaction reporting 
		display_trans_columns();
		
		//Begin the central record-processing while loop
		while (!salesIn.eof())
		{
			ticket = get_ticket_type(ticketType);//call function to obtain string value from ticketType
			coup = get_coupon(coupon);//call function to obtain string value from coupon
			delta = calc_delta(coupon, ticketType, ticketQty, ticketCost);//call function to calculate delta
			display_output(lineNum, ticket, ticketQty, coup, ticketCost, delta);//call function to display individual transaction output
			//begin accumulation for final output totals
			if(ticketType == 'A' && coupon == 'Y')
			{
				totalDisAdult += ticketQty;
				disAdultSales += ticketCost;
			}
			else if(ticketType == 'J' && coupon == 'Y')
			{
				totalDisJunior += ticketQty;
				disJuniorSales += ticketCost;
			}
			else if(ticketType == 'A' && coupon == 'N')
			{
				totalRegAdult += ticketQty;
				regAdultSales += ticketCost;
			}
			else if(ticketType == 'J' && coupon == 'N')
			{
				totalRegJunior += ticketQty;
				regJuniorSales += ticketCost;
			}
			else
			{
				totalChild += ticketQty;
			}//end if

			lineNum += 1;
			totalDelta += delta;
			transactions +=1;
			totalSales += ticketCost;
			totalJunior = totalDisJunior + totalRegJunior;
			totalAdult = totalDisAdult + totalRegAdult;
			highSellerType = get_highSellerType(totalChild, totalJunior, totalAdult);//call function to obtain which ticket type sold the most tickets
			highSellerNum = get_highSellerNum(highSellerType, totalChild, totalJunior, totalAdult);//call function to obtain high selling ticket type total

			//Read the next record (bottom of while loop)
			salesIn		>>	ticketDate
						>>	ticketType
						>>	ticketQty
						>>	coupon
						>>	ticketCost;
		} //END OF RECORD PROCESSING WHILE LOOP
		
		//Close the data file 
		salesIn.close();

		//display end of transaction report header, and final report
		transaction_report_header();
		system("pause");
		system("cls");
		display_final_report(ticketDate, transactions, totalRegJunior, regJuniorSales, totalDisJunior, disJuniorSales, totalRegAdult, regAdultSales, 
			totalDisAdult, disAdultSales, totalChild, totalSales, totalDelta, highSellerType, highSellerNum);
		cout << endl;

	}//END IF FILE OPENED

	else  //File did not open
		cout << "The sales file did not open!\n";

	

salesIn.open("ssw-sales.dat");
	if (salesIn.is_open())
	{
		//Prime read:  read the first record of the data file
		salesIn		>>	ticketDate
					>>	ticketType
					>>	ticketQty
					>>	coupon
					>>	ticketCost;
		while (!salesIn.eof())
		{
			profitLost = get_discount_profit_loss(coupon, ticketType, ticketQty);
			totalProfitLost += profitLost;		
		
		//Read the next record (bottom of while loop)
			salesIn		>>	ticketDate
						>>	ticketType
						>>	ticketQty
						>>	coupon
						>>	ticketCost;
		} //END OF RECORD PROCESSING WHILE LOOP
		salesIn.close();

		cout << setw(47) << " Coupon sales are costing the park $"<<totalProfitLost<<" for this " <<endl;
		cout << setw(47) << " transaction period. " <<endl;
		cout << endl;
	}//END IF FILE OPENED
	else  //File did not open
		cout << "The sales file did not open!\n";

	system("pause");
	return 0;
}//END MAIN

/********************************************************************************
 *PURPOSE	:display transaction program header									*
 *PASSED IN :nothing															*
 *RETURNED	:nothing															*
 ********************************************************************************/

void program_header()
{
	cout << setw(50) << "Summervile Sea World " <<endl;
	cout << setw(55) << "Porpoise Pond Ticket Counter " <<endl;
	cout << setw(49) << " Transaction Report " <<endl;
}//end program_header

/********************************************************************************
 *PURPOSE	:display column headings for transaction report						*
 *PASSED IN	:nothing															*
 *RETURNED	:nothing															*
 ********************************************************************************/

void display_trans_columns()
{
	cout << "#" << setw(10) << "TYPE" << setw(10) << "QTY" << setw(11) << "COUPON" << setw(14) << "ACTUAL CHG" << setw(20) << "OVER/UNDER" <<endl;
}//end display_trans_columns


/********************************************************************************
 *PURPOSE	:obtain a string value for ticket variable for display			*
 *PASSED IN	:ticketType from data file											*
 *RETURNED	:string value Adult, Junior, or Child, dependent on ticketType		*
 ********************************************************************************/

string get_ticket_type(char ticketType)
{
	string ticket = "";
	
	if(ticketType == 'A')
	{
		ticket = "Adult";
	}
	else if(ticketType == 'J')
	{
		ticket = "Junior";
	}
	else
	{
		ticket = "Child";
	}//end if
	return ticket;
}//end get_ticket_type

/********************************************************************************
 *PURPOSE	:obtain a string value for coup variable for display				*
 *PASSED IN	:coupon from data file												*
 *RETURNED	:string value Yes or No, dependent on coupon						*
 ********************************************************************************/

string get_coupon(char coupon)
{
	string coup ="";
	
	if(coupon == 'Y')
	{
		coup = "Yes";
	}
	else 
	{
		coup = "No";
	}//end if

	return coup;
}//end get_coup

/********************************************************************************
 *PURPOSE	:calculate delta value for return to MAIN from values in data file	*
 *PASSED IN	:coupon, ticketType, ticketQty, and ticketCost from data file		*
 *RETURNED	:delta value for ticket actual cost versus cost paid				*
 ********************************************************************************/

double calc_delta(char coupon, char ticketType, int ticketQty, double ticketCost)
{
	double actualCost = 0.0;
	double delta = 0.0;
	const double ADULT_COST = 11.5;
	const double JUNIOR_COST = 7.5;
	const double DISCOUNT = .25;
	
	if(coupon == 'N' && ticketType == 'A')
	{
		actualCost = ADULT_COST * ticketQty;
		delta = ticketCost - actualCost;
	}
	else if(coupon == 'Y' && ticketType == 'A')
	{
		actualCost = (ADULT_COST -(ADULT_COST * DISCOUNT)) * ticketQty;
		delta = ticketCost - actualCost;
	}
	else if(coupon == 'N' && ticketType == 'J')
	{
		actualCost = JUNIOR_COST * ticketQty;
		delta = ticketCost - actualCost;
	}
	else if(coupon == 'Y' && ticketType == 'J')
	{
		actualCost = (JUNIOR_COST -(JUNIOR_COST * DISCOUNT)) * ticketQty;
		delta = ticketCost - actualCost;
	}//end if
	return delta;
}//end calc_delta

/********************************************************************************
 *PURPOSE	:display transaction line outputs for inspection					*
 *PASSED IN	:lineNum, ticket, ticketQty, coup, ticketCost, delta values			*
 *RETURNED	:nothing															*
 ********************************************************************************/

void display_output(int lineNum, string ticket, int ticketQty, string coup, double ticketCost, double delta)
{
	if(lineNum < 10)
	{
		if(ticket == "Adult" || ticket == "Junior")
			{
				cout << lineNum << setw(10) << ticket << setw(10) << ticketQty << setw(11) << coup << setw(14) << ticketCost << setw(20) << delta << endl;
			}
			else
			{
			cout << lineNum << setw(10) << ticket << setw(10) << ticketQty << endl;
			}//end if
	}
	else 
	{
		if(ticket == "Adult" || ticket == "Junior")
			{
				cout << lineNum << setw(9) << ticket << setw(10) << ticketQty << setw(11) << coup << setw(14) << ticketCost << setw(20) << delta << endl;
			}
			else
			{
			cout << lineNum << setw(9) << ticket << setw(10) << ticketQty << endl;
			}//end if
	}//end if
}//end display_output	

/********************************************************************************
 *PURPOSE	:determine which type of ticket sold the most tickets for report	*
 *PASSED IN	:totalChild, totalJunior, and totalAdult values						*
 *RETURNED	:highSellerType value for display									*
 ********************************************************************************/

string get_highSellerType(int totalChild, int totalJunior, int totalAdult)
{
	string highSellerType ="";
	
	if(totalChild > totalJunior && totalChild > totalAdult)
	{
		highSellerType = "Child";
	}
	else if(totalJunior > totalChild && totalJunior > totalAdult)
	{
		highSellerType = "Junior";
	}
	else
	{
		highSellerType = "Adult";
	}//end if 
	return highSellerType;
}//end get_highSellerType

/********************************************************************************
 *PURPOSE	:determine and return the number of tickets sold by highSellerType	*
 *PASSED IN	:highSellerType, totalChild, totalJunior, and totalAdult values		*
 *RETURNED	:highSellerNum value for display									*
 ********************************************************************************/

int get_highSellerNum(string highSellerType, int totalChild, int totalJunior, int totalAdult)
{
	int highSellerNum = 0;
	
	if(highSellerType == "Child")
	{
		highSellerNum = totalChild;
	}
	else if(highSellerType == "Junior")
	{
		highSellerNum = totalJunior;
	}
	else
	{
		highSellerNum = totalAdult;
	}//end if
	return highSellerNum;
}//end get_highSellerNum

/********************************************************************************
 *PURPOSE	:display message that final report is forthcoming					*
 *PASSED IN	:nothing															*
 *RETURNED	:nothing															*
 ********************************************************************************/

void transaction_report_header()
{
	cout << "\n\nOkay, we're done with transactions. Now we're going to " <<endl;
	cout << "display the final transaction report. Whenever you're ready, " <<endl;
	cout << "you may... " <<endl;
	cout << endl;
}//end transaction_report_header

/********************************************************************************
 *PURPOSE	:dsiplay final transaction report									*
 *PASSED IN	:ticketDate, transactions, totalRegJunior, regJuniorSales,			*	
 *			totalDisJunior, disJuniorSales, totalRegAdult, regAdultSales,		*
 *			totalDisAdult, disAdultSales, totalChild, totalSales, totalDelta,	*
 *			highSellerType, highSellerNum										*
 *RETURNED	:string value Adult, Junior, or Child, dependent on ticketType		*
 ********************************************************************************/

void display_final_report(string ticketDate, int transactions, int totalRegJunior, double regJuniorSales, int totalDisJunior, double disJuniorSales, int totalRegAdult, 
	double regAdultSales, int totalDisAdult, double disAdultSales, int totalChild, double totalSales, double totalDelta, string highSellerType, int highSellerNum)
{
	cout << fixed << setprecision(2);
	cout << setw(47) << "FINAL SALES REPORT " <<endl;
	cout << setw(50) << "Sales Report for Porpoise Pond for: "<<ticketDate<<" " <<endl;
	cout << setw(61) << "============================================== " <<endl;
	cout << endl;
	cout << endl;
	cout << setw(50) << "Number of transactions: "<<transactions<<" " <<endl;
	cout << setw(50) << "Total Regular Junior Tickets Sold: "<<totalRegJunior<<"" <<endl;
	cout << setw(51) << "Total Regular Junior Ticket Sales: $"<<regJuniorSales<<"" <<endl;
	cout << setw(50) << "Total Discounted Junior Tickets Sold: "<<totalDisJunior<<"" <<endl;
	cout << setw(51) << "Total Discounted Junior Ticket Sales: $"<<disJuniorSales<<"" <<endl;
	cout << setw(50) << "Total Regular Adult Tickets Sold: "<<totalRegAdult<<"" <<endl; 
	cout <<	setw(51) << "Total Regular Adult Ticket Sales: $"<<regAdultSales<<"" <<endl;
	cout << setw(50) << "Total Discounted Adult Tickets Sold: "<<totalDisAdult<<"" <<endl;
	cout << setw(51) << "Total Discounted Adult Ticket Sales: $"<<disAdultSales<<"" <<endl;
	cout << setw(50) << "Total Child Tickets Sold: "<<totalChild<<"" <<endl;
	cout << endl;
	cout << setw(38) << "Total Sales for "<<ticketDate<<": $"<<totalSales<<" " <<endl;
	cout << endl;
	cout << setw(51) << "Total over/under for today's sales: $"<<totalDelta<<" " <<endl;
	cout << endl;
	cout << setw(49) << "The highest selling tickets today were "<<highSellerType<<" tickets. " <<endl;
	cout << setw(15) << "For "<<ticketDate<<", we sold a total of "<<highSellerNum<<" "<<highSellerType<<" tickets. " <<endl;
}//end display_final_report

/********************************************************************************
 *PURPOSE	:calculate profit lost from selling tickets at a discount			*
 *PASSED IN	:coupon, ticketType, ticketQty										*
 *RETURNED	:profitLoss															*
 ********************************************************************************/

double get_discount_profit_loss(char coupon, char ticketType, int ticketQty)
{
	double profitLoss = 0.0;
	double regPrice = 0.0;
	double disPrice = 0.0;
	const double ADULT_COST = 11.5;
	const double JUNIOR_COST = 7.5;
	const double DISCOUNT = .25;
	
	cout << fixed << setprecision(2);
	if(coupon == 'Y' && ticketType == 'A')
	{
		regPrice = ADULT_COST * ticketQty;
		disPrice = (ADULT_COST - (ADULT_COST * DISCOUNT)) * ticketQty;
		profitLoss = regPrice - disPrice;
	}
	else if(coupon == 'Y' && ticketType == 'J')
	{
		regPrice = JUNIOR_COST * ticketQty;
		disPrice = (JUNIOR_COST - (JUNIOR_COST * DISCOUNT)) * ticketQty;
		profitLoss = regPrice - disPrice;
	}//end if 
	
	return profitLoss;
}//end get_discount_profit_loss