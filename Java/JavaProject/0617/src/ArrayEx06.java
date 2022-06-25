
//문제 : 5행 5열짜리 정수 배열을 만들어 아래처럼 채우고 출력하시오
/*
1  3  6 10 15
2  5  9 14 19
4  8 13 18 22
7 12 17 21 24
11 16 20 23 25
*/
public class ArrayEx06 {
   final static int MAX = 5; // 상수 선언 (배열의 크기를 지정)

   public static void main(String[] args) {
      int ar[][] = new int[MAX][MAX];
      int k = 0;
      /*
       [0][0]
       [1][0],[0][1]
       [2][0],[1][1],[0][2]
       [3][0],[2][1],[1][2],[0][3]
       [4][0],[3][1],[2][2],[1][3],[0][4]
       [4][1],[3][2],[2][3],[1][4]
       [4][2],[3][3],[2][4]
       [4][3],[3][4]
       [4][4]
       */
      // 빗살 무늬로 채우기 1
      System.out.println("1번");
      System.out.println();
      for (int i = 0; i < MAX * 2 - 1; i++)
         if (i < MAX)
            for (int j = 0; j <= i; j++)
               ar[i - j][j] = ++k;
         else
            for (int j = i - MAX + 1; j < MAX; j++)
               ar[i - j][j] = ++k;

      arrayPrint(ar);

      // 빗살 무늬로 채우기 2
      System.out.println("2번");
      System.out.println();
      k = 0;
      for (int i = 0; i < MAX * 2 - 1; i++)
         for (int j = (i < MAX ? 0 : i - MAX + 1); j <= (i < MAX ? i : MAX - 1); j++)
            ar[i - j][j] = ++k;

      arrayPrint(ar);

      // 빗살 무늬로 채우기 3
      System.out.println("3번");
      System.out.println();
      k = 0;
      int start, end;
      for (int i = 0; i < MAX * 2 - 1; i++) {
         start = i < MAX ? 0 : i - MAX + 1;
         end = i < MAX ? i : MAX - 1;
         for (int j = start; j <= end; j++)
            ar[i - j][j] = ++k;
      }

      arrayPrint(ar);
   }

   private static void arrayPrint(int[][] ar) {
      for (int i = 0; i < MAX; i++) {
         for (int j = 0; j < MAX; j++)
            System.out.printf("%3d", ar[i][j]);
         System.out.println();
      }
      System.out.println();
   }
}