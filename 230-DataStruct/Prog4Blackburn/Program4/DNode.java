/*
 *Michael Blackburn and Kenneth Hanson(share credit)
 *DNode.java
 *Defines Node object containing Move item for use in creating a linked list
 *Defnies accessor methods for manipulating DNode object attributes
 *Provides constructor methods for default DNode and one with user-defined attributes
 */
public class DNode{
	//define variables for DNode attributes
	private Move m;
	private DNode next;
	private DNode previous;
	//default constructor 
	public DNode(){
		m = null;
		next = null;
		previous = null;

	}
	//constructor for user-defined attributes
	public DNode(Move move){
		m = move;
		next = null;
		previous = null;
	}
	/*
	 *setNext
	 *sets the next DNode to item node passed in
	 *@param: given DNode object as defnied by user
	 *@return: none
	 *post-condition: given DNode is set to the next object in the doubly-linked list
	 */
	public void setNext(DNode n){
		next = n;
	}
	/*
	 *getNext
	 *returns the DNode object that occurs next in the doubly-linked list
	 *@param: none
	 *@return: returns DNode object that occurs next in the list
	 *post-condition: none
	 */
	public DNode getNext(){
		return next;
	}
	/*
	 *setPrevious
	 *sets the previous DNode to the node passed in
	 *@param: given DNode object as defined by user
	 *@return: none
	 *post-condition: given DNode is set to the previous object in the doubly-linked list
	 */
	public void setPrevious(DNode p){
		previous = p;
	}
	/*
	 *getPrevious
	 *sets the previous DNode to the node passed in
	 *@param: none
	 *@return: returns the DNode object that is previous in the list
	 *post-condition: none
	 */
	public DNode getPrevious(){
		return previous;
	}
	/*
	 *getMove
	 *returns the current Move object contained in the DNode
	 *@param: none
	 *@return: returns Move object contained in current DNode in doubly-linked list
	 *post-condition: none
	 */
	public Move getMove(){
		return m;
	}
}