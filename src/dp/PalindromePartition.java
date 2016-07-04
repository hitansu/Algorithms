package dp;

public class PalindromePartition {

	public static void main(String[] args) {
		String s= "ababbbabbababa";
		PalindromePartition palindromePartition= new PalindromePartition();
		int minPartition = palindromePartition.findPartition(s);
		System.out.println(minPartition);
	}
	
	int findPartition(String s) {
		int l= s.length();
		return partionUtil(s, 0, l-1);
	}

	private int partionUtil(String s, int i, int j) {
		if(i== j) return 0;
		if(i+1== j) {
			if(s.charAt(i)== s.charAt(j)) return 0;
			else return 1;
		}
		
		if(isPalindrome(s,i,j)) return 0;
		
		int min= Integer.MAX_VALUE;
		for(int k= i;k<j;k++) {
			int count= partionUtil(s, i, k)+1+partionUtil(s, k+1, j);
		    if(count< min) {
		    	min= count;
		    }
		}
		return min;
	}

	private boolean isPalindrome(String s, int i, int j) {
		while(i<j) {
			if(s.charAt(i)!= s.charAt(j)) return false;
			i++;
			j--;
		}
		return true;
	}

}
