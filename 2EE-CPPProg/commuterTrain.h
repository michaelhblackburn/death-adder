//FILE			: CommuterTrain.h
//PROGRAMMER	: Michael Blackburn, with initial work prepared by Dave Jones
//PURPOSE		: Class for operation of high speed railway train simulator


#include <cstdlib>								
#include <ctime>					

class CommuterTrain
{
	private:
		int numOfStations;			//Number of stations serviced by this train
		int maxCapacity;			//Max capacity of entire train
		int currentStation;			//Number of the station the train is stopped at
		int numberOnBoard;			//Number of pax on train
		int destStation;			//Number of the next station to stop at
		
		//Private methods
		int genRandNumber(int);		//Generates a random int <= value passed in

	public:
		CommuterTrain(int, int, int);		
		int getNumberOnBoard();				
		int getMaxCapacity();
		int getCurrentStation();
		int getNumOfStations();
		int getDestinationStation();
		void setDestinationStation(int);
		void setCurrentStation(int);
		void setNumberOnBoard(int);
		void moveToStation(int);
		void returnToSummStation(int);
		void unloadPassengers();
		void loadPassengers();
		void runTheRoute();		
};

CommuterTrain::CommuterTrain(int numStations, int maxPersons, int start)
{
	numOfStations = numStations;
	maxCapacity = maxPersons;
	currentStation = start;

	numberOnBoard = 0;		

	//Seed the C library random number generator
	srand (unsigned(time(NULL)));
}

int CommuterTrain::getNumberOnBoard()
{
	return numberOnBoard;
}

int CommuterTrain::getMaxCapacity()
{
	return maxCapacity;
}

int CommuterTrain::getCurrentStation()
{
	return currentStation;
}

int CommuterTrain::getNumOfStations()
{
	return numOfStations;
}

int CommuterTrain::getDestinationStation()
{
	return destStation;
}

int CommuterTrain::genRandNumber(int maxNum)
{
	return (rand()%(maxNum + 1));
}

void CommuterTrain::setDestinationStation(int destSta)
{
	destStation = destSta;
}

void CommuterTrain::setCurrentStation(int curSta)
{
	currentStation = curSta;
}

void CommuterTrain::setNumberOnBoard(int numPass)
{
	numberOnBoard = numPass;
}

void CommuterTrain::moveToStation(int nextStation)
{
	//Update the instance variable
	destStation = nextStation;
	cout << "Leaving station " << currentStation << " for station "
		 << destStation << " with " << numberOnBoard  << " passengers. " <<endl;
		 
	//Now update curntStation to the destination, meaning we made it
	currentStation = destStation;
	cout << "Arriving at station "<< currentStation <<". " <<endl;
}

void CommuterTrain::returnToSummStation(int currentStation)
{
	moveToStation(currentStation - (currentStation -1));
	cout << "Arriving at Summerville Station. " <<endl;
	unloadPassengers();
}

void CommuterTrain::loadPassengers()
{
	int passOn;

	passOn = genRandNumber(500);
	cout << "There are "<<passOn<<" people at this station waiting to board the train. " <<endl;
	if(numberOnBoard == 0 && passOn <= maxCapacity)
	{
		numberOnBoard += passOn;
		cout << "Loading "<< passOn << " passengers. " <<endl;
	}
	else if((numberOnBoard + passOn) < maxCapacity)
	{
		numberOnBoard += passOn;
		cout << "Loading "<< passOn << " passengers. " <<endl;
	}
	else if((numberOnBoard + passOn) > maxCapacity)
	{
		passOn = maxCapacity - numberOnBoard;
		numberOnBoard = maxCapacity;
		cout << "Loading "<< passOn << " passengers. " <<endl;
	}//end if
}

void CommuterTrain::unloadPassengers()
{
	int passOff;
	
	passOff = genRandNumber(numberOnBoard);
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
}

void CommuterTrain::runTheRoute()
{
	loadPassengers();
	cout << "All aboard the Summerville Express Train! " <<endl;
	cout << "There are now "<< numberOnBoard <<" passengers on board. " <<endl;
	for(currentStation = 1; currentStation < numOfStations; )
	{
		moveToStation(currentStation + 1);
		unloadPassengers();
		loadPassengers();
		cout << "There are now "<< numberOnBoard <<" passengers on board. " <<endl;
	}//end for
	returnToSummStation(currentStation);
}