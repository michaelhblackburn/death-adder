/*
 *Michael Blackburn
 *RubberDuckBST.java
 *Implements a binary search tree with binary tree nodes
 *Provides default constructor for initializing an empty tree
 *Provides methods for inserting new nodes into tree and checking data in tree
 */
public class RubberDuckBST{
	//define attributes
	private BTNode root;
	//default constructor
	public RubberDuckBST(){
		root = null;
	}
	/*
	 *insert()
	 *receives a given integer coordinate value and inserts the value into a binary tree
	 *@param: passed-in integer value for the coordinate of a duck on a linear plane
	 *return: returns true if the value is placed in a node within the binary tree; else, returns false
	 *post-condition: binary tree is updated to reflect the new node containing the passed-in value
	 */
	public boolean insert(int duckCoord){
		if(root == null){
			root = new BTNode(duckCoord);
			return true;
		}
		else{
			BTNode temp = root;
			while(temp != null){
				if(duckCoord < temp.getData()){
					if(temp.getLeft() == null){
						temp.setLeft(new BTNode(duckCoord));
						return true;
					}
					else{
						temp = temp.getLeft();
					}
				}
				else{
					if(temp.getRight() == null){
						temp.setRight(new BTNode(duckCoord));
						return true;
					}
					else{
						temp = temp.getRight();
					}
				}
			}
		}
		return false;
	}

	/*
	 *checkToss()
	 *receives integer values for the coordinate point of a balloon toss and the splash radius of the balloon
	 *and checks the values against the nodes in the tree to determine if the balloon throw was a hit or miss
	 *@param: passed-in integer values for tossCoord and splashRadius
	 *@return: returns the integer data value of the node if hit by a balloon; else, returns -1
	 *post-condition: none
	 */
	public int checkToss(int tossCoord, int splashRadius){
		int radHigh = tossCoord + splashRadius;
		int radLow = tossCoord - splashRadius;
		BTNode temp = root;
		while(temp != null){
			if(tossCoord == temp.getData()){
				return temp.getData();
			}
			else if(temp.getData() <= radHigh && temp.getData() >= radLow){
				return temp.getData();
			}
			else if(temp.getData() > radHigh){
				temp = temp.getLeft();

			}
			else{
				temp = temp.getRight();
			}
		}
		return -1;
	}
}