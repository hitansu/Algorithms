package array;

public class ThirdLargest {

	public static void main(String[] args) {
		int[] a = {1, 14, 2, 16, 10, 20};
		printThirdHighest(a);
		int[] b = {19, -10, 20, 14, 2, 16, 10};
		printThirdHighest(b);
	}
	
	private static void printThirdHighest(int[] a) {
		int n= a.length;
		int first= Integer.MIN_VALUE;
		int second= Integer.MIN_VALUE;
		int third= Integer.MIN_VALUE;
		
		for(int i= 0;i<n;i++) {
			if(a[i]>first) {
				third= second;
				second= first;
				first= a[i];	
			} else if(a[i]>second) {
				third= second;
				second= a[i];		
			} else if(a[i]>third) {
				third= a[i];
			}
		}
		
		System.out.println("First: "+first+" Second: "+second+" Third: "+third);
	}

}
