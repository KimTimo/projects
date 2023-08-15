
public class Ex21_while {

	public static void main(String[] args) {

		// n!을 출력하시오!
		// 5! = 5*4*3*2*1 = 120
		int n = 5, fac = 1;
		
		System.out.println(n + "! = ");
		
		while(n>0) {
			System.out.print(n);
			if(n>0) System.out.println(" * ");
			fac *= n;
			n--;
		}
		System.out.println(" = " + fac);
		
		
		
		
		
		
		
		
		
		
	}

}
