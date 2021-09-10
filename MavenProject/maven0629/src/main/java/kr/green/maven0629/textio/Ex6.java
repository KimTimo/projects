package kr.green.maven0629.textio;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

public class Ex6 {

	static String fileName = "src/main/resource/koreansong.txt";

	public static void main(String[] args) {

		try {
			// import 주의
			List<String> lines = Files.readLines(new File(fileName), Charsets.UTF_8);
			StringBuilder sb = new StringBuilder();

			for (String line : lines) {
				sb.append(line);
				sb.append(System.lineSeparator());
			}
			System.out.println(sb);

			System.out.println("----------------------------------");
			String charSource = Files.asCharSource(new File(fileName), Charsets.UTF_8).read();
			System.out.println(charSource);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
