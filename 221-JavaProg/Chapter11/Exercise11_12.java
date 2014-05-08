/*Michael Blackburn
  CSCI 221
  Exercise11_12.java*/
  
/*This program prompts the user for 5 integers into an ArrayList, then adds all of the elements in the list.*/

import java.util.ArrayList;
import java.util.Scanner;

public class Exercise11_12{
	public static void main(String[] args){
		ArrayList doubList = new ArrayList();
		Scanner input = new Scanner(System.in);
		int count = 5;
		System.out.print("Enter a list of five numbers: ");
		while (count > 0){
			double n = input.nextDouble();
			doubList.add(n);
			count--;
		}
		double total = sum(doubList);
		System.out.println(total);
	}
	
	public static double sum(ArrayList<Double> list){
		double total = 0.0;
		for (int i = 0; i < list.size(); i++)
			total += list.get(i);
		return total;
	}
}