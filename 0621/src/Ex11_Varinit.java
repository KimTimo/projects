import java.util.Arrays;
import java.util.Random;

import javax.sql.rowset.serial.SQLOutputImpl;

class VarInit {
	int iv = 1; // 명시적 초기화 ----------------------------------------------------------------------- 우선순위 3
	static int sv = 2; // ------------------------------------------------------------------------------------- 우선순위 1
	static int rand[] = new int[100]; // 여기서 초기화를 할 수 있을까?
	
	// 초기화 블럭을 이용한초기화
	{ // 인스턴스 초기화 블럭 : 인스턴스 변수들의 초기화를 담당하는 블록 // ------------------------------------ 우선순위 4
		// 인스턴스 초기화 블럭은 생성자에서도 초기화가 가능하므로 잘 사용되지 않은다.
		System.out.println("인스턴스 초기화 블럭 초기화 전 : iv = " + iv);
		iv = 11;
		System.out.println("인스턴스 초기화 블럭 초기화 전 : iv = " + iv);
	}
	static { // 정적 초기화 블럭 : 정적변수들의 초기화를 담당하는 블록  // ----------------------------------- 우선순위 2
		     // 정적 변수의 초기화가 복잡할 경우에는 여기에서 초기화 해야한다.
		System.out.println("인스턴스 초기화 블럭 초기화 전 : iv = "  + sv);
		sv = 22;
		System.out.println("인스턴스 초기화 블럭 초기화 전 : iv = "  + sv);
	}
	// 생성자를 이용한 초기화
	public VarInit() { // // ------------------------------------------------------------------------------- 우선순위 5
		System.out.println(" 생성자 초기화 전 " + iv + ", " + sv);
		iv = 111;
		sv = 222;
		
//		// 생성자에서 정적 메서드를 초기화한 경우
//		Random rnd = new Random();
//		for(int i = 0; i < rand.length;i++) rand[i] = rnd.nextInt(101);
		System.out.println(" 생성자 초기화 전 " + iv + ", " + sv);
	}
}

public class Ex11_Varinit {
	public static void main(String[] args) {
		
		System.out.println(VarInit.sv); // 객체 생성전에도 사용 가능해야한다. 초기화를 생성자에서 하면 안된다.
		System.out.println(Arrays.toString(VarInit.rand));
		VarInit v1 = new VarInit();
	}

}
