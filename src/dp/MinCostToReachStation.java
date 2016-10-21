package dp;

import static java.lang.Integer.MAX_VALUE;

public class MinCostToReachStation {

	public static void main(String[] args) {
		int[][] cost= { {0, 15, 80, 90},
						{MAX_VALUE, 0, 40, 50},
						{MAX_VALUE, MAX_VALUE, 0, 70},
						{MAX_VALUE, MAX_VALUE, MAX_VALUE, 0}
          			  };
		MinCostToReachStation minCost= new MinCostToReachStation();
		int mincost = minCost.minCostToReachStation(cost, 0, cost.length-1);
		System.out.println(mincost);
	}
	
	private int minCostToReachStation(int[][] costMat, int st, int end) {
		if(st== end || st+1== end) return costMat[st][end];
		int min= costMat[st][end];
		for(int i= st+1;i<end;i++) {
			int min_= costMat[st][i]+ minCostToReachStation(costMat, i, end);
			if(min> min_) {
				min= min_;
			}
		}
		
		return min;
	}

}
