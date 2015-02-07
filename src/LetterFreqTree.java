import java.io.*;
import java.util.*;

public class LetterFreqTree
{
  public static void main(String[] args) throws IOException, QueueUnderflowException 
  {
    String letter;
    LetterFreq letterToTry;
    LetterFreq letterInTree;
    LetterFreq letterFromTree;

    BinarySearchTree<LetterFreq> tree = new BinarySearchTree<LetterFreq>();
    String skip;        // skip end of line after reading integer

    int numLetters = 0;
    int numvalidLetters = 0;
    int numValidFreqs = 0;
    int minSize;
    int minFreq;
    int treeSize;

    // Set up file reading
    FileReader fin = new FileReader("c:/WORDS.txt");
    Scanner lettersIn = new Scanner(fin);
    lettersIn.useDelimiter("[^a-zA-Z0-9]");  // delimiters are nonletters-digits

    // Set up console reading
    Scanner conIn = new Scanner(System.in);

    //Get word and frequency limits from user
    System.out.print("Minimum word size: ");
    minSize = conIn.nextInt();
    skip = conIn.nextLine();      
    System.out.print("Minimum word frequency: ");
    minFreq = conIn.nextInt();
    skip = conIn.nextLine();      

    while (wordsIn.hasNext())      // while more words to process
    {
      word = wordsIn.next();          
      numWords++;
      if (word.length() >= minSize)
      {
        numValidWords++;
        word = word.toLowerCase();
        wordToTry = new WordFreq(word);
        wordInTree = tree.get(wordToTry);
        if (wordInTree == null)
        {
          // insert new word into tree
          wordToTry.inc();               // set frequency to 1
          tree.add(wordToTry);
        }
        else
        {
          // word already in tree, just increment frequency
          wordInTree.inc();
        }
      }
    }
  
    treeSize = tree.reset(BinarySearchTree.INORDER);
    System.out.println("The words of length " + minSize + " and above,");
    System.out.println("with frequency counts of " + minFreq + " and above:");
    System.out.println();
    System.out.println("Freq  Word");
    System.out.println("----- -----------------");
    for (int count = 1; count <= treeSize; count++)
    {
      wordFromTree = tree.getNext(BinarySearchTree.INORDER);
      if (wordFromTree.freqIs() >= minFreq)
      {
        numValidFreqs++;
        System.out.println(wordFromTree);
      }
    }

    System.out.println();  
    System.out.println(numWords + " words in the input file.  ");
    System.out.println(numValidWords + " of them are at least " + minSize + " characters.");
    System.out.println(numValidFreqs + " of these occur at least " + minFreq + " times.");
    System.out.println("Program completed.");
  } 
} 