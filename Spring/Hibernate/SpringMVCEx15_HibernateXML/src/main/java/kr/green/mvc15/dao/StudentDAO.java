package kr.green.mvc15.dao;

import java.util.List;

import kr.green.mvc15.vo.Student;

public interface StudentDAO {
	void insert(Student student);
	List<Student> selectList();
	void delete(Student student);
	void update(Student student);
	Student selectByIdx(int idx);
}
