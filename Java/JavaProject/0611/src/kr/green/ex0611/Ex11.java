package kr.green.ex0611;

public class Ex11 {

	public static void main(String[] args) {

		int p = 657_8963;
		System.out.println("피 같은 돈");
		System.out.println(p);
		
		// 1원단위 절삭
		System.out.println(p/10*10 + " : " + p%10);
		
		// 10원단위 절삭
		System.out.println(p/100*100 + " : " + p%100);
		
		// 100원단위 절삭
		System.out.println(p/1000*1000 + " : " + p%1000);
		
		// 1000원단위 절삭
		System.out.println(p/10000*10000 + " : " + p%10000);
	}

}
