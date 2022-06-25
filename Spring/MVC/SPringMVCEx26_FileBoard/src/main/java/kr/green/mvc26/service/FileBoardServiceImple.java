package kr.green.mvc26.service;

import java.io.File;
import java.util.Arrays;
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
		log.info("{}의 selectByIdx 호출 : {}", this.getClass().getName(), idx);
		FileBoardVO fileBoardVO = fileBoardDAO.selectByIdx(idx); // 글 1개를 가져온다.
		// 그 글에 해당하는 첨부파일의 정보를 가져온다.
		if(fileBoardVO!= null) {
			List<FileBoardFileVO> list = fileBoardFileDAO.selectList(idx);
			fileBoardVO.setFileList(list);
		}
		log.info("{}의 selectByIdx 리턴 : {}", this.getClass().getName(), fileBoardVO);
		return fileBoardVO;
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
	public void delete(FileBoardVO fileBoardVO, String uploadPath) {
		log.info("{}의 update 호출 : {}", this.getClass().getName(), fileBoardVO + "\n" + uploadPath);
		FileBoardVO dbVO = fileBoardDAO.selectByIdx(fileBoardVO.getIdx());
		if(dbVO!=null && dbVO.getPassword().equals(fileBoardVO.getPassword())) { // DB의 비번과 입력한 비번이 같은 경우에만
			// 글삭제
			fileBoardDAO.delete(fileBoardVO.getIdx());
			// 모든 첨부파일의 목록을 읽어온다.
			List<FileBoardFileVO> list = fileBoardFileDAO.selectList(fileBoardVO.getIdx());
			if(list!=null && list.size()>0) {
				for(FileBoardFileVO vo : list) {
					// DB 파일 삭제
					fileBoardFileDAO.deleteByIdx(vo.getIdx());
					// 실제 파일삭제
					File file = new File(uploadPath + File.separator + vo.getSaveName());
					file.delete();
				}
			}
		}
	}
	
	@Override
	public void update(FileBoardVO fileBoardVO, String[] delFiles, String realPath) {
		log.info("{}의 update 호출 : {}", this.getClass().getName(), fileBoardVO + "\n" + Arrays.toString(delFiles) + "\n" + realPath);
		FileBoardVO dbVO = fileBoardDAO.selectByIdx(fileBoardVO.getIdx());
		if(dbVO!=null && dbVO.getPassword().equals(fileBoardVO.getPassword())) { // DB의 비번과 입력한 비번이 같은 경우에만
			// 1. 글수정
			fileBoardDAO.update(fileBoardVO);
			// 2. 새롭게 첨부된 첨부 파일의 정보도 저장해 주어야 한다.
			List<FileBoardFileVO> list = fileBoardVO.getFileList();
			if(list!=null && list.size()>0) {
				for(FileBoardFileVO vo : list) {
					vo.setRef(fileBoardVO.getIdx()); // 원본글번호
					fileBoardFileDAO.insert(vo);
				}
			} 
			// 3, 이미 첨부되었던 파일 삭제
			log.info("{}의 update delFiles : {}", this.getClass().getName(), delFiles);
			if(delFiles!=null && delFiles.length>0) {
				for(String t : delFiles ) {
					int idx = Integer.parseInt(t);
					if(idx>0) {
						// 실제 파일을 삭제하려면
						// 1. 해당 글번호의 글을 읽어와서
						FileBoardFileVO fileBoardFileVO = fileBoardFileDAO.selectByIdx(idx);
						if(fileBoardFileVO!=null) {
							// 2. 실제 서버의 파일을 삭제해 주어야 한다.
							File file = new File(realPath + File.separator + fileBoardFileVO.getSaveName());
							file.delete(); // 실제 파일삭제
							fileBoardFileDAO.deleteByIdx(idx); // DB에서만 삭제된다.
						}
					}
				}
			}

		}
		
	}
}
