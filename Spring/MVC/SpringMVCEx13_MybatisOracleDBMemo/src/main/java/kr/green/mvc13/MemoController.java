package kr.green.mvc13;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.green.mvc13.service.MemoService;
import kr.green.mvc13.vo.CommVO;
import kr.green.mvc13.vo.MemoVO;
import kr.green.mvc13.vo.PagingVO;

@Controller
public class MemoController {

	@Autowired
	private MemoService memoService;
	
	// 1. 목록보기
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String selectList(@ModelAttribute CommVO commVO, Model model) {
		PagingVO<MemoVO> pagingVO = memoService.selectList(commVO.getCurrentPage(), commVO.getPageSize(), commVO.getBlockSize());
		model.addAttribute("pv", pagingVO);
		return "list";
	}
	
	// 2. 저장/수정/삭제
	@RequestMapping(value = "/update", method=RequestMethod.POST)
	public String update(@ModelAttribute CommVO commVO, @ModelAttribute MemoVO memoVO) {
		switch (commVO.getMode()) {
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
		return "redirect:/list?p=" + commVO.getCurrentPage() + "&s=" + commVO.getPageSize() + "&b=" + commVO.getBlockSize();
	}
	
}
