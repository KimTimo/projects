import java.util.Random;

// 난수 : 사용자도 예측할 수 없는 수
//        Math.random() 과 Random클래스
public class Ex11_random {
   public static void main(String[] args) {
      int count = 0;
      while(count<10) {
         System.out.println(Math.random()); // 0 ~ 1사이의 난수를 발생시킨다.
         count++;
      }
      System.out.println("----------------------------------------");
      Random random = new Random();
      count = 0;
      while(count<10) {
         System.out.println(random.nextDouble()); // 0 ~ 1사이의 난수를 발생시킨다.
         count++;
      }
      System.out.println("----------------------------------------");
      
      
   }
}