package dp;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringwithoutRepeat {

	public static void main(String[] args) {
	//	String s= "GEEKSFORGEEKS";
	//	String s= "ABDEFGABEF";
	//	String s= "AAAAAAAAAAAAAA";
		String s= "AAAAAAAAAAa";
		LongestSubstringwithoutRepeat sol= new LongestSubstringwithoutRepeat();
		Result result = sol.findMaxLength(s);
		System.out.println(result.max_length);
		System.out.println("The Stirng is:: "+s.substring(result.start, result.start+result.max_length));
	}
	
	Result findMaxLength(String s) {
		int l= s.length();
		int tmpSt= 0;
		int start= 0;
		int length= 0;
		int maxL= Integer.MIN_VALUE;
		Map<Character, Integer> map= new HashMap<>();
		for(int i= 0;i<l;i++) {
			map.put(s.charAt(i), -1);
		}
		
		for(int i= 0;i<l;i++) {
			Character c= s.charAt(i);
			
			if(map.get(c)== -1) {
				length++;
				map.put(c, i);
			} else {
				int index= map.get(c);
				if(i-length> index) {
					length++;
					map.put(c, i);
				} else {
					length= length-(index-start+1);
					length++;
					start= index+1;
					map.put(c, i);

				}
			}
			
			if(length> maxL) {
				maxL= length;
				tmpSt= start;
			}
		}
		
		Result result= new Result();
		result.max_length= maxL;
		result.start= tmpSt;
		return result;
	}
	
	class Result {
		int max_length;
		int start;
	}

}
