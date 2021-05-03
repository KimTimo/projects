
public class StringMethodExam {

	public static void main(String[] args) {

		//String srt = new String("hello");
		String str = "hello";

		System.out.println(str.length());
		System.out.println(str.concat(" world"));
		str = str.concat(" world");
		System.out.println(str);
		
		System.out.println(str.substring(3));
		System.out.println(str.substring(3, 7));
	}

}
