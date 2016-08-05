package string;

public class ReverseStringUsingRecursion {

	public static void main(String[] args) {
		String s= "hitansu";
		System.out.println(reverse(s, 0));

	}
	
	private static String reverse(String s, int i) {
		if(i== s.length()) {
			return "";
		}
		return reverse(s, i+1)+s.charAt(i);
	}

}
