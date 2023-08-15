package kr.green.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service("fileService")
public class FileServiceImpl implements FileService {

	@Value("${sourceLocation:c:/temp/input}")
	private String source;

	@Value("${destinationLocation:c:/temp/output}")
	private String destination;

	@Autowired
	private Environment environment;
	
	@Value("${o.driver:}")
	private String driver;
	@Value("${o.url:}")
	private String url;
	@Value("${o.username:}")
	private String username;
	@Value("${o.password:}")
	private String password;

	public void readValue() {
		System.out.println("JDBC 드라이버 클래스 :" + environment.getProperty("jdbc.driverClassName"));
		System.out.println("JDBC 사용자 아이디 :" + environment.getProperty("jdbc.userName"));
		System.out.println("JDBC 사용자 비밀번호 :" + environment.getProperty("jdbc.password"));
		System.out.println("Source Location : " + source);
		System.out.println("Destination Location : " + destination);
	}

	@Override
	public String toString() {
		return "FileServiceImpl [source=" + source + ", destination=" + destination + ", environment=" + environment
				+ ", url=" + url + ", username=" + username + ", password=" + password + "]";
	}
	
	
}
