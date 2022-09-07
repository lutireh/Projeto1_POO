import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.TreeSet;

public class WordGraph {
    private TreeMap<String, TreeSet<String>> graph = new TreeMap<>();

    public void connect(String word1, String word2) {
        if (graph.get(word1) == null) {
            graph.put(word1, new TreeSet<>());
        }
        graph.get(word1).add(word2);
    }

    public void exportCSV(String outFile) throws IOException {
        try (Writer out = new BufferedWriter(new FileWriter(outFile))) {
            for (Entry<String, TreeSet<String>> entry : graph.entrySet()) {
                out.write(entry.getKey());

                for (String val : entry.getValue()) {
                    out.write("," + val);
                }

                out.write("\n");
            }
        }
    }
}
