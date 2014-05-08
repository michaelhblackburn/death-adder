/*Michael Blackburn
  CSCI 221
  Exercise09_06.java*/
  
/*This program reads in a string from the user and counts the number of characters in that string.*/

import java.util.Scanner;

public class Exercise09_06{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a string to count the number of letters: ");
		String s = input.nextLine();
		int count = countLetters(s);
		System.out.println(count);
	}
	
	public static int countLetters(String s){
		char [] c = s.toCharArray();
		int count = 0;
		for (int i = 0; i < c.length; i++){
			if (Character.isLetter(c[i]))
				count++;
		}
		return count;
	}
}
