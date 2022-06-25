package kr.green.calendar;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.green.calendar.service.EventService;
import kr.green.calendar.vo.EventVO2;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class EventController {

	@Autowired
	EventService eventService;
	
	@RequestMapping(value = "/events")
	public List<EventVO2> selectList(){
		log.info("{}의 selectList 호출 : ", this.getClass().getName());
		List<EventVO2> list = null;
		list = eventService.selectList();
		log.info("{}의 selectList 리턴 : {}", this.getClass().getName(), list);
		return list;
	}
	
	@RequestMapping(value = "/events2")
	public List<EventVO2> selectList2(@RequestParam(required = false, defaultValue = "") String username){
		if(username==null || username.equals("") || username.equals("모두")) username = null;
		log.info("{}의 selectList 호출 : {}", this.getClass().getName(), username);
		List<EventVO2> list = null;
		list = eventService.selectList2(username);
		log.info("{}의 selectList 리턴 : {}", this.getClass().getName(), list);
		return list;
	}
	@RequestMapping(value = "/insert")
	public void insert(@ModelAttribute EventVO2 eventVO2) {
		log.info("{}의 insert 호출 : {}", this.getClass().getName(), eventVO2);
		eventService.insert(eventVO2);
		// return "redirect:/";
	}
	@RequestMapping(value = "/insert2")
	public void insert2(@ModelAttribute EventVO2 eventVO2) {
		log.info("{}의 insert2 호출 : {}", this.getClass().getName(), eventVO2);
		eventService.insert2(eventVO2);
		// return "redirect:/";
	}
	@RequestMapping(value = "/dropUpdate")
	public void dropUpdate(@ModelAttribute EventVO2 eventVO2) {
		log.info("{}의 dropUpdate 호출 : {}", this.getClass().getName(), eventVO2);
		eventService.dropUpdate(eventVO2);
		// return "redirect:/";
	}
}
