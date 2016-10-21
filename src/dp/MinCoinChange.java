package dp;

public class MinCoinChange {

	public static void main(String[] args) {
	//	int[] coins= {25,10,5};
		int[] coins= {9,5,6,1};
		int v= 30;
		v= 11;
		int min_coins= findMinCoins(coins, v);
		System.out.println("Min coins req. "+ min_coins);

	}
	
	static int findMinCoins(int[] coins, int v) {
		int[] result= new int[v+1];
		int[] exactCoins= new int[v+1];
		exactCoins[0]= -1;
		result[0]= 0;
		for(int i= 1;i<=v;i++) {
			int MIN= Integer.MAX_VALUE;
			int coin= -1;
			for(int j= 0;j<coins.length;j++) {
				if(i>= coins[j]) {
					int min= 1+result[i-coins[j]];
					if(min<MIN) {
						MIN= min;
						coin= coins[j];
					}
				}
			}
			result[i]= MIN;
			exactCoins[i]= coin;
		}
		
	
		int val= v;
		while(val!= 0) {
			System.out.println(exactCoins[val ]);
			val= val-exactCoins[val];
		}
		
		return result[v];
	}

}
