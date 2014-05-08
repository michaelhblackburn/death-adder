/*
 *Michael Blackburn and Kenneth Hanson(share credit)
 *Move.java
 *defines class for player movements in game
 *provides attributes for accessing and manipulating class attributes
 *provides default constructor and constructor for use with user-defined inputs
 */
public class Move{
	//define class variables
	public enum Direction {MOVE_NONE, MOVE_LEFT, MOVE_RIGHT, MOVE_DOWN, MOVE_UP};
	public Direction moveDir;
	public int playerID;
	//default constructor
	public Move(){
		moveDir = Direction.MOVE_NONE;
		playerID = 0;
	}
	//constructor for use with user-defined attributes
	public Move(int player, Direction dir){
		moveDir = dir;
		playerID = player;
	}
	/*
	 *setPlayer
	 *sets the player ID attribute to the integer value passed in
	 *@param: integer N that is passed in from user
	 *@return: none
	 *post-condition: playerID is set to the variable N
	 */
	public void setPlayer(int N){
		playerID = N;
	}
	/*
	 *setDirection
	 *sets moveDir attribute to the Direction object passed in
	 *@param: Direction object D passed in from user
	 *@return: none
	 *post-condition: moveDir is set to the Direction object passed in
	 */
	public void setDirection(Direction D){
		moveDir = D;
	}
	/*
	 *getPlayer
	 *returns the integer value of the playerID attribute
	 *@param: none
	 *@return: integer value of playerID
	 *post-condition: none
	 */
	public int getPlayer(){
		return playerID;
	}
	/*
	 *getDirection
	 *returns the value of the moveDir attribute
	 *@param: none
	 *@return: Direction object stored in moveDir variable
	 *post-condition: none
	 */
	public Direction getDirection(){
		return moveDir;
	}
	/*
	 *directionToString
	 *returns a string representation of dreiction object passed in
	 *@param: Direction object passed in from user
	 *@return: String object representing the direction of the passed-in Direction object
	 *post-condition: none
	 */
	public static String directionToString(Direction D){
		if (D == Direction.MOVE_NONE){
			return "NONE";
		}
		else if(D == Direction.MOVE_LEFT){
			return "LEFT";
		}
		else if(D == Direction.MOVE_RIGHT){
			return "RIGHT";
		}
		else if(D == Direction.MOVE_DOWN){
			return "DOWN";
		}
		else{
			return "UP";
		}
	}
}