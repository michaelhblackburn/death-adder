/*Michael Blackburn
  CSCI 221
  Exercise11_04.java*/
  
/*This program prompts the user to enter a list of integers into an ArrayList, then returns the largest value in the list. If the list is null or has no elements, the method returns null.*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Exercise11_04{
	public static void main(String[] args){
		ArrayList intList = new ArrayList();
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a sequence of numbers ending in 0: ");
		int n = input.nextInt();
		while (n != 0){
			intList.add(n);
			n = input.nextInt();
		}
		int maxVal = max(intList);
		System.out.println(maxVal);			
	}
	
	public static Integer max(ArrayList<Integer> list){
		return Collections.max(list);
	}
}
