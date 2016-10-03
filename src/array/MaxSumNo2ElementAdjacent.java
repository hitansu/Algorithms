package array;

public class MaxSumNo2ElementAdjacent {

	public static void main(String[] args) {
	//	int[] a = {5,  5, 10, 40, 50, 35};
		//int[] a= {-5,- 5, 10, -1, 10, -5};
	int[] a= {2, 10,13, 24,30}; 
		int sum = getSum(a);
		System.out.println(sum);
        System.out.println(getSumRec(a, 0, a.length));
        System.out.println(getSumMethod3(a));
	}
	
	private static int getSumMethod3(int[] a) {
		int incl= 0;
		int excl= 0;
		int sum= 0;
		for(int i= 0;i<a.length;i++) {
			sum= Math.max(incl, a[i]+incl);
			sum= Math.max(sum, a[i]);
			sum= Math.max(sum, excl);
			incl= Math.max(incl, excl);
			excl= sum;
		}
		return sum;
	}

	private static int getSum(int[] a) {
		int excl= 0;
		int incl= 0;
		int sum= Integer.MIN_VALUE;
		for(int i= 0;i<a.length;i++) {
			int tmp= a[i]+excl;
			if(sum<tmp) {
				sum= tmp;
			}
			if(i-2>=0) {
				excl= Math.max(incl, a[i-2]);
			} else {
				excl= incl;
			}
			incl= tmp;
		}
		return sum;
	}
	
	private static int getSumRec(int[] a,int l, int h) {
		if(l>h-1) return 0;
		if(l== h-1) return a[l];
		if(l+1== h-1) return Math.max(a[l], a[h-1]);
		return Math.max(getSumRec(a,l,h-2)+a[h-1], getSumRec(a, l, h-1));
	}
}
