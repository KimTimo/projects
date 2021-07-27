package kr.green.jdbc.dao;

import java.sql.Connection;
import java.sql.SQLException;

import kr.green.jdbc.JDBCUtil;
import kr.green.jdbc.vo.SampleVO;

public class Test {
	public static void main(String[] args) {
		SampleDAO dao = SampleDAOImpl.getInstance();
		Connection conn = null;
		try {
			conn = JDBCUtil.getConnection();
			System.out.println(dao.getCount(conn) + "개");
			System.out.println(dao.selectByIdx(conn, 5));
			System.out.println(dao.selectList(conn, 1, 10));
		    SampleVO vo = new SampleVO();
		    vo.setName("머현쿤");
		    vo.setAge(26);
		    vo.setGender("M");
		    System.out.println(dao.insert(conn, vo) + "개 추가");
		    System.out.println(dao.getCount(conn) + "개");
		    vo.setIdx(5);
		    vo.setName("현지양");
		    vo.setAge(24);
		    vo.setGender("F");
		    System.out.println(dao.selectByIdx(conn, 5));
		    System.out.println(dao.update(conn, vo) + "개 수정");             
		    System.out.println(dao.selectByIdx(conn, 5));
		    
		    vo = dao.selectByIdx(conn, 5);
		    System.out.println(vo!=null ? vo : "5번 없다!!!");
		    dao.delete(conn, 5);
		    vo = dao.selectByIdx(conn, 5);
		    System.out.println(vo!=null ? vo : "5번 없다!!!");
		    
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn);
		}
	}

}
