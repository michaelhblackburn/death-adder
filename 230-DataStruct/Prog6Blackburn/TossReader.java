import java.io.*;
// Import to use the StringTokenizer class.
import java.util.StringTokenizer;
import java.util.ArrayList;

public class TossReader
{
  /* TossReader
   * @param filename Given name of text file to read.
   * @return ArrayList of Toss objects or empty list if nothing read.
   */
  public static ArrayList read(String filename)
  {
    ArrayList tossList = new ArrayList();
    
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
      
      // readLine method returns value null to signify the end-of-file.
      // An exception is thrown if you try to read past the end-of-file.
      while(line != null)
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
	      int tossCoord = Integer.parseInt(numStr);
	      
        numStr = tokenizer.nextToken();
        int splashRadius = Integer.parseInt(numStr);

        Toss toss = new Toss(tossCoord, splashRadius);
        tossList.add(toss);
	      
	      // Echo the input line.
	      // System.out.println("Toss: " + tossCoord + " radius " + splashRadius);
	
        // Read next line.
        line = reader.readLine();
      }
      
      fileReader.close();      
    }
    catch(Exception ex)
    {
      // Try running this program once with an invalid file name to see
      // what happens here.
      System.out.println(ex.getMessage());
    }
    
    return tossList;
  }
}
