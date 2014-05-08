/*Michael Blackburn
  CSCI 221
  Exercise06_26.java*/
  
//This program determines whether two lists of numbers are strictly identical.

import java.util.Scanner;

public class Exercise06_26{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.println("Enter list1: ");
		int length1 = input.nextInt();
		int[] list1 = new int[length1];
		for (int i = 0; i < list1.length; i++){
			//System.out.print("	enter a number: ");
			list1[i] = input.nextInt();
		}
		System.out.println();
		System.out.println("Enter list2: ");
		int length2 = input.nextInt();
		int[] list2 = new int[length2];
		for (int i = 0; i < list2.length; i++){
			//System.out.print("	enter a number: ");
			list2[i] = input.nextInt();
		}
		if(equals(list1, list2) == true){
			System.out.println("Two lists are strictly identical");
		}
		else{
			System.out.println("Two lists are not strictly identical");
		}
	}
	
	public static boolean equals(int[] list1, int[] list2){
		boolean isEqual = false;
		if (list1.length == list2.length){
			for (int i = 0; i < list1.length; i++){
				if (list1[i] != list2[i]){
					isEqual = false;
				}
				else
					isEqual = true;
			}
		}	
		return isEqual;
	}
}
