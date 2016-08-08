package string;

import java.util.Arrays;

public class PrintAllAnagramsTogether {

	public static void main(String[] args) {
		String[] strs= {"cat", "dog", "tac", "god", "act"};
		EachString[] returnAnagrams = returnAnagrams(strs);
		for(EachString s: returnAnagrams) {
			System.out.print(s.str+" ");
		}
	}
	
	private static EachString[] returnAnagrams(String[] s) {
		int l= s.length;
		EachString[] each= new EachString[l];
		int index= 0;
		for(String s1: s) {
			each[index]= new EachString(sort(s1), index);
			index++;
		}
		
		Arrays.sort(each);
		for(int i= 0;i<l;i++) {
			each[i].str= s[each[i].index];
		}
		return each;
	}
	
	private static String sort(String s1) {
		char[] ch= s1.toCharArray();
		Arrays.sort(ch);
		return new String(ch);
	}

	static class EachString implements Comparable<EachString>{
		 String str;
		 int index;
		
		public EachString(String str, int index) {
			this.str= str;
			this.index= index;
		}

		@Override
		public int compareTo(EachString that) {
			return this.str.compareTo(that.str);
		}
	}

}
