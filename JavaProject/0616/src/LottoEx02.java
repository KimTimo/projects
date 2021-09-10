import java.util.Arrays;
import java.util.Random;

// 로또 번호 자동 생성기 예제 2
public class LottoEx02 {
   public static void main(String[] args) {
      int lotto[] = new int[6]; // 로또 번호를 저장할 배열
      Random rnd = new Random(); // 난수 생성기
      
      for(int i = 0; i < lotto.length; i++) { // 6번
    	  lotto[i] = rnd.nextInt(45)+1;       // 난수발생
    	  for(int j = 0; j < i; j++) {        // 이전에 발생한 숫자와 같은 숫자인지 비교
    		  if(lotto[i]==lotto[j]){
    			  --i;                        // 같으면 현재 번호 버리기
    			  break;                      // 비교탈출
    		  }
    	  }
      }
      
      Arrays.sort(lotto); // 정렬
      System.out.println(Arrays.toString(lotto)); // 출력
     
   }
}