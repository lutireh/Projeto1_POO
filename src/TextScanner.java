import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Scanner;

public class TextScanner {

    public ArrayList<String> scan(String inFile) throws IOException {
        ArrayList<String> tokens = new ArrayList<>();

        try (Reader in = new BufferedReader(new FileReader(inFile)); Scanner scanner = new Scanner(in)) {
            scanner.useDelimiter("[\\p{Space}\\p{Punct}]+");

            while (scanner.hasNext()) {
                tokens.add(scanner.next().toLowerCase());
            }
        }

        return tokens;
    }
}
