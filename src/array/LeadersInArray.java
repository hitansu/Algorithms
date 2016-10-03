package array;

public class LeadersInArray {

	public static void main(String[] args) {
		int[] a= {16, 17, 4, 3, 5, 2};
		printLeadersInArray(a);
	}

	private static void printLeadersInArray(int[] a) {
		int size= a.length;
		System.out.print(a[size-1]+" ");
		int max= a[size-1];
		for(int i= size-2;i>=0;i--) {
			if(a[i]>max) {
				System.out.print(a[i]+" ");
				max= a[i];
			}
		}
		
	}
}
