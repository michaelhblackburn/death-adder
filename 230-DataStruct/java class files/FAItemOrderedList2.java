/*
 *Michael Blackburn
 *FAItemOrderedList2.java
 *Version 2 of FAItemOrderedList with revised add() method - insert into next open slot
 *param product given Item initialized object
 *@return true if not full and product's keyValue unique with given item having been inserted into List
 *false leaving list unchanged
 */
public static class FATItemOrderedList implements ItemOrderedList{
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
	  */
	 private int linearSearch(String keyValue, Item[] list){
	 	for(int i = 0; i < myCount; i++){
	 		if(myList[i].getName().compareToIgnoreCase(keyValue) = 0){ //get product name and compare to keyValue
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
	  */
	 public Ticket retrieve(String keyValue){
	 	int index = linearSearch(keyValue, myList);
	 	if (index == -1){
	 		return null;
	 	}
	 	else{
	 		return myList[index]
	 	}
	 }
	 /*
	  *print
	  *performs a bubble sort on the list, and prints list entries
	  *@param: none
	  *@return: none
	  *post-condition: none
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
	  */
	 public void bubbleSort(Item[] list){
	 	for (int i = 0; i < list.length - 1; i++){
	 		for (int j = list.length - 1; j > i; j--){
	 			if (list[j-1].getName().compareToIgnoreCase(list[j].getName()) > 0){
	 				swap(list, j-1, j);
	 			}
	 		}
	 	}
	 }
}