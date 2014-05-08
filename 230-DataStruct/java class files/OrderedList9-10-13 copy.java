//public void clear():
//public boolean add(Ticket T):
//public boolean delete(int keyValue):
//public Ticket retrieve(int keyValue):
//public boolean isEmpty(): Returns true if and only if the list is empty
//public boolean isFull(): Returns true if and only if the list is full
//public void print():

public class FATicketOrderedList implements TicketOrderedList {
	private static final int MAX_SIZE = 100;
	private Ticket[] myList;
	private int myCount; // number of tickets stored so far
	myCount = 0;
	
	public FATicketOrderedList() {
		myList = new Ticket[MAX_SIZE];
		myCount = 0; // No ticket objects yet in here
		
	
		
	}
	
	public boolean isEmpty() {  // returns true iff the list is empty
		if (myCount == 0)
			return true;
		
		else 
			return false;
	}
	
	public boolean isFull() {  // returns true iff the list is full
		if (myCount == MAX_SIZE)
			return true;
		
		else
			return false;
	}
	
	public void print() {  //prints all of the objects in the list in ascending order by the key field, we know list of tickets is stored in a sorted array already
		for (int i = 0; i < myCount; i++) {
			System.out.println("Ticket number" + myList[i].getNum());
			//or
			// System.out.println(myList[x].toString());
		}
	}
	
	public void clear() {  // clears to empty 
		for(int i = 0; i < myCount; i++){
			myList[i] = null;
			myCount = 0;
		}
	}
	
	public Ticket retireve(int key){
		int foundAtIndex = binarySearch(key, myList);
		if (foundAtIndex != -1){
			return myList[foundAtIndex];
		}
		else{
			return null;
		}
	}
	
	public boolean delete(int key){
		int foundAtIndex = binarySearch(key, myList);
		if (foundAtIndex == -1) 
			return false;
		myList[foundAtIndex] = null;
		myCount--;
		//move entries down 
		for (foundAtIndex; foundAtIndex < myCount; i++){
			myList[foundAtIndex] = myList[foundAtIndex+1];
		}
		myList[myCount] = null;
		return true;
	}
}