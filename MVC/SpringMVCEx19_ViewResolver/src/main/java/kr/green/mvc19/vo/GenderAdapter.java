package kr.green.mvc19.vo;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class GenderAdapter extends XmlAdapter<String, Boolean> {

	@Override // XML을 Object로 변경
	public Boolean unmarshal(String v) throws Exception {
		return v.equals("남자") ? true : false;
	}

	@Override // Object를 XML로 변경
	public String marshal(Boolean v) throws Exception {
		return v ? "남자" : "여자";
	}

}
