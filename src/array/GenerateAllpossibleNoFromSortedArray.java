package array;

public class GenerateAllpossibleNoFromSortedArray {

	public static void main(String[] args) {
		int[] a= {10,15,25};
		int[] b= {1,5,20,30};
		int m= a.length;
		int n= b.length;
		int[] c= new int[m+n];
		generateAllPossibleNo(a,0,m,b,0,n,c,0,true);
	}

	private static void generateAllPossibleNo(int[] a, int i, int m, int[] b, int j, int n, int[] c, int len, boolean flag) {
		if(flag) {
			if(len>0)
				print(c,len);
			
			for(int p= i;p<m;p++) {
				if(len== 0) {
					c[len]= a[p];
					generateAllPossibleNo(a, p+1, m, b, j, n, c, len, !flag);
				} else if(a[p]>c[len]) {
					c[len+1]= a[p];
					generateAllPossibleNo(a, p+1, m, b, j, n, c, len+1, !flag);
				}
			}
		} else {
			for(int q= j;q<n;q++) {
				if(b[q]>c[len]) {
					c[len+1]= b[q];
					generateAllPossibleNo(a, i, m, b, q+1, n, c, len+1, !flag);
				}
			}
		}
		
	}

	private static void print(int[] c, int len) {
		for(int i= 0;i<= len;i++) {
			System.out.print(c[i]+" ");
		}
		System.out.println();
	}
}
