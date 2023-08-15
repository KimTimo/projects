import java.io.IOException;

public class Jungol_557 {

	public static void main(String[] args) throws IOException {

		char ch[] = new char[10];
		
		for(int i = 0; i < ch.length; i++) {
			ch[i] = (char) System.in.read();
		}
		for(int i = 0; i < ch.length-2; i+=3) {
			System.out.println(ch[i] + " ");
		}
		System.out.println();
		
		System.out.println(ch[0] + " " + ch[3] + ch[6]);
	}
}
