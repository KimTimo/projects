package kr.green.maven0702.thread3;

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
	 }

}
