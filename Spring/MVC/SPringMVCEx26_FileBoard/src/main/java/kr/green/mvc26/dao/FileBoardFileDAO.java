package kr.green.mvc26.dao;

import java.util.List;

import kr.green.mvc26.vo.FileBoardFileVO;

public interface FileBoardFileDAO {
	// <!-- 1. 첨부파일 저장 -->
	void insert(FileBoardFileVO vo);
	// <!-- 2. 수정시 첨부파일 저장 : 이때는 원본글의 ref가 별도로 존재한다. -->
	void updateInsert(FileBoardFileVO vo);
	// <!-- 3. 첨부파일 삭제 -->
	void deleteByIdx(int idx);
	// <!-- 4. 원본글의 첨부파일 모두 읽기 -->
	List<FileBoardFileVO> selectList(int ref);
	// <!-- 5. 원본글의 첨부파일 모두 삭제하기 -->
	void deleteByRef(int ref);
	// <!-- 6. 글 1개 가져오기 -->
	FileBoardFileVO selectByIdx(int idx) ;
}
