package kr.green.maven0630.json;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import lombok.Data;

@Data
class BagOfPrimitives {
	private int value1 = 1;
	private String value2 = "abc";
	private transient int value3 = 3;

	BagOfPrimitives() {
		// no-args constructor
	}
}

public class Ex_Gson2 {
	public static void main(String[] args) {
		// 사용자가 만든 클래스도 json 으로 상호 변환이 가능할까?
		Gson gson = new Gson();

		// Serialization : 자바 객체를 json 문자열로 변환해 준다.
		// toJson 메소드는 넘어온 자바형식의 데이터를 json모양의 문자열로 만들어 준다.

		BagOfPrimitives vo = new BagOfPrimitives();
		String jsonData = gson.toJson(vo);
		System.out.println(jsonData);
		
		// Deserialization(역직렬화) : json 형식의 문자열을 자바에서 사용하는 자료형으로 변환해 준다.
		// fromJson 메소드는 넘어온 문자열을 두번째 인수의 자바형식으로 만들어 준다.
		BagOfPrimitives vo2 = gson.fromJson(jsonData, BagOfPrimitives.class);
		System.out.println("읽은 값 : " + vo2);
		
		JsonObject obj = new JsonObject();
		obj.addProperty("name", "한사람");
		obj.addProperty("age", 22);
		obj.addProperty("gender", true);
		
		System.out.println(obj);
		// 직렬화
		System.out.println(gson.toJson(obj));
		
		// 저장 : 직렬화
		String t = gson.toJson(obj);
		
		// 읽기 : 역직렬화
		JsonObject obj2 = gson.fromJson(gson.toJson(obj), JsonObject.class);
		System.out.println(obj2);
		System.out.println("이름 : " + obj2.get("name"));
		System.out.println("나이 : " + (obj2.get("age").getAsInt()+1));
		System.out.println("성별 : " + (obj2.get("gender").getAsBoolean()? "남" : "여"));
		
		// 파일로 저장하기
		try(PrintWriter pw = new PrintWriter("obj.son")){
			gson.toJson(obj2, pw);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		// 저장된 파일을 읽어보자
		try(FileReader fr = new FileReader("obj.son")){
			JsonObject obj3 = gson.fromJson(fr, JsonObject.class);
			System.out.println("읽은 값 : " + obj3);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
