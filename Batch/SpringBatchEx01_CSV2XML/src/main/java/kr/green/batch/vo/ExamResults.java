package kr.green.batch.vo;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement // 클래스 이름을 루트 태그로 쓰겠다
@XmlAccessorType(XmlAccessType.FIELD) // 설정 사항을 필드에 직접 쓰겠다
public class ExamResults {
	@XmlElement(name = "examResult")
	private List<ExamResult> examResults;
}
