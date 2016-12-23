package array;

import java.util.ArrayList;
import java.util.List;

public class GenerateAllpossibleNoFromSortedArray {

	public static void main(String[] args) {
		int[] a= {10,15,25};
		int[] b= {1,5,20,30};
		int m= a.length;
		int n= b.length;
		int[] c= new int[m+n];
	//	generateAllPossibleNo(a,0,m,b,0,n,c,0,true);
		
		generate(a, b, 0, 0, 0, new ArrayList<Integer>(), 0, true);
	}

	static void generate(int[] a, int[] b, int index_1, int index_2, int index, List<Integer> list, int size, boolean flag) {
		
		if(flag && size>0 && size%2== 0) {
			print(list, size);
		}
		
		if((flag && index_1>= a.length) || (!flag && index_2>= b.length)) return;
		
		if(flag) {
			for(int i= index_1;i<a.length;i++) {
				if(index== 0 || list.get(index-1)<a[i]) {
					list.add(index, a[i]);
					generate(a, b, i+1, index_2, index+1, list, size+1, false);
				}
			}
		} else {
			for(int j= index_2;j<b.length;j++) {
				if(list.get(index-1)<b[j]) {
					list.add(index, b[j]);
					generate(a, b, index_1, j+1, index+1, list, size+1, true);
				}
			
			}
		}
	}
	
	
	private static void print(List<Integer> list, int size) {
		int count= 1;
		for(Integer i: list) {
			System.out.print(i+" ");
			count++;
			if(count>size) break;
		}
		System.out.println("");
		
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
