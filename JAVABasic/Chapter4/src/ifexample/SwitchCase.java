package ifexample;

public class SwitchCase {

	public static void main(String[] args) {

//		int rank = 1;
//		char medalColor;
//		
//		switch(rank) {
//		    case 1: medalColor = 'G';
//		            break;
//		    case 2: medalColor = 'S';
//                    break;
//		    case 3: medalColor = 'B';
//                    break;
//		    default: medalColor = 'A';
//		}
//		System.out.println(rank +"등 메달의 색은 " + medalColor + "입니다.");
		String medal = "Gold";
		
		switch(medal) {
		case "Gold" :
			System.out.println("골드 입니다.");
			break;
		case "Silver" :
			System.out.println("실버 입니다.");
			break;
		case "Bronze" :
			System.out.println("브론즈 입니다.");
			break;
		default :
			System.out.println("언랭 입니다.");
			break;
		}
		System.out.println("김머현 롤의 티어는 " + medal + "입니다.");
		
	}

}
