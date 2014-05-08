/*Michael Blackburn
  CSCI 221
  Exercise08_08.java*/
  
// This program creates the fan class

public class Exercise08_08 {
  public static void main(String[] args) {
    Fan fan1 = new Fan();
    fan1.setSpeed(Fan.FAST);
    fan1.setRadius(10);
    fan1.setColor("yellow");
    fan1.setOn(true);
    System.out.println(fan1.toString());

    Fan fan2 = new Fan();
    fan2.setSpeed(Fan.MEDIUM);
    fan2.setRadius(5);
    fan2.setColor("blue");
    fan2.setOn(false);
    System.out.println(fan2.toString());
  }
}

class Fan{
	private int speed;
	private boolean on;
	private double radius;
	private String color;
	public static int SLOW = 1;
	public static int MEDIUM = 2;
	public static int FAST = 3;
	
	Fan(){
		speed = SLOW;
		on = false;
		radius = 5.0;
		color = "blue";
	}
	
	public void setSpeed(int s){
		speed = s;
	}
	
	public int getSpeed(){
		return speed;
	}
			
	public void setOn(boolean o){
		on = o;
	}
	
	public boolean getOn(){
		return on;
	}
	
	public void setRadius(double r){
		radius = r;
	}
	
	public double getRadius(){
		return radius;
	}
	
	public void setColor(String c){
		color = c;
	}
	
	public String getColor(){
		return color;
	}
	
	@Override
  	public String toString() {
    	return "speed " + speed + "\n"
     	 + "color " + color + "\n"
     	 + "radius " + radius + "\n"
     	 + ((on) ? "fan is on" : "fan is off");
   }
}