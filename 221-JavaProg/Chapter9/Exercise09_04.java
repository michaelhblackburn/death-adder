/*Michael Blackburn
  CSCI 221
  Exercise09_04.java*/
  
/*This program finds the number of occurences of a given character in a string*/

import java.util.Scanner;

public class Exercise09_04{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a string to search: ");
		String s = input.nextLine();
		System.out.print("Enter a character to search for in the string: ");
		char c = input.findInLine(".").charAt(0);
		int numOcc = count(s, c);
		System.out.println(numOcc);
	}
	
	public static int count(String str, char a){
		char [] charArray = str.toCharArray();
		int numOcc = 0;
		for (int i = 0; i < charArray.length; i++){
			if (a == charArray[i])
				numOcc++;
		}
		return numOcc;
	}
}
