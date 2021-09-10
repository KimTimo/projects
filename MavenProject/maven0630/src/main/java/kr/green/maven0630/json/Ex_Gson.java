package kr.green.maven0630.json;

import java.util.Arrays;

import com.google.gson.Gson;

public class Ex_Gson {

	public static void main(String[] args) {
		Gson gson = new Gson();
		
		// Serialization : 자바 객체를 json 문자열로 변환해 준다.
		System.out.println(gson.toJson(1));
		System.out.println(gson.toJson("abcd"));
		System.out.println(gson.toJson(new Long(10)));
		System.out.println(gson.toJson(new int[] {1,2,3,4,5}));
		// toJson 메소드는 넘어온 자바형식의 데이터를 json모양의 문자열로 만들어 준다.
		String jsonStr = gson.toJson(new int[] {1,2,3,4,5});
		System.out.println(jsonStr);
		
		// Deserialization(역직렬화) : json 형식의 문자열을 자바에서 사용하는 자료형으로 변환해 준다.
		// fromJson 메소드는 넘어온 문자열을 두번째 인수의 자바형식으로 만들어 준다.
		int [] ar = gson.fromJson(jsonStr, int[].class);
		System.out.println(Arrays.toString(ar));
		
		System.out.println(gson.fromJson("123", int.class) *2 );
		System.out.println(gson.fromJson("123", double.class) *2 );
	}

}
