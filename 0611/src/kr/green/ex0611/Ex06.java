package kr.green.ex0611;

import java.util.Scanner;
// &연산과 >> 연산을 이용한 10진수를 2진수로 변환하는 프로그램
public class Ex06 {
   public static void main(String[] args) {
      
	      char n[] = {0x4444, 0x00F0, 0x04E0, 0x4640, 0x6220, 0x0660};
	      for(int x = 0; x<n.length; x++) {
	    	  int mask = 0x8000; 
		      for (int i = 0; i < 16; i++) { // 8번 반복
		         //System.out.print((n & mask) == mask ? "1" : "0");
		         System.out.print((n[x] & mask) == mask ? "■" : "  ");
		         if((i+1)%4==0) System.out.println();
		         mask = mask >> 1;
	      }
	     
	      System.out.println();
	      }
      }
    
}