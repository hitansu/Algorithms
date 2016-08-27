package backtrack;

public class SubSetSumFind {

	public static void main(String[] args) {

		int[] data= {10, 7, 5, 18, 12, 20, 15};
		int[] result= new int[data.length];
		int trgtSum= 35;
		for(int i= 0;i< data.length;i++) {
			result[i]= Integer.MIN_VALUE; 
		}
		printSubsetOfSum(data, result, trgtSum);
	}

	private static void printSubsetOfSum(int[] arr, int[] result, int trgtSum) {
		int sum= 0;
		int rIndex= 0;
		printSubsetSumUtil(arr, result, sum, trgtSum, rIndex, 0, arr.length-1);
	}

	

	private static void printSubsetSumUtil(int[] data, int[] result, int sum, int trgtSum, int rIndex, int l, int h) {
		if(sum== trgtSum) {
			print(result);
		}
		for(int i= l;i<= h;i++) {
			if(sum+data[i]<= trgtSum) {
				result[rIndex]= data[i];
				printSubsetSumUtil(data, result, sum+data[i], trgtSum, rIndex+1, l+1, h);
				result[rIndex]= Integer.MIN_VALUE;
			}
		}
		
	}

	private static void print(int[] result) {
		int size= result.length;
		for(int i= 0;i<size;i++) {
			if(result[i]== Integer.MIN_VALUE) break;
			if(result[i]!= Integer.MIN_VALUE) {
				System.out.print(result[i]+" ");
			}
			
		}
		System.out.println("");
		
	}

}
