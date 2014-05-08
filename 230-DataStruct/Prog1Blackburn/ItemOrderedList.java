/*
 *Michael Blackburn
 *ItemOrderedList.java
 *defines an interface for constructing item-ordered lists
 *provides methods for interacting with a user-defined list of Item objects
 */
public interface ItemOrderedList{
	/*
	 *clear
	 *removes all items from the list 
	 *@param none
	 *return none
	 *post-condidtion: list is returned to empty state
	 */
	public void clear();
	/*
	 *add
	 *inserts given Item product into list if the list is not full
	 *@param: given Item objectwhose contents are initialized as defined by user
	 *@return: returns true if the Item is not null and unique, and the list is not full; otherwise returns false
	 *post-condition: Item is inserted into the ordered list if successful
	 */
	public boolean add(Item product);
	/*
	 *delete
	 *deletes Item with given String key value from the ordered list if the item is in the list
	 *@param: String key value given by user
	 *@return: returns true if the Item was found and successfully deleted; otherwise returns false
	 *post-condition: Item is deleted and the list is reordered accordingly
	 */
	public boolean delete(String keyValue);
	/*
	 *retrieve
	 *retrieves the Item object located at the list entry where the String key value occurs
	 *@param: String key value given by user
	 *@return: returns the Item object located at the found entry based on key value; if no object is present, returns null
	 *post-condition: none
	 */
	public Item retrieve(String keyValue);
	/*
	 *isEmpty
	 *determines if the list is empty
	 *@param: none
	 *@return: returns true if the lest is empty; returns false if there are one or more entries
	 *post-condition: none
	 */
	public boolean isEmpty();
	/*
	 *isFull
	 *determines if the list has reached its maximum size based on defined limit
	 *@param: none
	 *@return: returns true if the number of list entries has reached the maximum defined size; returns false if the number 
	 *of entries is less than maximum size
	 *post-condition: none
	 */
	public boolean isFull();
	/*
	 *print
	 *prints a given list entry
	 *@param: none
	 *@return: none
	 *post-condition: none
	 */
	public void print();
}