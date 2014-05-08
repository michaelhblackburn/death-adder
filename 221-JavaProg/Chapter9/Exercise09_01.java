/*Michael Blackburn
  CSCI 221
  Exercise09_01.java*/
  
/*This program prompts the user for a string of characters in a certain format and checks
  as to whether the input is a valid SSN*/
  
import java.util.Scanner;

public class Exercise09_01{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter  a Social Security number in the format DDD-DD-DDDD: ");
		String ssn = input.nextLine();
		
		if (ssn.matches("\\d{3}-\\d{2}-\\d{4}"))
			System.out.println("Valid SSN");
		else
			System.out.println("Invalid SSN");
		
	}
}