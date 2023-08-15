package kr.green.file.service;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.green.file.dao.FileBoardDAO;
import kr.green.file.dao.FileBoardFileDAO;
import kr.green.file.vo.CommVO;
import kr.green.file.vo.FileBoardFileVO;
import kr.green.file.vo.FileBoardVO;
import kr.green.file.vo.PagingVO;
import kr.green.mybatis.MybatisApp;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FileBoardService {
	private static FileBoardService instance = new FileBoardService();
	private FileBoardService() { }
	public static FileBoardService getInstance() {
		return instance;
	}
	//---------------------------------------------------------------------------
	// 1. 목록보기
	public PagingVO<FileBoardVO> selectList(CommVO commVO){
		log.debug("selectList 인수 : {}", commVO.toString());
		PagingVO<FileBoardVO> pagingVO = null;
		FileBoardFileDAO fileDAO = null;
		FileBoardDAO     boardDAO = null;
		SqlSession sqlSession = null;
		// =====================================================================
		try {
			sqlSession = MybatisApp.getSqlSessionFactory().openSession(false);
			boardDAO = FileBoardDAO.getInstance();
			fileDAO = FileBoardFileDAO.getInstance();
			// -----------------------------------------------------------------
			// 전체 개수 구하기
			int totalCount = boardDAO.selectCount(sqlSession);
			// 페이지 계산
			pagingVO = new PagingVO<FileBoardVO>(commVO.getCurrentPage(), commVO.getPageSize(), commVO.getBlockSize(), totalCount);
			// 글을 읽어오기
			HashMap<String, Integer> map = new HashMap<String, Integer>();
			map.put("startNo", pagingVO.getStartNo() );
			map.put("endNo", pagingVO.getEndNo());
			List<FileBoardVO> list = boardDAO.selectList(sqlSession, map);
			// 해당글들의 첨부파일 정보를 넣어준다.
			if(list!=null && list.size()>0) {
				for(FileBoardVO vo : list) {
					// 해당글의 첨부파일 목록을 가져온다.
					List<FileBoardFileVO> fileList = fileDAO.selectList(sqlSession, vo.getIdx());
					// vo에 넣는다.
					vo.setFileList(fileList);
				}
			}
			// 완성된 리스트를 페이징 객체에 넣는다.
			pagingVO.setList(list);
			// -----------------------------------------------------------------
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		// =====================================================================
		log.debug("selectList 리턴값 : {}", commVO.toString());
		return pagingVO;
	}
	// 2. 내용보기
	// 3. 글쓰기
	// 4. 글수정
	// 5. 글삭제
	// 6. 첨부파일 삭제
}
