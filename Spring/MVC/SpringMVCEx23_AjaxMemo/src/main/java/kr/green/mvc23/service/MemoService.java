package kr.green.mvc23.service;

import java.util.List;

import kr.green.mvc23.vo.MemoList;
import kr.green.mvc23.vo.MemoVO;
import kr.green.mvc23.vo.PagingVO;

public interface MemoService {
	// 로직 1개당 메서드 1개씩 작성
	// 1. 1개 얻기
	public MemoVO selectByIdx(int idx);
	// 2. 1페이지 얻기
	public PagingVO<MemoVO> selectList(int currentPage, int pageSize, int blockSize);
	// 3. 저장하기
	public void insert(MemoVO memoVO);	
	// 4. 수정하기
	public void update(MemoVO memoVO);
	// 5. 삭제하기
	public void delete(MemoVO memoVO);
	// 6. 모두 얻기
	public List<MemoVO> selectAll();
	// 7. EasyUI용 MemoList 얻기
	public MemoList memoList();
}
