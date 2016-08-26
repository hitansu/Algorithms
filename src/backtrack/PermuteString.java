package backtrack;

public class PermuteString {

	public static void main(String[] args) {
		String s= "ABC";
		permute(s, 0, s.length()-1);
	}
	
	private static void permute(String s, int l, int r) {
		if(l== r) {
			System.out.println(s);
		}
		for(int i= l;i<= r;i++) {
			s= swap(s, l, i);
			permute(s, l+1, r);
			s= swap(s, l, i);
		}
	}

	private static String swap(String s, int i, int j) {

		char[] charArray = s.toCharArray();
		char tmp= charArray[i];
		charArray[i]= charArray[j];
		charArray[j]= tmp;
		return new String(charArray);
	}

}
