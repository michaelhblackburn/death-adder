import java.io.*;
// Import to use the StringTokenizer class.
import java.util.StringTokenizer;

public class DictionaryReader
{
  public static boolean read(String filename, WordDictionary dictionary)
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
      
      // readLine method returns value null to signify the end-of-file.
      // An exception is thrown if you try to read past the end-of-file.
      while(line != null)
      {
        StringTokenizer tokenizer = new StringTokenizer(line);
        String wordText = tokenizer.nextToken();	
        String rankText = tokenizer.nextToken();
        if(wordText != null && rankText != null)
        {
          double rankValue = Double.parseDouble(rankText);
          if(dictionary.addEntry(wordText, rankValue))
            System.out.println("Added dictionary entry (" + wordText + ", " +
          	  rankValue + ")");
        }
        
        // Read next line.
        line = reader.readLine();
      }
      
      fileReader.close();  
      
      return true;
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
