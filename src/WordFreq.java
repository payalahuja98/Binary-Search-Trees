import java.text.DecimalFormat;
public class WordFreq implements Comparable<WordFreq>{
	String word;
	private int freq;

	DecimalFormat fmt = new DecimalFormat("00000");

	public WordFreq(String newWord){
		word = newWord;
		freq = 0;
	}
	public void inc(){
		freq++;
	}
	public int compareTo(WordFreq other){
		return word.compareTo(other.toString());
	}
	public String toString(){
		return fmt.format(freq) + " " + word;
	}
	public String wordIs(){
		return word;
	}
	public int freqIs(){
		return freq;
	}

}

