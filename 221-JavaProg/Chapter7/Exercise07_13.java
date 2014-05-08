/*Michael Blackburn
  CSCI 221
  Exercise07_13.java*/
  
/*This program asks the user to enter a two-dimensional array, and passes the array to a
  method that scans the array and returns the position in the array of the largest 
  element.*/
  
import java.util.Scanner;

public class Exercise07_13{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the number of rows and columns of the array: ");
		int row = input.nextInt();
		int col = input.nextInt();
		double [][] testArray = new double [row][col];
		System.out.println("Enter the array: ");
		for (int i = 0; i < testArray.length; i++){
			for(int j = 0; j < testArray[i].length; j++){
				testArray[i][j] = input.nextDouble();
			}
		}
		int [] largeElement = locateLargest(testArray);
		System.out.println("The location of the largest element is at (" + 
							largeElement[0] + ", " + largeElement[1] + ")"); 
		
	}
	
	public static int[] locateLargest(double[][] a){
		int [] location = new int [2];
		double bigElement = a[0][0];
		for (int i = 0; i < a.length; i++){
			for (int j = 0; j < a[i].length; j++){
				if (a[i][j] > bigElement){
					bigElement = a[i][j];
					location[0] = i;
					location[1] = j;
				}
			}
		}
		
		return location;
	}
}