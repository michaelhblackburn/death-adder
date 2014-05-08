/********************************************************************************
 *PROGRAM		:revisedTicketSalesCalc.cpp										*
 *PROGRAMMER	:Michael Blackburn												*
 *PURPOSE		:revision of ticket sales program for Summerville Porpoise Pond	*
 ********************************************************************************/

#include <iostream>
#include <iomanip>
#include <string>
#include <ctime>
using namespace std;

void display_program_header();
char get_ticket_type();
double find_ticket_price(char);
char get_coupon(char);
double apply_discount(char, char, double);
int ticket_quantity();
void disp_purchase(char, char, int, double);
void disp_final_report(const int, int, int, int, int, int, double, int,	int, double);
void report_message();

int main()
{
	//declare variable and constants
	
	char ticketType			    ='A';
	char coupon					='A';
	int quantity			    =0;//counter
	int totalToddler		    =0;//accumulator
	int totalJunior			    =0;//accumulator
	int totalAdult			    =0;//accumulator
	int extraTickets		    =0;
	int finalTicketCount	    =0;//accumulator
	double finalSale			=0.0;
	double ticketPrice			=0.0;
	double totalPrice			=0.0;
	double discountPrice		=0.0;
	double purchasePrice		=0.0;
	double purchaseTotal		=0.0;
	double totalRegularPrice	=0.0;
	double totalDiscountPrice	=0.0;
	double profitLost			=0.0;
	double totalProfitLost		=0.0;
	int discountJunior			=0;//accumulator
	int discountAdult			=0;//accumulator
	const int MAX_SEAT_COUNT    =20;
		
	
	//display program header
	display_program_header();
	
	//get initial input for ticket type	
	ticketType = get_ticket_type();
	
	//begin sales while loop
	while(ticketType != 'Q' && finalTicketCount < MAX_SEAT_COUNT)
	{	
		ticketPrice = find_ticket_price(ticketType);
		coupon = get_coupon(ticketType);
		discountPrice = apply_discount(coupon, ticketPrice, ticketPrice);
		quantity = ticket_quantity();
		totalPrice = ticketPrice * quantity;

		if(coupon == 'Y')
		{
			purchasePrice = discountPrice * quantity;
		}
		else
		{
			purchasePrice = ticketPrice * quantity;
		}//end if
		
		profitLost = totalPrice - purchasePrice;

		if(ticketType == 'A' && coupon == 'N')
		{
			totalAdult += quantity;
		}
		else if(ticketType == 'J' && coupon == 'N')
		{
			totalJunior += quantity;
		}
		else if(ticketType == 'A' && coupon == 'Y')
		{
			totalAdult += quantity;
			discountAdult += quantity;
		}
		else if(ticketType == 'J' && coupon == 'Y')
		{
			totalJunior += quantity;
			discountJunior += quantity;
		}
		else
		{
			totalToddler += quantity;
		}//end if
		
		disp_purchase(ticketType, coupon, quantity, purchasePrice);

		finalTicketCount += quantity;
		finalSale += purchasePrice;
		totalProfitLost += profitLost;

		cout <<endl;
		system("pause");
		system("cls");
				
		if(finalTicketCount < MAX_SEAT_COUNT)
		{
			ticketType = get_ticket_type();
		}//end if
	}//end while

	if(finalTicketCount > 0 && finalTicketCount > MAX_SEAT_COUNT)
	{
		extraTickets = finalTicketCount - MAX_SEAT_COUNT;
	}//end if 

	report_message();
	cout <<endl;
	system("pause");
	system("cls");

	disp_final_report(MAX_SEAT_COUNT, extraTickets, finalTicketCount, totalToddler, 
		totalJunior, totalAdult, finalSale, discountJunior, discountAdult, totalProfitLost);
	cout <<endl;
	cout <<endl;
	system("pause");
	return 0;
}//end of main

/*****************************************************************************
 *PURPOSE		:input ticket type or quit program-accepts A, J, T, or Q only*
 *PASSED IN		:nothing													 *
 *RETURNED		:Menu option noted above									 *
 *****************************************************************************/
 
