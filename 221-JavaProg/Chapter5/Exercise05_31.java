/*Michael Blackburn
  CSCI 221
  Exercise05_31.java*/
  
/*This program receives a credit card number form the user, and determines whether
  or not it is valid using the Luhn check or Mod 10 check.*/
  
import java.util.Scanner;
 
public class Exercise05_31{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a credit card number as a long integer: ");
		long cardNumber = input.nextLong();
		//System.out.println("Even " + sumOfDoubleEvenPlace(cardNumber));
		//System.out.println("Odd " + sumOfOddPlace(cardNumber));
		//System.out.println("getDigit " + getDigit(10));
		if (isValid(cardNumber) == true){
			System.out.println(cardNumber + " is valid.");
		}
		else{
			System.out.println(cardNumber + " is invalid.");
		}
	}
	
	public static long getPrefix(long number, int k){
		String stringNumber = String.valueOf(number);
		if (stringNumber.length() >= k){
			long prefix = Long.parseLong(stringNumber.substring(0, k));
			return prefix;
		}
		else{
			return number;
		}
	}
	
	public static int getSize(long d){
		String stringNumber = String.valueOf(d);
		int digits = stringNumber.length();
		return digits;
	}
	
	public static boolean prefixMatched(long number, int d){
		boolean matched = false;
		if (number == d){
			matched = true;
		}
		return matched;
	}
	
	public static int sumOfOddPlace(long number){
		int sum = 0;
		while (number != 0){
			sum += (number % 10);
			number = number / 10;
			number = number / 10;
		}
		return sum;
	}
	
	public static int getDigit(int number){
		int sum = 0, length = 0;
		String stringNumber = String.valueOf(number);
		length = stringNumber.length();
		if (length == 1){
			sum = number;
		}
		else{
			while (number != 0){
				sum += (number % 10);
				number = (number / 10);
			}
		}
		return sum;
	}
	
	public static int sumOfDoubleEvenPlace(long number){
		int sum = 0, digit = 0;
		String stringNumber = String.valueOf(number);
		for (int i = 0; i < stringNumber.length(); i = i + 2){
			StringBuffer numbers = new StringBuffer();
			String newNum = numbers.append(stringNumber.charAt(i)).toString();
			digit = Integer.parseInt(newNum) * 2;
			digit = getDigit(digit);
			sum += digit;
		}		
		return sum;
	}
	
	public static boolean isValid(long number){
		long sum = sumOfDoubleEvenPlace(number) + sumOfOddPlace(number);
		if ((sum % 10) == 0){
			return true;
		}
		else{
			return false;
		}
	}		
}
