/*
 * GameMap
 * Represent a two-dimensional game board.
 * The game board is a square array of MAP_SIZE x MAP_SIZE squares.
 * A sample game board is as follows:
################
#A...........$.#
#......#$......#
#...#########..#
#...#..$...$...#
#$..#..........#
##.....#####...#
#......#$......#
#$..#..........#
#...######.....#
#......###.....#
#......#$......#
#$..#..........#
#...#..###.....#
#...#$.#$.....B#
################
 */

public class GameMap
{
  // Map size is a 16 x 16 grid
  private static final int MAP_SIZE = 22;

  private static final int NUM_PLAYERS = 2;

  // Define char symbols that represent the players.
  private static final char PLAYER1_TOKEN = 'A';
  private static final char PLAYER2_TOKEN = 'B';

  // Blank tile symbol - anyone can move into this space.
  private static final char BLANK_TILE = '.';
  // Fence tile symbol - no player can enter this space.
  private static final char FENCE_TILE = '#';  

  // Score token - capture this symbol for points.
  private static final char SCORE_TOKEN = '$';
  // Increase player's score when a score token is captured.
  private static final int  SCORE_TOKEN_VALUE = 10;

  private char[][] myMap;
  private Player[] myPlayers;

  /*
   * GameMap
   * Initialize two-d array to map filled with EMPTY_TILE.
   */
  public GameMap()
  {
    // Allocate two-dimensional board map.
    myMap = new char[MAP_SIZE][MAP_SIZE];
    for(int y = 0; y < MAP_SIZE; y++)
      for(int x = 0; x < MAP_SIZE; x++)
        myMap[x][y] = BLANK_TILE;
      
    // Create Player objects.
    myPlayers = new Player[NUM_PLAYERS];
    myPlayers[0] = new Player(PLAYER1_TOKEN);
    myPlayers[1] = new Player(PLAYER2_TOKEN);
  }
  
  /*
   * getPlayer
   * @param num Given player number >= 0 and < NUM_PLAYERS.
   * @return Player object; else, null if num is not valid.
   */
  public Player getPlayer(int num)
  {
    if(num >= 0 && num < NUM_PLAYERS)
      return myPlayers[num];
    else
      return null;
  }
  
  /*
   * setRow
   * @param rowNum Given row number 0-MAP_SIZE-1, where row 0 is the
   * upper row and row MAP_SIZE-1 is the lowest row of the board.
   * @param row Given string whose length is equal to MAP_SIZE and contains
   * char symbols that initialize one row of the game board.
   * @return true if row number is valid and row contains MAP_SIZE characters
   * and row was updated; else, return false, leaving map unchanged.
   */
  public boolean setRow(int rowNum, String row)
  {
    if(row.length() == MAP_SIZE && rowNum >= 0 && rowNum < MAP_SIZE)
    {
      for(int c = 0; c < MAP_SIZE; c++)
        myMap[rowNum][c] = row.charAt(c);
      return true;
    }
    else return false;
  }

  /* 
   * findPlayer
   * @param player Given player
   * Locate player's symbol in the board and initialize 
   * player's position to the map location where its symbol
   * was found.
   * @return true if player's symbol was found; else, false.
   */
  private boolean findPlayer(Player player)
  {
    for(int y = 0; y < MAP_SIZE; y++)
      for(int x = 0; x < MAP_SIZE; x++)
        if(myMap[y][x] == player.getSymbol())
        {
          player.setXY(x, y);
          return true;
        }
    return false;
  }
  
  /*
   * startPlayers
   * Initialize starting positions of the players by finding each
   * player's symbol in the starting board.
   * For example, if player 'A' symbol is in map square (2,4)
   * then set that player's position to 2, 4.
   * @return true if all player's symbols are found in the map.
   */
  public boolean startPlayers()
  {
    boolean result = true;
    for(int p = 0; p < NUM_PLAYERS; p++)
      result &= findPlayer(myPlayers[p]);

    return result;
  }

  /*
   * movePlayer
   * @param M Given move that identifies the one player who makes the
   *        move and the Direction of movement.
   *        MOVE_LEFT:  decrease x-position by one
   *        MOVE_RIGHT: increase x-position by one
   *        MOVE_DOWN:  increase y-position by one
   *        MOVE_UP:    decrease y-position by one
   * If new player position will be a valid board
   * position x and y are between [0, BOARD_SIZE-1] and
   * the new player position is NOT a FENCE_TILE, then
   * allow the player to occupy that new map square.
   * Enact a valid move by setting the player's old map
   * square to the BLANK_TILE and the new player's square
   * to that player's symbol.
   * Otherwise, if the move is not valid, then make no 
   * change to the board.
   * @return true if valid moves was completed; else, false.
   */
   public boolean movePlayer(Move M)
  {
  boolean isValidMove = false;
  int playerId = M.getPlayer();
  Player player = getPlayer(playerId);
  int playerX = player.getX();
  int playerY = player.getY();
  int playerScore = player.getScore();
  if(playerId >= 0 && playerId < NUM_PLAYERS)
  {
    Move.Direction dir = M.getDirection();
    if(dir == Move.Direction.MOVE_LEFT) {
      if(myMap[playerY][playerX - 1] != '#') {
        if(myMap[playerY][playerX - 1] == '$') {
          player.setScore(playerScore + SCORE_TOKEN_VALUE);
        }
        player.setXY(playerX - 1, playerY);
        myMap[playerY][playerX] = '.';
        myMap[playerY][playerX-1] = player.getSymbol();
        isValidMove = true;
      }
    }
    else if(dir == Move.Direction.MOVE_RIGHT) {
      if(myMap[playerY][playerX + 1] != '#') {
        if(myMap[playerY][playerX + 1] == '$') {
          player.setScore(playerScore + SCORE_TOKEN_VALUE);
        }
        player.setXY(playerX + 1, playerY);
        myMap[playerY][playerX] = '.';
        myMap[playerY][playerX+1] = player.getSymbol();
        isValidMove = true;
      }
    }
    else if(dir == Move.Direction.MOVE_UP) {
      if(myMap[playerY - 1][playerX] != '#') {
        if(myMap[playerY - 1][playerX] == '$') {
          player.setScore(playerScore + SCORE_TOKEN_VALUE);
        }
        player.setXY(playerX, playerY - 1);
        myMap[playerY][playerX] = '.';
        myMap[playerY-1][playerX] = player.getSymbol();
        isValidMove = true;
      }
    }
    else if(dir == Move.Direction.MOVE_DOWN) {
      if(myMap[playerY + 1][playerX] != '#') {
        if(myMap[playerY + 1][playerX] == '$') {
          player.setScore(playerScore + SCORE_TOKEN_VALUE);
        }
        player.setXY(playerX, playerY + 1);
        myMap[playerY][playerX] = '.';
        myMap[playerY+1][playerX] = player.getSymbol();
        isValidMove = true;
      }
    }
    else if(dir == Move.Direction.MOVE_NONE) {
      isValidMove = true;
    }
    }
    return isValidMove;
  }
  /*
   * print
   * Prints the current game board.
   */
  public void print()
  {
    for(int y = 0; y < MAP_SIZE; y++)
    {
      for(int x = 0; x < MAP_SIZE; x++)
        // Note that we use the y-coordinate to select ROW
        // and the x-coordinate the select COLUMN of the two-D array.
        System.out.print(myMap[y][x]);
      System.out.println();
    }
    for(int p = 0; p < NUM_PLAYERS; p++)
      System.out.println(myPlayers[p].getSymbol() + ": " +
        myPlayers[p].getScore());
  }

};
