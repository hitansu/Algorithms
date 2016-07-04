package dp;

public class CuttingRod {

	public static void main(String[] args) {
		//int[] length= {1, 2, 3, 4, 5, 6, 7, 8 };
		int[] length= {1 ,  2  , 3  , 4  , 5  , 6 ,  7  , 8 };
		//int[] price= {1, 5, 8, 9, 10, 17, 17, 20};
		int[] price= {3  , 5  , 8   ,9 , 10  ,17 , 17 , 20};
		CuttingRod cutRod= new CuttingRod();
	//	int findMaxVal = cutRod.findMaxVal(price, length, 8);
		int findMaxValRec= cutRod.findMaxValRec(price, length, 8);
		System.out.println(findMaxValRec);
		
	}

	int findMaxVal(int[] price, int[] length, int size) {
		if(price.length!= length.length) throw new RuntimeException("Both shud be equal");
		int[] val= new int[size+1];
		val[0]= 0;
		val[1]= price[0];
		for(int j= 2;j<=size;j++) {
			int max= Integer.MIN_VALUE;
			for(int i= 1;i<=j;i++) {
				if(max< price[i-1]+val[j-i]) {
					max= price[i-1]+val[j-i];
				}
			}
			val[j]= max;
		}
		return val[size];
	}
	
	int findMaxValRec(int[] price, int[] length, int size) {
		if(size== 0) return 0;
		if(size== 1) return price[0];
		
		int max= Integer.MIN_VALUE;
		for(int l= 1;l<= size;l++) {
			int val= price[l-1]+findMaxValRec(price, length, size-l);
			if(max< val) {
				max= val;
			}
		}
		
		return max;
	}
	
}
