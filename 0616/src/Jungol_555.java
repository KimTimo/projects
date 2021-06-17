import java.io.IOException;

public class Jungol_555 {

	public static void main(String[] args) throws IOException {

		char chr[] = new char[10];
		for(int i = 0; i < chr.length; i++) {
			chr[i] = (char) System.in.read();
		}
		for(int i = 0; i < chr.length; i++) {
			System.out.print(chr[i]);
		}
	}

}
