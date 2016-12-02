package exam;

public class Test2 {

	public static void main(String[] args) {
		int[] a= new int[30];
		for(int i=0;i<30;i++) {
			a[i]= i+1;
		}
		int[] b= new int[] { 1, 2, 4, 5,7, 29, 30 };
		System.out.println(solution1(a));
		System.out.println(solution(a));
	}
	
	static int solution1(int[] A) {
        boolean[] isDayWithTrip = new boolean[31];
        for (final int dayWithTrip : A) {
               isDayWithTrip[dayWithTrip] = true;
        }

        int[] minCostUpThroughDay = new int[31];
        minCostUpThroughDay[0] = 0; 
        for (int d = 1; d <= 30; ++d) {
               if (!isDayWithTrip[d]) {
                      minCostUpThroughDay[d] = minCostUpThroughDay[d - 1];
                      continue;
               }

               int minCost;
               
               minCost = minCostUpThroughDay[d - 1] + 2;
               
               for (int prevD = Math.max(0, d - 7); prevD <= d - 4; ++prevD) {
                      minCost = Math.min(minCost, minCostUpThroughDay[prevD] + 7);
               }
               
               minCost = Math.min(minCost, 25);

               minCostUpThroughDay[d] = minCost;
        }

        return minCostUpThroughDay[30];

	}

	static int solution(int A[]) { // write your code in Java SE 8
		int n = A.length;

		int cost[] = new int[31];
		for (int i = 0; i < 30; i++) {
			cost[i] = 0;
		}

		int x = 0, y = 0;
		int k = 0;

		for (int i = A[0]; i <= A[n - 1]; i++) {
			if (i != A[k]) {
				cost[i] = cost[i - 1];
				continue;
			}

			if (i >= 1)
				x = cost[i - 1];

			if (i >= 7)
				y = cost[i - 7];

			cost[i] = (x + 2) > (y + 7) ? (y + 7) : (x + 2);

			k++;

		}

		return cost[A[n - 1]];
	}

}
