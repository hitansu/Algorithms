package amazon_alexa;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Source2 {

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T= in.nextInt();
        while(T> 0) {
        	solve(in);
        	T--;
        }
	}

	private static void solve(Scanner in) {
		
		final int totalCity= in.nextInt();
        final int developedCityFavVoteCount= in.nextInt();
        
        int totalPeopleDevelopingCity= 0;
        int totalPeopleDevelopedCity= 0;
        
        final int DEVELOPED= 1;
        final int DEVELOPING= 0;
        
        // Min heap to get the top k fav vote
        PriorityQueue<Integer> minHeap= new PriorityQueue<>(developedCityFavVoteCount, new Comparator<Integer>() {

			@Override
			public int compare(Integer a, Integer b) {
				return a.compareTo(b);
			}
		});
        
        int k= 0;
        for(int i= 1;i<= totalCity;i++) {
        	int developmentIndex= in.nextInt();
        	int people= in.nextInt();
        	
        	if(developmentIndex== DEVELOPING) {
        		totalPeopleDevelopingCity+= people;
        	} else if(developmentIndex== DEVELOPED){
        		if(k< developedCityFavVoteCount) {
        			minHeap.offer(people);
        			k++;
        		} else {
        			if(minHeap.peek()<people) {
        				minHeap.poll();
        				minHeap.offer(people);
        			}
        		}
        		totalPeopleDevelopedCity+= people;        	
          }
        }
        
        //count for total fav vote
        int total_fav_vote= totalPeopleDevelopingCity;
        
        //count for total fav vote in developed city
        int total_fav_vote_developed= 0;
        for(int i= 0;i< developedCityFavVoteCount;i++) {
        	total_fav_vote_developed+= minHeap.poll();
        }
        
        total_fav_vote+= total_fav_vote_developed;
        int min_against_vote= totalPeopleDevelopedCity - total_fav_vote_developed;
        
        System.out.println(total_fav_vote+" "+min_against_vote);
	}

}
