package array;

/**
 * There are 2 sorted lists.
 * One has the size of the double of other array
 * @author jenah
 *
 */
public class Merge2SpecialSortedArray {

	public static void main(String[] args) {
		int[] a= {4,8,11,-1,-1,-1};
		int[] b= {5,7,9};
		int m= a.length;
		int n= b.length;
		int i= n;
		int j= 0;
		int k= 0;
//		a= merge(a,b,i,j,k,m,n);
		
		i= n;
		j= 0;
		a= shiftElementToRight(a,i,n);
		merge(a, b, i, j, 0, n);
		for(int index= 0;index<m;index++) {
			System.out.print(a[index]+" ");
		}
	}

	private static int[] merge(int[] a, int[] b, int i, int j, int k, int m, int n) {
		a= shiftElementToRight(a,i,n);
		for(;i<m && j<n;) {
			if(a[i]<b[j]) {
				a[k]= a[i];
				a[i]= -1;
				i++;k++;
			} else {
				a[k]= b[j];
				j++;k++;
			}
		}
		if(k== m-1 && i<m) {
			a[k]= a[i];
		} else if(k== m-1 && j<n) {
			a[k]= b[j];
		}
		
		return a;
	}
	
	private static void merge(int[] a, int[] b, int i, int j, int k, int m) {
		if(k>= 2*m) {;
			return;
		}
		if(k== 2*m-1 && i<2*m) {
			a[k]= a[i];
			return;
		}
		if(k== 2*m-1 && j<m) {
			a[k]= b[j];
			return;
		}
		if(a[i]<b[j]) {
			a[k]= a[i];
			merge(a, b, i+1, j, k+1, m);
		} else {
			a[k]= b[j];
			merge(a, b, i, j+1, k+1, m);
		}
	}

	private static int[] shiftElementToRight(int[] a, int i, int n) {
		for(int j= 0;j<n;j++) {
			a[i]= a[j];
			a[j]= -1;
			i++;
		}
		return a;
	}
}
