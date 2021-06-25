package kr.green.maven0625.sb;

public class SBEx2 {

	public static void main(String[] args) {
		int i = 101;
		
		System.out.println(i);
		StringBuffer stringBulder = new StringBuffer(i + "");
		System.out.println(stringBulder);
		
		stringBulder.reverse();
		System.out.println(stringBulder);
	}

}
