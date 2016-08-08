package string;

public class RunLengthEncoding {

	public static void main(String[] args) {
		String s= "wwwwwaaadexxxxxx";
		String runLengthEncoding = runLengthEncoding(s);
		System.out.println(runLengthEncoding);
	}
	
	private static String runLengthEncoding(String given) {
		int l= given.length();
		int count= 1;
		Character first= given.charAt(0);
		String newStr= "";
		for(int i= 1;i<l;i++) {
			if(first== given.charAt(i)) {
				count++;
			} else {
				newStr= newStr+first+count;
				count= 1;
				first= given.charAt(i);
			}
			if(i== l-1) {
				newStr= newStr+first+count;
			}
		}
		
		return newStr;
	}

}
