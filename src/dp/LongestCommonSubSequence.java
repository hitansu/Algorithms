package dp;

public class LongestCommonSubSequence {

	public static void main(String[] args) {
		
		String s1= "ABCDGH";
		String s2= "AEDFHR";
		int max_length= maxSubSequnceLength(s1, s2, 0, s1.length()-1, 0, s2.length()-1);
		System.out.println(max_length);
		
		String s= maxSubSequnceLength2(s1, s2,s1.length(),s2.length());
		System.out.println(s);
		
		s= maxSubSequenceItr(s1, s2);
		System.out.println("length: "+s.length()+" String: "+s);

	}
	
	private static int maxSubSequnceLength(String s1,String s2,int l1,int h1,int l2,int h2) {
		if(l1>h1 || l2>h2)
			return 0;
		if(s1.charAt(l1)== s2.charAt(l2)) {
			return 1+maxSubSequnceLength(s1, s2, l1+1, h1, l2+1, h2);
		} else {
			return Math.max(maxSubSequnceLength(s1, s2, l1+1, h1, l2, h2), maxSubSequnceLength(s1, s2, l1, h1, l2+1, h2));
		}
	}
	
	private static String maxSubSequnceLength2(String s1,String s2,int h1,int h2) {
		if(h1== 0 || h2== 0)
			return "";
		if(s1.charAt(h1-1)== s2.charAt(h2-1)) {
			return maxSubSequnceLength2(s1, s2, h1-1, h2-1)+s1.charAt(h1-1);
		} else {
			String rs1= maxSubSequnceLength2(s1, s2,h1-1,h2);
			String rs2= maxSubSequnceLength2(s1, s2, h1,h2-1);
			return rs1.length()>rs2.length()?rs1:rs2;
		}
	}
	
	private static String maxSubSequenceItr(String s1, String s2) {
		int l1= s1.length();
		int l2= s2.length();
		String[][] result= new String[l1+1][l2+1];
		for(int i= 0;i<=l1;i++) {
			for(int j= 0;j<=l2;j++) {
				if(i== 0 || j== 0) {
					result[i][j]= "";
					continue;
				}
				
				if(s1.charAt(i-1)== s2.charAt(j-1)) {
					result[i][j]= result[i-1][j-1]+s1.charAt(i-1);
				} else {
					String rs1= result[i-1][j];
					String rs2= result[i][j-1];
					result[i][j]= rs1.length()>rs2.length()?result[i-1][j]:result[i][j-1];
				}
			}
		}
		return result[l1][l2];
	}

}
