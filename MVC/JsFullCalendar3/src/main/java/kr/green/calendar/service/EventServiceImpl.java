package kr.green.calendar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.calendar.dao.EventDao;
import kr.green.calendar.vo.EventVO2;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("eventService")
public class EventServiceImpl implements EventService{

	@Autowired
	EventDao eventDao;
	
	@Override
	public List<EventVO2> selectList() {
		log.info("{}의 selectList 호출 : ", this.getClass().getName());
		List<EventVO2> list = null;
		list = eventDao.selectList();
		for(EventVO2 vo : list) { // 반복하면서
			vo.setAllDay(vo.getAllDays()==1); // allDay의 값을 1이면 true 0이면 false로 넣어준다.
		}
		log.info("{}의 selectList 리턴 : {}", this.getClass().getName(), list);
		return list;
	}

	@Override
	public List<EventVO2> selectList2(String username) {
		log.info("{}의 selectList 호출 : ", this.getClass().getName());
		List<EventVO2> list = null;
		list = eventDao.selectList2(username);
		for(EventVO2 vo : list) {
			vo.setAllDay(vo.getAllDays()==1);
		}
		log.info("{}의 selectList 리턴 : {}", this.getClass().getName(), list);
		return list;
	}

	@Override
	public void insert(EventVO2 eventVO2) {
		log.info("{}의 insert 호출 : {}", this.getClass().getName(), eventVO2);
		eventDao.insert(eventVO2);
	}

	@Override
	public void insert2(EventVO2 eventVO2) {
		log.info("{}의 insert2 호출 : {}", this.getClass().getName(), eventVO2);
		eventDao.insert2(eventVO2);
	}

	@Override
	public void dropUpdate(EventVO2 eventVO2) {
		log.info("{}의 dropUpdate 호출 : {}", this.getClass().getName(), eventVO2);
		eventDao.dropUpdate(eventVO2);
	}

}
