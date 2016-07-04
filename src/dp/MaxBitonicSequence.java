package dp;

import java.util.ArrayList;
import java.util.List;

public class MaxBitonicSequence {

	public static void main(String[] args) {
		// int arr[] = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
		 int[] arr= {1, 11, 2, 10, 4, 5, 2, 1};
		 MaxBitonicSequence maxBitonicSequence= new MaxBitonicSequence();
		 int max_val = maxBitonicSequence.findMaxBitonicSequence(arr);
		 System.out.println(max_val);
	}
	
	int findMaxBitonicSequence(int[] arr) {
		int l= arr.length;
		int[] li= new int[l];
		int[] ld= new int[l];
		
		List<List<Integer>> liElement= new ArrayList<>();
		List<List<Integer>> ldElement= new ArrayList<>();

		
		for(int i= 0;i<l;i++) {
			li[i]= 1;
			ld[i]= 1;
		}
		List<Integer> zero= new ArrayList<>();
		zero.add(arr[0]);
		liElement.add(0, zero);
		
		for(int i= 1;i<l;i++) {
			List<Integer> elements= new ArrayList<>();
			for(int j= 0;j<i;j++) {
				if(arr[i]>arr[j] && li[j]+1>li[i]) {
					li[i]= li[j]+1;
					elements.add(arr[j]);
				}
			}
			elements.add(arr[i]);
			liElement.add(i, elements);
		}
		
		int maxIncr = findMax(li);
		
		for(int i= l-2;i>=0;i--) {
			for(int j= l-1;j>i;j--) {
				if(arr[i]>arr[j] && ld[j]+1>ld[i]) {
					ld[i]= ld[j]+1;
				}
			}
		}
		
		int maxDecr= findMax(ld);
		
		int maxResult= Integer.MIN_VALUE;
		for(int i= 0;i<l;i++) {
			if(li[i]+ld[i]-1> maxResult) {
				maxResult= li[i]+ld[i]-1;
			}
		}
		
		return maxResult;
	}

	private int findMax(int[] li) {
		int max= Integer.MIN_VALUE;
		for(int i= 0;i<li.length;i++) {
			if(li[i]>max) {
				max= li[i];
			}
		}
		
		return max;
	}

}
