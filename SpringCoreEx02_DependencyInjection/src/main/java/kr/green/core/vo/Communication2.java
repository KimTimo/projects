package kr.green.core.vo;

public class Communication2 {

	private Encryption encryption;

	// 생성자를 통한 의존성 주입
	public Communication2(){
		; // 다른 생성자를 만들면 기본 생성자도 같이 만들어 주어라. 
	}
	public Communication2(Encryption encryption) {
		super();
		this.encryption = encryption;
	}
	
	public void encryption() {
		encryption.encryptData();
	}
}