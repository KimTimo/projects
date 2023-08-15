package kr.green.jdbc.service;
//실제 비지니스 로직을 처리한다.
//싱글톤패턴으로 작성
//트랜잭션처리와 예외처리를 할것임.
//로직 1개당 1개의 메서드로 작성

import java.util.List;

import kr.green.jdbc.vo.SampleVO;

public interface SampleService {
	// 1. 1개 얻기
	SampleVO selectByIdx(int idx);
	// 2. 1페이지 얻기
	List<SampleVO> selectList(int currentPage, int pageSize, int blockSize);
	// 3. 저장하기
	int insert(SampleVO vo);
	// 4. 수정하기
	int update(SampleVO vo);
	// 5. 삭제하기
	int delete(SampleVO vo);
}
