import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) throws IOException {
		Scanner sc=new Scanner(System.in);
		System.out.print("digite o caminho do arquivo:");
		String path=sc.nextLine();
		Leitura l=new Leitura(path);
		//l.scan();
		ArrayList<String> words = l.scan2();
		Graph graph = new Graph(words);
		graph.printGraph();
		sc.close();
	}

}
