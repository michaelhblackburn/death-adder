/*
 *Michael Blackburn
 *DNode.java
 *defines node class in a dooubly-linked list
 *provides methods for accessing and manipulating class attributes
 *provides default constructor and constructor for user-defined integer
 */
public class DNode{
	//define class attributes
	private int num;
	private DNode next;
	private DNode previous;
	//default constructor
	public DNode(){
		num = 0;
		next = null;
		previous = null;
	}
	//constructor for user-defined integer
	public DNode(int N){
		num = N;
		next = null;
		previous = null;
	}

	/*
	 *setNum()
	 *set the num variable to the passed-in value N
	 *@param: passed-in integer value N
	 *@return: none
	 *post-condition: num is set to the new value N
	 */
	public void setNum(int N){
		num = N;
	}

	/*
	 *getNum()
	 *returns the the current value of the num variable
	 *@param: none 
	 *@return: integer num variable
	 *post-condition: none
	 */
	public int getNum(){
		return num;
	}

	/*
	 *setNext()
	 *sets the next variable to the passed-in DNode object n
	 *@param: passed-in DNode object n
	 *@return: none
	 *post-condition: next is set to the DNode object n
	 */
	public void setNext(DNode n){
		next = n;
	}

	/*
	 *getNext()
	 *returns the DNode object currently in next
	 *@param: none
	 *@return: returns the DNode object in the next variable
	 *post-condition: none
	 */
	public DNode getNext(){
		return next;
	}

	/*
	 *setPrevious()
	 *sets the previous variable to the passed-in DNode object p
	 *@param: passed-in DNode object p
	 *@return: none
	 *post-condition: previous is set to the DNode object p
	 */
	public void setPrevious(DNode p){
		previous = p;
	}

	/*
	 *getPrevious()
	 *returns the DNode object currently in previous
	 *@param: none
	 *@return: returns the DNode object in the previous variable
	 *post-condition: none
	 */
	public DNode getPrevious(){
		return previous;
	}
}