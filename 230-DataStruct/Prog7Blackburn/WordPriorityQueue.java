/*
 *Michael Blackburn
 *WordPriorityQueue.java
 *provides class and methods for implementing a max heap for a list of ordered RankedWord objects
 *provides mothods for inserting and removing objects form list
 *provides a default constructor for creating an empty max heap
 */
public class WordPriorityQueue{
	//class attributes
	private static final int MAX_SIZE = 1023;
	private RankedWord[] wordList;
	private int count;
	//default constructor
	public WordPriorityQueue(){
		wordList = new RankedWord[MAX_SIZE];
		count = 0;
	}
	/*
	 *isEmpty()
	 *returns true if the heap is empty; else, returns false
	 *@param: none
	 *@return: returns true if the list is empty; else, returns false
	 *post-condition: none
	 */
	public boolean isEmpty(){
		if(count == 0){
			return true;
		}
		else{
			return false;
		}
	}
	/*
	 *isFull()
	 *returns true if the heap is full; else, returns false
	 *@param: none
	 *@return: returns true if the list is full; else, returns false
	 *post-condition: none
	 */
	public boolean isFull(){
		if(count == MAX_SIZE){
			return true;
		}
		else{
			return false;
		}
	}
	/*
	 *insert()
	 *inserts a RankedWord object into a heap, returns true if inserted and false if not
	 *@param: a String object and a double for word rank
	 *@return: returns true if object was successfully inserted into the list; else, returns false
	 *post-condition: if successful, RankedWord object is inserted into the heap at the proper position
	 */
	public boolean insert(String w, double r){
		if(!isFull()){
			RankedWord temp = new RankedWord(w, r);
			int index = count;
			int hole = index;
			while (hole > 0 && r > wordList[(hole - 1) / 2].getRank()){
				wordList[hole] = wordList[(hole - 1) / 2];
				hole = (hole - 1) / 2;
			}
			wordList[hole] = temp;
			count++;
			return true;
		}
		else{
			return false;
		}
	}
	/*
	 *remove()
	 *removes the object at the top of the heap and returns it to the user
	 *@param: none
	 *@return: returns the RankedWord object at the top of the heap
	 *post-condition: highest ranked item is removed from the list, and the list is 
	 *reordered with a new highest object
	 */
	public RankedWord remove(){
		if(!isEmpty()){
			double maxValue = wordList[0].getRank();
			RankedWord temp = wordList[0];
			wordList[0] = wordList[count - 1];
			count--;
			int hole = 0;
			int child;
			RankedWord temp2 = wordList[hole];
			while(hole * 2 + 1 < count){
				child = 2 * hole + 1;
				if(child != count && wordList[child + 1].getRank() > wordList[child].getRank()){
					child++;
				}
				if(wordList[child].getRank() > temp2.getRank()){
					wordList[hole] = wordList[child];
				}
				else{
					break;
				}
				hole = child;
			}
			wordList[hole] = temp2;
			return temp;
		}
		return null;
	}
}