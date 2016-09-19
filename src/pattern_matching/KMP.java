package pattern_matching;

public class KMP {

	public static void main(String[] args) {
		String text= "abxabcabcaby";
		text= "ABABDABACDABABCABAB";
		String pat= "abcaby";
		pat= "ABABCABAB";
		match(text, pat);
	}

	private static void match(String text, String pat) {
		int[] prefixSuffix= getPrefixSuffix(pat);
		int tL= text.length();
		int pL= pat.length();
		int j= 0;
		int i= 0;
		while(i<tL) {
			if(text.charAt(i)== pat.charAt(j)) {
				if(j== pL-1) {
					System.out.println("match found at: "+(i-pL+1));
				}
				i++;
				j++;
			} else {
				if(j!= 0)
					j= prefixSuffix[j-1];
				if(j== 0 && (text.charAt(i)== pat.charAt(j))) {
					i++;
					j++;
				} else if(j== 0 && (text.charAt(i)!= pat.charAt(j))) {
					i++;
				}
			}
		}
		
	}

	private static int[] getPrefixSuffix(String pat) {
		int j= 0;
		int[] prefixSuffixArr= new int[pat.length()];
		prefixSuffixArr[0]= 0;
		for(int i= 1;i< pat.length();i++) {
			if(pat.charAt(i)== pat.charAt(j)) {
				prefixSuffixArr[i]= j+1; 
				j++;
			} else {
				prefixSuffixArr[i]= 0;
				while(j>0) {
					if(pat.charAt(i)== pat.charAt(j)) {
						prefixSuffixArr[i]= j+1;
						j++;
						break;
					} else {
						j= prefixSuffixArr[j-1];
					}
				}
				if(j== 0 && pat.charAt(j)== pat.charAt(i)) {
					prefixSuffixArr[i]= j+1;
				}
			}
		}
		return prefixSuffixArr;
	}
}
