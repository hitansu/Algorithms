package string;

import java.util.Stack;

public class DepthOfNestedParenthesis {

	public static void main(String[] args) {

		String s= "( ((X)) (((Y))) )";
		int depth= findDepth(s);
		System.out.print(depth);
		System.out.print(" "+findDepthWithoutExtraSpace(s)+" , ");
		
		s= "( a(b) (c) (d(e(f)g)h) I (j(k)l)m)";
		System.out.print(findDepth(s));
		System.out.print(" "+findDepthWithoutExtraSpace(s)+" , ");
		
		s= "( p((q)) ((s)t) )";
		System.out.print(findDepth(s));
		System.out.print(" "+findDepthWithoutExtraSpace(s)+" , ");
		
		s= "";
		System.out.print(findDepth(s));
		System.out.print(" "+findDepthWithoutExtraSpace(s)+" , ");
		
		s= "b) (c) ()";
		System.out.print(findDepth(s));
		System.out.print(" "+findDepthWithoutExtraSpace(s)+" , ");
		
		s= "(b) ((c) ()";
		System.out.print(findDepth(s));
		System.out.print(" "+findDepthWithoutExtraSpace(s)+" , ");
	}

	private static int findDepth(String s) {

		int l= s.length();
		if(l== 0) return 0;
		int i= 0;
		Stack<Character> stack= new Stack<>();
		int no_of_open_brace= 0;
		int max= Integer.MIN_VALUE;
		while(i<l) {
			if(s.charAt(i)== '(') {
				stack.push('(');
				no_of_open_brace++;
			} else if(s.charAt(i)== ')') {
				if(!stack.isEmpty()) {
					stack.pop();
					no_of_open_brace--;
				} else {
					return -1;
				}
				
			}
			if(max<no_of_open_brace) {
				max= no_of_open_brace;
			}
			i++;
		}
		if(!stack.isEmpty()) {
			return -1;
		}
		
		return max;
	}
	
	private static int findDepthWithoutExtraSpace(String s) {

		int l= s.length();
		if(l== 0) return 0;
		int i= 0;
		int no_of_open_brace= 0;
		int max= Integer.MIN_VALUE;
		while(i<l) {
			if(s.charAt(i)== '(') {
				no_of_open_brace++;
			} else if(s.charAt(i)== ')') {
					no_of_open_brace--;	
			}
			if(max<no_of_open_brace) {
				max= no_of_open_brace;
			}
			i++;
		}
		if(no_of_open_brace!= 0) {
			return -1;
		}
		
		return max;
	}

}
