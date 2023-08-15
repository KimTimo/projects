package kr.green.mvc26.service;

import kr.green.mvc26.vo.CommVO;
import kr.green.mvc26.vo.FileBoardVO;
import kr.green.mvc26.vo.PagingVO;

public interface FileBoardService {
	// 1. 목록보기
	PagingVO<FileBoardVO> selectList(CommVO commVO);
	// 2. 내용보기 - 글 1개 가져오기
	FileBoardVO selectByIdx(int idx);
	// 3. 글쓰기
	void insert(FileBoardVO fileBoardVO);
	// 4. 글수정
	void update(FileBoardVO fileBoardVO, String[] delFiles, String realPath);
	// 5. 글삭제
	void delete(FileBoardVO fileBoardVO, String uploadPath);
}
