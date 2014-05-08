/*Michael Blackburn
  CSCI 221
  Exercise07_05.java*/
  
/*This program has the user input two matrices of equal dimension, and sums the elements 
  from each matrix.*/
  
import java.util.Scanner;

public class Exercise07_05{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		double[][] matrix1 = new double [3][3];
		double[][] matrix2 = new double [3][3];
		System.out.print("Enter the first matrix, row by row: ");
		for (int i = 0; i < matrix1.length; i++){
			for (int j = 0; j < matrix1[i].length; j++){
				matrix1[i][j] = input.nextDouble();
			}
		}
		System.out.print("Enter the second matrix, row by row: ");
		for (int i = 0; i < matrix2.length; i++){
			for (int j = 0; j < matrix2[i].length; j++){
				matrix2[i][j] = input.nextDouble();
			}
		}
		double[][] matrix3 = addMatrix(matrix1, matrix2);
		for (int i = 0; i < matrix3.length; i++){
			for (int j = 0; j < matrix3[i].length; j++){
				System.out.print(matrix3[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static double[][] addMatrix(double[][] a, double[][] b){
		double sum = 0.0;
		double[][] newMatrix = new double[a.length][b.length];
		if (a.length == b.length){
			for (int i = 0; i < newMatrix.length; i++){
				for (int j = 0; j < newMatrix[i].length; j++){
					newMatrix[i][j] = a[i][j] + b[i][j];
				}
			}
		}
		return newMatrix;
	}
}