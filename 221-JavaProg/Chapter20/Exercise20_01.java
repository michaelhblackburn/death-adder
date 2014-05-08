/*Michael Blackburn
  CSCI 221
  Exercise20_01.java*/
  
/*This program implements a recursive method for factorial using the BigInteger class.*/

import java.math.BigInteger;
import java.util.Scanner;

public class Exercise20_01{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter an integer to compute the factorial of: ");
		int n = input.nextInt();
		BigInteger integer = new BigInteger(Integer.toString(n));
		System.out.println(factorial(integer));
	}
	
	public static BigInteger factorial(BigInteger integer){
		BigInteger bi0 = new BigInteger("0");
		BigInteger bi1 = new BigInteger("1");
		//base case
		if (integer.equals(bi0))
			return bi1;
		
		return integer.multiply(factorial(integer.subtract(bi1)));
	}
}