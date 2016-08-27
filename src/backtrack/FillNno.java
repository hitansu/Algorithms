package backtrack;

public class FillNno {

	public static void main(String[] args) {
		int n= 3;
		int[] result= new int[2*n];
		for(int i= 0;i<2*n;i++) {
			result[i]= Integer.MIN_VALUE;
		}
		boolean isPossible= fillNo(result, n, n);
		if(isPossible) {
			print(result);
		}

	}

	private static void print(int[] result) {
		for(Integer i: result) {
			System.out.print(i+" ");
		}
		
	}

	private static boolean fillNo(int[] result, int n, int curr) {
		if(curr== 0) return true;
		for(int i= 0;i<2*n-curr-1;i++) {
			if(result[i]== Integer.MIN_VALUE && result[i+curr+1]== Integer.MIN_VALUE) {
				result[i]= curr;
				result[i+curr+1]= curr;
				if(fillNo(result, n, curr-1)) {
					return true;
				}
				result[i]= Integer.MIN_VALUE;
				result[i+curr+1]= Integer.MIN_VALUE;
			}
		}
		return false;
	}

}
