package amazon_alexa;

/**
 * Question:
 * It is presidential election time.Mr X is fighting for the president.The country has N number of cities.
   The cities are divided into developed & developing city on basis of a developemt index A.
   If A is 1, then the city is developed. If A is 0, then the city is developing.
   A close source to Mr X told that all the people from developing cities will vote for him while people
   from only k number of developed cities will vote for him.
   Find out the no of maximum vote in favour & minimum vote in against Mr X will get.

	Input
	------
	10 3
	0 12
	0 6
	0 7
	1 8
	1 12
	1 17
	1 20
	1 22
	1 5
	1 6

	First 2 line gives no of cities N= 10 & number of developed cities vote for Mr X k= 3
	Next 10 lines give the development index A & number of people in the city
	For example in the first line A= 0, no of people= 12
 * 
 */



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
