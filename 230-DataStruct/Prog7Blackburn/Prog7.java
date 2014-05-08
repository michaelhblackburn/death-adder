/*
 *Michael Blackburn
 *Prog7.java
 *implements/tests the WordPriorityQueue and RankedWord classes
 */
public class Prog7
{
  public static void main(String[] args)
  {
    // Read dictionary of ranked words.
    // Words having higher values are more significant for our application.
    WordDictionary dictionary = new WordDictionary();
    if(!DictionaryReader.read("dictionary.txt", dictionary))
      System.out.println("Failed to read dictionary.txt file.");
    WordPriorityQueue list = new WordPriorityQueue();
    // Read a text message and get an array of words.
    String[] messgWords = WordReader.read("message.txt");
    if(messgWords != null)
    {
      for(int w = 0; w < messgWords.length; w++)
      {
      	// Check if each word in the message is found in the dictionary.
      	// If yes, then lookup that word's rank.
      	if(dictionary.isWord(messgWords[w])){
          System.out.println(messgWords[w] + ": " + 
            dictionary.getRank(messgWords[w]));
          list.insert(messgWords[w], dictionary.getRank(messgWords[w]));
        }

        else
          // Otherwise, print unknown word.
          System.out.println(messgWords[w] + " - unknown word");
      }
    }
    else
      System.out.println("Failed to read message.txt file.");
    System.out.println();
    System.out.println("Words with the highest rank: ");
    for(int i = 0; i < 5; i++){
        RankedWord word = list.remove();
        System.out.println(word.toString());
    }
  }
}
