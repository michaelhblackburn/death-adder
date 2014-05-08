/*
 *Michael Blackburn and Kenneth Hanson(share credit)
 *Player.java
 *Defines player object for use in GameMaze
 *Defines methods for accessing and manipulating Player class attributes
 *Provides constructor methods for a default constructor and oneo with user-defined parameters
 */
public class Player{
	//define class variables
	public char symbol;
	public int x;
	public int y;
	public int score;
	//default constructor
	public Player(){
		symbol = 'A';
		x = 0;
		y = 0;
		score = 0;
	}
	//constructor for user-defined parameter
	public Player(char sym){
		symbol = sym;
		x = 0;
		y = 0;
		score = 0;
	}
	/*
	 *setXY
	 *sets the X and Y coordinate values for the player with passed-in values
	 *@param: integer values used to set X and Y
	 *return: none
	 *post-condition: X and Y values are set to the integer values passed in from user
	 */
	public void setXY(int xVal, int yVal){
		x = xVal;
		y = yVal;
	}
	/*
	 *setScore
	 *sets player's score to value passed in from user
	 *@param: integer value used to set the score
	 *@return: none
	 *post-condition: score is set to passed in value
	 */
	public void setScore(int s){
		score = s;
	}
	/*
	 *getX
	 *returns value stored for x-coordinate
	 *@param: none
	 *@return: integer value x representing x-coordinate
	 *post-condition: none
	 */
	public int getX(){
		return x;
	}
	/*
	 *getY
	 *returns value stored for y-coordinate
	 *@param: none
	 *@return: integer value y representing x-coordinate
	 *post-condition: none
	 */
	public int getY(){
		return y;
	}
	/*
	 *getSymbol
	 *return character stored in symbol variable
	 *@param: none
	 *@return: char value of symbol variable
	 *post-condition: none
	 */
	public char getSymbol(){
		return symbol;
	}
	/*
	 *getScore
	 *returns integer value stored in score variable
	 *@param: none
	 *@return: returns integer stored in score varaible
	 *post-condition: none
	 */
	public int getScore(){
		return score;
	}
}