char get_ticket_type()
{
	char ticketType = 'A';
	cout << "\n\n\nPlease enter the type of tickets to be purchased or Q " <<endl;
	cout << "to quit and exit. " <<endl;
	cout << "Press T for Toddler tickets " <<endl;
	cout << "Press J for Junior tickets " <<endl;
	cout << "Press A for Adult tickets " <<endl;
	cout << "Press Q to quit and exit " <<endl;
	cin >> ticketType;
	ticketType = toupper(ticketType);
	
	//if input is not one of the offered options, ask for another selection
	while(ticketType != 'T' && ticketType != 'J' && ticketType != 'A' && ticketType != 'Q')
	{
		cout << "\nInvalid entry. Please enter the type of tickets you to be purchased or Q " <<endl;
		cout << "to quit and exit. " <<endl;
		cout << "Press T for Toddler tickets " <<endl;
		cout << "Press J for Junior tickets " <<endl;
		cout << "Press A for Adult tickets " <<endl;
		cout << "Press Q to quit and exit " <<endl;
		cin >> ticketType;
		ticketType = toupper(ticketType);		
	}//end while
	return ticketType;
}//end get_ticket_type


/********************************************************
 *PURPOSE		:input ticketType for ticket price		*
 *PASSED IN		:ticketType from user input				*
 *RETURNED		:purchase price for a single ticket		*
 ********************************************************/
 
double find_ticket_price(char ticketType)
{
	double purchasePrice =0.0;
	if(ticketType == 'A')
	{
		purchasePrice = 11.5;
	}	
	else if(ticketType == 'J')
	{
		purchasePrice = 7.5;
	}	
	else
	{
		purchasePrice = 0.0;
	}//end if
	return purchasePrice;
}//end find_ticket_price



/************************************************************************
 *PURPOSE		:input whether customer has a coupon-accept Y or N only	*
 *PASSED IN		:ticketType from user input								*
 *RETURNED		:coupon													*
 ************************************************************************/
 
char get_coupon(char ticketType)
{
	char coupon ='A';
	if(ticketType != 'T')
	{
		cout << "\nDo you have a coupon? Y for yes or N for no: ";
		cin >> coupon;
		coupon = toupper(coupon);
		//if entry is something other than Y or N, ask for another entry
		while(coupon != 'Y' && coupon != 'N')
		{
			cout << "Invalid entry. Do you have a coupon? Y for yes or N for no: ";
			cin >> coupon;
			coupon = toupper(coupon);
		}//end while
	}//end if
	return coupon;
}//end get_coupon



/****************************************************************
 *PURPOSE		:apply discount if customer has a coupon		*
 *PASSED IN		:ticketType and ticketPrice from previous input	*
 *RETURNED		:discountPrice									*
 ****************************************************************/
 
double apply_discount(char coupon, char ticketType, double ticketPrice)

{
	const double DISCOUNT = .25;
	double discountPrice =0.0;
	if(coupon == 'Y')
	{
		discountPrice = ticketPrice - (ticketPrice * DISCOUNT);
	}//end if	
	return discountPrice;
}//end apply_discount



/********************************************************************************************
 *PURPOSE		:obtain quantity of tickets customer wants to purchase-must be >0 and <10	*
 *PASSED IN		:nothing																	*
 *RETURNED		:quantity																	*
 ********************************************************************************************/

int ticket_quantity()
{
	int quantity =0;

	cout << "\nPlease enter the number of tickets to be purchased(maximum of 10): ";
	cin >> quantity;
	//if input is not a number that is >0 and <=10, ask for another entry
	while(10 < quantity || quantity < 0)
	{
		cout << "Invalid entry. Please enter the number of tickets to be purchased "<<endl;
		cout << "(maximum of 10): ";
		cin >> quantity;
	}//end while
	return quantity;
}//end ticket_quantity		



/************************************************************************************
 *PURPOSE		:display quantity, ticketType, and purchasePrice for each purchase	*
 *PASSED IN		:ticketType, coupon, quantity, and purchasePrice from inputs		*
 *RETURNED		:nothing															*
 ************************************************************************************/

