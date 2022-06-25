package kr.green.mvc13.service;

import kr.green.mvc13.vo.MemoVO;
import kr.green.mvc13.vo.PagingVO;

public interface MemoService {
	// 로직 1개당 메서드 1개씩 작성
	// 1. 1개 얻기
	public MemoVO selectByIdx(int idx);
	// 2. 1페이지 얻기
	public PagingVO<MemoVO> selectList(int currentPage, int pageSize, int blockSize);
	// 아래 3개는 1개로 합칠 수 있다.
	// 3. 저장하기
	public void insert(MemoVO memoVO);	
	
	// 4. 수정하기
	public void update(MemoVO memoVO);
	
	// 5. 삭제하기
	public void delete(MemoVO memoVO);
	
}
