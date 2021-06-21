import java.util.Scanner;

/*
5명 학생의 국어 영어 수학 과학 4과목의 점수를 입력 받아서
각 개인별로 평균이 80 이상이면“합격” 그렇지 않으면“불합격”을 출력하고
합격한 사람의 수를 출력하는 프로그램을 작성하시오.


입력 예
85 67 95 65
80 95 86 56
100 98 67 86
95 76 84 65
67 86 90 76
출력 예
fail
fail
pass
pass
fail
Successful : 2
 */
public class Jungol_569 {
   public static void main(String[] args) {
      int ar[][] = new int[5][4];
      Scanner sc = new Scanner(System.in);

      System.out.println("점수 입력(5행 4열)");
      for(int i=0;i<ar.length;i++)
         for(int j=0;j<ar[i].length;j++)
            ar[i][j] = sc.nextInt();
      
      int count = 0; // 개수
      for(int i=0;i<ar.length;i++) {
         int sum = 0; // 합계
         for(int j=0;j<ar[i].length;j++) {
            sum += ar[i][j];
         }
         if(sum/4>=80) {
            System.out.println("pass");
            count++;
         }else {
            System.out.println("fail");
         }
      }
      System.out.println("Successful : " + count);
      sc.close();
   }
}