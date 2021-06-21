
public class Ex04 {

	public static void main(String[] args) {

		System.out.println('1'-'0'); // '1' - '0' = 49 - 48 = 1 => 숫자가된다.
		System.out.println(1+'0'); // 1 + '0' = 1 + 48 = 49 
		System.out.println((char)(1+'0')); // 1 + '0' = 1 + 48 = '1' => 문자가 된다.
		
		// 참조현 변수
		String name1 = "한사람";
		String name2 = "한사람";
		String name3 = new String("한사람");
		String name4 = new String("한사람");
		
		// 위의 코드는 메모리에 "한사람"이 3개가 생기고 각각 name1과 name2는 같은 주소를 공유하지만 name3과 name4는 다른 주소를 기억한다.
		
		if(name1==name2) { // ==(상등연산자)로 비교
			System.out.println("1. 같은사람");
		}else {
			System.out.println("1. 다른사람");
		}
		if(name1==name3) { // ==(상등연산자)로 비교 => 주소가 비교
			System.out.println("2. 같은사람");
		}else {
			System.out.println("2. 다른사람");
		}
		if(name3==name4) { // ==(상등연산자)로 비교
			System.out.println("3. 같은사람");
		}else {
			System.out.println("3. 다른사람");
			
			
		if(name3==name4) { // ==(상등연산자)로 비교
			System.out.println("1. 같은사람");
		}else {
			System.out.println("1. 다른사람");
		}
		if(name1==name3) { // ==(상등연산자)로 비교 => 주소가 비교
			System.out.println("2. 같은사람");
		}else {	
			System.out.println("2. 다른사람");
		}
		
		if(name3==name4) { // ==(상등연산자)로 비교
			System.out.println("3. 같은사람");
		}else {
			System.out.println("3. 다른사람");	
		}	
			
			
			
		}
	}

}
