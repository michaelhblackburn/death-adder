import java.util.*;

public class WordDictionary
{
  private Map<String, Double> myMap;
  
  /*
   * WordDictionary
   * Default constructor initializes to an empty lookup table.
   */
  public WordDictionary()
  {
    // Create table that retrieves double value associated with a String.
    myMap = new HashMap<String, Double>();
  }
  
  /*
   * addEntry
   * @param word Given String word.
   * @param rank Given numeric rank expected in range [0.0, 1.0].
   * @return true if association of (word, rank) is added; else, false.
   * pre-conditions: word must be non-null and non-empty and
   * rank must be between 0.0 and 1.0, inclusive.
   */
  public boolean addEntry(String word, double rank)
  {
    if(word != null && word.length() > 0 && rank >= 0.0 && rank <= 1.0)
    {
      // convert string to lowercase to enable case insensitve lookups.
      word = word.toLowerCase();
      myMap.put(word, new Double(rank));
      return true;
    }
    else
      return false;
  }
  
  /*
   * isWord
   * @param W Given word as a String.
   * @return true if word W is found in this dictionary (case insensitive);
   * else, return false.
   */
  public boolean isWord(String W)
  {
    // Convert word to lowercase to enable case insensitve lookup.
    W = W.toLowerCase();
    return myMap.containsKey(W);
  }
  
  /*
   * getRank
   * @param W Given word as a String (case insensitive).
   * @return rank value between 0.0 and 1.0.
   * Words not found return a rank of 0.0.
   */
  public double getRank(String W)
  {
    double r = 0.0;
    if(isWord(W))
    {
      Double d = myMap.get(W.toLowerCase());
      r = d.doubleValue();
    }
    return r;
  }
}
