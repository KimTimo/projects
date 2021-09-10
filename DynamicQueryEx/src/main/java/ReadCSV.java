import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadCSV {
	public static void main(String[] args) {
		Scanner sc = null;
		try {
			sc = new Scanner(new File("src/main/resources/aac_intakes.csv"));
			while(sc.hasNextLine()) {
				String[] lines = sc.nextLine().split(",");
				System.out.println(lines[1] + " : " + lines[2] + " : "+ lines[10]);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}finally {
			if(sc!=null) sc.close();
		}
	}

}
