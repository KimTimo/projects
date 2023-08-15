package kr.green.maven0709.hsqldb;

import java.sql.*;

public class Test2 {
	public static void main(String[] a) {
		// 1. 드라이버를 로드한다.
		try {
			Class.forName("org.hsqldb.jdbcDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		// 2. 준비
		Connection conn = null; // 연결 객체
		Statement  stmt = null; // 명령 객체
		ResultSet  rs = null;   // 결과 객체
		try {
			// 3. 연결
			conn = DriverManager.getConnection("jdbc:hsqldb:file:mydb", "sa", "");
			// 4. 사용
			System.out.println("연결 성공 : " + conn);
			stmt = conn.createStatement();

			// 이미 테이블이 있으면 삭제해라
			String sql = "DROP TABLE IF EXISTS person";
			stmt = conn.createStatement();
			// 테이블이 있다면 만들지 말어라
			sql = "create table if not EXISTS person( idx int primary key, name varchar(20) not null, age int(5) default 0)";
			int count = stmt.executeUpdate(sql); // select명령을 제외한 모든 명령은 executeUpdate으로 실행
			System.out.println("실행 결과 : " + count);
			
			sql = "insert into person (name, age) values(1,'한사람', 22)";
			count = stmt.executeUpdate(sql);
			sql = "insert into person values(2,'두사람', 54)";
			count = stmt.executeUpdate(sql);
			sql = "insert into person values(3,'세사람', 12)";
			count = stmt.executeUpdate(sql);
			System.out.println("저장 성공");
			
			sql = "select * from person order by age desc";
			rs = stmt.executeQuery(sql);
			
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			if(rs.next()) {
				do {
					System.out.println("번호 : " + rs.getInt("idx"));
					System.out.println("이름 : " + rs.getString("name"));
					System.out.println("나이 : " + rs.getInt("age"));
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				}while(rs.next());
			}else {
				System.out.println("데이터가 없습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 5. 닫기 (열기의 역순으로 닫는다.)
			try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
		}
	}
}