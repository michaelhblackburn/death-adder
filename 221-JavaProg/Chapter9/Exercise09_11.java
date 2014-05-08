/*Michael Blackburn
  CSCI 221
  Exercise09_11.java*/
  
/*This program reads in a string from the user, sorts the string and returns the sorted string.*/

import java.util.Scanner;
import java.util.Arrays;

public class Exercise09_11{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the string to sort: ");
		String s = input.nextLine();
		
		String sorted_S = sort(s);
		System.out.println("sorted string is " + sorted_S);
	}
	
	public static String sort(String s){
		char [] c = s.toCharArray();
		Arrays.sort(c);
		String sorted = String.valueOf(c);
		return sorted;
	}
}

