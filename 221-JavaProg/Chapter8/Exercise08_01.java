/*Michael Blackburn
  CSCI 221
  Exercise08-01.java*/

/*This program creates a rectangle class and utilizes the class to create simple 
  rectangles, and reports values associated with the rectangles to the user.*/
  
public class Exercise08_01{
	public static void main(String[] args){
		Rectangle r1 = new Rectangle(4, 40);
		System.out.println("The width is " + r1.width + " and the height is " + r1.height);
		System.out.println("The area is " + r1.getArea() + " and the perimeter is " +
							r1.getPerimeter());
		Rectangle r2 = new Rectangle(3.5, 35.9);
		System.out.println("The width is " + r2.width + " and the height is " + r2.height);
		System.out.println("The area is " + r2.getArea() + " and the perimeter is " +
							r2.getPerimeter());
	}
}
	class Rectangle{
		double width;
		double height;
		
		Rectangle(){
			width = 1;
			height = 1;
		}
		
		Rectangle(double w, double h){
			width = w;
			height = h;			
		}
		
		double getArea(){
			return width * height;
		}
		
		double getPerimeter(){
			return (width * 2) + (height * 2);
		}
			
	}
