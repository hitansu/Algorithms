package string;

public class PrintAllSentencesFromWords {

	public static void main(String[] args) {

		String[][] words= {
							{"you", "we"},
							{"have", "are"},
							{"sleep", "eat", "drink"}
								
						  };
		
		printAllSentences(words, "", 0);
	}

	private static void printAllSentences(String[][] words, String prefix, int i) {

		if(words.length== i) {
			System.out.println(prefix);
			return;
		}
		String[] strs= words[i];
		i= i+1;
		int l= strs.length;
		for(int j= 0;j<l;j++) {
			printAllSentences(words, prefix+" "+strs[j], i);
		}
	}

}
