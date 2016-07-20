package dp;

import java.util.HashMap;
import java.util.Map;

public class PrintMaximumA {

	static Map<Cache, Integer> cache= new HashMap<>();
	public static void main(String[] args) {
		int n= 20;
		long strt= System.currentTimeMillis();
		PrintMaximumA prob= new PrintMaximumA();
		int maxNo = prob.getMaxNoOfA(n);
		System.out.println(maxNo);
		System.out.println("Using loop: "+prob.getMaxNoOfA(n));
		System.out.println("Time taken: "+(System.currentTimeMillis()-strt));
	}
	
	int getMaxNoOfALoop(int n) {
		int[] result= new int[n];
		for(int i= 0;i<6;i++) {
			result[i]= i+1;
		}
		
		for(int i= 6;i<n;i++) {
			result[i]= 0;
			for(int j= i-3;j>= 0;j++) {
				int currResult= (i-j-1)*result[j];
				if(result[i]<currResult) {
					result[i]= currResult;
				}
			}
		}
		
		return result[n-1];
	}
	

	int getMaxNoOfA(int n) {
		if(n<= 6) return n;
		Cache c= new Cache(n);
		if(cache.get(c)!= null) return cache.get(c);
		int max= 0;
		for(int b= n-3;b>=1;b--) {
			int curr= (n-b-1)*getMaxNoOfA(b);
			if(max< curr) {
				max= curr;
			}
		}
		cache.put(c, max);
		return max;
	}
	
	class Cache {
		int n;
		
		public Cache(int n) {
			this.n= n;
		}
		
		@Override
		public int hashCode() {
			return 31*n;
		}
		
		@Override
		public boolean equals(Object obj) {
			Cache that= (Cache) obj;
			return that.n== this.n;
		}
	}
}
