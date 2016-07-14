package dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BoxStackingProblem {

	public static void main(String[] args) {
		int[][] arr= {
						{4, 6, 7},
						{1, 2, 3},
						{4, 5, 6},
						{10, 12, 32}
					};
		BoxStackingProblem prob= new BoxStackingProblem();
		int maxheight = prob.findMaxHeight(arr);
		System.out.println(maxheight);
		
	}
	
	private int findMaxHeight(int[][] arr) {
		int size= arr.length;
		List<Box> boxes= new ArrayList<>();
		for(int i= 0;i<size;i++) {
			int[] tmp= arr[i];
			boxes.add(new Box(tmp[0], tmp[1]<tmp[2]?tmp[1]:tmp[2], tmp[1]>tmp[2]?tmp[1]:tmp[2]));
			boxes.add(new Box(tmp[1], tmp[0]<tmp[2]?tmp[0]:tmp[2], tmp[0]>tmp[2]?tmp[0]:tmp[2]));
			boxes.add(new Box(tmp[2], tmp[1]<tmp[0]?tmp[1]:tmp[0], tmp[1]>tmp[0]?tmp[1]:tmp[0]));
		}
		
		int newSize= boxes.size();
		Collections.sort(boxes, comparator);
		int[] maxH= new int[newSize];
		for(int i= 0;i<newSize;i++) {
			maxH[i]= boxes.get(i).h;
		}
		int MAXHEIGHT= Integer.MIN_VALUE;
		
		for(int j= 1;j<newSize;j++) {
			for(int i= 0;i<j;i++) {
				Box boxI= boxes.get(i);
				Box boxJ= boxes.get(j);
				if(boxI.w>boxJ.w && boxI.d>boxJ.d && maxH[i]+boxJ.h>maxH[j]) {
					maxH[j]= maxH[i]+boxJ.h;
					if(MAXHEIGHT< maxH[j]) {
						MAXHEIGHT= maxH[j];
					}
				}
			}
		}
		
		return MAXHEIGHT;
	}
	
	Comparator<Box> comparator= new Comparator<BoxStackingProblem.Box>() {

		@Override
		public int compare(Box box1, Box box2) {
			return box2.w*box2.d-box1.w*box1.d;
		}
	};

	class Box {
		int h;
		int d;
		int w;
		public Box(int h, int d, int w) {
			this.h= h;
			this.d= d;
			this.w= w;
		}
	}

}
