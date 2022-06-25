package kr.green.vo;

public class Exam {

	public static void main(String[] args) {
		Human human = new Human();
		System.out.println(human);
		human.think();
		
		Student student = new Student("한사람","210002");
		System.out.println(student);
		student.think();
		student.study();
		System.out.println(student.name); // protected멤버는 자식은 사용 가능하다.
		                                  // private은 자식 조차도 접근 불가하다.

	}

}
