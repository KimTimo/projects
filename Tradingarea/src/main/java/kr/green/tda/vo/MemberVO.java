package kr.green.tda.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberVO {
	private int idx;
	private String userid;
	private String password;
	private String uuid;
	private String username;
	private String email;
	private Date birth;
	private String phone;

}
