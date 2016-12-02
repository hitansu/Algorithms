package math;

public class FindSquareRoot {

	public static void main(String[] args) {
		int x= 30;
		int ans = findSqrt(x);
		System.out.println(ans);
		int y= 25;
		float findSqrt = findSqrt1(y);
		System.out.println(findSqrt);
	}
	
	static float findSqrt1(float n) {
		  float x = n;
		  float y = 1;
		  float e = (float) 0.000001;
		  while(x - y > e)
		  {
		    x = (x + y)/2;
		    y = n/x;
		  }
		  return x;
	}
	
	static int findSqrt(int x) {
		if(x== 0 || x== 1) {
			return x;
		}
		int start= 1;
		int end= x;
		while(start<=end) {
			int mid= (start+end)/2;
			if(mid*mid== x) {
				return mid;
			} else if(mid*mid<x) {
				start= mid+1;
			} else {
				end= mid-1;
			}
		}
		return end;
	}

}
