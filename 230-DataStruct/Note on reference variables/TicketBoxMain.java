/*
 * Main Demo Driver to test TicketBox Collection class
 */
import java.util.Scanner;

public class TicketBoxMain
{
  public static void main(String[] args)
  {
    Scanner kb = new Scanner(System.in);

    TicketBox tBox = new TicketBox();

    int t = getInput("Let us add a Ticket.");
    Ticket a = new Ticket(t);
    tBox.add(a);

    t = getInput("Let us add a Ticket.");
    Ticket b = new Ticket(t);
    tBox.add(b);

    // At this point tBox's array holds references to
    // two Ticket objects.  Slot 0 refers to the first Ticket.
    // Slot 1 refers to the second Ticket.

    // Create and add third Ticket with two new wrinkles:
    // 1) Since getInput returns an int and Ticket constructor
    //    can receive an int, we can combine two statements.
    // 2) Reference variables (a and b here) can be re-assigned at will.
    //    a now is made to point to this third and newest Ticket object.
    //    Do not fear that our first Ticket object has been lost...
    //    The reference variable in slot 0 of TicketBox is still
    //    pointing to our first Ticket object.
    a = new Ticket( getInput("Let us add a Ticket.") );
    tBox.add(a);

    // Create and add fourth Ticket
    // By combining statements once again, we eliminate the use of
    // temporary place holder variables one for int ticket number
    // and one to refer to a Ticket object.
    //
    // Be careful when applying this trick when it is possible
    // for one of the nested calls to fail, which would send bad input to 
    // the next method. 
    tBox.add( new Ticket( getInput("Let us add a Ticket.") ) );

    // Print contents.
    System.out.println("Here are our tickets...");
    tBox.print();

    if( tBox.isContained( getInput("Let us find a Ticket.") ) )
      System.out.println("Yes, we have that ticket.");
    else
      System.out.println("No, we do not have that ticket.");
    
  }

  // How do I know when to declare a method as static?
  // Since we have not created any "new" TicketBoxMain objects,
  // all of the methods defined within this file are static.
  // Static means that a method or variable exists without
  // us having to create a "new" object.
  // Conversely, all methods of Ticket and TicketBox are
  // not static since these methods all access instance variables
  // that exist only after we have created "new" Tickets or TicketBoxes.
  public static int getInput(String messg)
  {
    Scanner kb = new Scanner(System.in);
    System.out.println(messg);
    System.out.println("Enter ticket number: ");
    int k = kb.nextInt();

    return k;
  }
    
}