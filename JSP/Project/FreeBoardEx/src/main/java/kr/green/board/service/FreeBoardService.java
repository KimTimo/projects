package kr.green.board.service;

import kr.green.board.vo.FreeBoardVO;
import kr.green.board.vo.PagingVO;

public interface FreeBoardService {
	// 1. 목록보기
	PagingVO<FreeBoardVO> selectList(int currentPage, int pageSize, int blockSize);
	// 2. 1 --> 1개 가져오기 : 내용보기, 수정폼, 삭제폼
	FreeBoardVO selectByIdx(int idx, boolean isHit); // isHit값에 따라 조회수 증가여부를 지정한다. 참이면 증가, 거짓이면 증가X
	// 3. 1 --> 글쓰기
	int insert(FreeBoardVO vo);
	// 4. 1 --> 2 --> 수정하기
	int update(FreeBoardVO vo);
	// 5. 1 --> 2 --> 삭제하기
	int delete(FreeBoardVO vo);
}
