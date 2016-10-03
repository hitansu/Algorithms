package array;

public class ZigZagArray {

	public static void main(String[] args) {
		int[] arr= {4, 3, 7, 8, 6, 2, 1};
		arr= convertToZigZag(arr);
		for(Integer i: arr) {
			System.out.print(i+" ");
		}
	}
	
	private static int[] convertToZigZag(int[] a) {
		int l= a.length;
		boolean flag= true; //<
		
		for(int i= 0;i<l-1;i++) {
			if(flag) {
				if(a[i]>a[i+1]) {
					int tmp= a[i+1];
					a[i+1]= a[i];
					a[i]= tmp;
				}
			} else {
				if(a[i]<a[i+1]) {
					int tmp= a[i+1];
					a[i+1]= a[i];
					a[i]= tmp;
				}
			}
			flag= !flag;
		}
		return a;
	}
}
