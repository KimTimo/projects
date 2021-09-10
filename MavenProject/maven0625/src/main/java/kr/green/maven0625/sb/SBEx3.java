package kr.green.maven0625.sb;

public class SBEx3 {

	public static void main(String[] args) {
		int i = 101;
		
		System.out.println(i);
		StringBuffer stringBuffer = new StringBuffer(i + "");
		System.out.println(stringBuffer);
		
		stringBuffer.reverse();
		System.out.println(stringBuffer);
	}

}
