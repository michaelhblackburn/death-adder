import java.io.*;
// Import to use the StringTokenizer class.
import java.util.StringTokenizer;
import java.util.ArrayList;

public class DuckReader
{
  public static int[] read(String filename)
  {
    int[] duckArray = null;
    ArrayList duckList = new ArrayList();
    
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
      if(line != null)
      {
        StringTokenizer tokens = new StringTokenizer(line);
        while(tokens.hasMoreTokens())
        {
          String tok = tokens.nextToken();
          int coord = Integer.parseInt(tok);
          Integer iCoord = new Integer(coord);
          duckList.add(iCoord);
        }
        if(duckList.size() > 0)
        {
          duckArray = new int[duckList.size()];
          for(int i = 0; i < duckList.size(); i++)
          {
            Integer dInt = (Integer)duckList.get(i);
            duckArray[i] = dInt.intValue();
          }
        }// end if duck list is not empty.
      }// end if line is not null.
    }
    catch(Exception ex)
    {
      // Try running this program once with an invalid file name to see
      // what happens here.
      System.out.println(ex.getMessage());
    }
    return duckArray;
  }
}
