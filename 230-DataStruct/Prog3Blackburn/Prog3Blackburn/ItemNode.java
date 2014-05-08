/*
 *Michael Blackburn
 *ItemNode.java
 *Defines Node object containing an Item for use in creating a linked list
 *Defnies accessor methods for manipulating ItemNode object attributes
 *Provides constructor methods for default ItemNode and one with user-defined attributes
 */
public class ItemNode{
	//define variables for ItemNode attributes
	private Item myItem;
	private ItemNode next;
	//default constructor 
	public ItemNode(){
		myItem = null;
		next = null;
	}
	//constructor for user-defined attributes
	public ItemNode(Item m){
		myItem = m;
		next = null;
	}
	/*
	 *setNext
	 *sets the next ItemNode to item node passed in
	 *@param: given ItemNode object as defnied by user
	 *@return: none
	 *post-condition: given ItemNode is set to the next object in the singly-linked list
	 */
	public void setNext(ItemNode n){
		next = n;
	}
	/*
	 *getNext
	 *returns the ItemNode object that occurs next in the singly-linked list
	 *@param: none
	 *@return: returns ItemNode object that occurs next in the list
	 *post-condition: none
	 */
	public ItemNode getNext(){
		return next;
	}
	/*
	 *getItem
	 *returns the current Item object contained in the ItemNode
	 *@param: none
	 *@return: returns Item Object contained in current ItemNode in singly-linked list
	 *post-condition: none
	 */
	public Item getItem(){
		return myItem;
	}
}