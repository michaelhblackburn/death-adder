/*Michael Blackburn
  CSCI 221
  Exercise20_03.java*/
  
/*This program calculates the greatest common divisor of two numbers using recursion.*/

import java.util.Scanner;

public class Exercise20_03{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the first number: ");
		int n1 = input.nextInt();
		System.out.print("Enter the second number: ");
		int n2 = input.nextInt();
		int divisor = GCD(n1, n2);
		System.out.println("The GDC of " + n2 + " and " + n1 + " is " + divisor);
	}
	
	public static int GCD(int n1, int n2){
		//base case
		if (n2 % n1 == 0)
			return n1;
		return GCD(n1, n2 % n1);
	}
}