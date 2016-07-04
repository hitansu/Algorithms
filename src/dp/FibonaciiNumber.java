package dp;

import java.util.HashMap;

public class FibonaciiNumber {

	HashMap<Integer, Integer> map= new HashMap<>();
	public static void main(String[] args) {
		FibonaciiNumber fibonaciiNumber= new FibonaciiNumber();
		int fiboLoop = fibonaciiNumber.fiboLoop(5);
		int fiboRec = fibonaciiNumber.fiboRec(5);
		System.out.println("Result fibo loop:: "+fiboLoop);
		System.out.println("Result fibo rec:: "+fiboRec);
	}
	
	int fiboRec(int n) {
		if(map.get(n)!= null) {
			return map.get(n);
		}
		
		if(n== 0) return 0;
		if(n== 1) return 1;
		int result= fiboRec(n-1)+fiboRec(n-2);
		map.put(n, result);
		return result;
	}
	
	int fiboLoop(int n) {
		int a= 0;
		if(n== 0) return a;
		System.out.print(a);
		int b= 1;
		System.out.print(","+b);
		int c;
		for(int i= 2;i<= n;i++ ) {
			c= a+b;
			a= b;
			b= c;
			System.out.print(","+b);
		}
		System.out.println("");
		
		return b;
	}

}
