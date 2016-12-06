package dp;

import java.util.HashMap;
import java.util.Map;

public class DigitDecoding {

	static Map<String,Character> map= new HashMap<>();
	public static void main(String[] args) {
		
	/*	map.put("1", 'A');
		map.put("2", 'B');
		map.put("12",'L');
		map.put("21",'U');
		String digit= "121";
		findDecodings(digit, 3);*/
		
		System.out.println("*****************************************************");
		
		int[] arr= {1,2,1};
		Map<Integer,String> map1= new HashMap<>();
		map1.put(1, "A");
		map1.put(2, "B");
		map1.put(12, "L");
		map1.put(21, "U");
		printDecodings(arr, "", 0, map1);
		
	}
	
	static String findDecodings(String digit, int n) {
		if(n== 0) return "";
		if(n== 1) return ""+map.get(""+digit.charAt(n-1));
		String s= "";
		if(digit.charAt(n-1)>'0') {
		    s= findDecodings(digit, n-1)+map.get(""+digit.charAt(n-1));
			System.out.println(s);
		}
		if(n-2>= 0) {
			if(digit.charAt(n-2)>='0' && digit.charAt(n-1)<'7') {
				s= findDecodings(digit, n-2)+map.get(digit.substring(n-2,n));
				System.out.println(s);
			}
		}
		
		return s;
	}
	
	static void printDecodings(int[] arr, String prefix, int index, Map<Integer, String> map) {
		if(index== arr.length) {
			System.out.println(prefix);
		}
		
		for(int l= 1;l<= 2;l++) {
			if(index+l> arr.length) return;
			int no= getNo(arr, index, l);
			if(no<1 && no>26) continue;
			String s= prefix+map.get(no);
			printDecodings(arr, s, index+l, map);
		}
		
	}

	private static int getNo(int[] arr, int index, int l) {
		int low= index;
		int high= index+l-1;
		int no= 0;
		for(int i= low;i<= high;i++) {
			no= no*10+arr[i];
		}
		return no;
	}

}
