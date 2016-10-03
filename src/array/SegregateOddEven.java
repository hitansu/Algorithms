package array;

public class SegregateOddEven {

	public static void main(String[] args) {
		int[] a= {12, 34, 45, 9, 8, 90, 3};
		segregateOddEven(a);
		for(Integer i: a) {
			System.out.println(i+" ");
		}

	}
	
	static void segregateOddEven(int[] a) {
		int l= a.length;
		int i= 0;
		int j= l-1;
		while(i<j) {
			while(a[i]%2== 0) {
				i++;
			}
			while(a[j]%2== 1) {
				j--;
			}
			if(i<j) {
				int tmp= a[i];
				a[i]= a[j];
				a[j]= tmp;
			}
		}
		
	}

}
