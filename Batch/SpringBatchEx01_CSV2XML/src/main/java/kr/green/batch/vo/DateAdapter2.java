package kr.green.batch.vo;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;
// XML과 String을 상호 변경해주는 클랙스
public class DateAdapter2 extends XmlAdapter<String, Date>{
	private SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
	
	@Override
	public Date unmarshal(String v) throws Exception {
		return sdf.parse(v);
	}

	@Override
	public String marshal(Date v) throws Exception {
		return sdf.format(v);
	}

}
