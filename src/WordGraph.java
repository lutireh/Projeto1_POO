import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.TreeSet;

public class WordGraph {
    /** This class sorts the words into a list and exports them in a CVS archive;
     *
     *@autor group4
     *@version 1.?
     *
     */
    private TreeMap<String, TreeSet<String>> graph = new TreeMap<>();
    /** Method for ?
     *
     * @param word1
     * @param word2
     */
    public void connect(String word1, String word2) {
/** method that (arrange/sort) the words into adjacency lists;
 *
 */
        if (graph.get(word1) == null) {
            graph.put(word1, new TreeSet<>());
        }
        graph.get(word1).add(word2);
    }

    public void exportCSV(String outFile) throws IOException {
        /** Method responsible for receive the list, convert and export the list in a CVS archive form;
         *
         */
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
