package string;

public class If2StringInterLeaving {

	public static void main(String[] args) {
		String s1= "AB";
		String s2= "CD";
		String s3= "ABD";
		System.out.println(if2StringInterLeaving(s1, s2, s3));
	}
	
	private static boolean if2StringInterLeaving(String s1, String s2, String s3) {
		int i= 0;
		int j= 0;
		int k= 0;
		while(i<s3.length() && (Character)s3.charAt(i)!= null) {
			if(j<s1.length() && s3.charAt(i)== s1.charAt(j)) {
				j++;
			} else if(k<s2.length() && s3.charAt(i)== s2.charAt(k)) {
				k++;
			} else {
				return false;
			}
			i++;
		}
		if(j<s1.length()-1 || k<s2.length()-1) {
			return false;
		}
		
		return true;
	}
}
