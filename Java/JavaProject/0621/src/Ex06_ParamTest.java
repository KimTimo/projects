class Data {
	int data;
}

public class Ex06_ParamTest {

	public static void main(String[] args) {
		Data data = new Data();
		data.data = 11;
		System.out.println("Call By Value(값에 의한 호출) 메서드 호출 전 : " + data.data); // 11
		changeValue(data.data);
		System.out.println("Call By Value(값에 의한 호출) 메서드 호출 후 : " + data.data); // 11
		System.out.println();

		System.out.println("Call By Reference(참조에 의한 호출) 메서드 호출 전 : " + data.data); // 11
		changeReference(data);
		System.out.println("Call By Reference(참조에 의한 호출) 메서드 호출 후 : " + data.data); // 11
	}

	// Call By Value(값에 의한 호출)
	public static void changeValue(int data) { // 값을 전달하면 값이 복사되어 전달
		System.out.println("전달 받은 값 : " + data);
		data = 13;
		System.out.println("변경된 값 : " + data);
	} // 그 값은 소멸

	// Call By Reference(참조에 의한 호출)
	public static void changeReference(Data data) { // 객체를 전달하면 주소값이 전달 객체 = Data
		System.out.println("전달 받은 값 : " + data.data);
		data.data = 13;
		System.out.println("변경된 값 : " + data.data);
	}

}
