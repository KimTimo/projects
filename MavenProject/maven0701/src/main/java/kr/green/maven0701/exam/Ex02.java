package kr.green.maven0701.exam;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/*
수 암호화 프로그램
0~25만의 수 1개를 입력으로 받으면 그 수를 암호화하여 출력하는 프로그램을 작성하세요. 
방법은 다음과 같습니다. 
1. 입력받은 수의 제곱근에 1000을 곱한다. (예시: 2 => 1.414213... * 1000 => 1414.213...) 
2. 1의 결과에서 소수점 이하를 버림한다. (예시: 1414.213... => 1414) 
3. 2의 결과에서 입력받은 수를 뺀다.(예시: 1414 => 1414 - 2 => 1412) 이렇게 하면 2를 입력받았을 때 1412를 출력합니다. 
다음 결과로 테스트하세요.

>>> password(2)
1412
>>> password(125000)
228553
>>> password(250000)
250000
>>> password(100000)
216227
*/
public class Ex02 {

	public static void main(String[] args) {
		System.out.println(getPassword(2));
		System.out.println(getPassword(125000));
		System.out.println(getPassword(250000));
		System.out.println(getPassword(100000));
	}
	
	@Test
	public void test() {
		assertEquals(getPassword(2), 1412);
		assertEquals(getPassword(125000), 228553);
		assertEquals(getPassword(250000), 250000);
		assertEquals(getPassword(100000), 216227);
	}
	
	public static int getPassword(int n) {
		return (int)(Math.sqrt(n)*1000) - n;
		
	}
}
