package kr.green.mvc26.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.green.mvc26.dao.FileBoardDAO;
import kr.green.mvc26.dao.FileBoardFileDAO;
import kr.green.mvc26.vo.CommVO;
import kr.green.mvc26.vo.FileBoardFileVO;
import kr.green.mvc26.vo.FileBoardVO;
import kr.green.mvc26.vo.PagingVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Transactional
@Service("fileBoardService")
public class FileBoardServiceImple implements FileBoardService {
	
	@Autowired
	private FileBoardDAO fileBoardDAO;
	@Autowired
	private FileBoardFileDAO fileBoardFileDAO;
	
	@Override
	public PagingVO<FileBoardVO> selectList(CommVO commVO) {
		log.info("{}의 selectList 호출 : {}", this.getClass().getName(), commVO);
		PagingVO<FileBoardVO> pagingVO = null;
		try {
			// 전체 개수 구하기
			int totalCount = fileBoardDAO.selectCount();
			// 페이지 계산
			pagingVO = new PagingVO<>(commVO.getCurrentPage(), commVO.getPageSize(), commVO.getBlockSize(), totalCount);
			// 글을 읽어오기
			HashMap<String, Integer> map = new HashMap<String, Integer>();
			map.put("startNo", pagingVO.getStartNo() );
			map.put("endNo", pagingVO.getEndNo());
			List<FileBoardVO> list = fileBoardDAO.selectList(map);
			// 해당글들의 첨부파일 정보를 넣어준다.
			if(list!=null && list.size()>0) {
				for(FileBoardVO vo : list) {
					// 해당글의 첨부파일 목록을 가져온다.
					List<FileBoardFileVO> fileList =  fileBoardFileDAO.selectList(vo.getIdx());
					// vo에 넣는다.
					vo.setFileList(fileList);
				}
			}
			// 완성된 리스트를 페이징 객체에 넣는다.
			pagingVO.setList(list);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return pagingVO;
	}
	@Override
	public FileBoardVO selectByIdx(int idx) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void insert(FileBoardVO fileBoardVO) {
		log.info("{}의 insert 호출 : {}", this.getClass().getName(), fileBoardVO);
		// 컨트롤러에 있는 파일을 저장하는 부분을 유틸리티 클래스로 빼주면 컨트롤러가 간단해 진다.
		if(fileBoardVO!=null) {
			// 1. 글을 조장한다.
			fileBoardDAO.insert(fileBoardVO);
			// 저장을 했으면 저장된 idx값을 얻어온다
			int ref = fileBoardDAO.selectSeq();
			// 2. 첨부 파일의 정보도 저장해 주어야 한다.
			List<FileBoardFileVO> list = fileBoardVO.getFileList();
			if(list!=null && list.size()>0) {
				for(FileBoardFileVO vo : list) {
					vo.setRef(ref); // 원본글번호
					fileBoardFileDAO.insert(vo);
				}
			}
		}
	}
	@Override
	public void update(FileBoardVO fileBoardVO, List<Integer> delList, String uploadPath) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void delete(FileBoardVO fileBoardVO, String uploadPath) {
		// TODO Auto-generated method stub
		
	}
}
