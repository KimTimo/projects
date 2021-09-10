// 몬스터를 모두 잡으면 승리하는 게임을 만들자
// 몬스터의 개수를 세어주는 기능이 필요하다.
class Monster {
	int iv = 0; // 인스턴스변수 : 객체마다 다른값을 저장. 객체 생성시 생성되고 소멸시 소멸된다.
	static int sv = 0; // 정적 변수 : 모든 객체가 공유하는 변수

	void view() {
		int local; // 지역변수 : {}안에서만 유효. 메서드 호출시 생성 -> 메서드 종료시 소멸
	}

	// 객체가 생성될때 1씩 늘려주고 객체가 소멸될때 1씩 감소시키면 된다.
	public Monster() {
		iv++;
		sv++;
	}

	int getCount() { // 몬스터의 개수를 알아내는 메서드
		return iv;
	}

	static int getStaticCount() { // 몬스터의 개수를 알아내는 메서드
		// 메서드명 앞에도 static을 붙일 수 있다 : 정적 메서드
		// 정적 메서드 안에서는 정적변수만 사용이 가능하다
		return sv;
	}
}

public class MonsterEx {

	public static void main(String[] args) {
		// System.out.println(Monster.sv + "마리"); // 정적 변수는 클래스이름.정적변수
		System.out.println(Monster.getStaticCount() + "마리");

		Monster monster1 = new Monster();
		Monster monster2 = new Monster();
		Monster monster3 = new Monster();

		System.out.println(monster1.getCount() + "마리");
		System.out.println(monster3.getCount() + "마리"); // 인스턴스 변수는 참조변수.인스턴스변수
		System.out.println();
		System.out.println(Monster.getStaticCount() + "마리");
		Math.abs(-7);

	}

}
