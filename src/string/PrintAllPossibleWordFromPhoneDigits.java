package string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrintAllPossibleWordFromPhoneDigits {

	static Map<String, List<String>> digits;
	
	public static void main(String[] args) {

		digits= new HashMap<String, List<String>> ();
		digits.put("1", Arrays.asList(""));
		digits.put("0", Arrays.asList(""));
		digits.put("*", Arrays.asList(""));
		digits.put("#", Arrays.asList(""));
		digits.put("2", Arrays.asList("A","B","C"));
		digits.put("3", Arrays.asList("D","E","F"));
		digits.put("4", Arrays.asList("G","H","I"));
		digits.put("5", Arrays.asList("J","K","L"));
		digits.put("6", Arrays.asList("M","N","O"));
		digits.put("7", Arrays.asList("P","Q","R", "S"));
		digits.put("8", Arrays.asList("T","U","V"));
		digits.put("9", Arrays.asList("W","X","Y", "Z"));
		
		String telNo= "234";
		String prefix= "";
		int i= 0;
		printPhoneCharacters(telNo, prefix, i);
	}

	private static void printPhoneCharacters(String telNo, String prefix, int i) {
		if(i== telNo.length()) {
			System.out.println(prefix);
			return;
		}
		Character c= telNo.charAt(i);
		i= i+1;
		List<String> list = digits.get(c.toString());
		int size= list.size();
		for(int j= 0;j<size;j++) {
			printPhoneCharacters(telNo, prefix+list.get(j), i);
		}
	}

}
