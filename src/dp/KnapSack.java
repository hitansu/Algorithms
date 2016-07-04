package dp;

import java.util.HashSet;
import java.util.Set;

public class KnapSack {

	static Set<Integer> item= new HashSet<>();
	public static void main(String[] args) {

		int val[] = {60, 100, 120};
	    int wt[] = {10, 20, 30};
	    int  W = 50;
		KnapSack knapSack= new KnapSack();
		//int findMaxValue = knapSack.findMaxValueRec(0, val, wt, W, 0);
		int findMaxValue = knapSack.findMaxVal(0, val, wt, W, 0);
		System.out.println(findMaxValue);
	//	System.out.print(item);
	}
	
	int findMaxValueRec(int st, int[] val, int[] wt, int maxW, int maxVal) {
		if(maxW== 0) return maxVal;
		if(maxW<0) return maxVal- val[st-1];
		if(st>= wt.length) return maxVal;
		int val1= findMaxValueRec(st+1, val, wt, maxW, maxVal);
		int val2= findMaxValueRec(st+1, val, wt, maxW-wt[st], maxVal+val[st]);
		if(val2> val1) {
			item.add(st);
			return val2;
		}
		
		return val1;
	}

	int findMaxVal(int st, int[] val, int[] wt, int maxW, int maxVal) {
		int l= wt.length;
		int[][] result= new int[l+1][maxW+1];
		
		for (int i= 0;i<= l;i++) {
			for(int w= 0;w<= maxW;w++) {
				if(i== 0 || w== 0) {
					result[i][w]= 0;
				}
				
				else if(wt[i-1]> w) {
					result[i][w]= result[i-1][w]; 
				} else {
					result[i][w]= Math.max(val[i-1]+ result[i-1][w-wt[i-1]], result[i-1][w]); 
				}
			}
		}
		return result[l][maxW];
	}
}
