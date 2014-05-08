/*Michael Blackburn
  CSCI 221
  Exercise06_08.java*/
  
/*This program asks the user for ten double values, loads them into an array, and passes 
  the array to a method to calculate the average. There also exists another method that 
  accepts int values into an array, and calculates their average as well.*/
  
import java.util.Scanner;

public class Exercise06_08{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		double [] values = new double [10];
		for (int i = 0; i < values.length; i++){
			System.out.print("Enter a decimal value: ");
			values[i] = input.nextDouble();
		}
		double average = average(values);
		System.out.println("The average is " + average);
	}
	
	public static int average(int[] array){
		int sum = 0;
		for (int i = 0; i < array.length; i++){
			sum += array[i];
		}
		double average = (double)sum / array.length;
		return (int)average;
	}
	
	public static double average(double[] array){
		double sum = 0.0;
		for (int i = 0; i < array.length; i++){
			sum += array[i];
		}
		double average = sum / array.length;
		return average;
	}
}