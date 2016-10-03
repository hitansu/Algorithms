package array;

public class Max0ByFlipingArray {

	public static void main(String[] args) {
		 int[] arr = {0, 1, 0, 0, 1, 1, 0};
		 int count= getMaxCount0(arr);
		 System.out.println(count);

	}
	
	private static int getMaxCount0(int[] a) {
		int l= a.length;
		int max= Integer.MIN_VALUE;
		int max_so_far= 0;
		int start= 0;
		int tmp_start= 0;
		int end= 0;
		int zero_count= 0;
		for(int i= 0;i<l;i++) {
			if(a[i]== 0) {
				++zero_count;
			}
			int val= a[i]== 0?-1:1;
			max_so_far= max_so_far+val;
			if(max_so_far>max) {
				max= max_so_far;
				end= i;
				start= tmp_start;
			}
			if(max_so_far<0) {
				max_so_far= 0;
				tmp_start= i+1;
			}
		}
		System.out.println(start+" "+end);
		return zero_count+max;
	}

}
