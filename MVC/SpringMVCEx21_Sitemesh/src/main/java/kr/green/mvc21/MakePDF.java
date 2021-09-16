package kr.green.mvc21;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class MakePDF {
	public static void main(String[] args) {
		String result="";
		File file = new File("ItextExPDF");
		try {
			Document document = new Document();
			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(file));
			document.open();
			
			BaseFont baseFont = BaseFont.createFont("c:/windows/fonts/malgun.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
			Font font = new Font(baseFont, 30);
			PdfPTable table = new PdfPTable(4);
			Chunk chunk = new Chunk("장바구니", font);
			Paragraph ph = new Paragraph(chunk);
			ph.setAlignment(Element.ALIGN_CENTER);
			document.add(ph);

			font = new Font(baseFont, 12);
			document.add(Chunk.NEWLINE); // Chunk : 큰 떵어리

			PdfPCell cell1 = new PdfPCell(new Phrase("상품명", font)); // Phrase: 구, 구문
			cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell2 = new PdfPCell(new Phrase("단가", font));
			cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell3 = new PdfPCell(new Phrase("수량", font));
			cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell4 = new PdfPCell(new Phrase("금액", font));
			cell4.setHorizontalAlignment(Element.ALIGN_CENTER);

			table.addCell(cell1);
			table.addCell(cell2);
			table.addCell(cell3);
			table.addCell(cell4);

			document.add(table);
			document.close();
			writer.close();
			result = "pdf 파일이 생성되었습니다.";
		} catch (Exception e) {
			e.printStackTrace();
			result = "pdf 파일 생성 실패 ...";
		}
		System.out.println(result);
		// Chrome 으로 방금 작성한 파일을 바로 열어서 확인해봅니다.
		String chrome = "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe";
		try {
			new ProcessBuilder(chrome, file.getAbsolutePath()).start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
