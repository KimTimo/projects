package kr.green;

import java.io.Serializable;

// Serializable, Cloneable 등이 자바에서 만들어 놓은 대표적인 표시 인터페이스이다.
// Serializable : 직렬화/역직렬화의 지원 여부
// Cloneable    : 깊은 복사의 지원 여부
public class RepairableTest implements Serializable, Cloneable{
	public static void main(String[] args) {
		Tank tank = new Tank();
		Dropship dropship = new Dropship();

		Marine marine = new Marine();
		SCV scv = new SCV();

		scv.repair(tank); // SCV가 Tank를 수리하도록 한다.
		scv.repair(dropship);
		scv.repair(scv);
		scv.repair(marine);	
	}
}

//------------------------------------------------
// 얜 뭘까?
// 표시 인터페이스라고 한다. 무엇이 가능하다라고 표시하는 용도의 인터페이스
interface Repairable {
	;
}

//-------------------------------------------------
// 공통으로 사용되는 최상의 유닛 클래스
class Unit2 {
	int hitPoint;
	final int MAX_HP;

	Unit2(int hp) {
		MAX_HP = hp;
	}
	// ...
}

// 육지에서 이동하는 것들의 상위 클래스
class GroundUnit extends Unit2 {
	GroundUnit(int hp) {
		super(hp);
	}
}

// 하늘에 있는것들의 공통적인 상위 클래스
class AirUnit extends Unit2 {
	AirUnit(int hp) {
		super(hp);
	}
}

// 탱크를 작성
class Tank extends GroundUnit implements Repairable {
	Tank() {
		super(150); // Tank의 HP는 150이다.
		hitPoint = MAX_HP;
	}

	public String toString() {
		return "Tank";
	}
	// ...
}

// 수송선
class Dropship extends AirUnit implements Repairable {
	Dropship() {
		super(125); // Dropship의 HP는 125이다.
		hitPoint = MAX_HP;
	}

	public String toString() {
		return "Dropship";
	}
	// ...
}

// 구닌
class Marine extends GroundUnit implements Repairable {
	Marine() {
		super(40);
		hitPoint = MAX_HP;
	}
	// ...
}

class SCV extends GroundUnit implements Repairable {
	SCV() {
		super(60);
		hitPoint = MAX_HP;
	}

	// 여기에 수리를 담당하는 메소드 작성!!
	// 인수로 Repairable 인터페이스를 받는다.
	// 그렇다면 Repairable 인터페이스를 구현한 모든 종류의 캐릭터를 수리할 수 있다.
	// SCV가 탱크나 수송선도 수리가 가능하다.
	void repair(Repairable r) {
		if (r instanceof Unit2) {
			Unit2 u = (Unit2) r;
			while (u.hitPoint != u.MAX_HP) {
				/* Unit의 HP를 증가시킨다. */
				u.hitPoint++;
			}
			System.out.println(u.getClass().getSimpleName() + "의 수리가 끝났습니다.");
		}
	}
	// ...
}