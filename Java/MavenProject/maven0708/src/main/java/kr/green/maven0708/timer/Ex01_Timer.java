package kr.green.maven0708.timer;

import java.util.Timer;
import java.util.TimerTask;

public class Ex01_Timer {

	public static void main(String[] args) {
		Timer timer = new Timer();
		
		TimerTask task = new TimerTask() {
			int count = 0;
			public void run(){
				if(++count<5) {
					System.out.println("실행하라우" + System.currentTimeMillis());
				}else {
					timer.cancel();
				}
			}
		};
		timer.schedule(task, 1000, 1000);
		
	}

}
