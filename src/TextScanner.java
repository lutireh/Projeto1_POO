import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Scanner;

public class TextScanner {
    /**
     * This class (receives?/reads?) the listed text archives imputed by the program user;(Split?/divide?/select?) the words that will be used, removes punctuation and accentuation, and converts all letter to small letters ;
     * @autor group4
     * @version 1.?
     * @param inFile
     * @return
     * @throws IOException
     */

    public ArrayList<String> scan(String inFile) throws IOException {
        /**
         *
         */

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
