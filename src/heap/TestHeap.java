package heap;

public class TestHeap {

	public static void main(String[] args) {
		Heap<Integer> heap = new Heap<>();
		heap.addElement(12);
		heap.addElement(10);
		heap.addElement(1);
		heap.addElement(20);
		heap.addElement(8);
		heap.addElement(22);
		heap.addElement(13);
		
		System.out.println("Max ele: "+heap.getTop());
		heap.delete();
		System.out.println("Max ele: "+heap.getTop());
		heap.delete();
		heap.delete();
		heap.addElement(14);
		System.out.println("Max ele: "+heap.getTop());
	}

}
