package dp;

public class MinInsertionPalindrome {

	public static void main(String[] args) {
	//	String s= "geeks";
	//	String s= "abcdcba";
		String s= "aaa";
		MinInsertionPalindrome prob= new MinInsertionPalindrome();
		int result= prob.findMinInsertionRec(s, 0, s.length()-1);
		System.out.println(result);
		
		int resultDP= prob.findMinInsertion(s);
		System.out.println(resultDP);
	}
	
	int findMinInsertionRec(String s, int i, int j) {
		if(i>=j) return 0;
		if(i+1== j) {
			if(s.charAt(i)== s.charAt(j)) {
				return 0;
			} else {
				return 1;
			}
		}
		int resultMin= Integer.MAX_VALUE;
		if(s.charAt(i)== s.charAt(j)) {
			int res= findMinInsertionRec(s, i+1, j-1);
			if(resultMin>res) {
				resultMin= res;
			}
		} else {
			int res= Math.min(findMinInsertionRec(s, i+1, j), findMinInsertionRec(s, i, j-1))+1;
			if(resultMin>res) {
				resultMin= res;
			}
		}
		
		return resultMin;
	}
	
	int findMinInsertion(String s) {
		int n= s.length();
		int result[][]= new int[n][n];
		for(int l= 1;l<= n;l++) {
			for(int i= 0;i<n-l+1;i++) {
				int j= i+l-1;
				if(i== j || (i+1== j && s.charAt(i)== s.charAt(j))) {
					result[i][j]= 0;
				} else {
					if(s.charAt(i)== s.charAt(j)) {
						result[i][j]= result[i+1][j-1];
					} else {
						result[i][j]= Math.min(result[i][j-1], result[i+1][j])+1;
					}
				}
			}
		}
		 return result[0][n-1];
	}
}
