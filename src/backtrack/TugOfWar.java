package backtrack;

public class TugOfWar {
	static int minDiff= Integer.MAX_VALUE;
	public static void main(String[] args) {
		//int[] data= {3, 4, 5, -3, 100, 1, 89, 54, 23, 20};
		int[] data= {23, 45, -34, 12, 0, 98, -99, 4, 189, -1, 4};
		int n= data.length;
		int currIndex= 0;

		boolean[] selected= new boolean[n];
		boolean[] solution= new boolean[n];
		
		solveTugOfWar(n,data,selected,solution,currIndex);
		System.out.println(minDiff);
		printSolution(solution, data);
	}

	private static void printSolution(boolean[] solution, int[] data) {
		int size= solution.length;
		int sum1= 0;
		int sum2= 0;
		for(int i= 0;i<size;i++) {
			if(solution[i]) {
				sum1+= data[i];
				System.out.print(data[i]+" ");
			}
			if(i== size-1) 
				System.out.print(": "+sum1);
		}
		System.out.println("");
		for(int i= 0;i<size;i++) {
			if(!solution[i]) {
				sum2+= data[i];
			    System.out.print(data[i]+" ");
			}
			if(i== size-1) 
				System.out.print(": "+sum2);
		}
	}

	private static void solveTugOfWar(int size,int[] data, boolean[] selected, boolean[] solution, int currIndex) {
		int solSize= 0;
		for(int i=0;i<size;i++) {
			if(selected[i]) {
				solSize++;
			}
		}
		
		if(solSize== size/2) {
			int diff= getDiff(selected, data);
			if(diff<minDiff) {
				minDiff= diff;
				updateSolution(selected,solution);
			}
		}
		
		if(currIndex>= size) return;
		selected[currIndex]= true;
		solveTugOfWar(size, data, selected, solution, currIndex+1);
		selected[currIndex]= false;
		solveTugOfWar(size, data, selected, solution, currIndex+1);
		
	}

	private static void updateSolution(boolean[] selected, boolean[] solution) {
		int size= selected.length;
		for(int i=0;i<size;i++) {
				solution[i]= selected[i];
		}
		
	}

	private static int getDiff(boolean[] selected, int[] data) {
		int leftSum= 0;
		int rightSum= 0;
		int n= data.length;
		for(int i=0;i<n;i++) {
			if(selected[i]) {
				leftSum+= data[i];
			} else {
				rightSum+= data[i];
			}
		}
		int diff= leftSum-rightSum;
		return Math.abs(diff);
	}
	
	

}
