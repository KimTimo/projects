package kr.green.maven0702.thread8;

class CalcThread extends Thread {
	 SharedArea sharedArea ;
	 public void run(){
		 double total = 0.0;
		 for(int cnt=1; cnt<1000000000; cnt+=2){
			 if(cnt/2%2 ==0)
				 total += 1.0/cnt;
			 else 
				 total -= 1.0/cnt;			 
		 }
		 sharedArea.result = total*4; 
		 // 계산이 완료되었으니 완료되었다고 표시하자
		 sharedArea.isReady = true;
		 
		 
		 synchronized (sharedArea) {
			 sharedArea.notify(); // 통지 메세지를 보낸다. 잠들어있던 모든 스레드 중 제일 먼저 통지를 받는 객체가 깨어나 일한다.
		}
		 
		 /* 전원 기상.
		 sharedArea.notifyAll();
		 */
	 }

}
