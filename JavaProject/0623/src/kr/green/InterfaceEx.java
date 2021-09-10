package kr.green;

// 깊은 관계 : StudentA가 준비되기 전까지는 Teacher는 만들 수도 사용할 수도 없다.
class Teacher{
	void study(StudentA student) { // 직접사용 
		student.study();
	}
	void study(StudentB student) { // 직접사용 
		student.study();
	}
}
// 느슨한 관계 : 중간에 인터페이스를 넣어 간접적으로 사용
class Teacher2{
	void study(IStudent student) { // 사용자 클래스는 인터페이스를 사용 
		student.study();
	}
}

interface IStudent{
	void study();
}



class StudentA implements IStudent{ // 제공자 클래스는 인터페이스를 반드시 구현하게 한다.
	public void study() {
		System.out.println("A학생이 공부를 합니다...");
	}
}

class StudentB implements IStudent{
	public void study() {
		System.out.println("B학생이 공부를 합니다...");
	}
}

public class InterfaceEx {
	public static void main(String[] args) {
		StudentA studentA = new StudentA();
		StudentB studentB = new StudentB();
		
		Teacher teacher = new Teacher();
	    teacher.study(studentA);
	    teacher.study(studentB);
	    
	    Teacher2 teacher2 = new Teacher2();
	    teacher2.study(studentA);
	    teacher2.study(studentB);
	}
}
