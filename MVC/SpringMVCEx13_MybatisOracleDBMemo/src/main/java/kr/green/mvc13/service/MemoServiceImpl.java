package kr.green.mvc13.service;

import java.sql.SQLException;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.green.mvc13.dao.MemoDAO;
import kr.green.mvc13.vo.MemoVO;
import kr.green.mvc13.vo.PagingVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("memoService")
@Transactional
public class MemoServiceImpl implements MemoService{

	@Autowired
	private MemoDAO memoDAO;

	@Override
	public MemoVO selectByIdx(int idx) {
		log.info("{}의 selectByIdx 호출 :{}", this.getClass().getName(), idx);
		MemoVO memoVO = null;
		try {
			memoVO = memoDAO.selectByIdx(idx);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		log.info("{}의 selectByIdx 리턴 :{}", this.getClass().getName(), memoVO);
		return memoVO;
	}

	@Override
	public PagingVO<MemoVO> selectList(int currentPage, int pageSize, int blockSize) {
		log.info("{}의 selectList 호출 :{}", this.getClass().getName(), currentPage + ", " + pageSize + ", " + blockSize);
		PagingVO<MemoVO> pagingVO = null;
		try {
			int totalCount = memoDAO.selectCount();
			pagingVO = new PagingVO<>(currentPage, pageSize, blockSize, totalCount);
			HashMap<String, Integer> map = new HashMap<>();
			map.put("startNo", pagingVO.getStartNo());
			map.put("endNo", pagingVO.getEndNo());
			pagingVO.setList(memoDAO.selectList(map));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		log.info("{}의 selectList 리턴 :{}", this.getClass().getName(), pagingVO);
		return pagingVO;
	}

	@Override
	public void insert(MemoVO memoVO) {
		log.info("{}의 insert 호출 :{}", this.getClass().getName(), memoVO);
		try {
			if(memoVO!=null) memoDAO.insert(memoVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(MemoVO memoVO) {
		log.info("{}의 update 호출 :{}", this.getClass().getName(), memoVO);
		try {
			if(memoVO!=null) {
				MemoVO dbVO = memoDAO.selectByIdx(memoVO.getIdx());
				if(dbVO!=null && dbVO.getPassword().equals(memoVO.getPassword())) {
					memoDAO.update(memoVO);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(MemoVO memoVO) {
		log.info("{}의 delete 호출 :{}", this.getClass().getName(), memoVO);
		try {
			if(memoVO!=null) {
				MemoVO dbVO = memoDAO.selectByIdx(memoVO.getIdx());
				if(dbVO!=null && dbVO.getPassword().equals(memoVO.getPassword())) {
					memoDAO.delete(memoVO.getIdx());
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
