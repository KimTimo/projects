package kr.green.mvc21.vo;

import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@XmlRootElement
public class MessageMap {
	private Map<String, MessageVO> map;
}
