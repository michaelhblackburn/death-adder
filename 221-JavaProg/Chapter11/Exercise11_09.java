/*Michael Blackburn
  CSCI 221
  Exercise11_09.java*/
  
/*This program creates a square matrix, randomly assigns a 1 or 0 to each element in the matrix, and then determines which row(s) and column(s) has the largest amount of ones.*/

import java.util.Scanner;
import java.util.ArrayList;

public class Exercise11_09{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the array size: ");
		int n = input.nextInt();
		int [][] randArray = new int[n][n];
		for (int i = 0; i < randArray.length; i++){
			for (int j = 0; j < randArray[i].length; j++){
				randArray[i][j] = (int)(Math.random() * 2);
			}
		}
		System.out.println("The random array is ");
		for (int i = 0; i < randArray.length; i++){
			for (int j = 0; j < randArray[i].length; j++){
				System.out.print(randArray[i][j] + " ");
			}
			System.out.println();
		}
		int total = 0;
		int rowTotal = 0;
		int colTotal = 0;
		ArrayList bigRow = new ArrayList();
		ArrayList bigCol = new ArrayList();
		for (int i = 0; i < randArray.length; i++){
			for (int j = 0; j < randArray[i].length; j++){
				rowTotal += randArray[i][j];
			}
			if (rowTotal >= total){
				total = rowTotal;
				bigRow.add(i);
			}
		}
		System.out.println(bigRow);
	}
}