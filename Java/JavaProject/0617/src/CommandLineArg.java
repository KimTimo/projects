import javax.swing.JOptionPane;

public class CommandLineArg {

	public static void main(String[] args) {

		System.out.println("명령행 인수의 개수 : " + args.length + "개");
		if(args.length>0) {
			for(int i = 0; i < args.length; i++) {
				System.out.println(i+1 + "번째 인수 : " + args[i]);
			}
		} else {
			System.out.println("인수가 없다.");
		}
		JOptionPane.showMessageDialog(null, "반갑나~");
		String name = JOptionPane.showInputDialog("너어 이름이 모호니");
		String age = JOptionPane.showInputDialog("몇살이뉘?");
		JOptionPane.showInputDialog(null, name + "씨 " + age + "살이네 깍듯이해라이~");
	}

}
