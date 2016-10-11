package string;

import java.util.HashMap;
import java.util.Map;

public class RecursivelyRemoveAdjChars {

	public static void main(String[] args) {
		String s= "ABCCBCBA";
		System.out.println(removeChars(s));
		s= "ABCCBA";
		System.out.println(removeChars(s));
		s= "AAA";
		System.out.println(removeChars(s));
	
		
	}
	
	
	private static String removeChars(String s) {
		int n= s.length();
		int i= 0;
		int j= 1;
		Map<Integer, Boolean> mark= new HashMap<>();
		while(j<n) {
			if(s.charAt(i)== s.charAt(j)) {
				mark.put(i, true);
				mark.put(j, true);
				if(i== 0) {
					i= j+1;
					j= i+1;
				} else {
					i= i-1;
					j= j+1;
				}
			} else {
				i= j;
				j= j+1;
			}
		}
		
		String str= "";
		for(int k= 0;k<n;k++) {
			if(!mark.containsKey(k)) {
				str+= s.charAt(k);
			}
		}
		return str;
	}

}