void disp_purchase(char ticketType, char coupon, int quantity, double purchasePrice)
{
	cout << fixed << setprecision(2);
	if(ticketType == 'A' && coupon == 'N')
	{
		cout << "\nOkay, you're purchasing "<< quantity <<" adult tickets for $"<< purchasePrice <<". ";
	}
	else if(ticketType == 'A' && coupon == 'Y')
	{
		cout << "\nOkay, you're purchasing "<< quantity <<" adult tickets for $"<< purchasePrice <<". ";
	}	
	else if(ticketType == 'J' && coupon == 'N')
	{
		cout << "\nOkay, you're purchasing "<< quantity <<" junior tickets for $"<< purchasePrice <<". ";
	}
	else if(ticketType == 'J' && coupon == 'Y')
	{
		cout << "\nOkay, you're purchasing "<< quantity <<" junior tickets for $"<< purchasePrice <<". ";
	}
	else
	{
		cout << "\nOkay, you need "<< quantity <<" toddler tickets, which are free.";
	}//end if
}//end display_purchase



/****************************************************************************
 *PURPOSE		:display header for Porpoise Pond Ticket Counter program	*
 *PASSED IN		:nothing													*
 *RETURNED		:nothing													*
 ****************************************************************************/

void display_program_header()
{
	cout << setw(50) << "Summerville Sea World " <<endl;
	cout << setw(55) << "Porpoise Pond Ticket Counter " <<endl;
}//end display_program_header



/********************************************************************************************************
 *PURPOSE		:display final sales report for current day sales at the Porpoise Pond attraction		*
 *PASSED IN		:MAX_SEAT_COUNT, extraTickets, finalTicketCount, totalToddler, totalJunior, 			*
 *				 totalAdult, discountJunior, discountAdult, profitLost									*
 *RETURNED		:nothing																				*
 ********************************************************************************************************/
 
 void disp_final_report(const int MAX_SEAT_COUNT, int extraTickets, int finalTicketCount, 
						int totalToddler, int totalJunior, int totalAdult, double finalSale, 
						int discountAdult, int discountJunior, double totalProfitLost)
{
	char tmpbuf[128];
	
	_strdate_s ( tmpbuf );
	cout << setw(48) << "FINAL SALES REPORT " <<endl;
	cout << setw(53) << "Sales Report for Porpoise Pond for: "<<tmpbuf<<" "<<endl;
	cout << setw(62) << "============================================ " <<endl;
	cout << endl;
	cout << endl;
	cout << setw(18) << "TOTAL CAPACITY" << setw(27) << "EXTRA SEATS SOLD" << setw(26) << "TOTAL SEATS SOLD" <<endl;
	cout << setw(11) << MAX_SEAT_COUNT << setw(27) << extraTickets << setw(27) << finalTicketCount <<endl;
	cout << endl;
	cout << setw(17) << "TODDLER SEATS" << setw(26) << "JUNIOR SEATS" << setw(26) << "ADULT SEATS" <<endl;
	cout << setw(11) << totalToddler << setw(27) << totalJunior << setw(27) << totalAdult <<endl;
	cout << endl;
	cout << "=============================================================================== ";
	cout << endl;
	cout << setw(57) << "Gross Sales for "<<tmpbuf<<": $"<<finalSale<<" " <<endl;
	cout << endl;
	cout << endl;
	cout << setw(67) << "Discounted adult tickets sold: "<<discountJunior<<" "<<endl;
	cout << setw(67) << "Discounted junior tickets sold: "<<discountAdult<<" "<<endl;
	cout << setw(68) << "Profits lost from discount ticket sales: $"<<totalProfitLost<<" "<<endl;
}//end disp_final_report



 /********************************************************************************************
 *PURPOSE		:display message advising ticket sales are over and final report is coming	*
 *PASSED IN		:nothing																	*
 *RETURNED		:nothing																	*
 ********************************************************************************************/
 
 void report_message()
 {
	cout << "\n\n\nOkay, we're done selling seats in the attraction. " <<endl;
	cout << "Now we're going to display the final sales report for the day. " <<endl;
	cout << "Whenever you're ready, you may ";
}//end report_message
	