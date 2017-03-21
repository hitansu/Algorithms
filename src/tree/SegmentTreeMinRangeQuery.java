package tree;

public class SegmentTreeMinRangeQuery {

	int[] arr= {1, 3, 2, 7, 9, -1};
    int[] seg;
	
	public static void main(String[] args) {
		SegmentTreeMinRangeQuery segTree= new SegmentTreeMinRangeQuery();
		segTree.createSegmentTree(segTree.arr);
		int qs= 1;
		int qe= 5;
		int min= segTree.queryMinimum(qs, qe);
		System.out.println("Min value between range ["+qs+","+qe+"] is "+min);
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
		seg[i]= Math.min(createSegmentTreeUtil(l, mid, arr, seg, 2*i+1), createSegmentTreeUtil(mid+1, h, arr, seg, 2*i+2));
		return seg[i];
	}
	
	private int queryMinimum(int qs, int qe) {
		if(qe<qs)
			throw new IllegalStateException("Invalid range");
		return queryMinUtil(seg, 0, arr.length-1, qs, qe, 0);
	}
	
	private int queryMinUtil(int[] seg, int l, int h, int qs, int qe, int i) {
		if(qs<= l && qe>= h) {
			return seg[i];
		}
		if(qs>h || qe<l) return Integer.MAX_VALUE;
		
		int mid= l+((h-l)/2);
		return Math.min(queryMinUtil(seg, l, mid, qs, qe, 2*i+1), queryMinUtil(seg, mid+1, h, qs, qe, 2*i+2));
	}

}
