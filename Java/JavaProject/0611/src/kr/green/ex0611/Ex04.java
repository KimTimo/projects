package kr.green.ex0611;

import java.util.Scanner;
// &연산과 >> 연산을 이용한 10진수를 2진수로 변환하는 프로그램
public class Ex04 {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in); // 입력객체
      while(true) { // 무한반복
         System.out.print("0~255사이의 정수 입력(0은 종료)\n");
         int n = sc.nextInt();
         if(n==0) break; // 입력값이 0이면 종료
         if(n<0 || n>255) { // 유효성 검사
            System.out.println("정확한 값을 입력해주세요!!!\n");
            continue; // 반복문의 처음으로 가라
         }
         int mask = 0x80; // 이진수 : 1000 0000
         for(int i=0;i<8;i++) { // 8번 반복
            System.out.print((n & mask)==mask ? "1" : "0");
            mask = mask >> 1;
         }
         System.out.println();
      }
      sc.close();
   }
}