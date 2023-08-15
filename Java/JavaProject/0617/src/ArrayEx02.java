public class ArrayEx02 {

   final static int MAX = 3;

   public static void main(String[] args) {

      int[][] arr = new int[MAX][MAX];
      // 초기화
      for (int i = 0; i < arr.length; i++) {
         for (int j = 0; j < arr[i].length; j++) {
         }
      }
      // 출력
      for (int i = 0; i < arr.length; i++) {
         for (int j = 0; j < arr[i].length; j++) {
            arr[i][j] = i * arr.length + j + 1;
         }
         System.out.println();
      }

   }

}