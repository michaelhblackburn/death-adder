//FILE			:classElevator.h
//PROGRAMMER	:Michael Blackburn	
//PURPOSE		:define values and methods for elevator operation

class Elevator
{
	//data declarations
	private:
		int numberOnBoard;
		int maximumCapacity;
		int currentFloor;
		int destinationFloor;
		int maximumFloor;
		int minimumFloor;
		int requestedFloor;
		int loadPassenger;

	//methods declaration
	public:
		Elevator(int maxCap, int curFloor, int maxFloor, int minFloor);
		int getNumberOnBoard();
		int getMaximumCapacity();
		int getCurrentFloor();
		int getDestinationFloor();
		int getMaximumFloor();
		int getMinimumFloor();
		int pressRequestButton(int floorReq);
		void loadElevator(int passOn);
		void unloadElevator(int passOff);
		void moveElevator(int destFloor);
		void handleRequest(int passOn);
		void returnToBottom();
};

//implement methods
Elevator::Elevator(int maxCap, int curFloor, int maxFloor, int minFloor)
{
	numberOnBoard = 0;
	maximumCapacity = maxCap;
	currentFloor = curFloor;
	maximumFloor = maxFloor;
	minimumFloor = minFloor;
}

int Elevator::getNumberOnBoard()
{
	return numberOnBoard;
}//end getNumberOnBoard

int Elevator::getMaximumCapacity()
{
	return maximumCapacity;
}//end getMaximumCapacity

int Elevator::getCurrentFloor()
{
	return currentFloor;
}//end getCurrentFloor

int Elevator::getDestinationFloor()
{
	return destinationFloor;
}//end getMinimumFloor

int Elevator::getMaximumFloor()
{
	return maximumFloor;
}//end getMaximumFloor

int Elevator::getMinimumFloor()
{
	return minimumFloor;
}//end minimumFloor

void Elevator::loadElevator(int passOn)
{
	if(numberOnBoard == 0 && passOn <= maximumCapacity)
	{
		numberOnBoard += passOn;
		cout << "Loading "<< passOn << " passengers. " <<endl;
	}
	else if(numberOnBoard >= 0 && passOn > maximumCapacity)
	{
		passOn = maximumCapacity - numberOnBoard;
		numberOnBoard = maximumCapacity;
		cout << "Loading "<< passOn << " passengers. " <<endl;
	}
	
	
}//end loadElevator

void Elevator::unloadElevator(int passOff)
{
	if(passOff <= numberOnBoard)
	{
		numberOnBoard -= passOff;
		cout << "Unloading "<< passOff <<" passengers. " << endl;
	}
	else
	{
		numberOnBoard = 0;
		cout << "Unloading all passengers. " << endl;
	}//end if
	
}//end unloadElevator

void Elevator::moveElevator(int destFloor)
{
	destinationFloor = destFloor;
	if(destinationFloor < minimumFloor || destinationFloor > maximumFloor)
	{
		cout << "The elevator is not able to transport to that floor. Please select a "
			 << "\nvalid floor";
		cout << endl;
	}
	else if(destinationFloor == currentFloor)
	{
		cout << "That is the current floor. Please select another floor. " <<endl;
	}
	else if(destinationFloor > currentFloor)
	{
		cout << "Going up from floor " << currentFloor << " to floor " << destinationFloor <<". "<<endl;
		while(currentFloor < (destinationFloor - 1))
		{
			currentFloor ++;
			cout << "Passing floor " << currentFloor <<". "<<endl;
		}//end while
		currentFloor ++;
		cout << "Arriving at floor " << currentFloor <<". "<<endl;
	}
	else if(destinationFloor < currentFloor)
	{
		cout << "Going down from floor " << currentFloor << " to floor " << destinationFloor <<". "<<endl;
		while(currentFloor > (destinationFloor + 1))
		{
			currentFloor --;
			cout << "Passing floor " << currentFloor <<". "<<endl;
		}//end while
		currentFloor --;
		cout << "Arriving at floor " << currentFloor <<". "<<endl;
	}//end if
	cout << "Current floor is: " << currentFloor <<". "<<endl;
}//end moveElevator

int Elevator::pressRequestButton(int floorReq)
{
	requestedFloor = floorReq;
	cout << "There is an elevator request on floor "<< requestedFloor <<"." <<endl;
	return requestedFloor;
}//end pressRequestButton

void Elevator::handleRequest(int passOn)
{
	if(numberOnBoard == 0)
	{
		destinationFloor = requestedFloor;
		if(destinationFloor > currentFloor)
		{
			cout << "Going up from floor " << currentFloor << " to floor " << destinationFloor <<". "<<endl;
			while(currentFloor < (destinationFloor - 1))
			{
				currentFloor ++;
				cout << "Passing floor " << currentFloor <<". "<<endl;
			}//end while
			currentFloor ++;
			cout << "Arriving at floor " << currentFloor <<". "<<endl;
			if(passOn <= maximumCapacity)
			{
				numberOnBoard += passOn;
				cout << "Loading "<< passOn <<" passengers. " <<endl;
			}
			else
			{
				numberOnBoard = maximumCapacity;
				cout << "Loading "<< maximumCapacity <<" passengers. " <<endl;
			}//end if
		}//end if
		else if(destinationFloor < currentFloor)
		{
			cout << "Going down from floor " << currentFloor << " to floor " << destinationFloor <<". "<<endl;
			while(currentFloor > (destinationFloor + 1))
			{
				currentFloor --;
				cout << "Passing floor " << currentFloor <<". "<<endl;
			}//end while
			currentFloor --;
			cout << "Arriving at floor " << currentFloor <<". "<<endl;
			if(passOn <= maximumCapacity)
			{
				numberOnBoard += passOn;
				cout << "Loading "<< passOn <<" passengers. " <<endl;
			}
			else
			{
				numberOnBoard = maximumCapacity;
				cout << "Loading "<< maximumCapacity <<" passengers. " <<endl;
			}
		}//end if
	}
	cout << "Current floor is: " << currentFloor <<". "<<endl;
}

void Elevator::returnToBottom()
{
	cout << "Going down to bottom floor. " <<endl;
	while(currentFloor > (minimumFloor + 1))
	{
		currentFloor --;
		cout << "Passing floor " << currentFloor <<". "<<endl;
	}//end while
	currentFloor --;
	cout << "Arriving at floor " << minimumFloor <<". "<<endl;
}//end returnToBottom