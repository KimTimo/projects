package kr.green.guestbook.dao;

public class GuestBookDAO {
	// -----------------------------------------------------------------------------------
	// 싱글톤으로 만들자
	// 1. 자기 자신의 객체를 정적멤버로 가진다.
	private static GuestBookDAO instance = new GuestBookDAO();
	// 2. 외부에서 객체를 생성하지 못하도록 생성자를 private으로 만든다.
	private GuestBookDAO() {}
	// 3. 만들어진 객체를 외부에서 얻어서 사요할 수 있도록 객체를 얻는 메서드를 만든다.
	public static GuestBookDAO getInstance() { return instance; }
	// -----------------------------------------------------------------------------------
	
	
}
