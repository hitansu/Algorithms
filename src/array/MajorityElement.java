package array;

public class MajorityElement {

	public static void main(String[] args) {
		
		int[] arr= {2, 2, 3, 5, 2, 2, 6};
		int index= findMajorityElement(arr);
		int length= arr.length;
		int count= 0;
		for(int i= 0;i<length;i++) {
			if(arr[index]== arr[i]) {
				count++;
			}
		}
		if(count>length/2) {
			System.out.println(arr[index]);
		} else {
			System.out.println("does not exist");
		}
	}
	
	private static int findMajorityElement(int[] a) {
		int l= a.length;
		int major_element= 0;
		int count= 1;
		for(int i= 1;i<l;i++) {
			if(a[major_element]== a[i]) {
				count++;
			} else {
				count--;
			}
			if(count== 0) {
				major_element= i;
				count= 1;
			}
		}
		return major_element;
	}

}
