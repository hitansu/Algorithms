package interview_experience;

import java.util.ArrayList;
import java.util.List;

public class SuperSetOfSet {

	public static void main(String[] args) {
		char[] set= {'a','b','c','d'};
		List<String> superSet= new ArrayList<>();
		findSuperSet(set, "", 0, set.length, superSet);
		System.out.println(superSet.size());
		for(String s: superSet) {
			System.out.println(s);
		}
	}
	
	private static void findSuperSet(char[] set, String prefix, int index, int length, List<String> superSet) {
		superSet.add("{"+prefix+"}");
		if(index>= length) {
			return;
		}
		for(int i= index;i<length;i++) {
			String s= "";
			if(prefix.equals("")) {
				s= prefix+set[i];
			} else {
				s= prefix+","+set[i];
			}
			findSuperSet(set, s, i+1, length, superSet);
		}
		
	}

}
