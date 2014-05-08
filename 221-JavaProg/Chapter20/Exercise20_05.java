/*Michael Blackburn
  CSCI 221
  Exercise20_05.java*/
  
/*This program uses a recursive method to calculate the sum of a series of fractions.*/

public class Exercise20_05{
	public static void main(String[] args){
		System.out.println(m(1));
		System.out.println(m(2));
		System.out.println(m(3));
		System.out.println(m(4));
		System.out.println(m(5));
		System.out.println(m(6));
		System.out.println(m(7));
		System.out.println(m(8));
		System.out.println(m(9));
		System.out.println(m(10));
	}
	
	public static double m(double i){
		//base case
		if (i == 1)
			return (i / ((2 * i) + 1));
		return (i /((2 * i) + 1)) + (m(i - 1));
	}
}