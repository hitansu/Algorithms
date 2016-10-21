package dp;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstring {
	
	static int result= Integer.MIN_VALUE;
	static int result1= 0, result2= 0, result3= 0;
	static Map<Cache, Integer> cache= new HashMap<>();
	
	public static void main(String[] args) {
		String s1= "iSio";
		String s2= "SixSio";
		
    	s1= "OldSite:GeeksforGeeks.org";
		s2= "NewSite:GeeksQuiz.com";
		LongestSubstring problem= new LongestSubstring();
		problem.findMaxLength(s1, s2, 0, 0, 0);
		System.out.println(result);
	}
	
	public void findMaxLength1(String s1, String s2, int i, int j, int interMediateResult) {
		System.out.println("i: "+i+ "   "+"j: "+j+"  "+"intr: "+interMediateResult+"  "+"res: "+result);
		
		if(i> s1.length()-1 || j> s2.length()-1) return ;
		
		if(s1.charAt(i)== s2.charAt(j)) {
			result1+= 1;
			findMaxLength1(s1, s2, i+1, j+1, result1);
			
		} else {
			if(result< result1) result= result1;
			result1= 0;
			findMaxLength1(s1, s2, i+1, j, 0);
			findMaxLength1(s1, s2, i, j+1, 0);
		}
		
		if(result< result1) result= result1;
		
		result1= 0;
		
	}
	
	public void findMaxLength(String s1, String s2, int i, int j, int result1) {
		Cache c= new Cache(i,j);
		System.out.println(i+", "+j +"  "+result1 + "  ca: "+cache.get(c));
		if(cache.containsKey(c)) {
			int cacheResult= cache.get(c);
			if(result< result1+cacheResult) result= result1+cacheResult;
			cache.put(c, result);
			return;
		}
		
		if(i> s1.length()-1 || j> s2.length()-1) return ;
		
		if(s1.charAt(i)== s2.charAt(j)) {
			result1+= 1;
			cache.put(c, result1);
			findMaxLength(s1, s2, i+1, j+1, result1);
			
		} else {
			cache.put(c, result1);
			/*	if(result< result1) result= result1;
			result1= 0;*/
			findMaxLength(s1, s2, i+1, j, 0);
			findMaxLength(s1, s2, i, j+1, 0);
		}
		
		cache.put(c, result1);
		if(result< result1) result= result1;
		//cache.put(c, result);
		result1= 0;
		
	}
	
	class Cache {
		int i;
		int j;
		
		public Cache(int i, int j) {
			this.i= i;
			this.j= j;
		}
		
		@Override
		public int hashCode() {
			int result= 31;
			result= result*31+i*31+j;
			return result;
		}
		
		@Override
		public boolean equals(Object obj) {
			Cache that= (Cache)obj;
			if(that.i== this.i && that.j== this.j) return true;
			return false;
		}
	}
}
