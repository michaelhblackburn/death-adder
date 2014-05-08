/*Michael Blackburn
  CSCI 221
  Exercise10_21.java*/
  
/*This program finds the first ten numbers greater than Long.MAX_VALUE that are divisible by 5 or 6.*/

import java.math.BigInteger;

public class Exercise10_21{
	public static void main(String[] args){
		BigInteger bi1 = BigInteger.valueOf(Long.MAX_VALUE);
		BigInteger bi5 = new BigInteger("5");
		BigInteger bi0 = new BigInteger("0");
		//System.out.println("The first ten numbers greater than Long.MAX_VALUE " +
						   //"that are divisible by 5 or 6 are: :");
		int total = 0;
		int count = 0;
		while (total < 10){
			BigInteger bic = new BigInteger(Integer.toString(count));
			BigInteger bi1c = bi1.add(bic);
			if (bi1c.mod(bi5).equals(bi0)){	
				System.out.println(bi1c);
				total++;
			}
			count++;
    	}
	}
}