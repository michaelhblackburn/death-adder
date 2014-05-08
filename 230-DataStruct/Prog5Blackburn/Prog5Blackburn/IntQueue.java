/*
 *Michael Blackburn
 *IntQueue.java
 *interface for use in construction of linked list and circular array list
 */
public interface IntQueue{
	
	/*
	 *isFull()
	 *determines if the list is full and returns a boolean value
	 *@param: none
	 *@return: return true if the list is full; else return false
	 *post-condition: none
	 */
	public boolean isFull();

	/*
	 *isEmpty()
	 *determines if the list is empty and returns a boolean value 
	 *@param: none 
	 *@return: returns true if the list is empty; else, returns false
	 *post-condition: none
	 */
	public boolean isEmpty();

	/*
	 *insert()
	 *inserts the given integer value into an element at the rear of the list if the list is not full
	 *@param: a given integer value N
	 *@return: returns true if the passed-in value was successfully placed in the list; else returns false
	 *post-condition: passed-in integer value is in an element at the rear of the list
	 */
	public boolean insert(int N);

	/*
	  *remove()
	  *removes the first element in the list and returns the integer value contained in that element if the list is not empty
	  *@param: none
	  *@return: returns the integer value in the first element of the list; else returns -1
	  *post-condition: first element is removed from the list, and the list is updated with a new first element
	  */
	public int remove();
}