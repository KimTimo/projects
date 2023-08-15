package kr.green.calendar.dao;

import java.util.List;

import kr.green.calendar.vo.EventVO2;

public interface EventDao {
	List<EventVO2> selectList();
	List<EventVO2> selectList2(String username);
	void insert(EventVO2 eventVO2);
	void insert2(EventVO2 eventVO2);
	
	void dropUpdate(EventVO2 eventVO2);
}
