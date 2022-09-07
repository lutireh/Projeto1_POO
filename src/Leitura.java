import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Leitura {
	Scanner sc=new Scanner(System.in);
	private String path;
	public Leitura(String path) {
		this.path = path;
	}
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	public List<String> scan() {
		List<String>list=new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String line = br.readLine();
			while (line != null) {
				for (String word : line.split(" ")) {
					list.add(word);
				}
				line = br.readLine();
			}
		} catch (IOException e) {
			System.out.println("Error:" + e.getMessage());
		}
		for(String l: list) {
			System.out.println(l);
		}
		return list;
	}
	
	public ArrayList<String> scan2() throws FileNotFoundException {
		Scanner scanner = new Scanner(new BufferedReader(new FileReader(path)));
		ArrayList<String> list = new ArrayList<>();
		
		while (scanner.hasNext()) {
			list.add(scanner.next().toLowerCase());
		}
		for(String l: list) {
			System.out.println(l);
		}
		return list;
	}
}
