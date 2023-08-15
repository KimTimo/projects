package kr.green.core.vo;

public class Communication {

	private Messaging messaging;

	// 생성자를 통한 의존성 주입
	public Communication(){
		; // 다른 생성자를 만들면 기본 생성자도 같이 만들어 주어라. 
	}
	public Communication(Messaging messaging) {
		this.messaging = messaging;
	}
	
	
	// Setter를 통한 의존성 주입
	public void setMessaging(Messaging messaging) {
		this.messaging = messaging;
	}


	public void communicate() {
		messaging.sendMessage();
	}
}