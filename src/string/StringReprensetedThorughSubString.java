package string;

/**
 * Find if a given string can be represented from a substring by iterating the substring “n” times
Given a string ‘str’, check if it can be constructed by taking a substring of it and appending multiple copies of the substring together.

Examples:

Input: str = "abcabcabc"
Output: true
The given string is 3 times repetition of "abc"

Input: str = "abadabad"
Output: true
The given string is 2 times repetition of "abad"

Input: str = "aabaabaabaab"
Output: true
The given string is 4 times repetition of "aab"

Input: str = "abcdabc"
Output: false
Source: Google Interview Question

{@link http://www.geeksforgeeks.org/find-given-string-can-represented-substring-iterating-substring-n-times/}
 * @author jenah
 *
 */
public class StringReprensetedThorughSubString {

	public static void main(String[] args) {

		String s= "abcabc";
		int i= findSubstring(s);
		String msg= i==-1 ?s+" cant be represented": s+" can be representes as:: "+s.substring(0,i);
		System.out.println(msg);
		
		
		s= "abadabad";
		i= findSubstring(s);
		msg= i==-1 ?s+" cant be represented": s+" can be representes as:: "+s.substring(0,i);
		System.out.println(msg);
		
		s= "aabaabaabaab";
		i= findSubstring(s);
		msg= i==-1 ?s+" cant be represented": s+" can be representes as:: "+s.substring(0,i);
		System.out.println(msg);
		
		s= "abcdabc";
		i= findSubstring(s);
		msg= i==-1 ?s+" cant be represented": s+" can be representes as:: "+s.substring(0,i);
		System.out.println(msg);
		
		s= "ABCABCABCABCABC";
		i= findSubstring(s);
		msg= i==-1 ?s+" cant be represented": s+" can be representes as:: "+s.substring(0,i);
		System.out.println(msg);
		
	}

	private static int findSubstring(String s) {
		int strtIndex= 0;
		for(int i= 1;i<s.length();i++) {
			if(s.charAt(i)== s.charAt(strtIndex)) {
				if(checkForNext(s, strtIndex, i)) {
					return i;
				}
			}
		}
		return -1;
	}

	private static boolean checkForNext(String s, int strtIndex, int i) {
		int finish= i;
		while(strtIndex< finish && i<s.length()) {
			if(s.charAt(strtIndex)!= s.charAt(i)) {
				return false;
			}
			i++;
			strtIndex++;
		}
		
		String sub= s.substring(0, finish);
		int lsub= sub.length();
		int lmain= s.length();
		int repeat= lmain/lsub;
		int index= 0;
		String str= "";
		while(index<repeat) {
			str+= sub;
			index++;
		}
		return str.equals(s);
	}

}
