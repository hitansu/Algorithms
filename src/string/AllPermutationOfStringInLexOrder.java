package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AllPermutationOfStringInLexOrder {

	public static void main(String[] args) {

		String str= "abac";
		List<String> allPermStringInLexOrder = getAllPermStringInLexOrder(str);
		for(String s: allPermStringInLexOrder) {
			System.out.println(s);
		}
		System.out.println("*************");
		char[] chs= str.toCharArray();
		Arrays.sort(chs);
		String sortedStr= new String(chs);
		lex(sortedStr, "", 0, str.length(), new HashSet<String>(), new HashSet<Integer>());
	}
	
	static List<String> getAllPermStringInLexOrder(String s) {
		List<String> perms= new ArrayList<>();
		char[] chs= s.toCharArray();
		Arrays.sort(chs);
		s= new String(chs);
		boolean isFinished= false;
		int size= s.length();
		while(!isFinished) {
			perms.add(s);
			chs= s.toCharArray();
			int i;
			for(i= size-2;i>=0;i--) {
				if(s.charAt(i)<s.charAt(i+1)) {
					break;
				}
			}
			if(i== -1) {
				isFinished= true;
			} else {
				int ceilIndex= findCeil(s, i);
				char tmp= chs[ceilIndex];
				chs[ceilIndex]= chs[i];
				chs[i]= tmp;
				Arrays.sort(chs, i+1, chs.length);
				s= new String(chs);
			}
		}
		return perms;
	}

	private static int findCeil(String s, int l) {
		int ceilIndex= l+1;
		int size= s.length();
		for(int i= l+2;i<size;i++) {
			if(s.charAt(l)<s.charAt(i) && s.charAt(i)<s.charAt(ceilIndex)) {
				ceilIndex= i;
			}
		}
		return ceilIndex;
	}
	
	private static void lex(String text, String prefix, int length, int n, Set<String> duplicate, Set<Integer> usedChar) {
		if(length== n) {
			if(duplicate.add(prefix)) {
				System.out.println(prefix);
			}
			return;
		}
			for(int i= 0;i<n;i++) {
				if(!usedChar.add(i)) {
					continue;
				}
				String s= prefix+text.charAt(i);
				lex(text, s, length+1, n, duplicate, usedChar);
				usedChar.remove(i);
			}
	}

}
