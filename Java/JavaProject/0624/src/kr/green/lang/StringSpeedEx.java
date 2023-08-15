package kr.green.lang;
/*
자바의 String클래스는 immutable(불변)객체이므로 연산시 마다 새로운 객체를 만들어 낸다.
그래서 연산이 많을 경우에는 StringBuffer, StringBuilder클래스를 사용하는것이 좋다!!!! 
StringBuffer와 StringBuilder클래스의 차이점은 멀티스레드 프로그램의 지원 여부에 있다.
싱글스레드 프로그램에서는 StringBuilder을 사용하고 멀티스레드 프로그램에서는 StringBuffer을 사용하면 된다.
 */
public class StringSpeedEx {
	public static void main(String[] args) {
		long start = 0;
		StringBuffer stringBuffer = new StringBuffer();
		StringBuilder stringBuilder = new StringBuilder();
		String string = "";
		
		start = System.nanoTime();
		for(int i=0;i<100000;i++) stringBuffer.append("꽝");
		System.out.println("실행시간 : " + (System.nanoTime()-start) + "ns");

		start = System.nanoTime();
		for(int i=0;i<100000;i++) stringBuilder.append("꽝");
		System.out.println("실행시간 : " + (System.nanoTime()-start) + "ns");
		
		start = System.nanoTime();
		for(int i=0;i<100000;i++) string += "꽝";
		System.out.println("실행시간 : " + (System.nanoTime()-start) + "ns");
	}
}
