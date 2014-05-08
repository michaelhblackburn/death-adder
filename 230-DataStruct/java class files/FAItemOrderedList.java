/*
 *Michael Blackburn
 *FAItemOrderedList.java
 *creates an item ordered list while implementing the ItemOrderedList interface
 */
public static class FAItemOrderedList implements ItemOrderedList{
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
			if(isFull()){
				return false;
			}
  			if(retrieve(product.getName()) != null){
  				return false;
  			}
  			if(isEmpty()){ 
  	 			myList[myCount] = product;
  	 		}
 			else{
    			int i = myCount - 1;
       			while((i >= 0) && (product.getName().compareTo(myList[i].getName()) < 0)){  
     				myList[i + 1] = myList[i];
					i--;
				}
    			myList[i+1] = product;
  			}
  			myCount++;
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
			int foundAtIndex = binarySearch(keyValue);
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
		 *retrieve
		 *retrieves the Item object located at the list entry where the String key value occurs
		 *@param: String key value given by user
		 *@return: returns the Item object located at the found entry based on key value; if no object is present, returns null
		 *post-condition: none
		 */
		public Item retrieve(String keyValue){
			int foundAtIndex = binarySearch(keyValue);
			if (foundAtIndex != -1){
				return myList[foundAtIndex];
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
		 *prints a given list entry
		 *@param: none
		 *@return: none
		 *post-condition: none
		 */
		public void print(){
			for(int i = 0; i < myCount; i++){
				System.out.println(myList[i].toString());
			}
		}
		/*
		 *binarySearch
		 *performs binary search on the list with given String key value
		 *@param: user provided String key value used for comparison to entries in the list
		 *@return: returns integer value of index entry where key value was found (if found); returns -1 if not found
		 *post-condition: none
		 */
		private int binarySearch(String keyValue){
			int low = 0;
			int high = myCount - 1;
			int middle;
			
			while(low <= high){
				middle = (low + high) / 2;
				if(keyValue.equals(myList[middle].getName())){
					return middle;
				}
				else if(keyValue.compareTo(myList[middle].getName()) < 0){
					high = middle - 1;
				}
				else{
					low = middle + 1;
				}
			}
			return -1;
		}
	}