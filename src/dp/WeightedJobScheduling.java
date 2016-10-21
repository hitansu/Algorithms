package dp;

public class WeightedJobScheduling {

	public static void main(String[] args) {
/*		int[][] jobArr= {	{1, 2, 50},
							{3, 5, 20},
							{6, 19, 100},
							{2, 100, 200}
						}; */
		
/*		int[][] jobArr= {	{3, 10, 20},
							{1, 2, 50}, 
							{6, 19, 100}, 
							{2, 100, 200}};*/
		int[][] jobArr= {	{1,3,5},
							{2,5,6},
							{4,6,5},
							{6,7,4},
							{5,8,11},
							{7,9,2}
						};
		
		WeightedJobScheduling prob= new WeightedJobScheduling();
		int maxProfit = prob.findMaxProfit(jobArr);
		System.out.println(maxProfit);
	}
	
	private int findMaxProfit(int[][] jobArr) {
		int l= jobArr.length;
		int[] maxProfit= new int[l];
		for(int i= 0;i<l;i++) {
			maxProfit[i]= jobArr[i][2];
		}
		int maxYet= Integer.MIN_VALUE;
		for(int i= 1;i<l;i++) {
			for(int j= 0;j<i;j++) {
				if(jobArr[i][0]>=jobArr[j][1] && maxProfit[j]+jobArr[i][2]>maxProfit[i]) {
					maxProfit[i]= maxProfit[j]+jobArr[i][2];
					if(maxYet<maxProfit[i]) {
						maxYet= maxProfit[i];
					}
				}
			}
		}
		
		return maxYet;
	}

}
