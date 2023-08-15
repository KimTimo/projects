package kr.green.ex0611;

public class Ex08 {

	public static void main(String[] args) {

	
		byte a = 10, b = 21;
		//byte c = a + b; // byte + byte = int + int = int
		                // int를 byte에 대입해서 에러
		
		byte c = (byte)(a + b);
		System.out.println(c);
		
		double avg = (a + b) / 2; // int / int = int => double 
		System.out.println(avg);
		
	
		avg = (double)(a + b) / 2; // int / int = int => double 
		System.out.println(avg);
		
		avg = (a + b) / 2.;
		System.out.println(avg);
	}

}
