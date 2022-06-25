package kr.green.mvc23;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import kr.green.mvc23.service.MemoService;
import kr.green.mvc23.vo.MemoList;
import kr.green.mvc23.vo.MemoVO;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class MemoRESTController {

	@Autowired
	private MemoService memoService;
	
	// 모두 읽기
	@GetMapping(value = "/rest/selectAll")
	public List<MemoVO> selectAll(){
		return memoService.selectAll();
	}

	// 7. EasyUI용 MemoList 얻기
	@GetMapping(value = "/rest/list2")
	public MemoList selectList(){
		return memoService.memoList();
	}
	
	// 1개 읽기
	@GetMapping(value = "/rest/select/{idx}")
	public MemoVO selectByIdx(@PathVariable int idx){
		log.info("{}의 selectByIdx 호출 : {}", this.getClass().getName(), idx);
		MemoVO memoVO = memoService.selectByIdx(idx);
		log.info("{}의 selectByIdx 리턴 : {}", this.getClass().getName(), memoVO);
		return memoVO;
	}
	
	// 저장/수정/삭제 하기
	@GetMapping(value = "/rest/update")
	public void insert(@ModelAttribute MemoVO memoVO, HttpServletRequest request){
		memoVO.setIp(request.getRemoteAddr());
		log.info("{}의 update 호출 : {}", this.getClass().getName(), memoVO);
		switch (memoVO.getMode()) {
		case "insert":
			memoService.insert(memoVO);
			break;
		case "update":
			memoService.update(memoVO);
			break;
		case "delete":
			memoService.delete(memoVO);
			break;
		}
	}
}
