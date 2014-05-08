/*Michael Blackburn
  CSCI 221
  Exercise09_08.java*/
  
/*This program converts a string of binary numbers to their decimal value.*/

import java.util.Scanner;

public class Exercise09_08{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a binary number to convert to decimal: ");
		String bin = input.nextLine();
		int dec = binaryToDecimal(bin);
		System.out.println(dec);
	}
	
	public static int binaryToDecimal(String binaryString){
		int dec = 0;
    	for(int i = 0; i < binaryString.length(); i++){
        	if(binaryString.charAt(i) == '1'){
         		dec = dec + (int)Math.pow(2, binaryString.length()-1-i);
     		}
		}
		return (int)dec;
	}
}