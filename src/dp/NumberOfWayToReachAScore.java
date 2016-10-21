package dp;

public class NumberOfWayToReachAScore {

	public static void main(String[] args) {
		int[] score= {3,5,10};
		int n= 20;
		NumberOfWayToReachAScore prob= new NumberOfWayToReachAScore();
		int noOfWays = prob.findNoOfWaysToReachScore(score, n);
		System.out.println(noOfWays);
		System.out.println(prob.findNoOfWaysToReachScoreRec(20, 3));
		System.out.println(prob.findWays(n));
	}
	
	private int findNoOfWaysToReachScoreRec(int n, int scorePt) {
		if(n== 0) return 1;
		if(n<0) return 0;
		if(n== scorePt) return 1;
		
		if(scorePt== 3) {
			return findNoOfWaysToReachScoreRec(n-3, 3)+findNoOfWaysToReachScoreRec(n-5, 5)+findNoOfWaysToReachScoreRec(n-10, 10);
		}
		if(scorePt== 5) {
			return findNoOfWaysToReachScoreRec(n-5, 5)+findNoOfWaysToReachScoreRec(n-10, 10);
		}
		if(scorePt== 10) {
			return findNoOfWaysToReachScoreRec(n-10, 10);
		}
		return 0;
	}
	
	private int findWays(int n) {
		int[] s= new int[n+1];
		s[0]= 1;
		for(int i= 3;i<=n;i++) {
			s[i]+= s[i-3];
		}
		for(int i= 5;i<=n;i++) {
			s[i]+= s[i-5];
		}
		for(int i= 10;i<=n;i++) {
			s[i]+= s[i-10];
		}
		
		return s[n];
	}
	
	private int findNoOfWaysToReachScore(int[] score, int n) {
		int size= score.length;
		int[][] s= new int[size][n+1];
		
		for(int i= 0;i<size;i++) {
			s[i][0]= 1;
		}
		for(int i= 0;i<size;i++) {
			for(int j= 1;j<=n;j++) {
				if(i== 0 && score[i]>j) {
					s[i][j]= 0;
				} else if(score[i]>j) {
					s[i][j]= s[i-1][j];
				} else {
					if(s[i][j-score[i]]>0) {
						if(i== 0) {
							s[i][j]= s[i][j-score[i]]; 
						} else {
							s[i][j]= s[i-1][j]+s[i][j-score[i]]; 
						}
					} else if(i>0){
						s[i][j]= s[i-1][j]; 
					}
					
				}
			}
		}
		
		return s[size-1][n];
	}

}
