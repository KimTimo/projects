package kr.green.maven0628.enumex;

public class EnumEx01 {
	// 열거형 지원전  
	final static int CLOVER  = 0;
	final static int HEART   = 1;
	final static int DIAMOND = 2;
	final static int SPADE   = 3;
	
	public static void main(String[] args) {
		
		System.out.println(EnumEx01.CLOVER);
		
		int kind = EnumEx01.SPADE;
		
		System.out.println(kind);

		kind = 7;
		System.out.println(kind);
	}
}
