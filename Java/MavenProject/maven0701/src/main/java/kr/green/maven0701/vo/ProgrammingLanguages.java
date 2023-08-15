package kr.green.maven0701.vo;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@Data
@XmlRootElement(name="programming_languages")
public class ProgrammingLanguages {
	private List<Language> language = new ArrayList<>();
}
