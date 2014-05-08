/*
 *Michael Blackburn and Kenneth Hanson(share credit)
 *MoveQueueADT.java
 *defines an interface for constructing a move queue for game moves
 *provides methods for interacting with and manipulating move objects in the queue
 */
public interface MoveQueueADT{
	/*
	 *isEmpty
	 *determines if the move queue is empty
	 *@param: none
	 *@return: returns true if the move queue is empty; else, it returns false
	 *post-condition: none
	 */
	public boolean isEmpty();

	/*
	 *isFull
	 *determines if the move queue is full
	 *@param: none
	 *@return: returns true if the move queue is full; else, returns false
	 *post-condition: none
	 */
	public boolean isFull();

	/*
	 *insert
	 *determines if the move queue is full and inserts a given move at the end of the queue if not full
	 *@param: given Move object to append to the end of the queue
	 *@return: returns true if the move was appended to the end of the queue; else, returns false
	 *post-condition: new move is appended to the end of the queue if not full
	 */
	public boolean insert(Move M);

	/*
	 *remove
	 *removes the first move from the queue and returns that object if the queue is not empty
	 *@param: none
	 *@return: Move object that is first in the queue if the queue is not empty; else, returns null
	 *post-condition: first move in queue is removed from the queue
	 */
	public Move remove();
}