/************************************************************************************
 *PURPOSE		:display quantity, ticketType, and purchasePrice for each purchase	*
 *PASSED IN		:ticketType, coupon, quantity, and purchasePrice from inputs		*
 *RETURNED		:nothing															*
 ************************************************************************************/

void display_purchase(char ticketType, char coupon, int quantity, double purchasePrice)
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