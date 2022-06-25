package kr.green.maven0702.thread6;

public class Ex {
	public static void main(String[] args) {
		SharedArea1 area = new SharedArea1(); // 은행
        area.account1 = new Account("111-111-1111", "이몽룡", 20000000); // 계좌 1
        area.account2 = new Account("222-222-2222", "성춘향", 10000000); // 계좌 2

        TransferThread thread1 = new TransferThread(area);
        PrintThread1 thread2 = new PrintThread1(area);

        thread1.start();
        thread2.start();
	}
}
