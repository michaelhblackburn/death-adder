//FILE			:FerryBoat.h
//PROGRAMMER	:Michael Blackburn
//PURPOSE		:class for operation of a ferry boat and it's route

#include <cstdlib>
#include <ctime>

class FerryBoat

{
	private:
		char currentStation;	
		char destStation;		
		int carsPortA;			
		int carsPortB;			
		int maxCapacity;		
		int carsOnBoard;		
		
		//private method
		int genRandNumberFromRange(int, int);		//generate a random number within a given range

//public methods		
	public:
		FerryBoat(int, char);
		int getCarsOnBoard();				
		int getMaxCapacity();
		int getCarsPortA();
		int getCarsPortB();
		char getCurrentStation();
		char getDestinationStation();
		void setCurrentStation(char);
		void setDestinationStation(char);
		void setCarsOnBoard(int);
		void moveToStation();
		void unloadCars();
		void loadCars();
		void runTwoWayFerryRoute();
		void returnToHomePort(char);
};
//class methods
FerryBoat::FerryBoat(int maxCap, char start)
{
	maxCapacity = maxCap;		//Initialize values for maxCapacity,
	currentStation = start;		//currentStation with values from
	carsOnBoard = 0;			//main; carsOnBoard set to 0
	
	//Seed the C library random number generator
	srand (unsigned(time(NULL)));
	//Initialize number of cars at each port with genRandNumberFromRange
	carsPortA = genRandNumberFromRange(75, 100);
	carsPortB = genRandNumberFromRange(100, 150);
}

int FerryBoat::genRandNumberFromRange(int minNum, int maxNum)
{
	return (minNum + rand()% (maxNum - minNum) +1);
}

int FerryBoat::getCarsOnBoard()
{
	return carsOnBoard;
}

int FerryBoat::getMaxCapacity()
{
	return maxCapacity;
}

int FerryBoat::getCarsPortA()
{
	return carsPortA;
}

int FerryBoat::getCarsPortB()
{
	return carsPortB;
}

char FerryBoat::getCurrentStation()
{
	return currentStation;
}

char FerryBoat::getDestinationStation()
{
	return destStation;
}

void FerryBoat::setCurrentStation(char curSta)
{
	currentStation = curSta;
}

void FerryBoat::setDestinationStation(char destSta)
{
	destStation = destSta;
}

void FerryBoat::setCarsOnBoard(int cars)
{
	carsOnBoard = cars;
}

void FerryBoat::moveToStation()
{
	if(currentStation == 'A')
	{
		destStation = 'B';
	}
	else
	{
		destStation = 'A';
	}//end if
	cout << "Leaving station "<< currentStation <<" for station "<< destStation 
		 << " carrying "<< carsOnBoard << " cars. " <<endl;
	currentStation = destStation;
	cout << "Arriving at station "<< currentStation <<". " <<endl;
}

void FerryBoat::unloadCars()
{
	int carsOff;
	
	carsOff = carsOnBoard;
	carsOnBoard -= carsOff;
	cout << "Unloading "<< carsOff <<" cars. " <<endl;
}
void FerryBoat::loadCars()
{
	int carsOn;

	if(currentStation == 'A')
	{
		if(carsPortA > maxCapacity)
		{
			carsOn = maxCapacity;
			carsOnBoard = carsOn;
		}
		else
		{
			carsOn = carsPortA;
			carsOnBoard = carsOn;
		}//end if 
		cout << "Loading "<< carsOn <<" cars. "<<endl;
		cout << "There are now "<< carsOnBoard <<" cars on board. "<<endl;
		carsPortA -= carsOn;
	}
	else
	{
		if(carsPortB > maxCapacity)
		{
			carsOn = maxCapacity;
			carsOnBoard = carsOn;
		}
		else
		{
			carsOn = carsPortB;
			carsOnBoard = carsOn;
		}//end if
		cout << "Loading "<< carsOn <<" cars. "<<endl;
		cout << "There are now "<< carsOnBoard <<" cars on board. "<<endl;
		carsPortB -= carsOn;
	}//end if
}

void FerryBoat::runTwoWayFerryRoute()
{
	loadCars();
	cout << "All aboard the Charleston Ferry Service! "<<endl;
	while(carsPortA > 0 || carsPortB > 0)
	{
		moveToStation();
		unloadCars();
		loadCars();
		
	}//end while
	returnToHomePort('A');
	unloadCars();
}

void FerryBoat::returnToHomePort(char start)
{
	if(currentStation != start)
	{
		destStation = start;
		cout << "Leaving station "<< currentStation <<" for home port station "<< destStation 
			 << " carrying "<< carsOnBoard <<" cars. " <<endl;
		currentStation = destStation;
		cout << "Arriving at home port. " <<endl;
	}
}