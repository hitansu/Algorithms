package string;

public class LexicographicalRank {

	public static void main(String[] args) {

		String s= "string";
		System.out.println("Lex rank:: "+findLexicoGraphicalRank(s));
	}
	
	private static int findLexicoGraphicalRank(String s) {
		int l= s.length();
		int fact= fact(l);
		int rank= 1;
		for(int i= 0;i<l;i++) {
			fact= fact/(l-i);
			int noOfSmallChars= countSmallCharacters(s,i,l);
			rank+= noOfSmallChars*fact;
		}
		return rank;
	}

	private static int countSmallCharacters(String s, int i, int j) {
		char c = s.charAt(i);
		int count= 0;
		for(int k= i+1;k<j;k++) {
			if(c>s.charAt(k)) {
				count++;
			}
		}
		return count;
	}

	private static int fact(int l) {
		if(l==0 || l==1) return 1;
		
		return l*fact(l-1);
	}

}
