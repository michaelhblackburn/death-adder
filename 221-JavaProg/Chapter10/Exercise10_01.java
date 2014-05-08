/*Michael Blackburn
  CSCI 221
  Exercise10_01.java*/
  
/*This program creates and tests a class for time.*/

import java.util.Calendar;

public class Exercise10_01 {
	public static void main(String[] args){
		Time time1 = new Time();
		System.out.println("Hour: " + time1.getHour() + " Minute: " +
                       time1.getMinute() + " Second: " + time1.getSecond());
    	Time time2 = new Time(555550000);
    	System.out.println("Hour: " + time2.getHour() + " Minute: " +
                       time2.getMinute() + " Second: " + time2.getSecond());
  }
}


 
class Time{
	private int hour = 0;
	private int minute = 0;
	private int second = 0;
	
	Time(){
		hour = (int) ((System.currentTimeMillis() / (1000 *60 * 60)) % 24);
		minute = (int) ((System.currentTimeMillis() / (1000 * 60)) % 60);
		second = (int) (System.currentTimeMillis() / 1000) % 60 ;
	}
	
	Time(int d){
		hour = (int) ((d / (1000 *60 * 60)) % 24);
		minute = (int) ((d / (1000 * 60)) % 60);
		second = (int) (d / 1000) % 60 ;
	}
	
	Time(int h, int m, int s){
		hour = h;
		minute = m;
		second = s;
	}
	
	public int getHour(){
		return hour;
	}
	
	public int getMinute(){
		return minute;
	}
	
	public int getSecond(){
		return second;
	}
	
	public void setTime(long elapseTime){
		hour = (int) ((elapseTime / (1000 *60 * 60)) % 24);
		minute = (int) ((elapseTime / (1000 * 60)) % 60);
		second = (int) (elapseTime / 1000) % 60 ;
	}
}
	
