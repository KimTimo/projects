package kr.green.mvc21;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class MakePDF2 {
	public static void main(String[] args) {
		// 1) Document 클래스 인스턴스를 생성합니다.
		Document document = new Document();
		File file = new File("ItextExample1.PDF");

		try {
			// 2) Writer와 Document 사이의 연관을 맺어줍니다.
			// Writer를 이용해 문서를 하드디스크에 생성할 수 있습니다. ItextExample1.PDF 파일을 작성해보겠습니다.
			PdfWriter.getInstance(document, new FileOutputStream(file));

			// 3) 문서를 오픈합니다.
			document.open();
			// 4) 문서에 내용을 첨부합니다.
			document.add(new Paragraph("This is first Itext example 한글입력도될까요?"));
			System.out.println(file + " 파일을 성공적으로 생성하였습니다.");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		} finally {
			// 5) 문서를 닫습니다.
			document.close();
		}
		// 8) Chrome 으로 방금 작성한 파일을 바로 열어서 확인해봅니다.
		String chrome = "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe";
		try {
			new ProcessBuilder(chrome, file.getAbsolutePath()).start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
