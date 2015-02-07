import java.io.*;
import java.util.*;

public class FrequencyList{
	public static void main(String[] args) throws IOException, QueueUnderflowException{
		String word;
		WordFreq wordToTry;
		//WordFreq wordInTree;
		WordFreq wordFromTree;
		
		BinarySearchTree<WordFreq> tree = new BinarySearchTree<WordFreq>(); //tree that all words go into

		int numWords = 0;	//number of words in doc
		int numValidWords = 0;  //number of words that are at least minSize
		int minSize;  //min size that word must be
		int minFreq;  //min times word must appear in doc
		int treeSize = 0; //number of words that satisfy minSize and minFreq

		FileReader file = new FileReader("c:/WORDS.txt");
		Scanner input = new Scanner(file);
		input.useDelimiter("[^a-zA-Z0-9]");
		Scanner con = new Scanner(System.in);
		
		System.out.println("Enter min word size");
		minSize = con.nextInt();
		System.out.println("Enter min frequency");
		minFreq = con.nextInt();
		
	
		while(input.hasNext()){
			word = input.next(); //word = there
			word = word.toLowerCase(); //word = there
			numWords++; //numWords = 6;
			if(word.length() >= minSize){ //5 >= 1
				//numValidWords++;	//numValidWords = 6;
				wordToTry = new WordFreq(word); //wordToTry = there
				if(tree.get(wordToTry) != null){ //0 > 1
						wordToTry.inc();
						tree.add(wordToTry);
					}
					else{
						wordToTry.inc();
					}
				}
				
					numValidWords++;
				
			
		}
		treeSize = tree.reset(BinarySearchTree.INORDER);
	    System.out.println("The words of length " + minSize + " and above,");
	    System.out.println("with frequency counts of " + minFreq + " and above:");
	    System.out.println();
	    System.out.println("Freq  Word");
	    System.out.println("----- -----------------");
	    int numValidFreqs = 0;
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
