package email.vo;

import lombok.Data;

@Data
public class MailVO {
	private String from;
	private String password;
	private String to;
	private String subject;
	private String content;
}
