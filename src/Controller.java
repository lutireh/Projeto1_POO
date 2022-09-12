import java.io.IOException;

public class Controller {
    /**
     *This class controls program execution, coordinating the other classes;
     * @autor group4
     * @param args
     * @throws IOException
     */
    public void run(String[] args) throws IOException {
        /**This method receives the text archive name,and generate a cvs file with the same name;
         *
         */
        if (args.length == 0) {
            throw new IllegalArgumentException("Expected at least one input file");
        }

        for (String arg : args) {
            if (!arg.endsWith(".txt")) {
                throw new IllegalArgumentException("Input file name must end with '.txt' extension");
            }

            String inFile = arg;
            String outFile = arg.replace(".txt", ".csv");

            generateWordGraph(inFile, outFile);
        }
    }

    protected void generateWordGraph(String inFile, String outFile) throws IOException {
        /**Method that generates and export the word graph into the cvs file;
         *
         */
        TextScanner scanner = new TextScanner();
        WordGraph graph = new WordGraph();

        String prev = "";
        for (String word : scanner.scan(inFile)) {
            if (!prev.isEmpty()) {
                graph.connect(prev, word);
            }
            prev = word;
        }

        graph.exportCSV(outFile);
    }
}
