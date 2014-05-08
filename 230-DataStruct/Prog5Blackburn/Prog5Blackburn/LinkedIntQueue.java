/*
 *Michael Blackburn
 *LinkedIntQueue.java
 *defines class for a linked link of integers
 *provides methods for accessing and manipulating a linked list integer queue
 *provides default constructor
 */
public class LinkedIntQueue implements IntQueue{
	//define variables
	private DNode first;
	private DNode last;
	//default constructor
	public LinkedIntQueue(){
		first = null;
		last = null;
	}

	/*
	 *isEmpty()
	 *determines if the linked list is empty and returns a boolean value 
	 *@param: none 
	 *@return: returns true if the list is empty; else, returns false
	 *post-condition: none
	 */
	public boolean isEmpty(){
		if(first == null){
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
	 *@return: always returns false, as the linked list has no limit to capacity
	 *post-condition: none
	 */
	public boolean isFull(){
		return false;
	}

	/*
	 *insert()
	 *inserts the given integer value into a new node at the rear of the linked list
	 *@param: a given integer value N
	 *@return: returns true if the passed-in value was successfully placed in the list; else returns false
	 *post-condition: passed-in integer value is in a new node at the end of the linked list
	 */
	public boolean insert(int N){
		if (!isFull()){
	 		DNode node = new DNode(N);
	 		if(isEmpty()){
	 			first = node;
	 		}
	 		else{
	 			last.setNext(node);
	 			node.setPrevious(last);
	 		}
	 		last = node;
	 		return true;
	 	}
	 	else{
	 		return false;
	 	}
	 }

	 /*
	  *remove()
	  *removes the first node in the list and returns the integer value contained in that node
	  *@param: none
	  *@return: returns the integer value in the first node of the list; else returns -1
	  *post-condition: first node is removed from the list, and the list is updated with a new first node
	  */
	 public int remove(){
		if (!isEmpty()){
			DNode temp = first;
			if (first == last){
				first = null;
				last = null;
				return temp.getNum();
			}
			else{
				first = first.getNext();
				first.setPrevious(null);
				return temp.getNum();
			}
		}
		else
			return -1;
	} 
}