import java.util.Arrays;
import java.util.Random;

// 난수 : 사용자도 예측할 수 없는 수
//        Math.random() 과 Random클래스
public class Ex13_random {
   public static void main(String[] args) {
      //로또 생성기
	   int[] lotto = new int[6];
	   Random random = new Random();
	   int count = 0;
	   while(count < 6) {
		   lotto[count] = random.nextInt(45)+1;
		   //이전에 발생한 번호와 같은지 비교한다.
		   for(int i = 0; i<count; i++) {
			   if(lotto[i]==lotto[count]) {
				   count--;
				   break;
			   }
		   }
			count++;
	   }
	   Arrays.parallelSort(lotto);
       System.out.println("로또번호 : " + Arrays.toString(lotto));
   }
}