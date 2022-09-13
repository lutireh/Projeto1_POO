import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.TreeSet;
    /** This class sorts the words into a list and exports them in a CVS archive;
     *
     *@autor group4
     */
public class WordGraph {
  
      /** Method for conect two words 
     *
     * @param word1
     * @param word2
     */
    private TreeMap<String, TreeSet<String>> graph = new TreeMap<>();
    
  /** method that (arrange/sort) the words into adjacency lists;
 *
 */
    public void connect(String word1, String word2) {

        if (graph.get(word1) == null) {
            graph.put(word1, new TreeSet<>());
        }
        graph.get(word1).add(word2);
    }
   /** Method responsible for receive the list, convert and export the list in a CVS archive form;
         *
         */
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
