package kr.green.batch.vo;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;
// XML과 String을 상호 변경해주는 클랙스

import org.joda.time.LocalDate;
public class LocalDateAdapter extends XmlAdapter<String, LocalDate>{
	 
    public LocalDate unmarshal(String v) throws Exception {
        return new LocalDate(v);
    }
 
    public String marshal(LocalDate v) throws Exception {
        return v.toString();
    }
 
}