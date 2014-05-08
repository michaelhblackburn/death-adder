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