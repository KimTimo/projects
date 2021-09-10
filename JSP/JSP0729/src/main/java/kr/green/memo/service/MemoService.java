package kr.green.memo.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import kr.green.jdbc.DBCPUtil;
import kr.green.memo.dao.MemoDAO;
import kr.green.memo.vo.MemoVO;

public class MemoService {
	// --------------------------------------------------------------------------------------
	// 1. 자기 자신의 객체를 정적 멤버로 가진다.
	private static MemoService instance = new MemoService();

	// 2. 외부에서 객체를 만들지 못하도록 생성자를 private으로 만든다.
	private MemoService() {
		;
	}

	// 3. 외부에서 객체를 얻을 수 있도록 메서드를 만들어 준다.
	public static MemoService getInstance() {
		return instance;
	}

	// --------------------------------------------------------------------------------------
	// 실제 로직 1개당 1개의 메서드를 만든다.
	// 1. 목록보기(전체보기)
	public List<MemoVO> selectList() {
		List<MemoVO> list = null; // 여기
		MemoDAO dao = MemoDAO.getInstance();
		Connection conn = null;
		try {
			conn = DBCPUtil.getConnection();
			conn.setAutoCommit(false);
			// ------------------------------------
			// 여기
			list = dao.selectAll(conn);
			// ------------------------------------
			conn.commit();
		} catch (SQLException e) {
			DBCPUtil.rollback(conn);
			e.printStackTrace();
		} finally {
			DBCPUtil.close(conn);
		}
		return list; // 여기
	}
	// 2. 수정/삭제를 위해 1개 읽기
		public MemoVO selectByIdx(int idx) {
			MemoVO vo = null; // 여기
			MemoDAO dao = MemoDAO.getInstance();
			Connection conn = null;
			try {
				conn = DBCPUtil.getConnection();
				conn.setAutoCommit(false);
				// ------------------------------------
				// 여기
				vo = dao.selectByIdx(conn, idx);
				// ------------------------------------
				conn.commit();
			} catch (SQLException e) {
				DBCPUtil.rollback(conn);
				e.printStackTrace();
			} finally {
				DBCPUtil.close(conn);
			}
			return vo; // 여기
		}

	// 3. 저장하기
	public int insert(MemoVO memoVO) {
		int count = 0;
		MemoDAO dao = MemoDAO.getInstance();
		Connection conn = null;
		try {
			conn = DBCPUtil.getConnection();
			conn.setAutoCommit(false);
			// ------------------------------------
			// 여기
			// 데이터가 유효할때만 저장한다.
			if (memoVO != null) { // 객체가 전달되었느냐
				if (memoVO.getName() != null && memoVO.getName().trim().length() > 0) { // 이름이 존재하냐
					memoVO.setName(memoVO.getName().trim()); // 혹시라도 있을 수 있는 앞뒤의 공백을 제거
					if (memoVO.getPassword() != null && memoVO.getPassword().trim().length() > 0) { // 암호가 존재하냐
						memoVO.setPassword(memoVO.getPassword().trim()); // 혹시라도 있을 수 있는 앞뒤의 공백을 제거
						if (memoVO.getContent() != null && memoVO.getContent().trim().length() > 0) { // 내용이 존재하냐
							memoVO.setContent(memoVO.getContent().trim()); // 혹시라도 있을 수 있는 앞뒤의 공백을 제거
							// 여기까지 들어왔다는 것은 모든 내용이 있는 데이터이다. 그럼 저장만 하면된다.
							count = dao.insert(conn, memoVO);
						}
					}
				}
			}
			// ------------------------------------
			conn.commit();
		} catch (SQLException e) {
			DBCPUtil.rollback(conn);
			e.printStackTrace();
		} finally {
			DBCPUtil.close(conn);
		}
		return count;
	}

	// 4. 수정하기
	public int update(MemoVO memoVO) {
		int count = 0;
		MemoDAO dao = MemoDAO.getInstance();
		Connection conn = null;
		try {
			conn = DBCPUtil.getConnection();
			conn.setAutoCommit(false);
			// ------------------------------------
			// 여기
			// 데이터가 유효할때만 수정한다.
			if (memoVO != null) { // 객체가 전달되었느냐
				if (memoVO.getName() != null && memoVO.getName().trim().length() > 0) { // 이름이 존재하냐
					memoVO.setName(memoVO.getName().trim()); // 혹시라도 있을 수 있는 앞뒤의 공백을 제거
					if (memoVO.getPassword() != null && memoVO.getPassword().trim().length() > 0) { // 암호가 존재하냐
						memoVO.setPassword(memoVO.getPassword().trim()); // 혹시라도 있을 수 있는 앞뒤의 공백을 제거
						if (memoVO.getContent() != null && memoVO.getContent().trim().length() > 0) { // 내용이 존재하냐
							memoVO.setContent(memoVO.getContent().trim()); // 혹시라도 있을 수 있는 앞뒤의 공백을 제거
							// 여기까지 들어왔다는 것은 모든 내용이 있는 데이터이다. 그럼 수정을 하면된다.
							// 비밀번호가 같을때만 수정을 한다!
							// 1. DB에 저장된 비밀번호를 가져온다.
							MemoVO dbVO = dao.selectByIdx(conn, memoVO.getIdx()); // 현재 글번호의 글을 가져온다.
							// 2. 현재 비밀번호와 같으면 수정을 하고 다르면 수정을 하지 않는다.
							if (dbVO != null && dbVO.getPassword().equals(memoVO.getPassword())) {
								count = dao.update(conn, memoVO);
							}
						}
					}
				}
			}
			// ------------------------------------
			conn.commit();
		} catch (SQLException e) {
			DBCPUtil.rollback(conn);
			e.printStackTrace();
		} finally {
			DBCPUtil.close(conn);
		}
		return count;
	}

	// 5. 삭제하기
	public int delete(MemoVO memoVO) {
		int count = 0;
		MemoDAO dao = MemoDAO.getInstance();
		Connection conn = null;
		try {
			conn = DBCPUtil.getConnection();
			conn.setAutoCommit(false);
			// ------------------------------------
			// 여기
			// 데이터가 유효할때만 삭제한다.
			if (memoVO != null) { // 객체가 전달되었느냐
				if (memoVO.getPassword() != null && memoVO.getPassword().trim().length() > 0) { // 암호가 존재하냐
					memoVO.setPassword(memoVO.getPassword().trim()); // 혹시라도 있을 수 있는 앞뒤의 공백을 제거
					// 여기까지 들어왔다는 것은 모든 내용이 있는 데이터이다. 그럼 삭제를 하면된다.
					// 비밀번호가 같을때만 삭제를 한다!
					// 1. DB에 저장된 비밀번호를 가져온다.
					MemoVO dbVO = dao.selectByIdx(conn, memoVO.getIdx()); // 현재 글번호의 글을 가져온다.
					// 2. 현재 비밀번호와 같으면 삭제를 하고 다르면 수정을 하지 않는다.
					if (dbVO != null && dbVO.getPassword().equals(memoVO.getPassword())) {
						count = dao.delete(conn, memoVO.getIdx());
					}
				}
			}
			// ------------------------------------
			conn.commit();
		} catch (SQLException e) {
			DBCPUtil.rollback(conn);
			e.printStackTrace();
		} finally {
			DBCPUtil.close(conn);
		}
		return count;
	}

}
