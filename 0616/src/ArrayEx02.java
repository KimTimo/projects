import java.util.Arrays;
import java.util.Scanner;

/*
 * 배열명은 참조형 변수이다. 값을 저장하는 것이 아니라 값이 저장된 주소를 기억한다.
 */
public class ArrayEx02 {

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int sum = 0;
      double avg = 0;
      int score[] = new int[10];
      for(int i = 0; i < score.length; i++) {
         System.out.print(i+1 + "번째 정수 입력 : ");
         score[i] = sc.nextInt();
         sum += score[i];
      }
      
      for(int i = score.length-1; i>=0;i--)
         System.out.print(score[i] + " ");
      System.out.println();
      avg = (double)sum/score.length;
      System.out.println("합 : " + sum + ", 평균 : " + avg);
      
      
      

      sc.close();
   } // close main

} // close class