package math;

public class FindPower {

	public static void main(String[] args) {
		int x= 4;
		int y= 3;
		int ans= findPower(x, y);
		System.out.println(ans);
		ans= findPower1(x, y);
		System.out.println(ans);
	}
	
	static int findPower(int x, int y) {
		if(y== 0)
			return 1;
		int tmp= findPower(x, y/2);
		if(y%2== 0) {
			return tmp*tmp;
		} else {
			return x*tmp*tmp;
		}
	}
	
	static int findPower1(int x, int y) {
		if(y== 0)
			return 1;
		if(y%2== 0) {
			return findPower1(x, y/2)*findPower1(x, y/2);
		} else {
			return x*findPower1(x, y/2)*findPower1(x, y/2);
		}
	}

}
