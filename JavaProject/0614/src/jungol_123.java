import java.util.Scanner;

/*
  1번은 개, 2번은 고양이, 3번은 병아리로 정하고 번호를 입력하면
  번호에 해당하는 동물을 영어로 출력하는 프로그램을 작성하시오.
  해당 번호가 없으면 "I don't know."라고 출력한다.
  개-dog
  고양이-cat
  병아리-chick​ 
 */
public class jungol_123 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(true) {			
			System.out.println("1. 김방어");
			System.out.println("2. 완짜몽");
			System.out.println("3. 안몽돌");
			System.out.println("원하는 번호를 선택하면 영어로 알려드림");
		    int sel = scanner.nextInt();
		    if(sel == 0) break;
		    switch(sel) {
		    case 1:
		    	System.out.println("김방어 - Shark");
		    	break;
		    case 2:
		    	System.out.println("완짜몽 - JaMong");
		    	break;
		    case 3:
		    	System.out.println("안몽돌 - MongDol");
		    	break;
		    default:
		    	System.out.println("내가 어터케 알아");
		    } // switch
		    System.out.println("\n");
		} // while
		scanner.close();

	} // main

} // class
