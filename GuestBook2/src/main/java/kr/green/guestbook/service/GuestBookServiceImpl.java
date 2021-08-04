package kr.green.guestbook.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import kr.green.guestbook.dao.GuestBookDAO;
import kr.green.guestbook.vo.GuestBookVO;
import kr.green.guestbook.vo.PagingVO;
import kr.green.jdbc.DBCPUtil;

public class GuestBookServiceImpl implements GuestBookService {
	// -----------------------------------------------------------------------------------
	// 싱글톤으로 만들자
	// 1. 자기 자신의 객체를 정적멤버로 가진다.
	private static GuestBookServiceImpl instance = new GuestBookServiceImpl();

	// 2. 외부에서 객체를 생성하지 못하도록 생성자를 private으로 만든다.
	private GuestBookServiceImpl() {}

	// 3. 만들어진 객체를 외부에서 얻어서 사요할 수 있도록 객체를 얻는 메서드를 만든다.
	public static GuestBookServiceImpl getInstance() {
		return instance;
	}
	// -----------------------------------------------------------------------------------
	@Override
	public PagingVO<GuestBookVO> selectList(int currentPage, int pageSize, int blockSize) {
		PagingVO<GuestBookVO> pagingVO = null; // 이 부분만 변경 된다.
		Connection conn = null;
		GuestBookDAO dao = null;
		try {
			conn = DBCPUtil.getConnection();
			dao = GuestBookDAO.getInstance();
			conn.setAutoCommit(false);
			// -------------------------------------------
			// 이 부분만 변경 된다.
			int totalCount = dao.selectCount(conn); // 전체 개수를 구한다.
			pagingVO = new PagingVO<GuestBookVO>(currentPage, pageSize, blockSize, totalCount); // 페이지 계산을 한다.
			// 1페이지 분량을 가져와서 넣는다.
			List<GuestBookVO> list = dao.selectList(conn, pagingVO.getStartNo(), pagingVO.getPageSize());
			pagingVO.setList(list);
			// -------------------------------------------
			conn.commit();
		} catch (SQLException e) {
			DBCPUtil.rollback(conn);
			e.printStackTrace();
		} finally {
			DBCPUtil.close(conn);
		}
		return pagingVO; // 이 부분만 변경 된다.
	}

	@Override
	public GuestBookVO selectByIdx(int idx) {
		GuestBookVO guestBookVO = null;
		Connection conn = null;
		GuestBookDAO dao = null;
		try {
			conn = DBCPUtil.getConnection();
			dao = GuestBookDAO.getInstance();
			conn.setAutoCommit(false);
			// -------------------------------------------
			// 이 부분만 변경 된다.
			guestBookVO = dao.selectByIdx(conn, idx);
			// -------------------------------------------
			conn.commit();
		} catch (SQLException e) {
			DBCPUtil.rollback(conn);
			e.printStackTrace();
		} finally {
			DBCPUtil.close(conn);
		}
		return guestBookVO;
	}

	@Override
	public int insert(GuestBookVO guestBookVO) {
		int count = 0;
		Connection conn = null;
		GuestBookDAO dao = null;
		try {
			conn = DBCPUtil.getConnection();
			dao = GuestBookDAO.getInstance();
			conn.setAutoCommit(false);
			// -------------------------------------------
			// 이 부분만 변경 된다.
			if (guestBookVO != null) {
				if (guestBookVO.getName() != null && guestBookVO.getName().trim().length() > 0) {
					guestBookVO.setName(guestBookVO.getName().trim()); // 혹시라도 앞뒤의 공백이 있다면 공백 제거
					if (guestBookVO.getPassword() != null && guestBookVO.getPassword().trim().length() > 0) {
						// guestBookVO.setName(guestBookVO.getName().trim());
						if (guestBookVO.getContent() != null && guestBookVO.getContent().trim().length() > 0) {
							guestBookVO.setContent(guestBookVO.getContent().trim());

							// 여기까지 왔다는것은 사용자가 입력한 내용이 모두 있다는 것이다. 저장하면 된다.
							count = dao.insert(conn, guestBookVO);

						}
					}
				}
			}
			// -------------------------------------------
			conn.commit();
		} catch (SQLException e) {
			DBCPUtil.rollback(conn);
			e.printStackTrace();
		} finally {
			DBCPUtil.close(conn);
		}
		return count;
	}

	@Override
	public int update(GuestBookVO guestBookVO) {
		int count = 0;
		Connection conn = null;
		GuestBookDAO dao = null;
		try {
			conn = DBCPUtil.getConnection();
			dao = GuestBookDAO.getInstance();
			conn.setAutoCommit(false);
			// -------------------------------------------
			// 이 부분만 변경 된다.
			if (guestBookVO != null) {
				if (guestBookVO.getName() != null && guestBookVO.getName().trim().length() > 0) {
					guestBookVO.setName(guestBookVO.getName().trim()); // 혹시라도 앞뒤의 공백이 있다면 공백 제거
					if (guestBookVO.getPassword() != null && guestBookVO.getPassword().trim().length() > 0) {
						// guestBookVO.setName(guestBookVO.getName().trim());
						if (guestBookVO.getContent() != null && guestBookVO.getContent().trim().length() > 0) {
							guestBookVO.setContent(guestBookVO.getContent().trim());

							// 여기까지 왔다는것은 사용자가 입력한 내용이 모두 있다는 것이다. 수정하면 된다.
							// 수정할때는 비밀번호가 일치할때만 수정을 해야 한다.
							GuestBookVO dbVO = dao.selectByIdx(conn, guestBookVO.getIdx()); // DB에서 해당 글번호의 글을 얻기
							if (dbVO != null) { // 해당 글번호의 글이 있는 경우에만
								// 디비 비번과 넘어온 비번이 일치하면
								if (dbVO.getPassword() != null
										&& dbVO.getPassword().equals(guestBookVO.getPassword())) {
									// 수정하면 된다.
									count = dao.update(conn, guestBookVO);
								}
							}
						}
					}
				}
			}
			// -------------------------------------------
			conn.commit();
		} catch (SQLException e) {
			DBCPUtil.rollback(conn);
			e.printStackTrace();
		} finally {
			DBCPUtil.close(conn);
		}
		return count;
	}

	@Override
	public int delete(GuestBookVO guestBookVO) {
		int count = 0;
		Connection conn = null;
		GuestBookDAO dao = null;
		try {
			conn = DBCPUtil.getConnection();
			dao = GuestBookDAO.getInstance();
			conn.setAutoCommit(false);
			// -------------------------------------------
			// 이 부분만 변경 된다.
			if (guestBookVO != null) {
				if (guestBookVO.getPassword() != null && guestBookVO.getPassword().trim().length() > 0) {
					// 비밀번호가 있다면
					// 삭제할때는 비밀번호가 일치할때만 삭제을 해야 한다.
					GuestBookVO dbVO = dao.selectByIdx(conn, guestBookVO.getIdx()); // DB에서 해당 글번호의 글을 얻기
					if (dbVO != null) { // 해당 글번호의 글이 있는 경우에만
						// 디비 비번과 넘어온 비번이 일치하면
						if (dbVO.getPassword() != null && dbVO.getPassword().equals(guestBookVO.getPassword())) {
							// 삭제하면 된다.
							count = dao.delete(conn, guestBookVO.getIdx());
						}
					}
				}
			}
			// -------------------------------------------
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
