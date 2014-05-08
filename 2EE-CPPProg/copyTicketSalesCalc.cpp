/***************************************************************************
 *FILENAME		:ticketSalesCalc.cpp									   *
 *PROGRAMMER	:Michael Blackburn										   *
 *PURPOSE		:to calculate and disply ticket slaes for the Porpoise Pond*
 ***************************************************************************/

#include <iostream>
#include <iomanip>
#include <string>
#include <ctime>
using namespace std;

int main()
{
	//declare variable and constants
	char tmpbuf[128];
	char ticketType			    ='A';
	char coupon					='A';
	int quantity			    =0;
	int totalToddler		    =0;
	int totalJunior			    =0;
	int totalAdult			    =0;
	int extraTickets		    =0;
	int finalTicketCount	    =0;
	double saleToddler			=0.0;
	double saleJunior			=0.0;
	double saleAdult			=0.0;
	double discountJunior		=0.0;
	double discountAdult		=0.0;
	double totalSaleToddler		=0.0;
	double totalSaleJunior		=0.0;
	double totalSaleAdult		=0.0;
	double finalSale			=0.0;
	const int MAX_SEAT_COUNT    =20;
	const double TODDLER_TICKET =0.0;
	const double JUNIOR_TICKET  =7.5;
	const double ADULT_TICKET	=11.5;
	const double DISCOUNT		=.25;

	cout << fixed << setprecision(2);
	cout << setw(50) << "Summerville Sea World " <<endl;
	cout << setw(55) << "Porpoise Pond Ticket Counter " <<endl;

	//enter input for ticket type and quantity
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
	
	//begin while loop for ticket sales
	while(ticketType != 'Q' && finalTicketCount < MAX_SEAT_COUNT)
	{
		cout << "\nPlease enter the number of tickets to be purchased(maximum of 10): ";
		cin >> quantity;
		//if input is not a number that is <10, ask for another entry
		while(10 < quantity || quantity < 0)
		{
			cout << "Invalid entry. Please enter the number of tickets to be purchased "<<endl;
			cout << "(maximum of 10): ";
			cin >> quantity;
		}//end while
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
		if(ticketType == 'A' && coupon == 'N')
		{
			saleAdult = ADULT_TICKET * quantity;
			totalAdult += quantity;
			cout << "\nOkay, you're purchasing "<< quantity <<" adult tickets for $"<< saleAdult <<". ";
		}
		else if(ticketType == 'A' && coupon == 'Y')
		{
			discountAdult = (ADULT_TICKET - (ADULT_TICKET * DISCOUNT)) * quantity;
			totalAdult += quantity;
			cout << "\nOkay, you're purchasing "<< quantity <<" adult tickets for $"<< discountAdult <<". ";
		}	
		else if(ticketType == 'J' && coupon == 'N')
		{
			saleJunior = JUNIOR_TICKET * quantity;
			totalJunior += quantity;
			cout << "\nOkay, you're purchasing "<< quantity <<" junior tickets for $"<< saleJunior <<". ";
		}
		else if(ticketType == 'J' && coupon == 'Y')
		{
			discountJunior = (JUNIOR_TICKET - (JUNIOR_TICKET * DISCOUNT)) * quantity;
			totalJunior += quantity;
			cout << "\nOkay, you're purchasing "<< quantity <<" junior tickets for $"<< discountJunior <<". ";
		}
		else
		{
			saleToddler = 0;
			totalToddler += quantity;
			cout << "\nOkay, you need "<< quantity <<" toddler tickets, which are free.";
		}//end if

		//calculate totals
		finalTicketCount += quantity;
		totalSaleAdult = saleAdult + discountAdult;
		totalSaleJunior = saleJunior + discountJunior;
		totalSaleToddler = 0;
		cout << endl;
		cout << endl;
		system("pause");
		system("cls");

		//if statement before repeat
		if(finalTicketCount < MAX_SEAT_COUNT)
		{
			cout << "\n\nPlease enter the type of tickets to be purchased or Q " <<endl;
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
		}//end if
	}//end while
	finalSale = totalSaleAdult + totalSaleJunior;
	if(finalTicketCount > 0)
	{
		extraTickets = finalTicketCount - MAX_SEAT_COUNT;
	}//end if 

	//display message that seats sales are over and final report is forthcoming
	cout << "\n\n\nOkay, we're done selling seats in the attraction. " <<endl;
	cout << "Now we're going to display the final sales report for the day. " <<endl;
	cout << "Whenever you're ready, you may ";
	system("pause");
	system("cls");

			
	//display results and output
	_strdate_s ( tmpbuf );
	cout << setw(47) << "FINAL SALES REPORT " <<endl;
	cout << setw(52) << "Sales Report for Porpoise Pond for: "<<tmpbuf<<" "<<endl;
	cout << setw(61) << "============================================ " <<endl;
	cout << endl;
	cout << endl;
	cout << setw(17) << "TOTAL CAPACITY" << setw(26) << "EXTRA SEATS SOLD" << setw(25) << "TOTAL SEATS SOLD" <<endl;
	cout << setw(10) << MAX_SEAT_COUNT << setw(26) << extraTickets << setw(26) << finalTicketCount <<endl;
	cout << endl;
	cout << setw(16) << "TODDLER SEATS" << setw(25) << "JUNIOR SEATS" << setw(25) << "ADULT SEATS" <<endl;
	cout << setw(10) << totalToddler << setw(26) << totalJunior << setw(26) << totalAdult <<endl;
	cout << endl;
	cout << endl;
	cout << setw(36) << "Gross Sales for "<<tmpbuf<<": $"<<finalSale<<" " <<endl;
	cout << endl;
	cout << endl;


	system("pause");
	return 0;
}//end of main function







