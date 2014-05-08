import java.util.ArrayList;

public class BalloonGame
{
  public static void main(String[] args)
  {
    int[] duckCoords = DuckReader.read("ducks.txt");
    if(duckCoords != null)
    {
      System.out.println("Here come the ducks!  Quack! Quack!");
      for(int i = 0; i < duckCoords.length; i++)
        System.out.print(duckCoords[i] + "  ");
    }
    else
    {
      System.out.println("No ducks read.  No game today.");
      System.exit(0);
    }
      
    System.out.println();
    System.out.println("Here come the water balloons!");
    
    ArrayList tossList = TossReader.read("balloons.txt");
    for(int t = 0; t < tossList.size(); t++)
    {
      Toss toss = (Toss)tossList.get(t);
      System.out.println("Toss " + toss.getCoord() + ", " + toss.getRadius());
    }
  }
}