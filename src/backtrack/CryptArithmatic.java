package backtrack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CryptArithmatic {

	public static void main(String[] args) {

		String a= "SEND";
		String b= "MORE";
		String result= "MONEY";
		
		Map<Character, Integer> map= solve(a, b, result);
		if(map== null) {
			System.out.println("Not able to find solution");
		} else {
			printSol(map);
		}
	}

	private static Map<Character, Integer> solve(String a, String b, String result) {
		List<Character> distinctChar= getDistinctChars(a, b, result);
		Map<Character, Integer> map= new HashMap<>();
		int size= distinctChar.size();
		for(int i= 0;i<size;i++) {
			Map<Integer, Void> numberCheck= new HashMap<>();
			if(isSolvable(a,b,result,i,map,numberCheck,distinctChar)) {
				return map;
			}
		}
		return null;
	}

	private static void printSol(Map<Character, Integer> map) {
		Set<Character> keySet = map.keySet();
		for(Character c: keySet) {
			System.out.println(c+" : "+map.get(c));
		}
	}

	private static boolean isSolvable(String a, String b, String result, int index, Map<Character, Integer> map,
			Map<Integer, Void> numberCheck, List<Character> distinctChar) {

		if(map.size()== distinctChar.size()) {
			if(isSolved(a,b,result,map)) {
				return true;
			} else {
				return false;
			}
		}
		
		for(int i= 0;i<10;i++) {
			if(!numberCheck.containsKey(i)) {
				numberCheck.put(i, null);
				map.put(distinctChar.get(index), i);
				if(isSolvable(a, b, result, index+1, map, numberCheck, distinctChar)) {
					return true;
				}
				map.remove(distinctChar.get(index));
				numberCheck.remove(i);
			}
		}
		return false;
	}

	private static boolean isSolved(String a, String b, String result, Map<Character, Integer> map) {
		int sumA = 0, sumB = 0, sumResult = 0;
		char[] chArr= a.toCharArray();
		for(Character c: chArr) {
			sumA+= map.get(c);
		}
		chArr= b.toCharArray();
		for(Character c: chArr) {
			sumB+= map.get(c);
		}
		chArr= result.toCharArray();
		for(Character c: chArr) {
			sumResult+= map.get(c);
		}
		return sumA+sumB== sumResult;
	}

	private static List<Character> getDistinctChars(String a, String b, String result) {
		Set<Character> set= new HashSet<>();
		List<Character> distinctChars= new ArrayList<>();
		char[] chArr= a.toCharArray();
		for(Character c: chArr) {
			if(set.add(c)) {
				distinctChars.add(c);
			}
		}
		chArr= b.toCharArray();
		for(Character c: chArr) {
			if(set.add(c)) {
				distinctChars.add(c);
			}
		
		}
		chArr= result.toCharArray();
		for(Character c: chArr) {
			if(set.add(c)) {
				distinctChars.add(c);
			}
		
		}
		
		return distinctChars;
	}

}
