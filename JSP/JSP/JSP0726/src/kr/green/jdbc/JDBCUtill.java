package kr.green.jdbc;
// 매 페이지마다 연결하고 닫는 코드를 쓰면 비효율적이라 클래스로 뺀다.

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtill {
	// 연결하기 1
	public static Connection getConnection() {
		String driverName = "org.mariadb.jdbc.Driver";
		String url = "jdbc:mariadb://localhost:3306/jspdb";
		String user = "jspuser";
		String password = "123456";

		Connection conn = null;
		try {
			Class.forName(driverName);
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	// 연결하기 2
	// 인수로 4개를 받으면 어떤 DBMS든 접속이 가능한 메서드가 된다.
	public static Connection getConnection2(String driverName, String url, String user, String password) {
		Connection conn = null;
		try {
			Class.forName(driverName);
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	// 닫기 메서드 3개를 만든다.
	public static void close(Connection conn) { // 연결 닫기
		try {
			if(conn!=null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void close(Statement stmt) { // 명령 닫기
		try {
			if(stmt!=null) stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void close(ResultSet rs) { // 결과 닫기
		try {
			if(rs!=null) rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void rollback(Connection conn) {
		try {
			if(conn!=null) conn.rollback(); // 명령 취소
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
