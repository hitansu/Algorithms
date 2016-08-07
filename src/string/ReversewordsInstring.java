package string;

public class ReversewordsInstring {

	public static void main(String[] args) {
		String s= " I like this program very much";
		System.out.println(reverseWordInString(s));
		
	}
	private static String reverseWordInString(String s) {
		String[] splits = s.split(" ");
		String newStr= "";
		for(String str: splits) {
			newStr= str+" "+newStr;
		}
		return newStr;
	}

}
