package kr.green.core;

import java.util.List;

import org.hibernate.Session;

public class AppMain {
	public static void main(String[] args) {
		AppMain app = new AppMain();
		// 저장
		/*
		app.insertStudent("한사람", "잠사과");
		app.insertStudent("두사람", "축산과");
		app.insertStudent("세사람", "수학과");
		app.insertStudent("네사람", "물리학과");
		app.insertStudent("오사람", "관광과");
		*/
		// 모두 읽기
		for(Student student : app.selectList()) {
			System.out.println(student);
		}
		System.out.println();
		try {
			// 수정
			app.update(1, "땡땡이과");
			app.update(6, "경영학과");
			app.update(7, "서양화과");
		}catch (Exception e) {
			;
		}
		// 모두 읽기
		for(Student student : app.selectList()) {
			System.out.println(student);
		}
		System.out.println();
		try {
			// 삭제
			app.delete(5);
			app.delete(6);
			app.delete(9);
		}catch (Exception e) {
			;
		}
		// 모두 읽기
		for(Student student : app.selectList()) {
			System.out.println(student);
		}
	}
	// 저장
	public int insertStudent(String name, String section) {
		int result = 0;
		Student student = new Student();
		student.setName(name);
		student.setSection(section);
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		result = (int) session.save(student);
		session.getTransaction().commit();
		return result;
	}
	
	// 모두 얻기
	public List<Student> selectList(){
		List<Student> list = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		list = session.createQuery("from Student order by idx desc").list();
		session.getTransaction().commit();
		return list;
	}
	// 수정하기
	public void update(int idx, String section) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Student student = (Student) session.get(Student.class, idx);
		student.setSection(section);
		session.update(student);
		session.getTransaction().commit();
	}
	// 삭제하기
	public void delete(int idx) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		Student student = (Student) session.get(Student.class, idx);
		session.delete(student);
		
		session.getTransaction().commit();
	}
	
}
