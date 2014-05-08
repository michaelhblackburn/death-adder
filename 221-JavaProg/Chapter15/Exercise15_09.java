/*Michael Blackburn
  CSCI 221
  Exercise15_09.java*/
  
/*This program creates classes for GeometricObject, Square, Rectangle, and Circle, and implements an interface for HowToColor.*/

public class Exercise15_09 {
  public static void main(String[] args) {
    GeometricObject[] objects = {new Square(2), new Circle(5), new Square(5), new Rectangle(3, 4), new Square(4.5)};
    
    for (int i = 0; i < objects.length; i++) {
      System.out.println("Area is " + objects[i].getArea());
      if (objects[i] instanceof Colorable)
        ((Colorable)objects[i]).howToColor();
    }
  }
}

abstract class GeometricObject {
  private String color = "white";
  private boolean filled;
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

interface Colorable{
	public void howToColor();
}

class Circle extends GeometricObject implements Colorable{
	private double radius;
	
	Circle(double r){
		radius = r;
	}
	
	public double getArea(){
		return Math.PI * Math.pow(this.radius, 2);
	}
	
	public double getPerimeter(){
		return 2 * Math.PI * this.radius;
	}
	
	public void howToColor(){
		System.out.println("Color the whole thing");
	}
}

class Square extends GeometricObject implements Colorable{
	private double side;
	
	Square(double s){
		side = s;
	}
	
	public double getArea(){
		return Math.pow(this.side, 2);
	}
	
	public double getPerimeter(){
		return 4 * this.side;
	}
	
	public void howToColor(){
		System.out.println("Color all four sides");
	}
}

class Rectangle extends GeometricObject implements Colorable{
	private double length;
	private double width;
	
	Rectangle(double l, double w){
		length = l;
		width = w;
	}
	
	public double getArea(){
		return this.length * this.width;
	}
	
	public double getPerimeter(){
		return ((2 * this.length) + (2 * this.width));
	}
	
	public void howToColor(){
		System.out.println("Color all four sides");
	}
}