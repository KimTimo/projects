import java.util.Arrays;
import java.util.Random;

// 로또 번호 자동 생성기 예제 1
public class LottoEx01 {
   public static void main(String[] args) {
      int lotto[] = new int[45]; // 로또 번호를 저장할 배열
      // System.out.println(Arrays.toString(lotto));
      
      Random rnd = new Random(); // 난수 생성기
      
      for(int i=0;i<lotto.length;i++) lotto[i] = i + 1; // 배열을 1~45로 초기화
      // System.out.println(Arrays.toString(lotto));
      
      // 첫번째 데이터와 임의의 위치의 데이터 100번 교환한다.
      for(int i=0;i<100;i++) {
         int pos = rnd.nextInt(lotto.length); // 임의의 위치
         int temp = lotto[0];
         lotto[0] = lotto[pos];
         lotto[pos] = temp;
      }
      System.out.println(Arrays.toString(lotto));
      // 앞에서 6개 출력한다.
      for(int i=0;i<6;i++) System.out.printf("%3d", lotto[i]);
   }
}