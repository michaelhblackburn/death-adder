/*Michael Blackburn
  CSCI 221
  Exercise04_19.java*/
  
//This program prints a pyramid constructed of numbers that are powers of 2

public class Exercise04_19{
	public static void main(String[] args){
		for (int i = 0; i < 9; i++){
			int power = 0;
			for (int k = 9; k >= i; k--){
				System.out.print("  ");
			}
			for (int j = 0; j < i; j++){
				System.out.print(" " + (int)Math.pow(2, power));
				power++;
				
			}
			for (int j = 1; j < i; j++){
				power--;
				System.out.print(" " +(int)Math.pow(2, power-1));
			}
			System.out.println(" ");
		}	
	}
}