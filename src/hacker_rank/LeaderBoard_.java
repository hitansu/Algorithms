package hacker_rank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeaderBoard_ {

	public static void main(String[] args) {
		int[] scores= {100, 100, 50, 40, 40, 20, 10};
		int[] alice= {5, 25, 50, 120};
		
		
		
		Integer[] temp= new Integer[scores.length+alice.length];
		Set<Integer> setAlice= new HashSet<>();
		Set<Integer> setScore= new HashSet<>();
		int index= 0;
		for(int i= 0;i<scores.length;i++) {
			temp[index]= scores[i];
			setScore.add(scores[i]);
			index++;
		}
		
		for(int i= 0;i<alice.length;i++) {
			temp[index]= alice[i];
			setAlice.add(alice[i]);
			index++;
		}
		
		Arrays.sort(temp, desc);
		
		List<Integer> distinct= getDistinctNo(temp);
		List<Integer> ranks= new ArrayList<>();
		int[] result= new int[alice.length];
		int rIndex= 0;
		int rank= 0;
		for(int i= 0;i< distinct.size();i++) {
			if(!setAlice.contains(distinct.get(i))) {
				rank= rank+1;
				ranks.add(i, rank);
			} else if(setScore.contains(distinct.get(i))) {
				rank= rank+1;
				ranks.add(i, rank);
			} 
			if(setAlice.contains(distinct.get(i))) {
				ranks.add(i, 0);
				if(i== 0) {
					result[rIndex]= 1;
				} else {
					result[rIndex]= ranks.get(i-1)+1;
				}
				rIndex++;
			}
			
		}
		
		for(int i= result.length-1;i>= 0;i--) {
			System.out.println(result[i]);
		}
	}
	
	
	static Comparator<Integer> desc= new Comparator<Integer>() {
		
		@Override
		public int compare(Integer o1, Integer o2) {
			return o2-o1;
		}
	};

	private static List<Integer> getDistinctNo(Integer[] scores) {
		List<Integer> dist= new ArrayList<>();
		int lastNo= scores[0];
		for(int i= 1;i<scores.length;i++) {
			if(lastNo!= scores[i]) {
				dist.add(lastNo);
				lastNo= scores[i];
			}
		}
		dist.add(lastNo);
		return dist;
	}
}
