
//문제 : 5행 5열짜리 정수 배열을 만들어 아래처럼 채우고 출력하시오
/*
1  3  6 10 15
2  5  9 14 19
4  8 13 18 22
7 12 17 21 24
11 16 20 23 25
*/
public class ArrayEx07 {
	final static int MAX = 7;
	
   public static void main(String[] args) {
      int arr[][] = new int[MAX][MAX];
      int k = 0;
      //extracted(arr);
      System.out.println();
      
      for(int i = 0; i <= MAX/2; i++) {
    	  for(int j = i; j < MAX-i; j++) {
    		  arr[i][j] = ++k;
    	  }
      }
      
      extracted(arr);
      System.out.println();
      
      for(int i = 1; i <= MAX/2; i++) {
    	  for(int j = MAX/2-i; j <= MAX/2+i; j++) {
    		  arr[MAX/2 + i][j] = ++k;
    	  }
      }
   }

private static void extracted(int[][] arr) {
	for(int i = 0; i < MAX; i++) {
    	  for(int j = 0; j < MAX; j++) {
    		  if(arr[i][j]!=0)
    		  System.out.printf("5%d", arr[i][j]);
    		  else {
    			  System.out.print("     ");
    		  }
    	  }
    	  System.out.println();
      }
}
}