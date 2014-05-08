/*Michael Blackburn
  CSCI 221
  Exercise10_05.java*/
  
/*This program creates a class for factoring the prime numbers from an integer. StackOfIntegers.class copied from website materials.*/

import java.util.Scanner;

public class Exercise10_05{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a positive integer to factor: ");
		int num = input.nextInt();
		StackOfIntegers factorArray = factor(num);
		System.out.println("The factors for " + num + " is");
		for (int i = factorArray.getSize() - 1; i >= 0; i--)
			System.out.print(factorArray.element(i) + " ");
		System.out.println(); 
	}
	
	public static StackOfIntegers factor(int num){
		int n = num;
    	StackOfIntegers factors = new StackOfIntegers();
    	for (int i = 2; i <= n; i++) {
      		while (n % i == 0) {
        		factors.push(i);
        		n /= i;
      		}
    	}
    	return factors;
	}
}

class StackOfIntegers {
  private int[] elements;
  private int size;
  public static final int DEFAULT_CAPACITY = 16;

  /** Construct a stack with the default capacity 16 */
  public StackOfIntegers() {
    this(DEFAULT_CAPACITY);
  }

  /** Construct a stack with the specified maximum capacity */
  public StackOfIntegers(int capacity) {
    elements = new int[capacity];
  }

  /** Push a new integer into the top of the stack */
  public void push(int value) {
    if (size >= elements.length) {
      int[] temp = new int[elements.length * 2];
      System.arraycopy(elements, 0, temp, 0, elements.length);
      elements = temp;
    }

    elements[size++] = value;
  }

  /** Return and remove the top element from the stack */
  public int pop() {
    return elements[--size];
  }

  /** Return the top element from the stack */
  public int peek() {
    return elements[size - 1];
  }

  /** Test whether the stack is empty */
  public boolean empty() {
    return size == 0;
  }

  /** Return the number of elements in the stack */
  public int getSize() {
    return size;
  }
  
  public int element(int i){
  	return elements[i];
  }
}