/********************************************************************************************************
 *PURPOSE		:display final sales report for current day sales at the Porpoise Pond attraction		*
 *PASSED IN		:MAX_SEAT_COUNT, extraTickets, finalTicketCount, totalToddler, totalJunior, 			*
 *				 totalAdult, discountJunior, discountAdult, profitLost									*
 *RETURNED		:nothing																				*
 ********************************************************************************************************/
 
 void disp_final_report(const int MAX_SEAT_COUNT, int extraTickets, int finalTicketCount, 
						int totalToddler, int totalJunior, int totalAdult, int discountJunior,
						int discountAdult, double profitLost)
{
	char tmpbuf[128];
	
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
	cout << setw(30) << "Discounted adult tickets sold: "<<discountAdult<<" "<<endl;
	cout << setw(30) << "Discounted junior tickets sold: "<<discountJunior<<" "<<endl;
	cout << setw(30) << "Profits lost from discount ticket sales: $"<<profitLost<<" "<<endl;
}//end disp_final_report