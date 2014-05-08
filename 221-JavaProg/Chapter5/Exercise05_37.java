/*Michael Blackburn
  CSCI 221
  Exercise05_37.java*/
  
/*This program receives two numbers from the user: a number to format, and the number 
  of places to format the number. The number is converted to a string, and any 
  additional places are filled with leading zeros. If the input number to be formatted 
  is larger than the number of places input, the program simply returns the String 
  value for the number.*/
  
import java.util.Scanner;

public class Exercise05_37{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the number to format: ");
		int num = input.nextInt();
		System.out.print("Enter the number of places to format the number: ");
		int width = input.nextInt();
		System.out.println("The formatted number is " + format(num, width));
	}
	
	public static String format(int number, int width){
		String stringNumber = String.valueOf(number);
		if (stringNumber.length() >= width){
			return stringNumber;
		}
		else{
			StringBuffer formattedNum = new StringBuffer();
			for (int i = 0; i < (width - stringNumber.length()); i++){
				formattedNum = formattedNum.append(0);
			}
			stringNumber = formattedNum.append(stringNumber).toString();
			return stringNumber;
		}
	}
}
