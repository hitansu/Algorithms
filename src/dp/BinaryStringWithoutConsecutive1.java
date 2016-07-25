package dp;

public class BinaryStringWithoutConsecutive1 {

	public static void main(String[] args) {
		int n= 3;
	//	n= 4;
		BinaryStringWithoutConsecutive1 prob= new BinaryStringWithoutConsecutive1();
		System.out.println("No. of String:: "+prob.countNoOfString(n));
	}
	
	private int countNoOfString(int n) {
		int[] a= new int[n+1]; // represent string ends with 1
		int[] b= new int[n+1]; // represents string ends with 0
		b[0]= a[0]= 0;
		b[1]= a[1]=1;
		for(int i= 2;i<=n;i++) {
			b[i]= a[i-1]+b[i-1];
			a[i]= b[i-1];
		}
		return a[n]+b[n];
	}

}
