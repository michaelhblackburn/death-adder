/*
 *Michael Blackburn
 *BTNode.java
 *Defines class for a node for use in a binary search tree
 *Provides methods for accessing and manipulating class attributes
 *Provides default constructor and constructor for user-defined attribute
 */

public class BTNode{
	//define attributes
	private BTNode left;
	private BTNode right;
	private int data;
	//default constructor
	public BTNode(){
		left = right = null;
		data = 0;
	}
	//contructor for passed-in value 
	public BTNode(int n){
		left = right = null;
		data = n;
	}

	/*
	 *getData()
	 *returns the integer value of the data in the node
	 *@param: none
	 *return: integer value of data in node
	 *post-condition: none
	 */
	public int getData(){
		return data;
	}

	/*
	 *setData()
	 *sets the integer value of the data in the node
	 *@param: integer value n
	 *@return: none
	 *post-condition: data value of node is updated to passed-in integer
	 */
	public void setData(int n){
		data = n;
	}

	/*
	 *getLeft()
	 *gets the node that is the left child of the current node
	 *@param: none
	 *@return: returns the node that is the left child of the current node
	 *post-condition: none
	 */
	public BTNode getLeft(){
		return left;
	}

	/*
	 *setLeft()
	 *sets the left child of the current node to the passed-in node
	 *@param: passed-in BTNode value l
	 *@return: none
	 *post-condition: left child of the current node is updated to the passed-in node
	 */
	public void setLeft(BTNode l){
		left = l;
	}

	/*
	 *getRight()
	 *gets the node that is the right child of the current node
	 *@param: none
	 *@return: returns the node that is the right child of the current node
	 *post-condition: none
	 */
	public BTNode getRight(){
		return right;
	}

	/*
	 *setRight()
	 *sets the right child of the current node to the passed-in node
	 *@param: passed-in BTNode value r
	 *@return: none
	 *post-condition: right child of the current node is updated to the passed-in node
	 */
	public void setRight(BTNode r){
		right = r;
	}

	/*
	 *toString()
	 *sets the integer data value to a concatenated string for output
	 *@param: none
	 *@return: returns the string value of the data in a given node
	 *post-condition: none
	 */
	public String toString(){
		return "The number in the node is " + data;
	}

	/*
	 *print()
	 *prints the given, passed-in BTNode to the screen
	 *@param: passed-in BTNode to be printed
	 *@return: none
	 *post-condition: data of given node is printed to the screen
	 */
	public void print(BTNode n){
		System.out.println(n.toString());
		if (n.getLeft() != null){
			print(n.getLeft());
		}
		if (n.getRight() != null){
			print(n.getRight());
		}
	}
}