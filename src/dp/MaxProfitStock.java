package dp;

public class MaxProfitStock {

	public static void main(String[] args) {
	//	int[] stock= {10, 22, 5, 75, 65, 80};
	//	int[] stock= {2, 30, 15, 10, 8, 25, 80};
	//	int[] stock= {100, 30, 15, 10, 8, 25, 80};
		int[] stock= {90, 80, 70, 60, 50};
		MaxProfitStock prob= new MaxProfitStock();
		MaxProfit maxProfit = prob.findMaxProfit(stock);
		System.out.println("Max Profit:: "+maxProfit.max );
		System.out.println("Transaction 1:: Buy index- "+maxProfit.profit1.buyIdx +"  	Sell index- "+maxProfit.profit1.sellIdx);
		System.out.println("Transaction 2:: Buy index- "+maxProfit.profit2.buyIdx +"	Sell index- "+maxProfit.profit2.sellIdx);
		
		System.out.println("Max profit with o(n) sol:: "+prob.findMaxProfit(stock, true));
	}
	
	/**
	 * This solution has time complexity of O(n)
	 * @param stock
	 * @param onSolution
	 * @return
	 */
	private int findMaxProfit(int[] stock, boolean onSolution) {
		int n= stock.length;
		int[] profit= new int[n];
		profit[n-1]= 0;
		int max= stock[n-1];
		for(int i= n-2;i>=0;i--) {
			if(max<stock[i]) {
				max= stock[i];
			}
			profit[i]= Math.max(max-stock[i], profit[i+1]);
		}
		
		int min= stock[0];
		for(int i= 1;i<n;i++) {
			if(min>stock[i]) {
				min= stock[i];
			}
			profit[i]= Math.max((stock[i]-min)+profit[i], profit[i-1]);
		}
		
		return profit[n-1];
	}
	
	/**
	 * This method will have a Time complexity of O(n2)
	 * @param stock
	 * @return
	 */
	private MaxProfit findMaxProfit(int[] stock) {
		int n= stock.length;
		MaxProfit maxProfit= new MaxProfit();
		maxProfit.max= Integer.MIN_VALUE;
		Profit profit1= null;
		Profit profit2= null;
		for(int i= 1;i<n-1;i++) {
			profit1= findProfitwithOneTrans(stock, 0, i);
			profit2= findProfitwithOneTrans(stock, i+1, n-1);
			if(maxProfit.max< profit1.profit+profit2.profit) {
				maxProfit.profit1= profit1;
				maxProfit.profit2= profit2;
				maxProfit.max= profit1.profit + profit2.profit;
			}
		}
		return maxProfit;
	}

	private Profit findProfitwithOneTrans(int[] stock, int i, int j) {
		int min= stock[i];
		int max= 0;
		Profit profit= new Profit();
		profit.buyIdx= -1;
		profit.sellIdx= -1;
		profit.profit= 0;
		int buyId= -1;
		for(int k= i;k<= j;k++) {
			if(min>stock[k]) {
				min= stock[k];
				buyId= k;
			}
			if(max< stock[k]-min) {
				max= stock[k]-min;
				profit.sellIdx= k;
				profit.buyIdx= buyId;
			}
		}
		profit.profit= max;
		return profit;
	}
	
	class Profit {
		int buyIdx;
		int sellIdx;
		int profit;
	}
	
	class MaxProfit {
		Profit profit1;
		Profit profit2;
		int max;
	}

}
