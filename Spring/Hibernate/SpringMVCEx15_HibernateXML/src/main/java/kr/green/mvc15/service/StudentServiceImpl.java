package kr.green.mvc15.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.mvc15.dao.StudentDAO;
import kr.green.mvc15.vo.Student;

@Service("studentService")
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDAO studentDAO;

	@Override
	public void insert(Student student) {
		if(student!=null) studentDAO.insert(student);
	}

	@Override
	public List<Student> selectList() {
		return studentDAO.selectList();
	}

	@Override
	public void delete(Student student) {
		if(student!=null) studentDAO.delete(student);
		
	}

	@Override
	public void update(Student student) {
		if(student!=null) studentDAO.update(student);
		
	}

	@Override
	public Student selectByIdx(int idx) {
		return studentDAO.selectByIdx(idx);
	}
	
	
}
