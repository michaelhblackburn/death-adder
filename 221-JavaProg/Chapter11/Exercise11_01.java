/*Michael Blackburn
  CSCI 221
  Exercise11_01.java*/
  
/*This program creates an abstract class for geometric objects and a class for triangles that inherits the geometric object class. GeometricObject.class copied from book materials. */

public class Exercise11_01 {
  public static void main(String[] args) {
    Triangle triangle = new Triangle(1, 1.5, 1);
    triangle.setColor("yellow");
    triangle.setFilled(true);

    System.out.println(triangle);
    System.out.println("The area is " + triangle.getArea());
    System.out.println("The perimeter is "
      + triangle.getPerimeter());
    System.out.println(triangle);
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
	
	Triangle(double s1, double s2, double s3){
		side1 = s1;
		side2 = s2;
		side3 = s3;
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
    	return "Triangle: side1 = " + side1 + " side2 = " + side2 + " side3 = " +
    			side3;
    }
}
    			