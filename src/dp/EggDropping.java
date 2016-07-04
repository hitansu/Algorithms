package dp;

import java.util.HashMap;
import java.util.Map;

public class EggDropping {

	static Map<Index, Integer> cache= new HashMap<>();
	public static void main(String[] args) {
		EggDropping eggDropping= new EggDropping();
	//	int findMinCount = eggDropping.findMinEggCount(2, 36);
		int findMinCount = eggDropping.findMinEggCountLoop(2, 36);
	//	int findMinCount= eggDropping.eggDrop(2, 36);
		System.out.println(findMinCount);
	}
	
	int findMinEggCountLoop(int egg, int floor) {
		int[][] result= new int[egg+1][floor+1];
		
		for(int i= 1;i<=egg;i++) {
			result[i][0]= 0;
			result[i][1]= 1;
		}
		
		for(int i= 1;i<=floor;i++) {
			result[1][i]= i;
		}
		
		for(int i= 2;i<=egg;i++) {
			for(int j= 2;j<=floor;j++) {
				result[i][j]= Integer.MAX_VALUE;
				for(int k= 1;k<= j;k++) {
					int res= 1+ Math.max(result[i-1][k-1], result[i][j-k]);
					if(res< result[i][j]) {
						result[i][j]= res;
					}
				}
			}
		}
		
		return result[egg][floor];
	}
	
	int findMinEggCount(int egg, int floor) {
		Index index= new Index(egg, floor);
		if(cache.containsKey(index)) return cache.get(index);
		if(egg== 1) return floor;
		if(floor== 0 ) return floor;
		if(floor== 1) return floor;
		
		int min= Integer.MAX_VALUE;
		int strtFloor= -1;
		for(int i= 1;i<= floor;i++) {
			int result= Math.max(findMinEggCount(egg-1, i-1), findMinEggCount(egg, floor-i));
			if(result<min) {
				min= result;
				strtFloor= i;
			}
		}
		cache.put(index, min+1);
		return min+1;
	}
	
	class Index {
		final int egg;
		final int floor;
		
		public Index(int egg, int floor) {
			this.egg= egg;
			this.floor= floor;
		}
		
		@Override
		public int hashCode() {
			int result= 31;
			result= result*31+egg*31+floor*31;
			return result;
		}
		
		@Override
		public boolean equals(Object obj) {
			Index index= (Index)obj;
			if(index.egg== this.egg && index.floor== this.floor) return true;
			return false;
		}
	}
	
	/* Function to get minimum number of trails needed in worst
	  case with n eggs and k floors */
	int eggDrop(int n, int k)
	{
	    // If there are no floors, then no trials needed. OR if there is
	    // one floor, one trial needed.
	    if (k == 1 || k == 0)
	        return k;
	 
	    // We need k trials for one egg and k floors
	    if (n == 1)
	        return k;
	 
	    int min = Integer.MAX_VALUE, x, res;
	 
	    // Consider all droppings from 1st floor to kth floor and
	    // return the minimum of these values plus 1.
	    for (x = 1; x <= k; x++)
	    {
	        res = Math.max(eggDrop(n-1, x-1), eggDrop(n, k-x));
	        if (res < min)
	            min = res;
	    }
	 
	    return min + 1;
	}
	
	

}
