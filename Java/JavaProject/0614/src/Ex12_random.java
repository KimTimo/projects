import java.util.Random;

// 난수 : 사용자도 예측할 수 없는 수
//        Math.random() 과 Random클래스
public class Ex12_random {
   public static void main(String[] args) {
      int count = 0;
      // 원하는 정수 범위의 난수 발생하기 = (Int)(Math.random() * (최대-최소)) + 최소값
      // 50~100까지의 난수 = (Int)(Math.random() * (100-50+1)) + 50
      while(count<6) {            // 메스 클래스
         System.out.println((int)(Math.random()*45)+1 + " "); // 0 ~ 1사이의 난수를 발생시킨다.
         count++;
      }
      System.out.println();
      System.out.println("----------------------------------------");
      Random random = new Random(); // 랜덤 메소드
      // 원하는 정수 범위의 난수 발생하기 = random.nextInt(최대-최소+1) + 최소값
      // 50~100까지의 난수 = random.nextInt(100-50+1) + 50
      count = 0;
      while(count<6) {
         System.out.println(random.nextInt(45)+1 + " "); // 0 ~ 1사이의 난수를 발생시킨다.
         count++;
      }
      System.out.println("----------------------------------------");
   }
}