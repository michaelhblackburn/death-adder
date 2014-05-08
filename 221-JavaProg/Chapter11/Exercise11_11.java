/*Michael Blackburn
  CSCI 221
  Exercise11_11.java*/
  
/*This program prompts the user to enter five numbers into an ArrayList, passes the list to a method for sorting, and then displays the list in ascending order.*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Exercise11_11{
	public static void main(String[] args){
		ArrayList intList = new ArrayList();
		Scanner input = new Scanner(System.in);
		int count = 5;
		System.out.print("Enter a list of five numbers: ");
		while (count > 0){
			int n = input.nextInt();
			intList.add(n);
			count--;
		}
		sort(intList);
		for (int i = 0; i < intList.size(); i++)
			System.out.print(intList.get(i) + " ");
		System.out.println();
	}
	
	public static void sort(ArrayList<Integer> list){
		Collections.sort(list);
	}
}