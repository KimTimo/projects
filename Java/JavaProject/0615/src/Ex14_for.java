/*
 * for 반복문
 * ----------
 * for(초기식;종료식;증감식){
 *    종료식이 참인동안 실행할 명령들....
 * }
 * 
 * ;은 절대 생략할 수 없다.
 */
public class Ex14_for {
   public static void main(String[] args) {
      // 1~100까지 합을 구하는 여러가지 방법
      int i=1, sum=0;
      while(i<=100) sum += i++;
      System.out.println("1~100까지 합 : " + sum);
      
      i=sum=0;
      do sum += ++i; while(i<100);
      System.out.println("1~100까지 합 : " + sum);

      sum=0;
      for(i=1;i<=100;i++) sum += i; // 가장 일반적인 for문
      System.out.println("1~100까지 합 : " + sum);

      for(sum=0, i=1;i<=100;i++) sum += i; // 초기식을 2개 사용
      System.out.println("1~100까지 합 : " + sum);

      for(sum=0, i=1;i<=100;sum += i++); // 증감식에 연산식을 사용
      System.out.println("1~100까지 합 : " + sum);
      
      i=sum=0;
      for(;i<100;) sum += ++i;
      System.out.println("1~100까지 합 : " + sum);
      
      i=sum=0;
      for(;;) { // 무한 Loop
         sum += ++i;
         if(i==100) break;
      }
      System.out.println("1~100까지 합 : " + sum);
      
   }
}