package heap;

import java.util.ArrayList;
import java.util.List;

public class Heap <T extends Comparable<T>>{
	
	List<T> elements;
	int size;
	
	public Heap() {
		elements= new ArrayList<>();
		size= 0;
	}
	
	int getSize() {
		return size;
	}
	
	public int addElement(T data) {
		elements.add(data);
		++size;
		shiftUp();
		return size;
		
	}
	
	public T getTop() {
		if(size== 0) {
			throw new RuntimeException("Heap is empty");
		}
		return elements.get(0);
	}
	
	public T delete() {
		if(size== 0) {
			throw new RuntimeException("Can't delete from empty heap");
		}
		T data= elements.get(0);
		elements.set(0, elements.get(size-1));
		elements.remove(size-1);
		--size;
		shiftDown();
		
		
		return data;
		
	}

	private void shiftDown() {
		int pos= 0;
		int l= 2*pos+1;
		int max= pos;
		while(l<size) {
			int r= l+1;
			
			if(elements.get(max).compareTo(elements.get(l))<0) {
				max= l;
			}
			if(r<size && elements.get(max).compareTo(elements.get(r))<0) {
				max= r;
			}
			if(max!= pos) {
				T tmp= elements.get(pos);
				elements.set(pos, elements.get(max));
				elements.set(max, tmp);
				pos= max;
				l= 2*l+1;
			} else {
				break;
			}
			
		}
		
	}

	private void shiftUp() {
		int pos= size-1;
		while(pos>= 0) {
			int p= (pos-1)/2;
			if(p>= 0 && elements.get(pos).compareTo(elements.get(p))>0) {
				T tmp= elements.get(pos);
				elements.set(pos, elements.get(p));
				elements.set(p, tmp);
				pos= p;		
			} else {
				break;
			}
		}
	}

}
