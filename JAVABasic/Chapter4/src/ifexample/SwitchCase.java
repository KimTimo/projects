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
//		System.out.println(rank +"�� �޴��� ���� " + medalColor + "�Դϴ�.");
		String medal = "Gold";
		
		switch(medal) {
		case "Gold" :
			System.out.println("��� �Դϴ�.");
			break;
		case "Silver" :
			System.out.println("�ǹ� �Դϴ�.");
			break;
		case "Bronze" :
			System.out.println("����� �Դϴ�.");
			break;
		default :
			System.out.println("�� �Դϴ�.");
			break;
		}
		System.out.println("����� ���� Ƽ��� " + medal + "�Դϴ�.");
		
	}

}
