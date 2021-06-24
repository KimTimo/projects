package kr.green.lang;

public class Ex05 {

	public static void main(String[] args) {
		/*
		 * 문제 : "일월화수목금토"를 세로로된 문자열로 만들어 출력하시오.
		 */
		String week = "일월화수목금토";
		String d = "";
		for(String s : week.split("")) d += s + "\n";
		System.out.println(week);
		System.out.println(d);
		
		d = String.join("-",week.split(""));
		d = d.replace('-', '\n');
		System.out.println(d);
		
		System.out.println("한사람".compareTo("두사람"));
		System.out.println("두사람".compareTo("세사람"));
		System.out.println("세사람".compareTo("두사람"));
		
	}

}
