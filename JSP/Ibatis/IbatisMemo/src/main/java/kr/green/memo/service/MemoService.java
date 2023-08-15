package kr.green.memo.service;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.green.ibatis.IbatisApp;
import kr.green.memo.dao.MemoDAO;
import kr.green.memo.vo.MemoVO;
import kr.green.memo.vo.PagingVO;

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
	// 1. 목록보기(1페이지 분량보기)
	public PagingVO<MemoVO> selectList(int currentPage, int pageSize, int blockSize) {
		PagingVO<MemoVO> pagingVO = null; // -------------------------- 여기
		MemoDAO dao = MemoDAO.getInstance();
		SqlMapClient sqlMapClient = null;
		try {
			sqlMapClient = IbatisApp.getSqlMapClient();
			sqlMapClient.startTransaction();
			// -----------------------------------------------
			// 여기
			int totalCount = dao.getCount(sqlMapClient); // 전체 개수
			pagingVO = new PagingVO<MemoVO>(currentPage, pageSize, blockSize, totalCount); // 페이지 계산완료
			// 1페이지 분량만 가져와서
			List<MemoVO> list = dao.selectList(sqlMapClient, pagingVO.getStartNo(), pagingVO.getPageSize());
			pagingVO.setList(list); // 넣어준다.
			// -----------------------------------------------
			sqlMapClient.commitTransaction();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				sqlMapClient.endTransaction();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return pagingVO; // -------------------------- 여기 이렇게 세부분만 틀리다.
	}
	//------------------------------------------------------------------------------------------------

	// 2. 수정/삭제를 위해 1개 읽기
	public MemoVO selectByIdx(int idx) {
		MemoVO vo = null; // -------------------------- 여기
		MemoDAO dao = MemoDAO.getInstance();
		SqlMapClient sqlMapClient = null;
		try {
			sqlMapClient = IbatisApp.getSqlMapClient();
			sqlMapClient.startTransaction();
			// -----------------------------------------------
			vo = dao.selectByIdx(sqlMapClient, idx);
			// -----------------------------------------------
			sqlMapClient.commitTransaction();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				sqlMapClient.endTransaction();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return vo; // -------------------------- 여기 이렇게 세부분만 틀리다.
	}
	
	// 3. 저장하기
	public void insert(MemoVO memoVO) {
		MemoDAO dao = MemoDAO.getInstance();
		SqlMapClient sqlMapClient = null;
		try {
			sqlMapClient = IbatisApp.getSqlMapClient();
			sqlMapClient.startTransaction();
			// -----------------------------------------------
			if(memoVO!=null) dao.insert(sqlMapClient, memoVO);			
			// -----------------------------------------------
			sqlMapClient.commitTransaction();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				sqlMapClient.endTransaction();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// 4. 수정하기
	public void update(MemoVO memoVO) {
		MemoDAO dao = MemoDAO.getInstance();
		SqlMapClient sqlMapClient = null;
		try {
			sqlMapClient = IbatisApp.getSqlMapClient();
			sqlMapClient.startTransaction();
			// -----------------------------------------------
			if(memoVO!=null) {
				MemoVO dbVO = dao.selectByIdx(sqlMapClient, memoVO.getIdx());
				if(dbVO!=null && dbVO.getPassword().equals(memoVO.getPassword())){
					dao.update(sqlMapClient, memoVO);			
				}
			}
			// -----------------------------------------------
			sqlMapClient.commitTransaction();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				sqlMapClient.endTransaction();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// 5. 삭제하기
	public void delete(MemoVO memoVO) {
		MemoDAO dao = MemoDAO.getInstance();
		SqlMapClient sqlMapClient = null;
		try {
			sqlMapClient = IbatisApp.getSqlMapClient();
			sqlMapClient.startTransaction();
			// -----------------------------------------------
			if(memoVO!=null) {
				MemoVO dbVO = dao.selectByIdx(sqlMapClient, memoVO.getIdx());
				if(dbVO!=null && dbVO.getPassword().equals(memoVO.getPassword())){
					dao.delete(sqlMapClient, memoVO.getIdx());	
				}
			}
			// -----------------------------------------------
			sqlMapClient.commitTransaction();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				sqlMapClient.endTransaction();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
