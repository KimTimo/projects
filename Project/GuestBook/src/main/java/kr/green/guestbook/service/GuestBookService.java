package kr.green.guestbook.service;

import kr.green.guestbook.vo.GuestBookVO;
import kr.green.guestbook.vo.PagingVO;

public interface GuestBookService {
	// 1. 목록보기
	PagingVO<GuestBookVO> selectList(int currentPage, int pageSize, int blockSize);
	// 2. 한개 얻기
	GuestBookVO selectByIdx(int idx);
	// 3. 저장하기
	int insert(GuestBookVO guestBookVO);
	// 4. 수정하기
	int update(GuestBookVO guestBookVO);
	// 5. 삭제하기
	int delete(GuestBookVO guestBookVO);
}
