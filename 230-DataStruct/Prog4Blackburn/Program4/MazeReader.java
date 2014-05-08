import java.io.*;
// Import to use the StringTokenizer class.
import java.util.StringTokenizer;
import java.util.ArrayList;

public class MazeReader
{
  public static boolean read(String filename, GameMap maze)
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
        maze.setRow(lineCount, line);
        
        // Read next line.
        line = reader.readLine();
	
	      // Increment line count.
	      lineCount++;
      }
      
      fileReader.close();  
      
      // Must have read entire board and found all player tokens.
      return maze.startPlayers() && numLinesOfInput == lineCount;
    }
    catch(Exception ex)
    {
      // Try running this program once with an invalid file name to see
      // what happens here.
      System.out.println(ex.getMessage());
    }
    return false;
  }
}
