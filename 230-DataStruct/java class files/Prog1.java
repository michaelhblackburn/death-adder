
/*
 *Michael Blackburn
 *Program 1, CSCI 230
 *Prog1Blackburn.java
 *This program uses several classes to build a shopping interface for Sammy's Warehouse Club 
 */
import java.util.Scanner;

public class Prog1{	
	
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
				System.out.println("Please give the, name, quantity, and unit price of the item");
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
				System.out.print("Enter the name of the item to be deleted:");
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
				list.print();
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
					System.out.println("You cart is empty.");
				}
				else{
					System.out.println("Your cart is not empty");
					System.out.println("You have " + list.getMyCount() + " items in your cart.")
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
	
	