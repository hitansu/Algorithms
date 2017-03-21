package tree;

public class SegmentTreeSumRangeQuery {


	int[] arr= {1, 3, 2, 7, 9, -1};
    int[] seg;
	
	public static void main(String[] args) {
		SegmentTreeSumRangeQuery segTree= new SegmentTreeSumRangeQuery();
		segTree.createSegmentTree(segTree.arr);
		int qs= 2;
		int qe= 4;
		int sum= segTree.querySum(qs, qe);
		System.out.println("Sum  between range ["+qs+","+qe+"] is "+sum);
	}
	
	void createSegmentTree(int[] arr) {
		int l= arr.length;
		int x= (int) Math.ceil(Math.log(l)/Math.log(2));
		int max_size= (int) (2*Math.pow(2, x) - 1);
		seg= new int[max_size];
		createSegmentTreeUtil(0, l-1, arr, seg, 0);
		
	}

	private int createSegmentTreeUtil(int l, int h, int[] arr, int[] seg, int i) {
		if(l== h) {
			seg[i]= arr[l];
			return seg[i];
		}
		
		int mid= l+((h-l)/2);
		seg[i]= createSegmentTreeUtil(l, mid, arr, seg, 2*i+1)+createSegmentTreeUtil(mid+1, h, arr, seg, 2*i+2);
		return seg[i];
	}
	
	private int querySum(int qs, int qe) {
		if(qe<qs)
			throw new IllegalStateException("Invalid range");
		return querySumUtil(seg, 0, arr.length-1, qs, qe, 0);
	}
	
	private int querySumUtil(int[] seg, int l, int h, int qs, int qe, int i) {
		if(qs<= l && qe>= h) {
			return seg[i];
		}
		if(qs>h || qe<l) return 0;
		
		int mid= l+((h-l)/2);
		
		return querySumUtil(seg, l, mid, qs, qe, 2*i+1) + querySumUtil(seg, mid+1, h, qs, qe, 2*i+2);
	}


}
