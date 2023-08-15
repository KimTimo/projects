package kr.green.maven0629.exam;

public class Ex02 {
	public static void main(String[] args) {
		split("c910m6ia 1ho");
	}

	public static void split(String str) {
		StringBuilder strSb = new StringBuilder();
		StringBuilder numSb = new StringBuilder();
		for(char ch : str.toCharArray()) {
			if("0123456789".contains(ch+""))
				numSb.append(ch);
			else
				strSb.append(ch);
		}
		System.out.println("str : " + strSb.toString());
		System.out.println("nutm : " + numSb.toString());
	}

}
