package kr.green.maven0702.thread7;

// 모든 계좌 정보를 가지고 있는 클래스!!! -- 공유 영역
public class SharedArea1 {
	Account account1;
	Account account2;

	// 계좌끼리 이체를 하고 계좌의 합계를 구한다.
	// 그렇다면 이 메소드들은 다른곳에 있는 것보다 여기에 있는게 더 효율적이다.
	// 이체하는 메소드
	public void transfer() {
		// critical section의 동기화 : 작업전환이 이루어지면 안되는 critical section 을 불록으로 잡아준다.
		// 블록 내에서는 작업전환이 이루어지지 않는다.
		synchronized (this) {
			// 계좌 이체 기능을 수행하는 클래스
			account1.widthdraw(1000000);
			System.out.print("이몽룡 계좌 : 100만원 인출,");
			account2.deposit(1000000);
			System.out.println("성춘향 계좌 : 100만원 입금");
		}
	}

	
	// 위의 코드를 보면 메소드 내용 전체가 동기화 블록이다. 이런때는 동기화 블록 보다는 동기화 메소드로 만들면 좋다.
	
	// 총합을 구하는 메소드
	
	synchronized public long getTotal() {
		return account1.getBalance() + account2.getBalance();
	}
}
