package dp;

public class PrintMaxA {

	public static void main(String[] args) {
		
		int n= 11;
		int maxLength= findMaxCount(n);
		System.out.println(maxLength);
		
		maxLength= findMaxCountItr(n);
		System.out.println(maxLength);

	}
	
	static int findMaxCount(int n) {
		if(n<7) {
			return n;
		}	
		int opPt; //optimal point
		int MAX= Integer.MIN_VALUE;
		for(opPt= n-3;opPt>=1;opPt--) {
			int curr= (n-opPt-1)*findMaxCount(opPt);
			if(MAX<curr) 
				MAX= curr;
		}
		return MAX;
	}
	
	static int findMaxCountItr(int n) {
		int[] result= new int[n+1];
		result[0]= 0;
		for(int i= 1;i<7;i++) {
			result[i]= i;
		}
		for(int j= 7;j<=n;j++) {
			result[j]= 0;
			for(int opPt= j-3;opPt>=1;opPt--) {
				int curr= (j-opPt-1)*result[opPt];
				if(result[j]<curr) {
					result[j]= curr;
				}
			}
		}
		return result[n];	
	}

}
