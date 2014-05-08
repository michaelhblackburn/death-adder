/*Michael Blackburn
  CSCI 221
  Exercise07_01.java*/
  
/*This program receives a 3x4 array from the user, and sums the values for each 
  column.*/
  
import java.util.Scanner;

public class Exercise07_01{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		double[][] newArray = new double [3][4];
		System.out.print("Enter a 3x4 matrix row by row: ");
		for (int i = 0; i < newArray.length; i++){
			for (int j = 0; j < newArray[i].length; j++){
				newArray[i][j] = input.nextDouble();
			}
		}
		for (int i = 0; i <= newArray.length; i++){
			int column = i;
			double sum = sumColumn(newArray, column);
			System.out.println("Sum of the elements at column " + column + " is " + sum);
		}
	}
	
	public static double sumColumn(double[][] m, int columnIndex){
		double sum = 0.0;
		for (int i = 0; i < m.length; i++){
			sum += m[i][columnIndex];
		}
		return sum;
	}
}