package string;

public class StringMatchWithWildCard {

	public static void main(String[] args) {
		String text= "geeksforgeeks";
		String pat= "ge?ks*i";
		System.out.println("Is matched- "+text +" , "+ pat+":: "+isStringMatched(text, pat));
		
		text= "geeks";
		pat= "g*ks";
		System.out.println("Is matched- "+text +" , "+ pat+":: "+isStringMatched(text, pat));
		
		text= "gee";
		pat= "g*k";
		System.out.println("Is matched- "+text +" , "+ pat+":: "+isStringMatched(text, pat));
		
		text= "pqrst";
		pat= "*pqrs";
		System.out.println("Is matched- "+text +" , "+ pat+":: "+isStringMatched(text, pat));
		
		text= "abcdhghgbcd";
		pat= "abc*bcd";
		System.out.println("Is matched- "+text +" , "+ pat+":: "+isStringMatched(text, pat));
		
		text= "abcd";
		pat= "abc*c?d";
		System.out.println("Is matched- "+text +" , "+ pat+":: "+isStringMatched(text, pat));
		
		text= "abcd";
		pat= "*c*d";
		System.out.println("Is matched- "+text +" , "+ pat+":: "+isStringMatched(text, pat));
		
		text= "abcd";
		pat= "*?c*d";
		System.out.println("Is matched- "+text +" , "+ pat+":: "+isStringMatched(text, pat));
		
		System.out.println("Is String matched:: "+isStringMatched(text, pat));
		
		text= "abcd";
		pat= "*?c***d";
		System.out.println(isStringMatched(text, pat));
	}
	
	private static boolean isStringMatched(String text, String pat) {
		int l= text.length();
		int n= pat.length();
		int starIndex= -1;
		int iIndex= -1;
		int i= 0;
		int j= 0;
		while(i<l) {
			if(j<n && ((text.charAt(i)== pat.charAt(j)) || (pat.charAt(j)== '?'))) {
				j++;
				i++;
			} else if(j<n && pat.charAt(j)== '*') {
				starIndex= j;
				iIndex= i;
				j++;
			} else if(starIndex!= -1) {
				j= starIndex+1;
				i= iIndex+1;
				iIndex++;
			} else {
				return false;
			}
		}
		
		while(j<n && pat.charAt(j)== '*') {
				j++;
		}
		
		if(j!= n) {
			return false;
		}
		return true;	
	}

}
