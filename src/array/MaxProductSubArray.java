package array;

public class MaxProductSubArray {

	public static void main(String[] args) {
	//	int[] a= {6, -3, -10, 0, 2};
	//	int[] a = {-1, -3, -10, 0, 60};
		int[] a= {-2, -3, 0, -2, -40};
		
		int maxproduct= getMaxProduct(a);
		System.out.println(maxproduct);
	}

	private static int getMaxProduct(int[] a) {
		int start= -1;
		int curr= 1;
		int finish= -1;
		int tmpStart= -1;
		int max= Integer.MIN_VALUE;
		for(int i= 0;i<a.length;i++) {
			curr= curr*a[i];
			/*check max between product of all element upto i & max product*/
			if(max<curr) {
				max= curr;
				finish= i;
				if(tmpStart!= -1)
					start= tmpStart;
			}
			/*check max between current element & max (for negative)*/
			if(max<=a[i]) {
				max= a[i];
				finish= i;
				start= i;
				
			}
			/*when current element 0*/
			if(curr== 0) {
				curr= 1;
				tmpStart= i+1;
			}
		}
		System.out.println("start: "+start+" end: "+finish);
		return max;
	}

}
