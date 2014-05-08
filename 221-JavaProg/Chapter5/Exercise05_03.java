/*Michael Blackburn
  CSCI 221
  Exercise05_03.java*/
  
/*This program receives an integer from the user, reverses the order of the digits
  then checks to see if the reversed order is equal to the original order. If the 
  numbers are equal, the program returns that the numbers are palindromes.*/
  
import java.util.Scanner;

public class Exercise05_03{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter an integer: ");
		int number = input.nextInt();
		boolean palindrome = isPalindrome(number);
		if (palindrome == true){
			System.out.println(number + " is palindrome.");
		}
		else{
			System.out.println(number + " and " + reverse(number) +
							   " are not palindromes.");
		}
	}
	
	public static int reverse(int num){
		int reverse = 0;
		while (num != 0){
			reverse = reverse * 10;
			reverse = reverse + (num % 10);
			num = num / 10;
		}
		return reverse;
	}
	
	public static boolean isPalindrome(int num){
		boolean palindrome = false;
		int reverse = reverse(num);
		if (num == reverse){
			palindrome = true;
		}
		return palindrome;
	}
}