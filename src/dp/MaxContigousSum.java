package dp;

public class MaxContigousSum {

	public static void main(String[] args) {
	//	int arr[]= {-2, -3, 4, -1, -2, 1, 5, -3};
		int[] arr= {56, -451, -222, 80, -57, -85, -304, -108, 95, -377, -282, -260, -497, -471, -97, -350, -147, 62, -447, -229, 78, -165, -333, -427, -59, -338, 60, -207, -247, -431, -54, -240, -426, -123, -209, 57, -74, -287, -70, -292, 45, -278, -408, -129, -35, 65, -77, -230, -426, 20, -402, -375, -449, -280, -125, -15, -21, -327, -366, 64, -211, -414, -307};
		MaxContigousSum maxContigousSum= new MaxContigousSum();
		Result result = maxContigousSum.maxSum(arr);
		System.out.println("Max Sum:: "+result.max_sum+" : start pos:: "+result.start+ ":: end pos:: "+result.end);
		
		Result r = findMaxSum(arr);
		System.out.println("Max Sum:: "+r.max_sum+" : start pos:: "+r.start+ ":: end pos:: "+r.end);
	}
	
	private static Result findMaxSum(int[] arr) {
		int start= 0;
		int tmp_start= 0;
		int end= 0;
		int max= Integer.MIN_VALUE;
		int max_so_far= 0;
		for(int i= 0;i<arr.length;i++) {
			max_so_far+= arr[i];
			if(max<max_so_far) {
				max= max_so_far;
				start= tmp_start;
				end= i;
			}
			if(max_so_far<0) {
				max_so_far= 0;
				tmp_start= i+1;
			}
		}
		
		Result r= new Result();
		r.end= end;
		r.start= start;
		r.max_sum= max;
		return r;
	}
	
	Result maxSum(int []a) {
		Result result= new Result();
		int l= a.length;
		boolean allNegative= true;
/*		int negMax= Integer.MIN_VALUE;
		for(int k= 0;k<l;k++) {
			if(a[k]>0) {
				allNegative= false;
				break;
			}
			if(a[k]>negMax) {
				negMax= a[k];
			}
		}
		if(allNegative) return negMax;*/
		
		int sum, max_sum;
		int st_pos, end_pos;
		sum= a[0];
		max_sum= sum;
		st_pos= 0;
		end_pos= 0;
		for(int i= 1;i<l;i++) {
			if(sum<0 && a[i]> sum) {
				sum= a[i];
				if(sum> max_sum) {
					st_pos= i;
					end_pos= i;
				}
			} else {
				sum+= a[i];
				if(sum> max_sum) {
					max_sum= sum;
					end_pos= i;
				}
			}
		}
		result.max_sum= max_sum;
		result.start= st_pos;
		result.end= end_pos;
		
		return result;
		
	}
	
	static class Result {
		int max_sum;
		int start;
		int end;
	}
}
