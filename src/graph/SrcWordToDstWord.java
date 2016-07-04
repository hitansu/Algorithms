package graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SrcWordToDstWord {
	public static List<String> getSequence(Set<String> dictionary, String start, String end)	{
		Map<String, String> parent = new HashMap<String, String>();
		LinkedList<String> queue = new LinkedList<String>();
		queue.add(start);
		while(!queue.isEmpty())	{
			String curr = queue.removeFirst();
			for(int i = 0; i < curr.length(); i++)	{
				for(char ch = 'A'; ch <= 'Z'; ch++)	{
					String next = curr.substring(0,i) + ch + curr.substring(i+1);
					if(!parent.containsKey(next) && dictionary.contains(next))	{
						parent.put(next, curr);
						queue.addLast(next);
					}
				}
			}
		}
		if(!parent.containsKey(end))
			return null;
		LinkedList<String> sequence = new LinkedList<String>();
		sequence.addLast(end);
		String curr = end;
		while(!curr.equals(start))	{
			curr = parent.get(curr);
			sequence.addFirst(curr);
		}
		return sequence;
	}
	
	public static void main(String[] args) {
		HashSet<String> dictionary= new HashSet<>();
		dictionary.add("CAT");
		dictionary.add("COT");
		dictionary.add("COG");
		dictionary.add("CAG");
		dictionary.add("DAT");
		dictionary.add("DOT");
		dictionary.add("DOG");
		dictionary.add("CAD");
		dictionary.add("CDT");
		System.out.println(SrcWordToDstWord.getSequence(dictionary, "CAT", "DOG"));
	}
}
