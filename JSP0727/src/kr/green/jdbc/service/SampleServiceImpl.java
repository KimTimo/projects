package kr.green.jdbc.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import kr.green.jdbc.JDBCUtil;
import kr.green.jdbc.dao.SampleDAO;
import kr.green.jdbc.dao.SampleDAOImpl;
import kr.green.jdbc.vo.SampleVO;

public class SampleServiceImpl implements SampleService{
	//---------------------------------------------------------------------------------
	// 싱글톤 패턴으로 작성하기
	// 1. 자기 자신의 객체를 정적 멤버로 가진다.
	private static SampleService instance = new SampleServiceImpl();
	// 2. 외부에서 객체를 생성하지 못하도록 생성자를 private으로 만든다.
	private SampleServiceImpl() {
		;
	}
	// 3. 자신의 객체를 얻는 메서드를 작성한다. 대부분 getInstance() 이다.
	public static SampleService getInstance() {
		return instance;
	}
	//---------------------------------------------------------------------------------
	@Override
	public SampleVO selectByIdx(int idx) {
		SampleVO sampleVO = null;  // 1. 이 부분 바뀐다.
		Connection conn = null;
		SampleDAO dao = null;
		try {
			conn = JDBCUtil.getConnection();
			dao = SampleDAOImpl.getInstance();
			conn.setAutoCommit(false);
			//----------------------------------------
			// 2. 이 부분 바뀐다.
			sampleVO = dao.selectByIdx(conn, idx);
			//----------------------------------------
			conn.commit();
		} catch (SQLException e) {
			JDBCUtil.rollback(conn);
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn);
		}
		// 3. 이 부분 바뀐다.
		return sampleVO;
	}
	@Override
	public List<SampleVO> selectList(int currentPage, int pageSize, int blockSize) {
		List<SampleVO> list = null;
		Connection conn = null;
		SampleDAO dao = null;
		try {
			conn = JDBCUtil.getConnection();
			dao = SampleDAOImpl.getInstance();
			conn.setAutoCommit(false);
			//----------------------------------------
			// 2. 이 부분 바뀐다.
			list = dao.selectList(conn, (currentPage-1)*pageSize, pageSize);
			//----------------------------------------
			conn.commit();
		} catch (SQLException e) {
			JDBCUtil.rollback(conn);
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn);
		}
		return list;
	}
	@Override
	public int insert(SampleVO vo) {
		int count = 0;
		Connection conn = null;
		SampleDAO dao = null;
		try {
			conn = JDBCUtil.getConnection();
			dao = SampleDAOImpl.getInstance();
			conn.setAutoCommit(false);
			//----------------------------------------
			// 2. 이 부분 바뀐다.
			count = dao.insert(conn, vo);
			//----------------------------------------
			conn.commit();
		} catch (SQLException e) {
			JDBCUtil.rollback(conn);
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn);
		}
		return count;
	}
	@Override
	public int update(SampleVO vo) {
		int count = 0;
		Connection conn = null;
		SampleDAO dao = null;
		try {
			conn = JDBCUtil.getConnection();
			dao = SampleDAOImpl.getInstance();
			conn.setAutoCommit(false);
			//----------------------------------------
			// 2. 이 부분 바뀐다.
			count = dao.update(conn, vo);
			//----------------------------------------
			conn.commit();
		} catch (SQLException e) {
			JDBCUtil.rollback(conn);
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn);
		}
		return count;
	}
	@Override
	public int delete(SampleVO vo) {
		int count = 0;
		Connection conn = null;
		SampleDAO dao = null;
		try {
			conn = JDBCUtil.getConnection();
			dao = SampleDAOImpl.getInstance();
			conn.setAutoCommit(false);
			//----------------------------------------
			// 2. 이 부분 바뀐다.
			count = dao.delete(conn, vo.getIdx());
			//----------------------------------------
			conn.commit();
		} catch (SQLException e) {
			JDBCUtil.rollback(conn);
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn);
		}
		return count;
	}
	

}
