import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Graph {
	private TreeMap<String, Set<String>> graph = new TreeMap<>();
	
	public Graph(ArrayList<String> words) {
		String prev = null;
		
		for (String word : words) {
			if (prev != null) {
				graph.get(prev).add(word);
			}
			if (!graph.containsKey(word)) {
				graph.put(word, new TreeSet<>());
			}
			prev = word;
		}
	}
	
	public void printGraph() {
		for (Entry<String, Set<String>> entry : graph.entrySet()) {
			System.out.print(entry.getKey() + ": ");
			for (String word : entry.getValue()) {
				System.out.print(word + " ");
			}
			System.out.println();
		}
	}
	
}
