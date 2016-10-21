package dp;

public class WordWrapProblem {

	public static void main(String[] args) {
		//String[] words= {"abcde", "bd", "de", "ddddd"};
		String[] words= {"aaa", "bb", "cc", "ddddd"};
		int lineLength= 6;
		WordWrapProblem prob= new WordWrapProblem();
		int minCost = prob.findMinCost(words, lineLength);
		System.out.println("Min Cost of arranging the words:: "+minCost);
	}
	
	int findMinCost(String[] words, int length) {
		
		int size= words.length;
		int[] wordL= new int[size];
		for(int i= 0;i<size;i++) {
			wordL[i]= words[i].length(); 
		}
		
		int[][] space= new int[size][size];
		for(int i= 0;i<size;i++) {
			for(int j= i;j<size;j++) {
				if(i== j && i!= size-1) { // probably the first word.so calculte with length
					space[i][j]= length-wordL[j];
				} else if(i== size-1) {
					if(wordL[i]>= length) {
						space[i][j]= 0;
					} else {
						space[i][j]= length-wordL[i];
					}
					
				} else {
					space[i][j]= space[i][j-1]-wordL[j]-1;
				}
				
			}
		}
		
		//try putting each word in a single line
		int[][] cost= new int[size][size];
		for(int i= 0;i<size;i++) {
			for(int j= i;j<size;j++) {
				if(space[i][j]<0) {
					cost[i][j]= Integer.MAX_VALUE;
				} else {
					cost[i][j]= getCost(space[i][j]);
				}
				
			}
			
		}
		
		int[] minCostA= new int[size];
		int[] breakdown= new int[size];
		for(int i= 0;i<size;i++) {
			minCostA[i]= cost[0][i]; 
			breakdown[i]= i;
			for(int j= 0;j<i;j++) {
				int mincost= Integer.MAX_VALUE;
				if(cost[j+1][i]!= Integer.MAX_VALUE) {
					mincost= minCostA[j]+cost[j+1][i];
				}
				if(mincost<minCostA[i]) {
					minCostA[i]= mincost;
					breakdown[i]= j;
				}
			}
		}
//		printPath(breakdown, size-1);
		return minCostA[size-1];
	}
	
   int printPath(int[] p,int n) {
		    int k;
		    if (n == 0)
		        k = 0;
		    else
		        k = printPath (p, p[n])+p[n];
		    System.out.println(" From word no. "+(k+1)+" to "+n);
		    return k;
   }

	private int getCost(int i) {
		return i*i*i;
	}
}
