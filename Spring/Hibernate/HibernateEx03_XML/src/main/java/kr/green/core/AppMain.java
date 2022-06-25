package kr.green.core;

import java.util.List;

import org.hibernate.Session;

public class AppMain {
	public static void main(String[] args) {
		AppMain app = new AppMain();
		
		app.insert("김", "말동");
		app.insert("최", "달봉");
		app.insert("이", "태백");
		
		System.out.println();
		for(MyEmp myEmp : app.selectList()) {
			System.out.println(myEmp);
		}
		
		System.out.println();
		app.update(28, "강", "회장");
		for(MyEmp myEmp : app.selectList()) {
			System.out.println(myEmp);
		}
		System.out.println();

		app.delete(28, "", "");
		for(MyEmp myEmp : app.selectList()) {
			System.out.println(myEmp);
		}
		System.out.println();
		
		
	}
	// 저장
	public int insert(String firstName, String lastName) {
		int result = 0;
		MyEmp myEmp = new MyEmp(0, firstName, lastName);
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		result = (int) session.save(myEmp);
		session.getTransaction().commit();
		return result;
	}
	
	// 모두 얻기
	public List<MyEmp> selectList(){
		List<MyEmp> list = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		list = session.createQuery("from MyEmp order by idx desc").list();
		session.getTransaction().commit();
		return list;
	}
	// 수정하기
	public void update(int idx, String firstName, String lastName) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		MyEmp myEmp = (MyEmp) session.get(MyEmp.class, idx);
		myEmp.setFirstName(firstName);
		myEmp.setLastName(lastName);
		session.getTransaction().commit();
	}
	// 삭제하기
	public void delete(int idx, String firstName, String lastName) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		MyEmp myEmp = (MyEmp) session.get(MyEmp.class, idx);
		session.delete(myEmp);
		
		session.getTransaction().commit();
	}
	
}
