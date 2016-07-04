package dp;

import java.util.HashMap;
import java.util.Map;

public class TopToDownWithMaxPath {
	
	public static void main(String[] args) {
		TopToDownWithMaxPath path= new TopToDownWithMaxPath();
		int i= 3, j= 3, k= 2;
		int pathCount = path.countPath(i-1, j-1, k);
		System.out.println(pathCount);
	}
	
	private int countPath(int i, int j, int k) {
		if(i== 0 && j== 0) return 1;
		HashMap<Index, Integer> memo= new HashMap<>();
		return countPathUtils(i, j-1, k, 0, memo)+countPathUtils(i-1, j, k, 1, memo);
	}

	private int countPathUtils(int i, int j, int k, int d, Map<Index, Integer> memo) {
		Index index= new Index(i, j, k, d);
		if(memo.containsKey(index)) return memo.get(index);
		if(i<0 || j<0) return 0;
		if(i== 0 && j== 0 && k>= 0) return 1;
		if(k== 0) {
			if(d== 0 && i== 0) return 1;
			if(d== 1 && j== 0) return 0;
			
			return 0;
		}
		if(d== 0) {
			int result= countPathUtils(i, j-1, k, 0, memo) + countPathUtils(i-1, j, k-1, 1, memo);
			memo.put(index, result);
			return result;
		}
		int result= countPathUtils(i, j-1, k-1, 0, memo) + countPathUtils(i-1, j, k, 1, memo);
		memo.put(index, result);
		return result;
	}
	
	class Index {
		int i;
		int j;
		int k;
		int d;
		
		public Index(int i, int j, int k, int d) {
			this.d= d;
			this.i= i;
			this.j= j;
			this.k= k;
		}
		
		@Override
		public int hashCode() {
			int result= 31*i;
			result= result+j+k+d;
			return result;
		}
		
		@Override
		public boolean equals(Object obj) {
			Index that= (Index)obj;
			if(that.i== this.i && that.j== this.j && that.k== this.k && that.d== this.d) {
				return true;
			}
			return false;
		}
	}
}
