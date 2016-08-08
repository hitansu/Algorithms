package string;

public class InPlaceStringTransformation {

	public static void main(String[] args) {

		String s= "a1b2c3d4e5f6g7h8i9j1k2l3m4";
		System.out.println(transformString(s));
		
	}
	
	private static String transformString(String s) {
		int l= s.length();
		String even= "";
		String odd= "";
		for(int i= 0;i<l;i++) {
			if(i%2== 0) {
				even+= s.charAt(i);
			} else {
				odd+= s.charAt(i);
			}
		}
		return even+odd;
	}

}
