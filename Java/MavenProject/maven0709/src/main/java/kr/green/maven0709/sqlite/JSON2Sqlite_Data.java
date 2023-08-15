package kr.green.maven0709.sqlite;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class JSON2Sqlite_Data {
	public static void main(String[] args) {
		List<DataVO> list = readJSON();
		System.out.println(list.size() + "개를 읽었습니다.");
		// 샘플로 10개만 출력해보자
		for(int i=0;i<10;i++) {
			System.out.println(list.get(i));
		}
		// 이제 데이터 베이스에 저장해 보자
		// 연결 만들고
		// 1. 드라이버를 로드한다.
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		// 2. 준비
		Connection conn = null; // 연결 객체
		Statement stmt = null;
		try {
			// 3. 연결
			conn = DriverManager.getConnection("jdbc:sqlite:src/main/resources/license.db");
			System.out.println("연결 성공 : " + conn);
			conn.setAutoCommit(false);
			// 4. 사용
			// 테이블 작성
			StringBuilder sb = new StringBuilder();
			sb.append("create table if not exists data(");
			sb.append("idx integer primary key autoincrement,");
			sb.append("l varchar(20) not null,");
			sb.append("h varchar(20) not null,");
			sb.append("k varchar(20) not null,");
			sb.append("t text not null)");
			
			stmt = conn.createStatement();
			stmt.executeUpdate(sb.toString());
			System.out.println("테이블 생성 완료");
			
			stmt.executeUpdate("delete from data where idx>0");
			conn.commit();
			System.out.println("모든 데이터 삭제 완료");
			
			 //반복문을 돌면서 저장해주는 메서드를 호출
			for(DataVO vo : list) {
				insert(conn, vo);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	// vo 1개를 DB에 저장해주는 메서드
	public static void insert(Connection conn, DataVO vo) {
		PreparedStatement pstmt = null;
		String sql = "insert into data (l,h,k,t) values (?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getL());
			pstmt.setString(2, vo.getH());
			pstmt.setString(3, vo.getK());
			pstmt.setString(4, vo.getT());
			
			pstmt.executeUpdate();
			conn.commit();
			System.out.println("저장 완료!! " + vo);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	// json파일을 리스트 읽어서 리턴하는 메서드
	public static List<DataVO> readJSON(){
		Gson gson = new Gson();
		FileInputStream fis = null;
		InputStreamReader isr = null;
		List<DataVO> list = null;
		try {
			fis = new FileInputStream("src/main/resources/data.json");
			isr = new InputStreamReader(fis);
			
			list = gson.fromJson(isr, new TypeToken<List<DataVO>>() {}.getType());
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				isr.close();
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
}
