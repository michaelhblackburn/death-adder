public class Ticket
{
  private int myKey;

  public Ticket()
  {
    myKey = 0;
  }


  public Ticket(int k)
  {
    myKey = k;
  }

  public int getKey()
  {
    return myKey;
  }

  public String toString()
  {
    return "Key: " + myKey;
  }
}
