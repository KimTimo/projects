import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

// 로또 번호 자동 생성기 예제 3
public class LottoEx03 {
   public static void main(String[] args) {
      int lotto[] = new int[45]; // 로또 번호를 저장할 배열
      Random rnd = new Random(); // 난수 생성기
      Scanner sc = new Scanner(System.in);
      
      System.out.print("난프찐막!!!!");
      int game = sc.nextInt();
      
      
      
      int temp;
      // 게임 수만큼 반복
      while(game>0) {
    	  for(int i = 0; i < lotto.length; i++) lotto[i] = 0; // 배열을 모두 0으로 초기화
    	  for(int i = 0; i < 6; i++) { // 6번 반복
    		  do {
    			  temp = rnd.nextInt(lotto.length);
    		  }while(lotto[temp]!=0); // 중복제거 : 0이 있는 위치를 찾는다.
    		  lotto[temp] = 1; // 그 자리에 0이 아닌 숫자를 넣는다.
    	  }
    	  // 출력 : 배열의 내용 중에서 0이 아닌값이 있는 위치를 출력한다. -- 정렬
    	  for(int i = 0; i < lotto.length; i++)
    		  if(lotto[i]!=0) System.out.printf("%3d", i+1);
    	  System.out.println();
    	  game--;
    	  
      }
      
      sc.close();
     
   }
}