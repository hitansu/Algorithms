package array;

import java.util.HashMap;
import java.util.Map;

public class ZigZagArray {

	public static void main(String[] args) {
/*		int[] arr= {4, 3, 7, 8, 6, 2, 1};
		arr= convertToZigZag(arr);
		for(Integer i: arr) {
			System.out.print(i+" ");
		}*/
		
		
		int[] a= { 1, 17, 5, 10, 13, 15, 10, 5, 16, 8 };//1,17,10,13,10,16,8
		
	//	int[] a= { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

		int count= recur(a, 0, a.length-1);
		System.out.println(count);
	}
	
	static int MAX= Integer.MIN_VALUE;
	
	static int recur(int[] arr, int l, int h) {
		Cache c= new Cache(l, h);
		if(cacheMap.containsKey(c)) return cacheMap.get(c);
		if(l== h) {
			return 1;
		}
		if(l>h) return 0;
	
		if(isZigzag(arr, l, h)) {
			cacheMap.put(c, (h-l)+1);
			return (h-l)+1;
		}
		
		int l1= recur(arr, l+1, h);
		int l2= recur(arr, l, h-1);
		int max= Math.max(l1, l2);
		MAX= Math.max(MAX, max);
		cacheMap.put(c, MAX);
		return max;
		
	}
	
	private static boolean isZigzag(int[] a, int l, int h) {

		boolean flag= true; //<
		for(int i= l;i< h;i++) {
			if(flag) {
				if(a[i]>a[i+1]) {
					return false;
				}
			} else {
				if(a[i]<a[i+1]) {
					return false;
				}
			}
			flag= !flag;
		
		}
		return true;
	}
	
	static Map<Cache, Integer> cacheMap= new HashMap<>();

	private static int[] convertToZigZag(int[] a) {
		int l= a.length;
		boolean flag= true; //<
		
		for(int i= 0;i<l-1;i++) {
			if(flag) {
				if(a[i]>a[i+1]) {
					int tmp= a[i+1];
					a[i+1]= a[i];
					a[i]= tmp;
				}
			} else {
				if(a[i]<a[i+1]) {
					int tmp= a[i+1];
					a[i+1]= a[i];
					a[i]= tmp;
				}
			}
			flag= !flag;
		}
		return a;
	}
	
	static class Cache {
		int key1;
		int key2;
		
		public Cache(int key1, int key2) {
			this.key1= key1;
			this.key2= key2;
		}
		
		@Override
		public boolean equals(Object obj) {
			Cache that= null;
			if(obj instanceof Cache) {
				that= (Cache) obj;
			}
			if(that== null) return false;
			if(this.key1!= that.key1 || this.key2!= that.key2) return false;
			
			return true;
		}
		
		@Override
		public int hashCode() {
			int prime= 31;
			int hash= prime*key1+key2*prime+key1;
			return hash;
		}
	}
}
