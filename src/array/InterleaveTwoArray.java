package array;

import java.util.ArrayList;
import java.util.List;

public class InterleaveTwoArray {

	public static void main(String[] args) {
		int[] a= {1,2,3};
		int[] b= {4,5,6};
		Integer[] prefix= new Integer[a.length+b.length];
		List<Integer[]> results= new ArrayList<>();
		interleave(a,0,a.length-1,b,0,b.length-1,prefix,results,0);
		System.out.println(results.size());
		for(Integer[] r: results) {
			for(Integer i: r) {
				System.out.print(i+" ");
			}
			System.out.println("");
		}
		
		interleaveString("ab", 0, "cd", 0, "");
	}
	
	private static void interleaveString(String s1, int i1, String s2, int i2, String s) {
		if(s.length()== s1.length()+s2.length()) {
			System.out.println(s);
		}
		if(i1<s1.length()) {
			String s_= s+s1.charAt(i1);
			interleaveString(s1, i1+1, s2, i2, s_);
		}
		
		if(i2<s2.length()) {
			String s_= s+s2.charAt(i2);
			interleaveString(s1, i1, s2, i2+1, s_);
		}
		
	}

	private static void interleave(int[] a, int l1, int h1, int[] b, int l2, int h2, Integer[] prefix,List<Integer[]> results,int i) {
		if(l1>h1 || l2>h2) {
			Integer[] clone= new Integer[prefix.length];
			int k= i;
			for(int index= 0;index<k;index++) {
				clone[index]= prefix[index];
			}
			if(l1<=h1) {
				int k1= i;
				for(int index= l1;index<=h1;index++) {
					clone[k1]= a[index];k1++;
				}
			}
			if(l2<=h2) {
				int k1= i;
				for(int index= l2;index<=h2;index++) {
					clone[k1]= b[index];k1++;
				}
			}
			
			results.add(clone);
			return;
		}
		
		int headF= a[l1];
		prefix[i]= headF;
		interleave(a, l1+1, h1, b, l2, h2, prefix, results, i+1);
		
		headF= b[l2];
		prefix[i]= headF;
		interleave(a, l1, h1, b, l2+1, h2, prefix, results, i+1);
	}

}
