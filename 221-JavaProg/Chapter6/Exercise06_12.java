/*Michael Blackburn
  CSCI 221
  Exercise06_12.java*/
  
/*This program receives ten number from the user, enters these numbers into an array, and
  passes the array to a method that reverses the entries and enters them into a new array,
  then returns the new array.*/
  
import java.util.Scanner;

public class Exercise06_12{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int [] numArray = new int [10];
		System.out.println("Enter " + numArray.length + " numbers.");
		for (int i = 0; i < numArray.length; i++){
			System.out.print("Enter a number: ");
			numArray[i] = input.nextInt();
		}
		System.out.println();
		int [] reversedArray = reverseArray(numArray);
		for (int i = 0; i < reversedArray.length; i++){
			System.out.print(reversedArray[i] + " ");
		}
		System.out.println();
	}
	
	public static int [] reverseArray(int [] intArray){
		int count  = intArray.length;
		int [] reversedArray = new int[intArray.length];
		for (int i = 0; i < reversedArray.length; i++){
			reversedArray[i] = intArray[count - 1];
			count--;
		}
		return reversedArray; 
	}
}