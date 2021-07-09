package kr.green.maven0709.hsqldb;

import java.sql.*;

import java.sql.*;

public class Test {
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
         stmt.executeUpdate("create table dual(dummy varchar(1))");
         stmt.executeUpdate("insert into dual (dummy) values ('X')");
         String sql = "select now(), SYSDATE";
         stmt = conn.createStatement();  // 연결을 통해 명령 생성
         rs = stmt.executeQuery(sql);    // 명령을 실행에 결과에 넣고
         if(rs.next()) {                 // 결과가 있으면
            System.out.println("DB 날짜 : " + rs.getString(1)); // 첫번째 값을 읽어서 출력해라.. 0부터가 아니라 1부터다
            System.out.println("DB 날짜 : " + rs.getString(2)); // 첫번째 값을 읽어서 출력해라.. 0부터가 아니라 1부터다
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