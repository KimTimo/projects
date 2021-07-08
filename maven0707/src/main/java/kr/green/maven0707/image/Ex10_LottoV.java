package kr.green.maven0707.image;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Ex10_LottoV extends JFrame {
	public Ex10_LottoV() {
		setTitle("로또 스크롤 시키기");
		setSize(600, 125);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new GridLayout(1, 6, 5, 5));
		getContentPane().setBackground(Color.WHITE);
		
		
		//add(new VScrollPanel(5, 10, 1)); // 번호 1개 스크롤
		// 로또번호를 자동으로 만든다.
		List<Integer> lotto = new Random().ints(1, 46).limit(6).sorted().boxed().collect(Collectors.toList());
		System.out.println(lotto);
		for(int i = 0; i < lotto.size(); i++) {
			add(new VScrollPanel(lotto.get(i), i+1, i+1));
		}
		setVisible(true);
	}

	public static void main(String[] args) {
		new Ex10_LottoV();
	}

	
	
}
