package tree;

public class BinaryIndexedTree {

	int[] arr= {1, -1, 2, 8, 5, 6, 8};
	int[] bit;
	
	public static void main(String[] args) {
		BinaryIndexedTree bi= new BinaryIndexedTree();
		bi.constructTree(bi.arr);
		int l= 3;
		int sum= bi.findSum(bi.bit, l);
		System.out.println("Sum in range [0 - "+l+"] is "+sum);
		bi.update(bi.arr, bi.bit, 3, 10);
		sum= bi.findSum(bi.bit, l);
		System.out.println("Sum in range [0 - "+l+"] is "+sum);
		
	}
	
	void constructTree(int[] arr) {
		int l= arr.length;
		bit= new int[l+1];
		for(int i= 0;i< l;i++) {
			update(arr, bit, i, arr[i]);
		}
	}

	void update(int[] arr, int[] bit, int index, int newVal) {
		index= index+1;
		while(index<= arr.length) {
			bit[index]+= newVal;
			index= index + (index & (-index));
		}
	}
	
	int findSum(int[] bit, int index) {
		index= index+1;
		int sum= 0;
		while(index>0) {
			sum+= bit[index];
			index= index - (index & (-index));
		}
		
		return sum;
	}

}
