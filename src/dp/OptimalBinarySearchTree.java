package dp;

public class OptimalBinarySearchTree {

	static String s= "";
	public static void main(String[] args) {
		int[] freq= {34, 8, 50};
		OptimalBinarySearchTree prob= new OptimalBinarySearchTree();
		int optimalCost = prob.findOptimalCostRec(freq, 0, 2);
		System.out.println(optimalCost);
		System.out.println(prob.findOptimalCost(freq));
		System.out.println(s);
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
