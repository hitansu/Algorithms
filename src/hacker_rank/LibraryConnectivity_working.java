package hacker_rank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class LibraryConnectivity_working {

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int n = in.nextInt();
            int m = in.nextInt();
            int x = in.nextInt();
            int y = in.nextInt();
            Map<Integer, List<Integer>> hashMap = new HashMap<>();
            for(int a1 = 0; a1 < m; a1++){
                int city_1 = in.nextInt();
                int city_2 = in.nextInt();
				List<Integer> list1 = hashMap.get(city_1);
				List<Integer> list2 = hashMap.get(city_2);
				if (list1 == null)
					list1 = new ArrayList<>();
				if (list2 == null)
					list2 = new ArrayList<>();
				list1.add(city_2);
				list2.add(city_1);
				hashMap.put(city_1, list1);
				hashMap.put(city_2, list2);
			}
            getCost(hashMap, x, y, n);
        }
    }
    
    	public static void getCost( Map<Integer, List<Integer>> hashMap,
                                int costLib, int costRoad, int cities) {
        boolean visited[] = new boolean[cities+1];
        Arrays.fill(visited,false);
        long totalCost = 0;
        int visits;
        for(int i = 1 ; i <= cities ; i++) {
            if(!visited[i]) {
                visits = DFSVisit(hashMap,i,visited);
                totalCost +=  Math.min(((visits-1) * costRoad) + costLib, visits * costLib);
            }
        }
        System.out.println(totalCost);
    }

	public static int DFSVisit( Map<Integer, List<Integer>> hashMap, int src, boolean visited[]) {
        visited[src] = true;
        int visits = 1;
        List<Integer> list = hashMap.get(src);
        if(list == null)
            return visits;

        for(int i = 0 ; i < list.size() ; i++) {
            if(!visited[list.get(i)]) {
                visits += DFSVisit(hashMap,list.get(i),visited);
            }
        }
        return visits;
        
	}

}
