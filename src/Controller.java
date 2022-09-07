import java.io.IOException;

public class Controller {

    public void run(String[] args) throws IOException {
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
