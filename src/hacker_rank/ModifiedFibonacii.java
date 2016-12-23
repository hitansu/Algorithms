package hacker_rank;

import java.math.BigInteger;

public class ModifiedFibonacii {

	public static void main(String[] args) {
		BigInteger t1= new BigInteger(""+0);
		BigInteger t2= new BigInteger(""+1);
		int n=10;
        for(int i= 3;i<=n;i++) {
        	BigInteger temp= t2;
        	t2= t1.add(t2.multiply(t2));
            t1= temp;
        }
        System.out.println(t2);

	}

}
