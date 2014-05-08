/*Michael Blackburn
  CSCI 221
  Exercise20_02.java*/
  
/*This program rewrites the Fibonacci sequence without recursion, using an iterative loop to ascertain the number at the index.*/

import java.util.Scanner;

public class Exercise20_02{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter an index for a Fibonacci number: ");
		int n = input.nextInt();
		int fib0 = 0;
		int fib1 = 1;
		int currentFib = 0;
		for (int i = 1; i < n; i++){
			currentFib = fib0 + fib1;
			fib0 = fib1;
			fib1 = currentFib;
		}
		System.out.println("The Fibonacci number at index " + n + " is " + currentFib);
	}
}