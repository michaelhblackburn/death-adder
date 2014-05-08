/*Michael Blackburn
  CSCI 221
  Exercise10_11.java*/
  
/*This program creates and implements a class for dealing with circles.*/

public class Exercise10_11 {
  public static void main(String[] args) {
    Circle2D c1 = new Circle2D(2, 2, 5.5);
    System.out.println("Area is " + c1.getArea());
    System.out.println("Perimeter is " + c1.getPerimeter());
    System.out.println(c1.contains(3, 3));
    System.out.println(c1.contains(new Circle2D(4, 5, 10.5)));
    System.out.println(c1.overlaps(new Circle2D(3, 5, 2.3)));
  }
}

class Circle2D{
	private double x = 0;
	private double y = 0;
	private double radius = 0;
	
	Circle2D(){
		radius = 1;
	}
	
	Circle2D(double x1, double y1, double r){
		x = x1;
		y = y1;
		radius = r;
	}
	
	public double getX(){
		return x;
	}
	
	public double getY(){
		return y;
	}
	
	public double getRadius(){
		return radius;
	}
	
	public double getArea(){
		return Math.PI * Math.pow(radius, 2);
	}
	
	public double getPerimeter(){
		return 2 * Math.PI * radius;
	}
	
	public boolean contains(double x1, double y1){
		double d = Math.sqrt(Math.pow((this.x - x1), 2) + Math.pow((this.y - y1), 2));
		if (d <= this.radius)
			return true;
		else
			return false;
	}
	
	public boolean contains(Circle2D c){
		double d = Math.sqrt(Math.pow((this.x - c.getX()), 2) + 
						  Math.pow((this.y - c.getY()), 2));
		if ((d + c.getRadius()) <= this.radius)
			return true;
		else
			return false;
	}
	
	public boolean overlaps(Circle2D c){
		double d = Math.sqrt(Math.pow((this.x - c.getX()), 2) + 
						  Math.pow((this.y - c.getY()), 2));
		if (d <= (this.radius + c.getRadius()))
			return true;
		else
			return false;
	}
}