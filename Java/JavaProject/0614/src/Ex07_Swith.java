import java.util.Scanner;

public class Ex07_Swith {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("권한을 입력하세요 (0은 종료)");
			int grant = sc.nextInt();
			if(grant==0) break; // 탈출
			
			switch(grant) {
			case 3:
				System.out.println("삭제권한");
				break;
			case 2:
				System.out.println("쓰기권한");
				break;
			case 1:
				System.out.println("읽기권한");
				break;
			default:
				System.out.println("알 수 없는 권한입니다.");
			}
		} // end while
		sc.close();
	} // end main
} //
