package dp;

import java.util.ArrayList;
import java.util.List;

public class Test { 
		public int maxSubArray(final List<Integer> a) {
		    
			int l= a.size();
			boolean allNegative= true;
			int negMax= Integer.MIN_VALUE;
			for(int k= 0;k<l;k++) {
				if(a.get(k)>0) {
					allNegative= false;
					break;
				}
				if(a.get(k)>negMax) {
					negMax= a.get(k);
				}
			}
			if(allNegative) return negMax;
			
			int sum, max_sum;
			int st_pos, end_pos;
			sum= a.get(0);
			max_sum= sum;
			st_pos= 0;
			end_pos= 0;
			for(int i= 1;i<l;i++) {
				if(sum<0 && a.get(i)> sum) {
					sum= a.get(i);
					if(sum> max_sum) {
						st_pos= i;
						end_pos= i;
					}
				} else {
					sum+= a.get(i);
					if(sum> max_sum) {
						max_sum= sum;
						end_pos= i;
					}
				}
			}
			
			return max_sum;
			
		
		    
		    
		}
		
		int maxSubArraySum(int a[], int size)
		{
		   int max_so_far = a[0];
		   int curr_max = a[0];
		 
		   for (int i = 1; i < size; i++)
		   {
		        curr_max = Math.max(a[i], curr_max+a[i]);
		        max_so_far = Math.max(max_so_far, curr_max);
		   }
		   return max_so_far;
		}
		
		public static void main(String[] args) {
			Test test= new Test();
/*			ArrayList<Integer> a= new ArrayList<>();
			a.add(-2);
			a.add(1);
			a.add(-3);
			a.add(4);
			a.add(-1);
			a.add(2);
			a.add(1);
			a.add(-5);
			a.add(4);
			
			System.out.println(test.maxSubArray(a));*/
			
			int[] arr= {56, -451, -222, 80, -57, -85, -304, -108, 95, -377, -282, -260, -497, -471, -97, -350, -147, 62, -447, -229, 78, -165, -333, -427, -59, -338, 60, -207, -247, -431, -54, -240, -426, -123, -209, 57, -74, -287, -70, -292, 45, -278, -408, -129, -35, 65, -77, -230, -426, 20, -402, -375, -449, -280, -125, -15, -21, -327, -366, 64, -211, -414, -307};
			System.out.println(test.maxSubArraySum(arr, arr.length));
		}
	}

