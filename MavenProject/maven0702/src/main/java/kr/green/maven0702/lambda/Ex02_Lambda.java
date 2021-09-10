package kr.green.maven0702.lambda;

interface Calculator3{
	int calc(int n, int m);
}
public class Ex02_Lambda {
	public static void main(String[] args) {
		
		Calculator3 addCalc = new Calculator3() {
			
			@Override
			public int calc(int n, int m) {
				return n + m;
			}
		};
		// 람다식 : 익명함수의 구현
		Calculator3 add = (x,y) -> x + y;
		Calculator3 sub = (x,y) -> x - y;
		Calculator3 mul = (x,y) -> x * y;
		Calculator3 div = (x,y) -> x / y;
		Calculator3 mod = (x,y) -> x % y;
		
		System.out.println(add.calc(4, 6));
		System.out.println(sub.calc(4, 6));
		System.out.println(mul.calc(4, 6));
		System.out.println(div.calc(4, 6));
		System.out.println(mod.calc(4, 6));
	}

}
