package kr.green.inner;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyWindowListener  extends WindowAdapter{

	@Override
	public void windowClosing(WindowEvent e) {
		super.windowClosing(e);
		System.exit(0); // 프로그램 강제종료
	}

}
