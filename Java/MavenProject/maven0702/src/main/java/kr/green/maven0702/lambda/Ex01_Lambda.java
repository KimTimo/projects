package kr.green.maven0702.lambda;

class Calculator1{
	public int calc(int n) {
		return n+1;
	}
}
interface Calculator2{
	int calc(int n);
}
public class Ex01_Lambda {
	public static void main(String[] args) {
		int n = 2;
		Calculator1 calculator = new Calculator1();
		System.out.println(calculator.calc(n));
		//--------------------------------------------
		Calculator2 calculator2 = new Calculator2() {
			
			@Override
			public int calc(int n) {
				return n+1;
			}
		};
		System.out.println(calculator2.calc(n));
		//-----------------------------------------
		// 람다식 : 익명함수의 구현
		Calculator2 calculator3 = (int x) ->{return x+1;};
		System.out.println(calculator3.calc(n));
		//------------------------------------------
		Calculator2 calculator4 = (x) -> x+1;
		System.out.println(calculator4.calc(n));
		
		Runnable runnable = ()-> System.out.println("움하하하하");
		runnable.run();
	}

}
