/*
 * Example of a Simple Container Class
 * Demonstrates arrays of objects
 */
public class TicketBox
{
  // Define constant maximum number of Tickets to hold.
  private static final int MAX_SIZE = 10;
  private Ticket[] myTickets;
  // Running count of how many Tickets we actually hold.
  private int myCount;

  /*
   * default constructor
   * Initializes to an empty TicketBox.
   */
  public TicketBox()
  {
    // create array to hold up to MAX_SIZE Tickets.
    // All array entries are null at this time.
    myTickets = new Ticket[MAX_SIZE];
    myCount = 0;
  }

  /*
   * add
   * @param T Given Ticket object that has been created
   * using new Ticket() and has had its instance variables
   * initialized.  TicketBox is not responsible for creating
   * a Ticket object.
   * @return true if TicketBox is not full and given Ticket
   * was inserted; else, false.
   */
  public boolean add(Ticket T)
  {
    boolean result = false;
    // Safety checks - add only if
    // box is not full and Ticket reference is not null.
    // Call our isFull method rather than duplicating its code.
    if(!isFull() && T != null)
    {
      // Insert reference that points to Ticket object T
      // into next open array slot.
      myTickets[myCount] = T;
      // Update count of number of Tickets stored.
      myCount++;

      // My examples show the style of saving return values 
      // and having a single return statement as the last line.
      result = true;
    }
    return result;
  }

  /*
   * isFull
   * @return true if the box is full; else, false.
   */
  public boolean isFull()
  {
    return myCount == MAX_SIZE;
  }

  /*
   * isContained
   * @param keyToFind Given key value to seek.
   * @return true if we found a Ticket having the given key value;
   * else, false.
   */
  public boolean isContained(int keyToFind)
  {
    boolean foundIt = false;
    int i = 0;

    // Sequential search until we have examined all stored Tickets
    // and have not yet found a Ticket with the desired key.

    // We must say i < myCount and NOT i < MAX_SIZE since not all
    // array slots hold references to Ticket objects.  Attempting
    // to use a null reference will crash our program.
    while(i < myCount && !foundIt)
    {
      // When comparing array elements that are objects, we must
      // call the appropriate getter method to access the key attribute value.
      if(myTickets[i].getKey() == keyToFind)
        // Set flag that will stop our loop on having found it.
        foundIt = true;
      else
        i++;
    }
    return foundIt;
  }

  /*
   * print
   * Prints all Tickets in the box.
   */
  public void print()
  {
    if(myCount == 0)
      System.out.println("Box is empty");
    else
      for(int i = 0; i < myCount; i++)
        System.out.println(myTickets[i].toString());
 
  }
}