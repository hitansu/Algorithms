package dp;

public class LongestPalindromeSubstring {

	static int max= Integer.MIN_VALUE;
	public static void main(String[] args) {
	//	String s= "abbad";
		String s= "forgeeksskeegfor";
		LongestPalindromeSubstring prob= new LongestPalindromeSubstring();
		Result result = prob.findMaxPlaindromeSubstring(s);
		System.out.println("Max length:: "+result.length);
		System.out.println("String:: "+s.substring(result.start, result.start+result.length));
	}
	
	
	Result findMaxPlaindromeSubstring(String s) {
		int n= s.length();
		int[][] pal= new int[n][n];
		for(int i= 0;i<n;i++) {
			pal[i][i]= 1;
		}
		int maxLength= 1;
		int strtIndex=0;
		for(int l= 2;l<=n;l++) {
			for(int i= 0;i<n-l+1;i++) {
				int j= i+l-1;
				if(s.charAt(i)== s.charAt(j)) {
					if(i+1== j) {
						pal[i][j]= 1;
						maxLength= 2;
						strtIndex= i;
					} else {
						pal[i][j]= pal[i+1][j-1]== 1?1:0; 
						if(pal[i][j]== 1 && maxLength<l) {
							maxLength= l;
							strtIndex= i;
						}
					}
					
				} else {
					pal[i][j]= 0;
				}
			}
		}
		
		Result result= new Result(maxLength, strtIndex);
		return result;
	}
	
	class Result {
		int length;
		int start;
		
		public Result(int length, int start) {
			this.length= length;
			this.start= start;
		}
	}

}
