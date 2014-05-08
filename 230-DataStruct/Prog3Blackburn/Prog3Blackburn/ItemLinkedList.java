/*
 *Michael Blackburn
 *ItemLinkedList.java
 *Defines method for interacting with items in a Java one-way linked list
 */
public class ItemLinkedList implements ItemOrderedList{
	private ItemNode first;

	public ItemLinkedList(){
		first = null;
	}

	/*
	 *clear
	 *removes all items from the list 
	 *@param none
	 *return none
	 *post-condidtion: list is returned to empty state
	 */
	public void clear(){
		first = null;
	}
	/*
	 *add
	 *inserts given Item product into list if the list is not full
	 *@param: given Item objectwhose contents are initialized as defined by user
	 *@return: returns true if the Item is not null and unique, and the list is not full; otherwise returns false
	 *post-condition: Item is inserted into the ordered list if successful
	 */
	public boolean add(Item keyValue){
		ItemNode n = new ItemNode(keyValue);
		ItemNode f = first;
		ItemNode prev = null;
		if(retrieve(keyValue.getName()) != null){
			return false;
		}
		while (f != null && keyValue.getName().compareToIgnoreCase(f.getItem().getName()) > 0){
			prev = f;
			f = f.getNext();
		}
		if (prev == null){
			n.setNext(f);
			first = n;
		}
		else if(f == null){
			prev.setNext(n);
		}
		else{
			n.setNext(f);
			prev.setNext(n);
		}
		return true;
	}
	/*
	 *delete
	 *deletes Item with given String key value from the ordered list if the item is in the list
	 *@param: String key value given by user
	 *@return: returns true if the Item was found and successfully deleted; otherwise returns false
	 *post-condition: Item is deleted and the list is reordered accordingly
	 */
	public boolean delete(String keyValue){
		ItemNode prev = null;
		ItemNode f = first;
		while(f != null && keyValue.compareToIgnoreCase(f.getItem().getName()) != 0){
			prev = f;
			f = f.getNext();
		}
		if(f == null){
			return false;
		}
		if(prev == null){
			first = f.getNext();
		}
		else{
			prev.setNext(f.getNext());
		}
		return true;
	}
	/*
	 *retrieve
	 *retrieves the Item object located at the list entry where the String key value occurs
	 *@param: String key value given by user
	 *@return: returns the Item object located at the found entry based on key value; if no object is present, returns null
	 *post-condition: none
	 */
	public Item retrieve(String keyValue){
		ItemNode f = first;
		while(f != null && keyValue.compareToIgnoreCase(f.getItem().getName()) != 0){
			f = f.getNext();
		}
		if(f != null){
			return f.getItem();
		}
		else{
			return null;
		}
	}
	/*
	 *isEmpty
	 *determines if the list is empty
	 *@param: none
	 *@return: returns true if the lest is empty; returns false if there are one or more entries
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
	public boolean isFull(){
		return false;
	}
	public void print(){
		ItemNode f = first;
		while(f != null){
			System.out.println(f.getItem().toString());
			f = f.getNext();
		}
	}
	/*
	 *getMyCount
	 *returns the number of items currently in the cart
	 *@param: none
	 *@return: integer value of number of items in cart
	 *post-condition: none
	 */
	public int getMyCount(){
		int count  = 0;
		ItemNode f = first;
		while (f != null){
			count++;
			f = f.getNext();
		}
		return count;
	}
}
