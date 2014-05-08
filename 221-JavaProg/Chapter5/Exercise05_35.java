/*Michael Blackburn
  CSCI 221
  Exercise05_35.java*/
  
/*This program receives the length of a side of a pentagon from the user,
  calculates and returns the area of the pentagon.*/
  
import java.util.Scanner;

public class Exercise05_35{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the side: ");
		double side = input.nextDouble();
		System.out.println("The area of the pentagon is " + pentagonArea(side));
	}
	
	public static double pentagonArea(double s){
		double area = ((5 * Math.pow(s, 2)) / (4 * Math.tan(Math.PI / 5)));
		return area;
	}
}