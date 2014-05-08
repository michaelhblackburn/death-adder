/*Michael Blackburn
  CSCI 221
  Exercise10_03.java*/
  
/*This program creates and test a class for various functions of integers.*/

public class Exercise10_03 {
  public static void main(String[] args) {
    MyInteger n1 = new MyInteger(5);
    System.out.println("n1 is even? " + n1.isEven());
    System.out.println("n1 is prime? " + n1.isPrime());
    System.out.println("15 is prime? " + MyInteger.isPrime(15));

    char[] chars = {'3', '5', '3', '9'};
    System.out.println(MyInteger.parseInt(chars));

    String s = "3539";
    System.out.println(MyInteger.parseInt(s));
    
    MyInteger n2 = new MyInteger(24);
    System.out.println("n2 is odd? " + n2.isOdd());
    System.out.println("45 is odd? " + MyInteger.isOdd(45));
    System.out.println("n1 is equal to n2? " + n1.equals(n2));
    System.out.println("n1 is equal to 5? " + n1.equals(5));
    
  }
}

class MyInteger{
	private int value = 0;
	
	MyInteger(int i){
		value = i;
	}
	
	public int getMyInteger(){
		return value;
	}
	
	public boolean isEven(){
		if (this.value % 2 == 0)
			return true;
		else
			return false;
	}
	
	public boolean isOdd(){
		if (this.value % 2 != 0)
			return true;
		else
			return false;
	}
	
	public boolean isPrime() {
    	if (this.value % 2 == 0) 
    		return false;
    	for(int i = 3; i * i <= this.value; i += 2){
        	if(this.value % i == 0)
            	return false;
    	}
    	return true;
	}
	
	public static boolean isEven(int i){
		if (i % 2 == 0)
			return true;
		else
			return false;
	}
	
	public static boolean isOdd(int i){
		if (i % 2 != 0)
			return true;
		else
			return false;
	}
	
	public static boolean isPrime(int i) {
    	if (i % 2 == 0) 
    		return false;
    	for(int j = 3; j * j <= i; j += 2){
        	if(i % j == 0)
            	return false;
    	}
    	return true;
	}
	
	public boolean isEven(MyInteger m){
		if (m.getMyInteger() % 2 == 0)
			return true;
		else
			return false;
	}
	
	public boolean isOdd(MyInteger m){
		if (m.getMyInteger() % 2 != 0)
			return true;
		else
			return false;
	}
	
	public boolean isPrime(MyInteger m) {
    	if (m.getMyInteger() % 2 == 0) 
    		return false;
    	for(int i = 3; i * i <= m.getMyInteger(); i += 2){
        	if(m.getMyInteger() % i == 0)
            	return false;
    	}
    	return true;
	}
	
	public boolean equals(int i){
		if (this.value == i)
			return true;
		else
			return false;
	}
	
	public boolean equals(MyInteger m){
		if (this.value == m.getMyInteger())
			return true;
		else
			return false;
	}
	
	public static int parseInt(char [] c){
		int number = Integer.parseInt(new String(c));
		return number;
	}
	
	public static int parseInt(String s){
		int number = Integer.parseInt(s);
		return number;
	}
}