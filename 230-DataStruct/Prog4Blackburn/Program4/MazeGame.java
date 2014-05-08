import java.util.ArrayList;

public class MazeGame
{
  public static void main(String[] args)
  {
    GameMap map = new GameMap();
    if(MazeReader.read("maze.txt", map))
    {
      ArrayList moveList = new ArrayList();
      MoveReader.read("moves.txt", moveList);
    
      // Continue player as long as our Queue of moves is not empty.
      while(!moveList.isEmpty())
      {
        Move move = (Move)moveList.remove(0);
      
        Player p = map.getPlayer(move.getPlayer());
        if(p != null)
        {
          // Print commentary on outcome of current move.
          System.out.print(p.getSymbol() + " move " + 
            Move.directionToString(move.getDirection()));
          int oldPlayerScore = p.getScore();
          if(map.movePlayer(move))
          {
            if(p.getScore() > oldPlayerScore)
              System.out.println(" - Score!");
            else
              System.out.println(" - good move.");
          }
          else
            System.out.println(" - sorry, cannot make that move.");
          
          // Update display of game board.
          map.print();
          System.out.println("--------------------");
        }
      }// end while loop.
    }// end if read map successfully.
    else
      System.out.println("Sorry, unable to read maze board.");
  }
}
