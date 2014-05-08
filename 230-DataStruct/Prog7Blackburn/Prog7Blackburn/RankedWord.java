/*
 *Michael Blackburn
 *RankedWord.java
 *creates class for a RankedWord object composed of a String object and a double value representing rank
 *provides accessor meothds for interacting  with class
 *provides a default constructor for an empty object
 *provides constructor for user-defined attributes
 */
public class RankedWord{
	//class attributes
	private String word;
	private double rank;
	//default constructor
	public RankedWord(){
		word = "";
		rank = 0.0;
	}
	//constructor for user-defined attributes
	public RankedWord(String w, double r){
		word = w;
		rank = r;
	}
	/*
	 *getWord()
	 *returns the String object word of the object
	 *@param: none
	 *@return: String object word 
	 *post-condition: none
	 */
	public String getWord(){
		return word;
	}
	/*
	 *setWord()
	 *sets the String word object contained in the RankedWord to the passed-in string value
	 *@param: String object word
	 *@return: none
	 *post-condition: word is set to the the passed-in String object
	 */
	public void setWord(String w){
		word = w;
	}
	/*
	 *getRank()
	 *returns the double value of the RankedWord's rank attribute
	 *@param: none
	 *@return: returns the double value of the RankedWord object
	 *post-condition: none
	 */
	public double getRank(){
		return rank;
	}
	/*
	 *setrank()
	 *sets the double value of the RankedWord object to the passed-in value 
	 *@param: double value r representing the object's rank
	 *@return: none
	 *post-condition: object's rank attribute is set to passed-in value
	 */
	public void setRank(double r){
		rank = r;
	}
	/*
	 *toString()
	 *returns a String representation of the RankedWord object
	 *@param: none
	 *@return: String representation of RankedWord
	 *post-condition: none
	 */
	public String toString(){
		return "Word: " + word + ", Rank: " + rank;
	}
}