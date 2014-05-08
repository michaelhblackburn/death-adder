/*Michael Blackburn
  CSCI 221
  Exercise08_10.java*/
  
//This class covers various functions for arithmetic involving quadratic equations

import java.util.Scanner;

public class Exercise08_10 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter a, b, c: ");
    double a = input.nextDouble();
    double b = input.nextDouble();
    double c = input.nextDouble();

    QuadraticEquation equation = new QuadraticEquation(a, b, c);
    double discriminant = equation.getDiscriminant();

    if (discriminant < 0) {
      System.out.println("The equation has no roots");
    }
    else if (discriminant == 0)
    {
      System.out.println("The root is " + equation.getRoot1());
    }
    else // (discriminant >= 0)
    {
      System.out.println("The roots are " + equation.getRoot1() 
        + " and " + equation.getRoot2());
    }  
  }
}

class QuadraticEquation{
	private double a;
	private double b;
	private double c;
	
	QuadraticEquation(double a1, double b1, double c1){
		a = a1;
		b = b1;
		c = c1;
	}
	
	public double getA(){
		return a;
	}
	
	public double getB(){
		return b;
	}
	
	public double getC(){
		return c;
	}
	
	public double getDiscriminant(){
		return (b * b) - (4 * a * c);
	}
	
	public double getRoot1(){
		if (this.getDiscriminant() < 0)
			return 0.0;
		else{
			double r1 = ((b * -1) + Math.sqrt(this.getDiscriminant())) / (2 * a);
			return r1;
		}
	}
	
	public double getRoot2(){
		if (this.getDiscriminant() < 0)
			return 0.0;
		else{
			double r2 = ((b * -1) - Math.sqrt(this.getDiscriminant())) / (2 * a);
			return r2;
		}
	}
}