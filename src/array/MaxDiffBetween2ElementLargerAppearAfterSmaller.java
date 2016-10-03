package array;

public class MaxDiffBetween2ElementLargerAppearAfterSmaller {

	public static void main(String[] args) {
		int[] a= {2, 3, 10, 6, 4, 8, 1};
	//	int[] a= {7, 9, 5, 6, 3, 2 };
		int max_diff= getMaxDiff(a);
		System.out.println(max_diff);
		max_diff= getMaxDiffApproach2(a);
		System.out.println(max_diff);
	}

	private static int getMaxDiffApproach2(int[] a) {
		int min= a[0];
		int max_diff= a[1]-a[0];
		int size= a.length;
		for(int i=1;i<size;i++) {
			if(a[i]-min>max_diff) {
				max_diff= a[i]-min;
			}
			if(min>a[i]) {
				min= a[i];
			}
		}
		return max_diff;
	}

	private static int getMaxDiff(int[] a) {
		int size= a.length;
		int[] lt= new int[size];
		int[] rt= new int[size];
		rt[size-1]= a[size-1];
		for(int i= size-2;i>=0;i--) {
			if(a[i]<rt[i+1]) {
				rt[i]= rt[i+1];
			} else {
				rt[i]= a[i];
			}
		}
		lt[0]= a[0];
		for(int i= 1;i<size;i++) {
			if(a[i]<lt[i-1]) {
				lt[i]= a[i];
			} else {
				lt[i]= lt[i-1];
			}
		}
		int i= 0;
		int j= 0;
		int max_diff= Integer.MIN_VALUE;
		while(i<size && j<size) {
			if(rt[i]>lt[j]) {
				if(rt[i]-lt[j]>max_diff)
					max_diff= rt[i]-lt[j];
					i++;
			} else {
				j++;
			}
		}
		return max_diff;
	}

}
