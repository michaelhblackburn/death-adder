/*Michael Blackburn
  CSCI 221
  Exercise06_15.java*/
  
/*This program reads in numbers from the user, enteres them into an array, examines the 
  list for duplicates, and places the original entries into a new array, discarding 
  duplicate entires.*/
  
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class Exercise06_15{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int [] numArray = new int [10];
		System.out.println("Enter " + numArray.length + " numbers.");
		for (int i = 0; i < numArray.length; i++){
			System.out.print("Enter a number: ");
			numArray[i] = input.nextInt();
		}
		int [] newArray = eliminateDuplicates(numArray);
		for (int i = 0; i < newArray.length; i ++){
			System.out.print(newArray[i] + " ");
		}
		System.out.println();
		
	}
	
	public static int[] eliminateDuplicates(int[] array){
		List<Integer> conciseArray = new ArrayList<Integer>();
		for (int i = 0; i < array.length; i++)
			conciseArray.add(array[i]);
		for (int i = 0; i < conciseArray.size() + 1; i++){
			if (conciseArray.get(i) == conciseArray.get(i+1)){
					conciseArray.remove(conciseArray.get(i+1));
				
			}
		}
		int[] newArray = new int[conciseArray.size()];
		for (int i = 0; i < newArray.length; i++){
			newArray[i] = conciseArray.get(i);
		}
		return newArray;
	}
}