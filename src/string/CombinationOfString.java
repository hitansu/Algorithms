package string;

import java.util.ArrayList;
import java.util.List;

public class CombinationOfString {

	public static void main(String[] args) {

		String s= "abc";
		List<String> combinationOfString = getCombinationOfString("", s);
		for(String str: combinationOfString) {
			System.out.println(str);
		}
		System.out.println(combinationOfString.size());
	}
	
	private static List<String> getCombinationOfString(String prefix, String str) {
		List<String> strs= new ArrayList<String>();
		strs.add(prefix);
		int l= str.length();
		for(int i= 0;i<l;i++) {
			strs.addAll(getCombinationOfString(prefix+str.charAt(i), str.substring(i+1)));
		}
		
		return strs;
	}

}
