/*
 *Michael Blackburn and Kenneth Hanson(share credit)
 *DLMoveQueue.java
 *implements the MoveQueueADT to provide a doubly-linked list queue for holding moves in queue for a game
 *provides methods for interacting with the queue
 *provides a defualt constructor for initiating a new, empty queue
 */
public class DLMoveQueue implements MoveQueueADT{
	//define class attributes
	private DNode first;
	private DNode last;
	//default constructor
	public DLMoveQueue{
		first = null;
		last = null;
	}
	/*
	 *isEmpty
	 *returns boolean value based on whether the list is empty
	 *@param: none
	 *@return: returns true is the list is empty; else, returns false
	 *post-consdition: none
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
	 *isFull
	 *returns false, as a doubly-linked list has no maximum number of node
	 *@param: none
	 *@return: returns false, as there is no maximum for a doubly-linked list
	 *post-condition: none
	 */
	public boolean isFull(){
		return false;
	}
	/*
	 *insert
	 *inserts a new Node containing a Move object at the end of the list
	 *@param: Move object m passed in by user
	 *@return: returns true if the Node was inserted successfully at the end of the list; else, returns false
	 *post-condition: new Node object containing the passed-in Move object is now in the last position
	 */
	public boolean insert(Move m){
		if(!isFull()){
			DNode node = DNode(m);
			if(isEmpty()){
				first = node;
			}
			else{
				last.setNext(node);
				node.setPrevious(last);
			}
			last = node;
			return true;
		else{
			return false;
		}
	}
	/*
	 *remove
	 *removes the first Node from the list and returns the Move object contained in the node
	 *@param: none
	 *@return: returns the Move object contained in the Node at the front of the list if the list is not empty; else, returns null
	 *post-condition: queue adjusted with new first item reflecting removal of previous first Node in the queue
	 */
	public Move remove(){
		if (!isEmpty()){
			DNode temp = first;
			if (first == last){
				first = null;
				last = null;
				return temp.getMove();
			}
			else{
				first = first.getNext();
				first.setPrevious(null);
				return temp.getMove();
			}
		}
		else
			return null;
	} 
}