package kr.green.maven0701.io;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
// 자식은 직렬화/역직렬화를 구현했다.
@NoArgsConstructor
@Setter
@Getter
public class Child extends Parent implements Serializable{
	private static final long serialVersionUID = 4434298882227001951L;
	
	private String id;
	private String password;
	
	public Child(String name, int age, String id, String password) {
		super(name, age);
		this.id = id;
		this.password = password;
	}
	//*************************************************************************************
	// 직렬화/역직렬화 메서드를 사용자가 직접 만들어 주면 된다.
	// 직렬화 메서드
	private void writeObject(ObjectOutputStream out) throws IOException {
		// 저장이 되도록 out에 출력하면 된다.
		out.writeUTF(super.getName());
		out.writeInt(super.getAge());
		// 자식에서 추가한 변수가 많다 아래의 코드가 길어다. 이를 줄일 수 있다.
		// out.writeUTF(id);
		// out.writeUTF(password);
		out.defaultWriteObject(); // 모든 자식의 요소를 직렬화 시켜준다.
	}

	// 역직렬화 메서드
	private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
		// in에서 읽어서 내 변수에 대입해 주면 된다. 
		super.setName(in.readUTF());
		super.setAge(in.readInt());
		// 자식에서 추가한 변수가 많다 아래의 코드가 길어다. 이를 줄일 수 있다.
		// id = in.readUTF();
		// password = in.readUTF();
		in.defaultReadObject();
	}
	//*************************************************************************************
	@Override
	public String toString() {
		return super.toString() + "\n" + id + ", " + password;
	}
}
