package interview_experience;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordbreakProblemEfficient {

	static Set<String> dictionary= new HashSet<String>() {
		{
			add("cat");
			add("sand");
			add("dog");
			add("cats");
			add("and");
			add("sam");
			add("sung");
			add("samsung");
		}
	};
	public static void main(String[] args) {
		String str= "catsanddog";
//		str= "samsung";
		List<String> validwords= new ArrayList<>();
	//(str, validwords);
		wordBreakUtil(str, validwords, "");
		
		for(String s: validwords) {
			System.out.println(s);
		}
	//	System.out.println("");
	//	printValidwords();
		
	}
	
	static void wordBreakUtil(String str, List<String> validwords, String result)
	{
		int size= str.length();
	    //Process all prefixes one by one
	    for (int i=0; i<=size; i++)
	    {
	        //extract substring from 0 to i in prefix
	        String prefix = str.substring(0, i);
	
	        if (dictionary.contains(prefix))
	        {
	        	//   validwords.add(prefix);
	        	   String s= str.substring(i);
	        	   if(s.isEmpty()) {
	        		   validwords.add(result+prefix);
	        	   } else {
	        		   wordBreakUtil(str.substring(i),validwords, result+prefix+" ");
	        	   }
	            
	        }
	    }      //end for
	}//end function
	
	
	static void printValidwords() {
		String s= "catsanddog";
		int l= s.length();
		List<String> []p= new ArrayList[l+1];
		p[0]= new ArrayList<String>();
		for(int i= 0;i<s.length();i++) {
			if(p[i]!= null) {
				for(int j= i;j<l+1;j++) {
					String str= s.substring(i, j);
					if(dictionary.contains(str)) {
						if(p[j]!= null) {
							p[j].add(str);
						} else {
							p[j]= new ArrayList<String>();
							p[j].add(str);
						}
					}
				}
			}
		}
		
		printWord("", l, l, p);
	}
	
	static void printWord(String prefix, int l, int index, List<String> []p) {
		if(index== 0) {
			System.out.println(prefix);
			return;
		}
		if(p[index]!= null) {
			for(String s: p[index]) {
				String str= s+" "+prefix;
				printWord(str, l, index-s.length(), p);
			}
		}
		
	}

}
