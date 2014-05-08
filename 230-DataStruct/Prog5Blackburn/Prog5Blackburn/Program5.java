/*
 *Michael Blackburn
 *CSCI230
 *Program5.java
 *System information: Type of processor: 2.4 GHz Intel Core i7
 *					  Amount of RAM: 8GB 1600 MHz DDR3
 *					  Number of iterations (N) for loop 1: 10000000
 *					  Number of iterations (N) for loop 2: 100000000
 *					  Number of iterations (N) for loop 3: 1000000000
 *Based on three loops, with increasing values for N in each loop, the circular queue 
 *appears to be faster than the linked list in this exercise.
 */

public class Program5{
	public static void main(String[] args){
		//declare variables
		LinkedIntQueue linkedList = new LinkedIntQueue();
		CircularIntQueue circularList = new CircularIntQueue();
		int N = 10000000;
		int circTot = 0;
		int linkTot = 0;
		String faster = "";
		for (int j = 1; j < 4; j++){
			//fill linked list and circular array with values 1-100, inclusive
			for (int i = 0; i < 100; i++){
				linkedList.insert(i + 1);
				circularList.insert(i + 1);
			}//end loop

			//evaluate elapsed time for linked list
			long startTimeLinked = System.currentTimeMillis();
			for (int i = 0; i < N; i++){
				int x = linkedList.remove();
				linkedList.insert(x);
			}//end loop

			long endTimeLinked = System.currentTimeMillis();
			long elapsedTimeLinked = endTimeLinked - startTimeLinked;
			//evaluate elapsed time for circular array
			long startTimeCircular = System.currentTimeMillis();
			for (int i = 0; i < N; i++){
				int x = circularList.remove();
				circularList.insert(x);
			}//end loop

			long endTimeCircular = System.currentTimeMillis();
			long elapsedTimeCircular = endTimeCircular - startTimeCircular;
			/*evaluate the ratio of time for the two methods as a double. If the number is 
			 *greater than 1, the circular array is hte faster method; otherwise, the linked list
			 *is faster.
			 */
			double ratio = (double)elapsedTimeLinked / (double)elapsedTimeCircular;
			if (ratio > 1){
				faster = "Circular List";
				circTot++;
			}
			else{
				faster = "Linked List";
				linkTot++;
			}//end if 

			//output of results
			System.out.println("Linked List time, loop " + j + ": " + elapsedTimeLinked);
			System.out.println("Circular List time, loop " + j + ": " + elapsedTimeCircular);
			System.out.println("The time ratio of the two methods is " + String.format("%.2f", ratio) + ", with the " + faster + " being faster.");
			System.out.println("");
			N = N * 10;
		}//end outer loop
		if (circTot > linkTot){
			System.out.println("Overall, the Circular List is faster.");
		}
		else{
			System.out.println("Overall, the Linked List is faster.");
		}
	}
}