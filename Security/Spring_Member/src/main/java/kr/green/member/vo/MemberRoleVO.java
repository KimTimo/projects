package kr.green.member.vo;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
	idx 		NUMBER	PRIMARY KEY,
	username	varchar2(50)  NOT NULL,
	role	varchar2(50)  NOT NULL
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
public class MemberRoleVO {
	private int idx;
	private String username;
	private String role;
}
