package array;

public class MaxProductSubArray {

	public static void main(String[] args) {
	//	int[] a= {6, -3, -10, 0, 2};
	//	int[] a = {-1, -3, -10, 0, 60};
	//	int[] a= {-2, -3, 0, -2, -40};
		int[] a= {-2,-3,-4,9};
		
		int maxproduct= getMaxProduct(a);
		System.out.println(maxproduct);
		System.out.println(maxProduct2(a));
		System.out.println(maxPro(a));
	}
	
	static int maxPro(int[] a) {
		int n= a.length;
		int[] proLeft= new int[n];
		int[] proRight= new int[n];
		int maxLeft= Integer.MIN_VALUE;
		int maxRight= Integer.MIN_VALUE;
		for(int i= 0;i<n;i++) {
			if(a[i]== 0) {
				proLeft[i]= 1;
			} else {
				if(i== 0) {
					proLeft[i]= a[i];
				} else {
					proLeft[i]= proLeft[i-1]*a[i];
				}
			}
			if(maxLeft<proLeft[i]) {
				maxLeft= proLeft[i];
			}
		}
		
		for(int i= n-1;i>=0;i--) {
			if(a[i]== 0) {
				proRight[i]= 1;
			} else {
				if(i== n-1) {
					proRight[i]= a[i];
				} else {
					proRight[i]= proRight[i+1]*a[i];
				}
			}
			if(maxRight<proRight[i]) {
				maxRight= proRight[i];
			}
		}
		
		return maxLeft>maxRight?maxLeft:maxRight;
	}
	
	public static int maxProduct2(int input[]){
        int maxEnding = 1;
        int minEnding = 1;
        int maxSoFar = 1;
        for (int i = 0; i < input.length; i++) {
            if (input[i] > 0) {
                maxEnding = maxEnding*input[i];
                minEnding = Math.min(minEnding*input[i], 1);
            } else if (input[i] == 0) {
                maxEnding = 1;
                minEnding = 1;
            } else {
                int t = maxEnding;
                maxEnding = Math.max(minEnding*input[i], 1);
                minEnding = t * input[i];
            }

            if (maxSoFar < maxEnding) {
                maxSoFar = maxEnding;
            }
        }
        return maxSoFar;
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
