package dp;

public class OptimalBinarySearchTree {

	static String s= "";
	public static void main(String[] args) {
	//	int[] freq= {34,  50};
		int[] freq= {10, 12};
		OptimalBinarySearchTree prob= new OptimalBinarySearchTree();
		int optimalCost = prob.findOptimalCostRec(freq, 0, freq.length-1);
		System.out.println(optimalCost);
		System.out.println(prob.findOptimalCost(freq));
		System.out.println(s);
		
		System.out.println(test(freq, 0, freq.length-1, 1));
	}
	
	
	static int test(int[] freq, int l, int h, int level) {
		if(l>h) return 0;
		if(l== h) return level*freq[l];
		if(l+1== h) return level*Math.max(freq[l], freq[h])+(level+1)*Math.min(freq[l], freq[h]);
		int MIN= Integer.MAX_VALUE;
		for(int i= l;i<= h;i++) {
			int val= test(freq, l, i-1, level+1)+(level*freq[i])+test(freq, i+1, h, level+1);
			if(val< MIN) {
				MIN= val;
			}
		}
		
		return MIN;
	}
	
	int findOptimalCost(int[] freq) {
		int n= freq.length;
		int result[][]= new int[n][n];
		
		for(int i= 0;i<n;i++) {
			result[i][i]= freq[i];
		}
		
		for(int l= 2;l<=n;l++) {
			for(int i= 0;i<n-l+1;i++) {
				int j= i+l-1;
				result[i][j]= Integer.MIN_VALUE;
				int min= Integer.MAX_VALUE;
				for(int k= i;k<= j;k++) {
					int cost= (i<k ?result[i][k-1]:0) + (k<j ?result[k+1][j]:0) + getSum(freq, i, j);
					if(cost< min) min= cost;
				}
				result[i][j]= min;
			}
		}
		
		return result[0][n-1];
	}
	
	int findOptimalCostRec(int freq[], int i, int j) {
		if(i>j) return 0;
		if(i== j) return freq[i];
		int sum= getSum(freq, i, j);
		int min= Integer.MAX_VALUE;
		for(int k= i;k<= j;k++) {
			int cost= findOptimalCostRec(freq, i, k-1)+findOptimalCostRec(freq, k+1, j);
			if(min> cost) {
				s+= k+" ";
				min= cost;
			}
		}
		
		return min+sum;
	}

    int getSum(int[] freq, int i, int j) {
    	int sum= 0;
    	for(int k= i;k<= j;k++) {
    		sum+= freq[k];
    	}
    	return sum;
	}
}
