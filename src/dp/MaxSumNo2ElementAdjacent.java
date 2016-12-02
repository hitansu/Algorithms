package dp;

import java.util.HashMap;
import java.util.Map;

public class MaxSumNo2ElementAdjacent {

	public static void main(String[] args) {
	//	int[] a = {5,  5, 10, 40, 50, 35};
		int[] a= {-5,- 5, 10, -1, 10, -5};
	//	int[] a= {2, 10,13, 24,30}; 
	//	int[] a= {-3,-2,-1,-4};
		int sum = getSum(a);
		System.out.println(sum);
        System.out.println(getSumRecursive(a, 0, a.length));
        System.out.println(getSumMethodEasy(a));
        System.out.println(getSumMethodEasy_2(a));
	}
	
	private static int getSumMethodEasy(int[] a) {
		Map<String, Integer> areAllNegative = areAllNegative(a);
		if(areAllNegative.get("is_all_-ve")== 1) {
			return areAllNegative.get("max");
		}
		int incl= 0;
		int excl= 0;
		int sum= 0;
		for(int i= 0;i<a.length;i++) {
			sum= Math.max(incl, a[i]+incl);
			sum= Math.max(sum, a[i]);
			sum= Math.max(sum, excl);
			incl= Math.max(incl, excl);
			excl= sum;
		}
		return sum;
	}
	
	private static int getSumMethodEasy_2(int[] a) {
		int incl= 0;
		int excl= 0;
		int sum= 0;
		int maxSum= Integer.MIN_VALUE;
		for(int i= 0;i<a.length;i++) {
			sum= Math.max(a[i], a[i]+excl);
			excl= Math.max(excl, incl);
			incl= Math.max(incl, sum);
			if(sum>maxSum) {
				maxSum= sum;
			}
		}
		return maxSum;
	}
	
	private static Map<String,Integer> areAllNegative(int[] a) {
		Map<String, Integer> result= new HashMap<>();
		int max= Integer.MIN_VALUE;
		for(int i= 0;i<a.length;i++) {
			if(a[i]>=0) {
				result.put("is_all_-ve", 0);
				return result;
			}
			if(a[i]>max) {
				max= a[i];
			}
		}
		result.put("is_all_-ve", 1);
		result.put("max", max);
		return result;
	}

	private static int getSumRecursive(int[] a,int l, int h) {
		if(l>h-1) return 0;
		if(l== h-1) return a[l];
		if(l+1== h-1) return Math.max(a[l], a[h-1]);
		return Math.max(getSumRecursive(a,l,h-2)+a[h-1], getSumRecursive(a, l, h-1));
	}
	
	private static int getSum(int[] a) {
		int excl= 0;
		int incl= 0;
		int sum= Integer.MIN_VALUE;
		for(int i= 0;i<a.length;i++) {
			int tmp= a[i]+excl;
			if(sum<tmp) {
				sum= tmp;
			}
			if(i-2>=0) {
				excl= Math.max(incl, a[i-2]);
			} else {
				excl= incl;
			}
			incl= tmp;
		}
		return sum;
	}
}
