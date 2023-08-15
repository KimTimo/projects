package kr.green.mybatis.emp.vo;

import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@XmlRootElement
@Data
public class DeptVO {
	private int emp_id;
	private String emp_name;
	private String dept_id;
	private String dept_name;
	private String job_id;
	private String dept_city;
}
