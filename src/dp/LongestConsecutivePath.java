package dp;

import static java.lang.Integer.MIN_VALUE;

import java.util.HashMap;
import java.util.Map;

/**
 * Here I am just giving the index by myself.
 * It can be modified to search for the index of a letter and call the methods.
 * @author jenah
 *
 */
public class LongestConsecutivePath {
	Map<Cache, Integer> cache1= new HashMap<>();
	Map<Cache, String> cache2= new HashMap<>();
	
	public static void main(String[] args) {
		char[][] arr= { {'a', 'c', 'd'},
                        {'h', 'b', 'e'},
                        {'i', 'g', 'f'}
                      };
		
		LongestConsecutivePath prob= new LongestConsecutivePath();
		int pathLength = prob.findLongestConsecutivePath(arr,0 ,0 , MIN_VALUE, MIN_VALUE);
		String str = prob.findLongestConsecutiveString(arr,0 ,0 , MIN_VALUE, MIN_VALUE);
		System.out.println(pathLength);
		System.out.println("The string is:: "+str+" & its length is:: "+str.length());
		prob.invalidateCache();
		
		pathLength = prob.findLongestConsecutivePath(arr,1 ,2 , MIN_VALUE, MIN_VALUE);
		str = prob.findLongestConsecutiveString(arr,1 ,2 , MIN_VALUE, MIN_VALUE);
		System.out.println(pathLength);
		System.out.println("The string is:: "+str+" & its length is:: "+str.length());
		prob.invalidateCache();
		
		pathLength = prob.findLongestConsecutivePath(arr,1 ,1 , MIN_VALUE, MIN_VALUE);
		str = prob.findLongestConsecutiveString(arr,1 ,1 , MIN_VALUE, MIN_VALUE);
		System.out.println(pathLength);
		System.out.println("The string is:: "+str+" & its length is:: "+str.length());
		prob.invalidateCache();
		
		pathLength = prob.findLongestConsecutivePath(arr,2 ,2 , MIN_VALUE, MIN_VALUE);
		str = prob.findLongestConsecutiveString(arr,2 ,2 , MIN_VALUE, MIN_VALUE);
		System.out.println(pathLength);
		System.out.println("The string is:: "+str+" & its length is:: "+str.length());
		
	}
	
	
	private void invalidateCache() {
		cache1= new HashMap<>();
		cache2= new HashMap<>();	
	}

	boolean isAllowed(char[][] arr, int i, int j) {
		if(i== Integer.MIN_VALUE || j== Integer.MIN_VALUE) return true;
		if(i<0 || i>= arr.length || j<0 || j>= arr[0].length) {
			return false;
		}
		return true;
	}
	
	int findLongestConsecutivePath(char[][] arr, int i, int j, int prevI, int prevJ) {
		Cache key= new Cache(i, j, prevI, prevJ);
		if(cache1.get(key)!= null) return cache1.get(key);
		if(!isAllowed(arr, i, j)) {
			return 0;
		}
		if(prevI!= Integer.MIN_VALUE && prevJ!= Integer.MIN_VALUE && arr[i][j]-arr[prevI][prevJ]!= 1) {
			return 0;
		}
		int res= 0;
		res= Math.max(res, 1+findLongestConsecutivePath(arr, i, j-1,i,j));
		res= Math.max(res, 1+findLongestConsecutivePath(arr, i, j+1,i,j));
		res= Math.max(res, 1+findLongestConsecutivePath(arr, i+1,j-1,i,j));
		res= Math.max(res, 1+findLongestConsecutivePath(arr, i+1,j,i,j));
		res= Math.max(res, 1+findLongestConsecutivePath(arr, i+1,j+1,i,j));
		res= Math.max(res, 1+findLongestConsecutivePath(arr, i-1,j-1,i,j));
		res= Math.max(res, 1+findLongestConsecutivePath(arr, i-1,j,i,j));
		res= Math.max(res, 1+findLongestConsecutivePath(arr, i-1,j+1,i,j));
		
		cache1.put(key, res);
		return res;
	}
	
	String findLongestConsecutiveString(char[][] arr, int i, int j, int prevI, int prevJ) {
		Cache key= new Cache(i, j, prevI, prevJ);
		if(cache2.get(key)!= null) return cache2.get(key);
		if(!isAllowed(arr, i, j)) {
			return "";
		}
		if(prevI!= Integer.MIN_VALUE && prevJ!= Integer.MIN_VALUE && arr[i][j]-arr[prevI][prevJ]!= 1) {
			return "";
		}
		String result= "";
		String s1= ""+arr[i][j]+findLongestConsecutiveString(arr, i, j-1,i,j);
		result= result.length()>s1.length()?result:s1;
		String s2=  ""+arr[i][j]+findLongestConsecutiveString(arr, i, j+1,i,j);
		result= result.length()>s2.length()?result:s2;
		String s3=  ""+arr[i][j]+findLongestConsecutiveString(arr, i+1,j-1,i,j);
		result= result.length()>s3.length()?result:s3;
		String s4=  ""+arr[i][j]+findLongestConsecutiveString(arr, i+1,j,i,j);
		result= result.length()>s4.length()?result:s4;
		String s5=  ""+arr[i][j]+findLongestConsecutiveString(arr, i+1,j+1,i,j);
		result= result.length()>s5.length()?result:s5;
		String s6=  ""+arr[i][j]+findLongestConsecutiveString(arr, i-1,j-1,i,j);
		result= result.length()>s6.length()?result:s6;
		String s7=  ""+arr[i][j]+findLongestConsecutiveString(arr, i-1,j,i,j);
		result= result.length()>s7.length()?result:s7;
		String s8=  ""+arr[i][j]+findLongestConsecutiveString(arr, i-1,j+1,i,j);
		result= result.length()>s8.length()?result:s8;
		
		cache2.put(key, result);
		return result;
		
	}
	
	class Cache {
		int i;
		int j;
		int prevI;
		int prevJ;
		
		public Cache(int i, int j, int prevI, int prevJ) {
			this.i= i;
			this.j= j;
			this.prevI= prevI;
			this.prevJ= prevJ;
		}
		
		@Override
		public int hashCode() {
			int prime= 31;
			int result= prime*i+prime*j+prevI+prevJ;
			return result;
		}
		
		@Override
		public boolean equals(Object obj) {
			Cache that= (Cache) obj;
			if(this.i== that.i && this.j== that.j && this.prevI== that.prevI && this.prevJ== that.prevJ) return true;
			return false;
		}
	}
}
