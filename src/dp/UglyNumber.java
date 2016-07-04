package dp;

import java.util.HashSet;

public class UglyNumber {

	public static void main(String[] args) {
		UglyNumber uglyNumber= new UglyNumber();
		int[] uglyNo = uglyNumber.findUglyNo(11);
		System.out.println("Ugly no:: "+ uglyNo[uglyNo.length-1]);
		
		for(int i= 0; i< uglyNo.length; i++) {
			if(i== 0) {
				System.out.print(" "+ uglyNo[i]);
			} else {
				System.out.print(", "+ uglyNo[i]);
			}
		}
	}
	
	int[] findUglyNo(int n) {
		int []arr= new int[n];
		int ugly_no= 1;
		int i= 0;
		arr[i]= ugly_no;
		int i2= 0, i3= 0, i5= 0;
		int next_ugly_2= arr[i2]*2;
		int next_ugly_3= arr[i3]*3;
		int next_ugly_5= arr[i5]*5;
		HashSet<Integer> set= new HashSet<>();
		for(i= 1;i< n;i++) {
			ugly_no= findMin(next_ugly_2, next_ugly_3, next_ugly_5);
		    boolean add = set.add(ugly_no);
			if(add) {
				arr[i]= ugly_no;
			} else {
				i= i-1;
			}
			if(ugly_no== next_ugly_2) {
				i2= i2+1;
				next_ugly_2= arr[i2]*2;
			} else if(ugly_no== next_ugly_3) {
				i3= i3+1;
				next_ugly_3= arr[i3]*3;
			} else if(ugly_no== next_ugly_5) {
				i5= i5+1;
				next_ugly_5= arr[i5]*5;
			}
		}
		
		return arr;
	}
	
	int findMin(int a, int b, int c) {
		  if(a <= b)
		    {
		      if(a <= c)
		        return a;
		      else
		        return c;
		    }
		    if(b <= c)
		      return b;
		    else
		      return c;
	}
}
