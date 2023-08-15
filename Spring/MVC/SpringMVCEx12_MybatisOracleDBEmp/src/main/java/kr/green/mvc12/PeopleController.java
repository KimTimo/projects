package kr.green.mvc12;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.green.mvc12.service.PeopleService;
import kr.green.mvc12.vo.PeopleVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class PeopleController {
	
	@Autowired
	private PeopleService peopleService;
	
	// 리스트
	@RequestMapping(value = "/list2") // 메서드와 주소를 연결하고 뷰페이지를 리턴하도록 만든다.
	public String getAll(Model model) {
		log.debug(this.getClass().getName() + "의 getAll 호출");
		List<PeopleVO> list = peopleService.selectList();
		log.debug(this.getClass().getName() + "의 getAll 결과 : " + list);
		model.addAttribute("list", list);
		return "list2";
	}
	// 저장
	@RequestMapping(value = "/insertOk2") // 메서드와 주소를 연결하고 뷰페이지를 리턴하도록 만든다.
	public String insert(@ModelAttribute PeopleVO peopleVO) { // @ModelAttribute : VO로 데이터 받기
		log.debug(this.getClass().getName() + "의 insert 호출 : " + peopleVO);
		peopleService.insert(peopleVO);		
		return "redirect:/list2";
	}
	
	
	// 수정
	@RequestMapping(value = "/updateOk2") // 메서드와 주소를 연결하고 뷰페이지를 리턴하도록 만든다.
	public String update(@ModelAttribute PeopleVO peopleVO) { // @ModelAttribute : VO로 데이터 받기
		log.debug(this.getClass().getName() + "의 update 호출 : " + peopleVO);
		peopleService.update(peopleVO);
		return "redirect:/list2";
	}
	
	// 삭제
	@RequestMapping(value = "/deleteOk2") // 메서드와 주소를 연결하고 뷰페이지를 리턴하도록 만든다.
	public String delete(@ModelAttribute PeopleVO peopleVO) { // @ModelAttribute : VO로 데이터 받기
		log.debug(this.getClass().getName() + "의 delete 호출 : " + peopleVO);
		peopleService.delete(peopleVO.getId());
		return "redirect:/list2";
	}
	
}
