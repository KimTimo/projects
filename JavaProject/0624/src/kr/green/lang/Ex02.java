package kr.green.lang;

public class Ex02 {

	public static void main(String[] args) {
		String str = "1234qwertyqwerty";
		System.out.println(str.indexOf('a'));
		System.out.println(str.indexOf('e'));
		System.out.println(str.lastIndexOf('e'));
		
		String str2 = "한사람 두사람 홍익사람";
		System.out.println(str2);
		str2 = str2.replace("사람", "인간");
		System.out.println(str2);
		str2 = str2.replace(" ", "");
		System.out.println(str2);
		str2 = str2.replace("간", "간, ");
		System.out.println(str2);
		str2 = str2.replace(",", "");
		System.out.println(str2);
		
		
		str2 = str2.replace(' ','\t');
		System.out.println(str2);
		str2 = str2.replace('\t','\n');
		System.out.println(str2);
		
		
	}

}
