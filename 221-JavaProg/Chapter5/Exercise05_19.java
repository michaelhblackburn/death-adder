/*Michael Blackburn
  CSCI 221
  Exercise05_19.java*/
  
/*This program receives the lengths of the three sides of a triangle, tests the lengths 
  to ensure that they are valid, and calculates the area of the triangle if they are
  valid.*/
  
import java.util.Scanner;

public class Exercise05_19{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter side 1: ");
		double side1 = input.nextDouble();
		System.out.print("Enter side 2: ");
		double side2 = input.nextDouble();
		System.out.print("Enter side 3: ");
		double side3 = input.nextDouble();
		if (MyTriangle.isValid(side1, side2, side3) == true){
			System.out.println("The area of the triangle is " + 
								MyTriangle.area(side1, side2, side3));	
		}
		else{
			System.out.println("The sides are not valid.");
		}
	}
}

class MyTriangle{
	public static boolean isValid(double side1, double side2, double side3){
		if (side1 + side2 > side3){
			return true;
		}
		else if (side2 + side3 > side1){
			return true;
		}
		else if (side1 + side3 > side2){
			return true;
		}
		else{
			return false;
		}
	}
	
	public static double area(double side1, double side2, double side3){
		double s = (side1 + side2 + side3) / 2;
		double area = Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
		return area;
	}
}