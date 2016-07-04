package dp;

public class MaxSubSequence {

	public static void main(String[] args) {
		MaxSubSequence maxSubSequence= new MaxSubSequence();
		String s1= "ABCDGH";
		String s2= "AEDFHR";
		int maxLength = maxSubSequence.maxSubsequence(s1, s2, 0, 0);
		System.out.println(maxLength);
	}
	
	int maxSubsequence(String s1, String s2, int i, int j) {
		if(i>= s1.length() || j>= s2.length()) return 0;
		
		if(s1.length()==1 && s2.length()== 1) {
			if(s1.equals(s2)) {
				return 1;
			} else {
				return 0;
			}
		}
		
		if(s1.charAt(i)== s2.charAt(j)) {
			return 1+ maxSubsequence(s1, s2, i+1, j+1);
		} else {
			return Math.max(maxSubsequence(s1, s2, i+1, j), maxSubsequence(s1, s2, i, j+1));
		}
	}

}
