
/*
 *Michael Blackburn
 *Program 1, CSCI 230
 *Prog1Blackburn.java
 *This program uses several classes to build a shopping interface for Sammy's Warehouse Club 
 */
import java.util.Scanner;

public class Prog1Blackburn22{	
	/*
 *Michael Blackburn
 *Item.java
 *defines ADT Item for use in item-ordered arrays
 *provides accessor methods for ADT attributes
 *provides constructors for both a default Item and one with user-defined attributes
 */
public static class Item{
		//define variables for Item attributes
		private String name;
		private int quantity;
		private double price;
		//default constructor
		public Item(){
			quantity = 0;
			name = null;
			price = 0.0;
		}
		//constructor with user-defined attributes
		public Item(int number_of_items, String name_of_item, double price_of_item){
			quantity = number_of_items;
			name = name_of_item;
			price = price_of_item;		
		}
		//returns current quantity
		public int getQuantity(){
			return quantity;
		}
		//returns current name
		public String getName(){
			return name;
		}
		//returns current price
		public double getPrice(){
			return price;
		}
		//returns String of all attributes
		public String toString(){
			return "Name: " + name + "\nQuantity: " + quantity + "\nPrice: $" + String.format("%.2f", price) + "\n";
		}
	}

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

/*
 *Michael Blackburn
 *FAItemOrderedList.java
 *creates an item ordered list while implementing the ItemOrderedList interface
 */
/*
 *Michael Blackburn
 *FAItemOrderedList2.java
 *Version 2 of FAItemOrderedList with revised add() method - insert into next open slot
 *param product given Item initialized object
 *@return true if not full and product's keyValue unique with given item having been inserted into List
 *false leaving list unchanged
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
	public static void main(String[] args){
		//create/initalize variables
		Scanner entry = new Scanner(System.in);
		int menu = 0;
		int quantity = 0;
		String name = null;
		String find;
		double price = 0.0;
		Item input = null;
		FAItemOrderedList list = new FAItemOrderedList();
		boolean success;
		
		//Greet the user and show menu
		
		System.out.println("Welcome to Sammy's Warehouse Club!  Select an item from the menu below.");
		menu = menu();
		
		while (menu != 0){
			switch (menu){
			case 1://Case 1 is for adding items to the cart. Prompt notifies user of success or failure.
				System.out.println("Please give the, name, quantity, and unit price of the item:");
				System.out.print("Enter name: ");
				name = entry.next();
				System.out.print("Enter quantity: ");
				quantity = entry.nextInt();
				//if the user enters a quantity less than one, prompt for another entry until entry > 0
				while (quantity < 1){
					System.out.print("Invalid quantity.  Please enter a" +
						"quantity greater than zero: ");
					quantity = entry.nextInt();
				}
				
				System.out.print("Enter price: ");
				price = entry.nextDouble();
				//if user enters a prices <= zero, promtp for a valid entry
				while (price < 0.01){
					System.out.print("Invalid price.  Please enter a" +
						"price greater than zero: ");
					price = entry.nextDouble();
				}				
				input = new Item(quantity, name, price);
				success = list.add(input);
				//checks to see if item was added and reports to user
				if (success == true){
					System.out.println(input.getName() + " successfully added!");
				}
				else{
					System.out.println("Error - item is either " +
					"already in the cart or the cart may be full");
					System.out.println("Check cart and try again.");
				}
				break;
			case 2://case 2 deletes items from the list. Prompt notifies user of success or failure.
				System.out.print("Enter the name of the item to be deleted: ");
				find = entry.next();
				success = list.delete(find);
				System.out.println("");
				if (success == true){
					System.out.println("Item deleted!");
				}
				else{
					System.out.println("Error - the item may " +
						"not be in the cart.");
					System.out.println("Check cart and try again.");
				}				
				break;
			case 3://case 3 prints information in the list
				if(!list.isEmpty()){
					list.print();
				}
				else{
					System.out.println("The cart is empty.");
				}
				break;
			case 4://case 4 serches for items in the cart
				System.out.print("Enter the name of the search item: ");
				find = entry.next();
				Item findItem;
				findItem = list.retrieve(find);
				
				if (findItem == null){
					System.out.println(find + " was not found.");
				}
				else{
					System.out.println("You have " + findItem.getName() + " in your cart.");
					System.out.println("You have " + findItem.getQuantity() +
						" at $" + String.format("%.2f", findItem.getPrice()) + " each.");
				}
				break;
			case 5://case 5 determines if the list is empty
				success = list.isEmpty();
				if (success == true){
					System.out.println("Your cart is empty.");
				}
				else{
					System.out.println("Your cart is not empty");
					System.out.println("You have " + list.getMyCount() + " items in your cart.");
				}
				break;
			case 6://case 6 resets the list to its default state - an empty list
				list.clear();
				System.out.println("The cart has been emptied");
				break;
			default:
			}
		menu = menu();
		}
		System.out.println("");
		System.out.println("Thank you for using Sammy's! Have a wonderful day!");
	}
	
	public static int menu(){
		int sel = 0;
		boolean isValid = false;
        Scanner entry = new Scanner(System.in);
		
		while (isValid == false){
			System.out.println("");
			System.out.println("1. Add an item to your cart");
			System.out.println("2. Remove an item from your cart");
			System.out.println("3. Show a list of each item in your cart");
			System.out.println("4. Search for an item in your cart");
			System.out.println("5. Determine whether your cart is empty");
			System.out.println("6. Empty your cart");
			System.out.println("0. Quit");
			System.out.print("Please enter a number, 0-6: ");
			sel = entry.nextInt();
			if ((sel >=0) && (sel <= 6))
				isValid = true;
			else System.out.println("Invalid choice.  Please enter a number between 1 and 6, or 0 to exit.");
		}		
		return sel;
	}
}
	
	