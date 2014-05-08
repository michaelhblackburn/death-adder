/*
 *Michael Blackburn
 *FAItemOrderedList2.java
 *Version 2 of FAItemOrderedList with revised add() method - insert into next open slot
 *param product given Item initialized object
 *@return true if not full and product's keyValue unique with given item having been inserted into List
 *false leaving list unchanged
 */
public class FAItemOrderedList implements ItemOrderedList{
	//define terms used by class
	private static final int MAX_SIZE = 50;
	private Item[] myList;
	private int myCount;
	//constructor for FAItemOrderedList object; creates array of MAX_SIZE and sets count to zero
	public FAItemOrderedList(){
		myList = new Item[MAX_SIZE];
		myCount = 0;
	}
	/*
	 *getMyCount
	 *returns the current count of the list
	 *@param: none
	 *@return: returns integer of the current count of the list
	 *post-condition: none
	 */
	public int getMyCount(){
		return myCount;
	}
	 /*
	  *clear
	  *removes all items from the list 
	  *@param none
	  *return none
	  *post-condidtion: list is returned to empty state
	  */
	 public void clear(){
		for(int i = 0; i < myCount; i++){
			myList[i] = null;
		}
		myCount = 0;
	 }
	 /*
	  *add
	  *inserts given Item product into list if the list is not full
	  *@param: given Item objectwhose contents are initialized as defined by user
	  *@return: returns true if the Item is not null and unique, and the list is not full; otherwise returns false
	  *post-condition: Item is inserted into the ordered list if successful
	  *The add method in this version now appends new entries to the end of the array, rather than pre-sorting
	  *the list as items are added. The previous add method from Program 1 was a cost of O(n). The new add method
	  *runs at a cost of O(1).
	  */
	 public boolean add(Item product){
	 	if(isFull()){ //check to see if list is full
	 		return true;
	 	}
	 	if(retrieve(product.getName()) != null){ //retireve option to check for duplicate
	 		return false;
	 	}
	 	myList[myCount] = product; //add T to next entry in array
	 	myCount++; //increment count
	 	return true; //return value 
	 }
	 /*
	  *delete
	  *deletes Item with given String key value from the ordered list if the item is in the list
	  *@param: String key value given by user
	  *@return: returns true if the Item was found and successfully deleted; otherwise returns false
	  *post-condition: Item is deleted and the list is reordered accordingly
	  *The delete method in this version now implements a linear search, rather thatn the binary search used in
	  *Program 1, reducing the efficiency of this method. The binary search came at a cost of O(log2n). The 
	  *linear search comes with a cost of O(n).
	  */
	 public boolean delete(String keyValue){
		int foundAtIndex = linearSearch(keyValue);
		if (foundAtIndex == -1){ 
			return false;
		}
		myList[foundAtIndex] = null;
		myCount--;
		//move entries down 
		for (int i = foundAtIndex; i < myCount; i++){
			myList[i] = myList[i+1];
		}
		myList[myCount] = null;
		return true;
	 }
	 /*
	  *linearSearch
	  *performs linear search on the list with given String key value
	  *@param: user provided String key value used for comparison to entries in the list
	  *@return: returns integer value of index entry where key value was found (if found); returns -1 if not found
	  *post-condition: none
	  *This program implements linear search for location vs the binary search in Program 1. Binary search has a 
	  * cost of O(log2n); linear search has a cost of O(n), making it slightly less efficient than the binary search.
	  */
	 private int linearSearch(String keyValue){
	 	for(int i = 0; i < myCount; i++){
	 		if(keyValue.equals(myList[i].getName())){ //get product name and compare to keyValue
	 			return i;
	 		}
	 	}
	 	return -1; //not found
	 }
	 /*
	  *retrieve
	  *retrieves the Item object located at the list entry where the String key value occurs
	  *@param: String key value given by user
	  *@return: returns the Item object located at the found entry based on key value; if no object is present, returns null
	  *post-condition: none
	  *The retrieve method also implements the linear search instead of binary, with a cost of O(n), vs the efficiency
	  * of binary at a cost of O(log2n).
	  */
	 public Item retrieve(String keyValue){
	 	int index = linearSearch(keyValue);
	 	if (index == -1){
	 		return null;
	 	}
	 	else{
	 		return myList[index];
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
	   	if(myCount == 0){
			return true;
		}
		else{
			return false;
		}
	 }
	 /*
	  *isFull
	  *determines if the list has reached its maximum size based on defined limit
	  *@param: none
	  *@return: returns true if the number of list entries has reached the maximum defined size; returns false if the number 
	  *of entries is less than maximum size
	  *post-condition: none
	  */
	 public boolean isFull(){
		if(myCount == MAX_SIZE){
			return true;
		}
		else{
			return false;
		}
	 }
	 /*
	  *print
	  *performs a bubble sort on the list, and prints list entries
	  *@param: none
	  *@return: none
	  *post-condition: none
	  *This version utilizes a bubble sort on the unsorted list prior to printing. Unlike Program 1, where the list 
	  *was sorted during the add method, this list in this version remains unsorted until the print method is called,
	  *implementing the bubble sort. In Program 1, the print method had a cost of O(n), iterating through the sorted 
	  *entries. Here, the bubble sort comes with a cost of O(n^2).
	  */
	 public void print(){
	 	bubbleSort(myList);
	 	for (int i = 0; i < myCount; i++){
	 		System.out.println(myList[i].toString());
	 	}
	 }
	 /*
	  *bubbleSort
	  *receives a user-provided list and performs a bubble sort
	  *@param: unsorted array list
	  *@return: none
	  *post-condition: provided array is sorted upon completion
	  *In Program 1, sorting was handled during the add method, where items were sorted real-time during 
	  *addition. Here, the implementation of a sort is necessary for the ordered printing of the list. The cost 
	  *of the cost is O(n^2).
	  */
	 public void bubbleSort(Item[] myList){
	 	for (int i = 0; i < myCount - 1; i++){
	 		for (int j = myCount - 1; j > i; j--){
	 			if (myList[j-1].getName().compareToIgnoreCase(myList[j].getName()) > 0){
	 				Item temp = myList[j-1];
	 				myList[j-1] = myList[j];
	 				myList[j] = temp;
	 			}
	 		}
	 	}
	 }
}