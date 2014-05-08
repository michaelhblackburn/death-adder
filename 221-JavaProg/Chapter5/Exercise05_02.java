/*Michael Blackburn
  CSCI 221
  Exercise05_02.java*/
  
/*This program receives an integer from the user, sums the individual digits
  in that number, and returns the sum of the integer.*/
  
import java.util.Scanner;

public class Exercise05_02{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter an integer: ");
		long number = input.nextInt();
		System.out.println("The sum of the digits for " + number +
							" is " + sumDigits(number) + ".");
	}
 	
 	public static int sumDigits(long num){
 		int sum = 0;
 		while (num != 0){
 			sum += (num % 10);
 			num = num / 10;
 		}
 		return sum;
 	}
}