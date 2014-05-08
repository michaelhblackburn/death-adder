import java.io.*;
// Import to use the StringTokenizer class.
import java.util.StringTokenizer;
import java.util.ArrayList;

public class MoveReader
{
  public static void read(String filename, ArrayList moveList)
  {
    // Reading a file is "risky" since the file might not exist.
    try
    {
      File theFile = new File(filename);
      
      // A FileReader reads a file one character at a time.
      FileReader fileReader = new FileReader(theFile);
   
      // Connect the FileReader to a BufferedReader for more efficient processing.
      // BufferedReader gives you one whole line at a time.
      BufferedReader reader = new BufferedReader(fileReader);
      
      // Read first line (everything up to the newline or ENTER).
      String line = reader.readLine();
      
      // Expect to have a single integer token on the first line.
      // So convert the String into an integer.
      int numLinesOfInput = Integer.parseInt(line);
      
      // Read next line of text.
      line = reader.readLine();
      
      // Initialize line count.
      int lineCount = 0;
      
      // readLine method returns value null to signify the end-of-file.
      // An exception is thrown if you try to read past the end-of-file.
      while(line != null && lineCount < numLinesOfInput)
      {
	      // Each line of text input is expected to contain exactly two blank-space separated tokens.
	      // <integer> <String>
	      // Initialize a StringTokenizer object for the current line of text.
	      // The tokenizer breaks the line of text into space-delimited Strings.
	      // For example the String "10 kitten" is tokenized into two Strings "10" and "kitten".
	      StringTokenizer tokenizer = new StringTokenizer(line);
        
	      // Since we expect two tokens per line just call nextToken twice.
	      String numStr = tokenizer.nextToken();
	      // First token is expected to be an integer so convert it to integer value.
	      int playerId = Integer.parseInt(numStr);
	
	      String strDir = tokenizer.nextToken();
	      Move.Direction dir = Move.Direction.MOVE_NONE;
	      if(strDir.equalsIgnoreCase("UP"))
	        dir = Move.Direction.MOVE_UP;
	      else if(strDir.equalsIgnoreCase("DOWN"))
	        dir = Move.Direction.MOVE_DOWN;
	      else if(strDir.equalsIgnoreCase("LEFT"))
	        dir = Move.Direction.MOVE_LEFT;
	      else if(strDir.equalsIgnoreCase("RIGHT"))
	        dir = Move.Direction.MOVE_RIGHT;	      
	      
	      Move move = new Move(playerId, dir);
	      moveList.add(move);
	      
	      // Echo the input line.
	      System.out.println("Player: " + playerId + " Moves: " + strDir);
	
        // Read next line.
        line = reader.readLine();
	
	      // Increment line count.
	      lineCount++;
      }
      
      fileReader.close();      
    }
    catch(Exception ex)
    {
      // Try running this program once with an invalid file name to see
      // what happens here.
      System.out.println(ex.getMessage());
    }
  }
}
