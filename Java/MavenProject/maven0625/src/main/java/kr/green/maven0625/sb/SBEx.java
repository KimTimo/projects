package kr.green.maven0625.sb;
// StringBeffer : String처럼 불변 객체가 아니라 연산하면 스스로가 변경된다.
                  

public class SBEx {
	public static void main(String[] args) {
		//StringBuffer sb = new StringBuffer();    // 16
		//StringBuffer sb = new StringBuffer(200);    // 200의 공간
		StringBuffer sb = new StringBuffer("오오오오오");    // 21
		view(sb);
		// 내용 추가
		sb.append("하하하하 하하하하");
		view(sb);
		
		sb.append("하하하하 하하하하");
		view(sb);
		// 내용 삽입
		sb.insert(5, "우앙~~~");
		view(sb);
		// 삭제
		sb.delete(6, 14);
		view(sb);
		
		sb.deleteCharAt(2);
		view(sb);
		
		// 치환(수정)
		sb.replace(3, 6, "***");
		view(sb);
		
		sb.reverse();
		view(sb);
	}

	private static void view(StringBuffer sb) {
		System.out.println(" 기본 용량 : " + sb.capacity());
		System.out.println(" 길이 : " + sb.length());
		System.out.println(" 내용 : " + sb);
	}

}
