import java.text.DecimalFormat;
public class LetterFreq implements Comparable<LetterFreq>{
	String letter;
	private int freq;

	
	public LetterFreq(String newLetter){
		letter = newLetter;
		freq = 0;
	}
	public void inc(){
		freq++;
	}
	public int compareTo(LetterFreq other){
		return letter.compareTo(other.toString());
	}
	public String toString(){
		return freq + letter;
	}
	public String LetterIs(){
		return letter;
	}
	public int freqIs(){
		return freq;
	}
	

}

