import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class AppKeywordFrequencies {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner user= new Scanner(System.in);
		System.out.println("Enter the name of the input Java file:");
		String filename= user.nextLine();
		File file = new File(filename);
		Scanner input= new Scanner(file);
		System.out.println("Keyword Frequencies is Descending Order:");

		ArrayList<WordOccurrence> list= new ArrayList<>();

		HashMap<String,Integer> hash = new HashMap<String,Integer>();

		String[] keywords = {"abstract", "assert", "boolean",
				"break", "byte", "case", "catch", "char", "class", "const",
				"continue", "default", "do", "double", "else", "enum",
				"extends", "for", "final", "finally", "float", "goto",
				"if", "implements", "import", "instanceof", "int",
				"interface", "long", "native", "new", "package", "private",
				"protected", "public", "return", "short", "static",
				"strictfp", "super", "switch", "synchronized", "this",
				"throw", "throws", "transient", "try", "void", "volatile",
				"while", "true", "false", "null"};

		Set<String> set= new HashSet<String>(Arrays.asList(keywords));

		while(input.hasNext()){

			String[] terms= input.next().split("[ \\[,.()\\]]");
			

			for(int k=0; k<terms.length; k++){

				String key = terms[k];
				if(terms[0].contains("//")){
					input.nextLine();
				}
				
				//int index= key.indexOf("//");
				//key=key.substring(0, index-1);

				if (set.contains(key)){
					if(hash.containsKey(key)){
						int i= hash.get(key);
						hash.put(key,i+1);
					}
					else{
						hash.put(key, 1);
					}
				}
			}

		}
		Set<Map.Entry<String,Integer>> entrySet= hash.entrySet();
		for(Map.Entry<String, Integer> entry: entrySet) {
			WordOccurrence o= new WordOccurrence();
			o.word= entry.getKey();
			o.count= entry.getValue();
			list.add(o);
			//System.out.println(entry.getKey() +  " :"+  entry.getValue());
		}	
		Collections.sort(list);
		for(WordOccurrence entry: list) {
			System.out.println(entry);
		}
	}
}
