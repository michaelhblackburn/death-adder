/*
 * Toss
 * Represent the tossing and bursting of a water balloon at a one-dimensional
 * line of targets.
 */
public class Toss
{
  private int myCoord, myRadius;
  
  /*
   * default constructor initializes coordinate and radius to 0.
   */
  public Toss()
  {
    myCoord = myRadius = 0;
  }
  
  /*
   * initializing constructor
   * @param c Given non-negative coordinate of center of water balloon toss.
   * @param r Given postive radius of splash created by this balloon toss.
   */
  public Toss(int c, int r)
  {
    myCoord = c;
    myRadius = r;
  }
  
  /*
   * getCoord
   * @return Center coordinate of balloon splash as non-negative integer.
   */
  public int getCoord() 
  {
    return myCoord;
  }
  
  /*
   * getRadius
   * @return positive radius of the splash created by a water balloon busrt.
   */
  public int getRadius()
  {
    return myRadius;
  }
}