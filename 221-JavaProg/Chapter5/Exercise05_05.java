/*Michael Blackburn
  CSCI 221
  Exercise05_05.java*/
  
/*This program receives three numbers from the user and sorts the numbers 
  in ascending order.*/

import java.util.Scanner;
  
public class Exercise05_05{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter number 1: ");
		double num1 = input.nextDouble();
		System.out.print("Enter number 2: ");
		double num2 = input.nextDouble();
		System.out.print("Enter number 3: ");
		double num3 = input.nextDouble(); 
		displaySortedNumbers(num1, num2, num3);
	}
	
	public static void displaySortedNumbers(double num1, double num2, double num3){
		double tempInt = 0;
		if (num1 > num2){
            tempInt = num1;
            num1 = num2;
            num2 = tempInt;
        }
        if (num2 > num3){
            tempInt = num2;
            num2 = num3;
            num3 = tempInt;
        }
        if (num1 > num2){
            tempInt = num1;
            num1 = num2;
            num2 = tempInt;
        }
        System.out.println("The sorted numbers in order are: " + num1 + " " +
                                num2 + " " + num3 + ".");
	}
}