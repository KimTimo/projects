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

public class JSON2Sqlite {
	public static void main(String[] args) {
		List<LicenseVO> list = readJSON();
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
		try {
			// 3. 연결
			conn = DriverManager.getConnection("jdbc:sqlite:src/main/resources/license.db");
			System.out.println("연결 성공 : " + conn);
			// 4. 사용
			// 반복문을 돌면서 저장해주는 메서드를 호출
			for(LicenseVO vo : list) {
				insert(conn, vo);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	// vo 1개를 DB에 저장해주는 메서드
	public static void insert(Connection conn, LicenseVO vo) {
		PreparedStatement pstmt = null;
		String sql = "insert into license (type, question, ans1, ans2, ans3, ans4, ans5, cor1, cor2, desc, contents ) values (?,?,?,?,?,?,?,?,?,?,?)";
		try {
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getType());
			pstmt.setString(2, vo.getQuestion());
			pstmt.setString(3, vo.getAns1()==null ? "" : vo.getAns1() );
			pstmt.setString(4, vo.getAns2()==null ? "" : vo.getAns2() );
			pstmt.setString(5, vo.getAns3()==null ? "" : vo.getAns3() );
			pstmt.setString(6, vo.getAns4()==null ? "" : vo.getAns4() );
			pstmt.setString(7, vo.getAns5()==null ? "" : vo.getAns5() );
			pstmt.setInt(8, vo.getCor1());
			pstmt.setInt(9, vo.getCor2());
			pstmt.setString(10, vo.getDesc()==null ? "" : vo.getDesc() );
			pstmt.setString(11, vo.getContents()==null ? "" : vo.getContents() );
			
			int count = pstmt.executeUpdate();
			conn.commit();
			System.out.println("저장 완료 : " + vo.getIdx() + "번");
			
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
	public static List<LicenseVO> readJSON(){
		Gson gson = new Gson();
		FileInputStream fis = null;
		InputStreamReader isr = null;
		List<LicenseVO> list = null;
		try {
			fis = new FileInputStream("src/main/resources/license.json");
			isr = new InputStreamReader(fis);
			
			list = gson.fromJson(isr, new TypeToken<List<LicenseVO>>() {}.getType());
			
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
