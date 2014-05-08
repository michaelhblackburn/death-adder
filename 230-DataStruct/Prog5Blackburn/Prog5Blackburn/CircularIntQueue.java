/*
 *Michael Blackburn
 *CircularIntQueue.java
 *defines a class for a circular array of integers
 *provides methods for accessing and manipulating class attributes
 *provides default constructor
 */
public class CircularIntQueue implements IntQueue{
	//define class attributes
	private static final int MAX_SIZE = 100;
	private int count;
	private int first;
	private int last;
	private int[] myList;
	//default constructor
	public CircularIntQueue(){
		myList = new int[MAX_SIZE];
		count = 0;
		first = 0;
		last = 0;
	}

	/*
	 *isEmpty()
	 *determines if the list is empty and returns a boolean value 
	 *@param: none 
	 *@return: returns true if the list is empty; else, returns false
	 *post-condition: none
	 */
	public boolean isEmpty(){
		if (count == 0){
			return true;
		}
		else{
			return false;
		}
	}

	/*
	 *isFull()
	 *determines if the list is full and returns a boolean value
	 *@param: none
	 *@return: return true if the list is full; else return false
	 *post-condition: none
	 */
	public boolean isFull(){
		if (count == MAX_SIZE){
			return true;
		}
		else{
			return false;
		}
	}

	/*
	 *insert()
	 *inserts the given integer value into an element at the rear of the list if the list is not full
	 *@param: a given integer value N
	 *@return: returns true if the passed-in value was successfully placed in the list; else returns false
	 *post-condition: passed-in integer value is in an element at the rear of the list
	 */
	public boolean insert(int N){
		if(isFull()){
			return false;
		}
		else{
			myList[count] = N;
			count++;
			last = (count + 1) % MAX_SIZE;
		}
		return true;
	}

	/*
	  *remove()
	  *removes the first element in the list and returns the integer value contained in that element if the list is not empty
	  *@param: none
	  *@return: returns the integer value in the first element of the list; else returns -1
	  *post-condition: first element is removed from the list, and the list is updated with a new first element
	  */
	public int remove(){
		if(count != 0){
			int temp = myList[first];
			first = (first + 1) % MAX_SIZE;
			return temp;
		}
		else{
			return -1;
		}
	}
}