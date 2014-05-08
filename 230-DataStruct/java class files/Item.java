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