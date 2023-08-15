package kr.green.maven0702.thread1;

import javax.swing.JOptionPane;


public class Ex07_Thread {
	public static void main(String[] args) {
		// 멀티 스레드
		new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0;i<30;i++) {
					System.out.println("힘내라~~~");
					// 일시 정지 : 1/1000초 단위
					try { Thread.sleep(500); } catch (InterruptedException e) { ; }
				}
			}
		}).start();
		

		String name = JOptionPane.showInputDialog("이름을 입력하세요?","한사람");
		System.out.println(name + "씨 방가방가~~~~");
		
	}
}
