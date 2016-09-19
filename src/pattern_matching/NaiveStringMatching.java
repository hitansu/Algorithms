package pattern_matching;

/**
 * 
 * @author jenah
 *
 */
public class NaiveStringMatching {

	public static void main(String[] args) {

		String text= "TEST THIS IS A TEST TEXT TEST TEST";
		text= "AABAACAADAABAAABAA";
		text= "ABABDABACDABABCABAB";
		text= "aabcedabcdbabc";
		String pat= "TEST";
		pat= "AABA";
		pat= "ABABCABAB";
		pat= "abc";
		
		findMatchPoint(text, pat);
	}

	private static void findMatchPoint(String text, String pat) {
		char[] tArr = text.toCharArray();
		char[] pArr = pat.toCharArray();
		int lt= tArr.length;
		for(int i= 0;i<lt;i++) {
			 if(match(tArr, i, pArr, 0)) {
				 System.out.println("match found at: "+i);
			 }
		}
	}

	private static boolean match(char[] tArr, int i, char[] pArr, int j) {
		int l= pArr.length;
		for(int index= i;index<i+l;index++) {
			if(tArr[index]!= pArr[j]) {
				return false;
			}
			j++;
		}
		return true;
	}

}
