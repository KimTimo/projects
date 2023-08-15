package kr.green.maven0709.sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Test4 {
	public static void main(String[] a) {
		// 1. 드라이버를 로드한다.
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		// 2. 준비
		Connection conn = null; // 연결 객체
		PreparedStatement stmt = null; // 명령 객체
		ResultSet rs = null; // 결과 객체

		System.out.println("사자성어 검색 프로그램!!!!");
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("찾고자하는 사자성어를 입력하세요(0은 종료)? ");
			String word = sc.nextLine();
			if(word.charAt(0)=='0') break;
			try {
				// 3. 연결
				conn = DriverManager.getConnection("jdbc:sqlite:src/main/resources/license.db");
				// 4. 사용
				// System.out.println("연결 성공 : " + conn);
				// 바뀌는 부분을 ?로 코딩한다.
				String sql = "SELECT * FROM data WHERE k=?";
				// 명령을 만든다. 아직은 미완성 명령이다.
				stmt = conn.prepareStatement(sql);
				// ? 를 값으로 바꿔준다.
				stmt.setString(1, word);

				rs = stmt.executeQuery();
				if (rs.next()) {
					System.out.println(rs.getString("h") + "(" + rs.getString("h") + ") : " + rs.getString("t"));
				} else {
					System.out.println("당신이 입력한 사자성어는 존재하지 않습니다.");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				// 5. 닫기 (열기의 역순으로 닫는다.)
				try {
					if (rs != null)
						rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				try {
					if (stmt != null)
						stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				try {
					if (conn != null)
						conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		sc.close();
	}
}