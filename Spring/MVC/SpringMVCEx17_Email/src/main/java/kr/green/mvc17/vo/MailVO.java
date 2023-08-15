package kr.green.mvc17.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MailVO {
	private String fromEmailAddress;
	private String toEmailAddress;
	private String subject;
	private String body;
}
