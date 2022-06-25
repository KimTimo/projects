package kr.green.mvc15.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.green.mvc15.vo.Student;

@Repository("studentDAO")
public class StudentDAOImpl implements StudentDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void insert(Student student) {
		sessionFactory.openSession().persist(student);
	}

	@Override
	public List<Student> selectList() {
		Criteria criteria = sessionFactory.openSession().createCriteria(Student.class);
		return criteria.list();
	}

	@Override
	public void delete(Student student) {
		sessionFactory.openSession().delete(student);		
	}

	@Override
	public void update(Student student) {
		sessionFactory.openSession().update(student);		
	}

	@Override
	public Student selectByIdx(int idx) {
		Student student = null;
		Criteria criteria = sessionFactory.openSession().createCriteria(Student.class);
		criteria.add(Restrictions.eq("idx", idx));
		student = (Student) criteria.uniqueResult();
		return student;
	}
}
