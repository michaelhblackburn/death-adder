/* Michael Blackburn
  CSCI 221
  Exercise 08_11.java*/
  
//This exercise covers functions of linear equations

import java.util.Scanner;

public class Exercise08_11 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter a, b, c, d, e, f: ");
    double a = input.nextDouble();
    double b = input.nextDouble();
    double c = input.nextDouble();
    double d = input.nextDouble();
    double e = input.nextDouble();
    double f = input.nextDouble();

    LinearEquation equation = new LinearEquation(a, b, c, d, e, f);

    if (equation.isSolvable()) {
      System.out.println("x is " +
        equation.getX() + " and y is " + equation.getY());
    }
    else {
      System.out.println("The equation has no solution");
    }
  }
}

class LinearEquation{
	private double a;
	private double b;
	private double c;
	private double d;
	private double e;
	private double f;
	
	LinearEquation(double a1, double b1, double c1, double d1, double e1, double f1){
		a = a1;
		b = b1;
		c = c1;
		d = d1;
		e = e1;
		f = f1;
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
	
	public double getD(){
		return d;
	}
	
	public double getE(){
		return e;
	}
	
	public double getF(){
		return f;
	}
	
	public boolean isSolvable(){
		if (((a * d) - (b * c)) != 0)
			return true;
		else 
			return false;
	}
	
	public double getX(){
		return (((e * d) - (b * f)) / ((a * d) - (b * c)));
	}
	
	public double getY(){
		return (((a * f) - (e * c)) / ((a * d) - (b * c)));
	}
		
}