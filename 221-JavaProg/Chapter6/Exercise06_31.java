/*Michael Blackburn
  CSCI 221
  Exercise06_31.java*/
  
/*This program receives two lists from the user, sorts each list, then merges the 
  sorted lists, and outputs the new list.*/
  
import java.util.Scanner;
import java.util.Arrays;

public class Exercise06_31{
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
		Arrays.sort(list1);
		Arrays.sort(list2);
		int[] mergedList = merge(list1, list2);
		System.out.print("The merged list is ");
		for (int i = 0; i < mergedList.length; i++){
			System.out.print(mergedList[i] + " ");
		}
	}
	
	public static int[] merge(int[] list1, int[] list2){
		int[] newList = new int[list1.length + list2.length];
		int i = 0, j = 0, n = 0;
		while (i != list1.length && j != list2.length){
			if (list1[i] < list2[j]){
				newList[n] = list1[i];
				i++;
			}
			else{
				newList[n] = list2[j];
				j++;
			}
			n++;
		}
		if (i < list1.length){
			while (i != list1.length){
				newList[n] = list1[i];
				i++;
				n++;
			}
		}
		if (j < list2.length){
			while (j != list2.length){
				newList[n] = list2[j];
				j++;
				n++;
			}
		}		
		return newList;		
	}
}