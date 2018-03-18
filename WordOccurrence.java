
public class WordOccurrence implements Comparable<WordOccurrence>{
	String word;
	int count;
	
	
	@Override
	public int compareTo(WordOccurrence o) {
		if(count<o.count)
			return 1;
		else if(count == o.count)
			return 0;
		else
			return -1;
	}
	@Override
	public String toString(){
		return String.format(" %-10s : %d ",word,count );
	}

}
