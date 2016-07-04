package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LIS {

	List<Integer> calculateLIS(int []arr) {
		int size= arr.length;
		int []length= new int[size];
		length[0]= 1;
		int max_index= -1;
		Map<Integer, List<Integer>> lis= new HashMap<>();
		int max= Integer.MIN_VALUE;
		lis.put(0, Arrays.asList(arr[0]));
		for(int i= 1;i<size;i++) {
			int element= arr[i];
			int localMax= Integer.MIN_VALUE;
			int index= -1;
			for(int j= 0;j<i;j++) {
				if(element> arr[j] && localMax< length[j]+1) {
					localMax= length[j]+1;
					index= j;
				}
			}
			if(index!= -1) {
				List<Integer> list= new ArrayList<>(lis.get(index));
				list.add(Integer.valueOf(arr[i]));
				lis.put(i, list) ;
			}
			length[i]= localMax;
			if(max< length[i]) {
				max= length[i];
				max_index= i;
			}
		}
		return lis.get(max_index);
	}
	
	public static void main(String[] args) {
		int[] arr= {10, 22, 9, 33, 21, 50, 41, 60, 80};
		LIS lis= new LIS();
		List<Integer> elements = lis.calculateLIS(arr);
		System.out.println("size:: "+elements.size());
		System.out.println("elements:: "+elements);
	}
}
