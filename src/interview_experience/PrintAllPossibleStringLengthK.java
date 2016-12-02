package interview_experience;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PrintAllPossibleStringLengthK {

	public static void main(String[] args) {
		String s= "ab";
		int k= 3;
		char[] result= new char[k];
		List<String> combinations= new  ArrayList<>();
		getCombinations(s.toCharArray(), k, 0, result, combinations);
		for(String comb: combinations) {
			System.out.println(comb);
		}
		combinations.clear();
		System.out.println("***** PERMUTATION *****");
		permute(s, new char[s.length()], 0, s.length(), combinations);

		for(String comb: combinations) {
			System.out.println(comb);
		}
	}

	private static void permute(String str, char[] prefix, int index, int length, List<String> combinations) {
		if(index==length) {
			combinations.add(String.valueOf(prefix));
			return;
		}
		for(int i= 0;i<str.length();i++) {
			prefix[index]= str.charAt(i);
		//	prefix.+= str.charAt(i);
			permute(str, prefix, index+1, length, combinations);
		}
		
	}

	private static void getCombinations(char[] s, int k, int index, char[] result, List<String> combinations) {
		if(index>= k) {
			combinations.add(String.valueOf(result));
			return;
		}
		
		for(int i= 0;i<s.length;i++) {
			result[index]= s[i];
			getCombinations(s, k, index+1, result, combinations);
		}
		
	}

}
