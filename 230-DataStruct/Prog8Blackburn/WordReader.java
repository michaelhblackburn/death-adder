import java.io.*;
// Import to use the StringTokenizer class.
import java.util.StringTokenizer;
import java.util.ArrayList;

public class WordReader
{
  public static String[] read(String filename)
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
      
      ArrayList<String> wordList = new ArrayList<String>();
      
      // readLine method returns value null to signify the end-of-file.
      // An exception is thrown if you try to read past the end-of-file.
      String delimiters = " \t\n\r\f;,.!()-_";
      while(line != null)
      {
        StringTokenizer tokenizer = new StringTokenizer(line, delimiters);
        while(tokenizer.hasMoreTokens())
        {
          String word = tokenizer.nextToken();
          wordList.add(word);
        }
        
        line = reader.readLine();
      }
      
      fileReader.close();  

      String[] wordArray = null;
      if(wordList.size() > 0)
      {
      	wordArray = new String[wordList.size()];
      	for(int w = 0; w < wordList.size(); w++)
          wordArray[w] = (String)wordList.get(w);
      }
      return wordArray;
    }
    catch(Exception ex)
    {
      // Try running this program once with an invalid file name to see
      // what happens here.
      System.out.println(ex.getMessage());
    }
    return null;
  }
}
