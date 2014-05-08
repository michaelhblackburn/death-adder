/*Michael Blackburn
  CSCI 221
  Exercise15_02.java*/
  
/*This program is a re-implementation of the GeometricObject and triangle classes.*/

import java.util.Scanner;

public class Exercise15_02 {
  public static void main(String[] args) {
  	//Original code by me asking user for input - LiveLab won't grade due to lack of input
  	/*Scanner input = new Scanner(System.in);
  	System.out.print("Enter the color: ");
  	String color = input.nextLine();
  	System.out.print("Enter side 1: ");
  	double s1 = input.nextDouble();
  	System.out.print("Enter side 2: ");
  	double s2 = input.nextDouble();
  	System.out.print("Enter side 3: ");
  	double s3 = input.nextDouble();
  	System.out.print("Is the triangle filled (true or false): ");
  	boolean filled = input.nextBoolean();*/
  	double s1 = 3.0;
  	double s2 = 4.0;
  	double s3 = 5.0;
  	String color = "yellow";
  	boolean filled = true;
   	System.out.println();
    Triangle triangle = new Triangle(s1, s2, s3, color, filled);
    
    
    System.out.println(triangle.getArea());
    System.out.println(triangle.getPerimeter());
	System.out.println(triangle.getColor());
	System.out.println(triangle.isFilled());


  }
}

abstract class GeometricObject {
  protected String color = "white";
  protected boolean filled;
  private java.util.Date dateCreated;

  /** Construct a default geometric object */
  protected GeometricObject() {
    dateCreated = new java.util.Date();
  }

  /** Construct a geometric object with color and filled value */
  protected GeometricObject(String color, boolean filled) {
    dateCreated = new java.util.Date();
    this.color = color;
    this.filled = filled;
  }

  /** Return color */
  public String getColor() {
    return color;
  }

  /** Set a new color */
  public void setColor(String color) {
    this.color = color;
  }

  /** Return filled. Since filled is boolean,
   *  the get method is named isFilled */
  public boolean isFilled() {
    return filled;
  }

  /** Set a new filled */
  public void setFilled(boolean filled) {
    this.filled = filled;
  }

  /** Get dateCreated */
  public java.util.Date getDateCreated() {
    return dateCreated;
  }

  @Override
  public String toString() {
    return "created on " + dateCreated + "\ncolor: " + color +
      " and filled: " + filled;
  }

  /** Abstract method getArea */
  public abstract double getArea();

  /** Abstract method getPerimeter */
  public abstract double getPerimeter();
}

class Triangle extends GeometricObject{
	private double side1 = 1.0;
	private double side2 = 1.0;
	private double side3 = 1.0;
	
	Triangle(){
	}
	
	Triangle(double s1, double s2, double s3, String c, boolean f){
		side1 = s1;
		side2 = s2;
		side3 = s3;
		color = c;
		filled = f;
	}
	
	public double getSide1(){
		return side1;
	}
	
	public void setSide1(double s1){
		side1 = s1;
	}
	
	public double getSide2(){
		return side2;
	}
	
	public void setSide2(double s2){
		side2 = s2;
	}
	
	public double getSide3(){
		return side3;
	}
	
	public void setSide3(double s3){
		side3 = s3;
	}
	
	public double getArea(){
		double s = (side1 + side2 + side3) / 2;
		double area = Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
		return area;
	}
	
	public double getPerimeter(){
		return side1 + side2 + side3;
	}
	
	@Override
  	public String toString() {
    	return "Triangle: area = " + this.getArea() + " perimeter = " + 														
    					this.getPerimeter() + " color = " + color + " isFilled = " + 
    					filled;
    }
}
    			