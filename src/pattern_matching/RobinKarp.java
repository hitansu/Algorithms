package pattern_matching;

/**
 * 
 * @author jenah
 *
 */
public class RobinKarp {

	static int prime= 31;
	
	public static void main(String[] args) {
		String text= "aabcedabcdbabc";
	//	text= "aaaaaaaaaaaaaaaaaaaaaaaa";
		text= "TEST THIS IS A TEST TEXT TEST TEST";
		String pat= "abc";
		pat= "TEST";
	//	pat= "aa";
		matchPattern(text, pat);
	}
	
	private static void matchPattern(String text, String pat) {
		int patL= pat.length();
		int txtL= text.length();
		long patHash= calculateHash(pat);
		long prevHash= Integer.MIN_VALUE;
		char prevChar = 0;
		long hash;
		String tmp= null;
		for(int i= 0;i<=txtL-patL;i++) {
			tmp= text.substring(i, i+patL);
			if(prevHash== Integer.MIN_VALUE) {
				hash= calculateHash(tmp);
			} else {
				hash= reHash(tmp, prevChar, prevHash);
			}
			if(hash== patHash) {
				if(match(tmp, pat)) {
					System.out.println("The string match found at index: "+i);
				}
			}
			
			prevChar= tmp.charAt(0);
			prevHash= hash;
		}
	}

	private static boolean match(String tmp, String pat) {
		int l= tmp.length();
		for(int i= 0;i<l;i++) {
			if(tmp.charAt(i)!= pat.charAt(i)) {
				return false;
			}
		}
		return true;
	}

	private static long reHash(String tmp, char prevChar, long prevHash) {
		long hash= (int) (prevHash-(int)prevChar);
		hash= hash/prime;
		hash= (long) (hash+(tmp.charAt(tmp.length()-1)*Math.pow(prime, tmp.length()-1)));
		return hash;
	}

	private static long calculateHash(String pat) {
		int l= pat.length();
		long hash= pat.charAt(0);
		for(int i= 1;i<l;i++) {
			hash+= pat.charAt(i)*Math.pow(prime, i);
		}
		return hash;
	}
}
