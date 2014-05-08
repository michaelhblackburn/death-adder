/*Michael Blackburn
  CSCI 221
  Exercise10_04.java*/
  
/*This program creates a class for creating points on a coordinate plane.*/

public class Exercise10_04{
    public static void main(String[] args) {
        MyPoint p1 = new MyPoint();
        MyPoint p2 = new MyPoint(10, 30.5);
        System.out.println(p1.distance(p2));
        System.out.println(MyPoint.distance(p1, p2));
    }
}

class MyPoint{
	private double x = 0;
	private double y = 0;
	
	MyPoint(){
	
	}
	
	MyPoint(double x1, double y1){
		x = x1;
		y = y1;
	}
	
	public double getX(){
		return x;
	}
	
	public double getY(){
		return y;
	}
	
	public static double distance(MyPoint p1, MyPoint p2){
		return Math.sqrt(Math.pow((p1.getX() - p2.getX()), 2) + 
						 Math.pow((p1.getY() - p2.getY()), 2));
	}
	
	public double distance(MyPoint p){
		return Math.sqrt(Math.pow((this.x - p.getX()), 2) + 
						 Math.pow((this.y - p.getY()), 2));
	}
}