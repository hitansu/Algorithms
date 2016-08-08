package string;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MinWindowToContainAllChars {

	private static Set<Character> keySet;

	public static void main(String[] args) {
		String text= "ABBACBAA";
		String pat= "AAB";
		text= "XBBACDXMAEXA";
		pat= "XA";

		findMinwindow1(text, pat);
	}
	
	private static void findMinwindow(String text, String pat) {
		
		Map<Character, Integer> req= new HashMap<>();
		int l= pat.length();
		for(int i= 0;i<l;i++) {
			if(req.containsKey(pat.charAt(i))) {
				req.put(pat.charAt(i), req.get(pat.charAt(i))+1);
			} else {
				req.put(pat.charAt(i), 1);
			}
		}
		
		Map<Character, Integer> curr= new HashMap<>();
		int strt= 0;
		int j= 0;
		int n= text.length();
		int minW= Integer.MAX_VALUE;
		int minI= -1;
		int minJ= -1;
		while(j<n) {
			if(!req.containsKey(text.charAt(j))) {
				if(minW!= Integer.MAX_VALUE && j-strt+1>=(minW-1)) strt++;
				j++;
				
				continue;
			}
			
			if(curr.containsKey(text.charAt(j))) {
				curr.put(text.charAt(j), curr.get(text.charAt(j))+1);
			} else {
				curr.put(text.charAt(j), 1);
			}
			
			if(matched(req, curr)) {
				if(minW> j+1-strt) {
					minW= j-strt+1;
					minJ= j;
					minI= strt;
					curr.clear();
				}
				j= j+1;
				strt= j+1-(minW-1);
			} else {
				if(minW!= Integer.MAX_VALUE && j-strt+1>=(minW-1)) strt++;
				j++;
				
			}
		}
		
		System.out.println("MinW:: "+minW +" MinI:: "+minI +" MinJ:: "+minJ);
	}

	private static boolean matched(Map<Character, Integer> req, Map<Character, Integer> curr) {
        keySet = req.keySet();
        for(Character key: keySet) {
        	if(curr.get(key)== null || curr.get(key)< req.get(key)) return false;
        }
		return true;
	}
	
private static void findMinwindow1(String text, String pat) {
		
		Map<Character, Integer> req= new HashMap<>();
		Map<Character, Integer> curr= new HashMap<>();
		int minW= Integer.MAX_VALUE;
		int l= pat.length();
		int count= 0;
		int minI= -1;
		int minJ= -1;
		int n= text.length();
		int j= 0;
		
		for(int i= 0;i<l;i++) {
			if(req.containsKey(pat.charAt(i))) {
				req.put(pat.charAt(i), req.get(pat.charAt(i))+1);
			} else {
				req.put(pat.charAt(i), 1);
			}
		}
		
		for(int i= 0;i<n;i++) {
			if(!req.containsKey(text.charAt(i))) {
				continue;
			}
			Character c= text.charAt(i);
			if(curr.containsKey(c)) {
				curr.put(c, curr.get(c)+1);
			} else {
				curr.put(c, 1);
			}
			
			if(req.get(c)>= curr.get(c)) {
				count++;
			}
			
			if(count== l) {
				while(!req.containsKey(text.charAt(j)) || curr.get(text.charAt(j))>req.get(text.charAt(j))) {
					if(curr.containsKey(text.charAt(j)) && curr.get(text.charAt(j))>req.get(text.charAt(j))) {
						curr.put(text.charAt(j), curr.get(text.charAt(j))-1);
					}
				    j++;
				}
				if(minW>i-j+1) {
					minW= i-j+1;
					minJ= j;
					minI= i;
				}
			}
		}
		System.out.println("MinW:: "+minW +" MinI:: "+minI +" MinJ:: "+minJ);
	}
}
