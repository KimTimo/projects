/*
 * 반복문의 중첩
 */
public class Ex08 {

	public static void main(String[] args) {

		int i, j, sum = 0;
		i = j = 1;
		while(i <= 10) {
			j = 0;
			while(j <= i) {
				System.out.println(j + " ");
				sum += j;
				j++;
			}
			System.out.println();
			i++;
		}
		System.out.println("답 : " + sum);
		
		int sum2;
		sum = sum2 = 0;
		i = j = 1;
		while(i <= 10) {
			sum += i;
			sum2 += sum;
			i++;
		}
		System.out.println("답 : " + sum2);
		}
	}

