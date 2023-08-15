package kr.green.maven0702.thread2;

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
	 }

}
