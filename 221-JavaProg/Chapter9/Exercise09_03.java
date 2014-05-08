/*Michael Blackburn
  CSCI 221
  Exercise09_03.java*/
  
/*This program reads in a string from the user, and determines whether or not it conforms to the password conventions given*/

import java.util.Scanner;

public class Exercise09_03{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the password: \n" +
						 "(The password must be at least 8 characters,\n" +
						 " consist of only letters and digits, and \n" +
						 " contain at least two digits.)");
		String password = input.nextLine();
		char [] c = password.toCharArray();
		int len = c.length;
		int digit = 0;
		int charOrDigit = 0;
		for (int i = 0; i < c.length; i++){
			if (Character.isDigit(c[i]))
				digit++;
			if (Character.isLetterOrDigit(c[i]))
				charOrDigit ++;
		}
		
		if (c.length >= 8 && charOrDigit == c.length && digit >= 2)
			System.out.println("Valid Password");
		else
			System.out.println("Invalid Password");	
	}
}

