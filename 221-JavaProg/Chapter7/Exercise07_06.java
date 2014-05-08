/*Michael Blackburn
  CSCI 221
  Exercise07_06.java*/
  
/*This program receives two matrices from the user, multiplies them and returns the 
  result.*/
  
import java.util.Scanner;
  
public class Exercise07_06{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int r = 3;
		int c = r;
		double [][] matrix1 = new double [r][c];
		double [][] matrix2 = new double [r][c];
		System.out.print("Enter the first 3x3 matrix: ");
		for(int i = 0; i < matrix1.length; i++){
			for (int j = 0; j < matrix1[i].length; j++){
				matrix1[i][j] = input.nextDouble();
			}
		}
		for(int i = 0; i < matrix1.length; i++){
			for (int j = 0; j < matrix1[i].length; j++){
				System.out.print(matrix1[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		System.out.print("Enter the second 3x3 matrix: ");
		for(int i = 0; i < matrix2.length; i++){
			for (int j = 0; j < matrix2[i].length; j++){
				matrix2[i][j] = input.nextDouble();
			}
		}
		for(int i = 0; i < matrix2.length; i++){
			for (int j = 0; j < matrix2[i].length; j++){
				System.out.print(matrix2[i][j] + " ");
			}
			System.out.println();
		}
		double[][] product = multiplyMatrix(matrix1, matrix2);
			
		System.out.println("The product of the matrices is ");
		for (int i = 0; i < product.length; i++){
			for (int j = 0; j < product[i].length; j++){
				System.out.print(product[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static double[][] multiplyMatrix(double[][] a, double[][] b){
		double prod[][] = new double [a.length][b.length];
		if (a.length == b.length){
			for (int i = 0; i < prod.length; i++){
				for (int j = 0; j < prod[i].length; j++){
					prod[i][j] = (a[i][0] * b[0][j]) + (a[i][1] * b[1][j]) +
					 			 (a[i][2] * b[2][j]) ;
				}
			}
		}
		return prod;
	}
}