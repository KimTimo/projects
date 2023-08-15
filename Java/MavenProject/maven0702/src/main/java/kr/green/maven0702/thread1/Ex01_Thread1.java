package kr.green.maven0702.thread1;

public class Ex01_Thread1 {
	public static void main(String[] args) {
		// 싱글 스레드
		for(char i='A';i<='Z';i++) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		for(int i=1;i<=26;i++) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}
