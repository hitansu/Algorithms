package dp;

import java.util.HashMap;
import java.util.Map;

public class MinRemoveElement {

	static Map<Cache, Integer> cacheMap= new HashMap<>();
	public static void main(String[] args) {
		int arr[]= {4, 5, 100, 9, 10, 11, 12, 15, 200};
	//	int arr[] = {20, 7, 5, 6};
		int h= arr.length-1;
		MinRemoveElement prob= new MinRemoveElement();
		int minRemoveElement = prob.minRemoveElementRec(arr, 0, h);
		System.out.println("Using recursion:: "+minRemoveElement);
		System.out.println("Using loop:: "+prob.minRemoveElementLoop(arr));
		System.out.println("Using best solution:: "+prob.minRemoveEleBestApproach(arr));

	}
	
	private int minRemoveEleBestApproach(int[] arr) {
		int l= arr.length;
		int l_start= -1;
		int l_end= 0;
		for(int start= 0;start<l;start++) {
			int min= Integer.MAX_VALUE;
			int max= Integer.MIN_VALUE;
			for(int end= start;end<l;end++) {
				if(arr[end]>max) max= arr[end];
				if(arr[end]<min) min= arr[end];
				if(2*min<max) break;
				if(end-start>l_end-l_start || l_start== -1) {
					l_end= end;
					l_start= start;
				}
			}
		}
		if(l_start== -1) return l;
		//print the array
		for(int i= l_start;i<=l_end;i++) {
			System.out.print(arr[i]+" ");
		}
		return l-(l_end-l_start+1);
	}
	
	private int minRemoveElementRec(int[] arr, int l, int h) {
		Cache c= new Cache(l, h);
		if(cacheMap.get(c)!= null) return cacheMap.get(c);
		if(l== h) return 0;
		int min= findMin(arr, l, h);
		int max= findMax(arr, l, h);
		if(2*min>max) return 0;
		int res= Math.min(minRemoveElementRec(arr, l, h-1), minRemoveElementRec(arr, l+1, h))+1;
		cacheMap.put(c, res);
		return res;
	}
	
	private int minRemoveElementLoop(int[] arr) {
		int size= arr.length;
		int[][] minMatrix= new int[size][size];
		for(int i= 0;i<size;i++) {
			minMatrix[i][i]= 0;
		}
		for(int l= 2;l<= size;l++) {
			for(int i= 0;i<= size-l;i++) {
				int j= i+l-1;
				int min= findMin(arr, i, j);
				int max= findMax(arr, i, j);
				if(2*min>max) {
					minMatrix[i][j]= 0;
				} else {
					minMatrix[i][j]= Math.min(minMatrix[i+1][j], minMatrix[i][j-1])+1;
				}
			}
		}
		
		return minMatrix[0][size-1];
	}

	private int findMin(int[] arr, int l, int h) {
		int min= Integer.MAX_VALUE;
		for(int i= l;i<=h;i++) {
			if(arr[i]<min) {
				min= arr[i];
			}
		}
		return min;
	}

	private int findMax(int[] arr, int l, int h) {
		int max= Integer.MIN_VALUE;
		for(int i= l;i<=h;i++) {
			if(arr[i]>max) {
				max= arr[i];
			}
		}
		return max;
	
	}
	
	class Cache{
		int l;
		int h;
		public Cache(int l, int h) {
			this.l= l;
			this.h= h;
		}
		
		@Override
		public int hashCode() {
			return 31*l+31*h;
		}
		
		@Override
		public boolean equals(Object obj) {
			Cache that= (Cache) obj;
			if(that.l== this.l && that.h== this.h) return true;
			return false;
		}
	}

}
