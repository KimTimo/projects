package kr.green.batch.service;

import org.springframework.batch.item.ItemProcessor;

import kr.green.batch.vo.LicenseVO;

public class LicenseVOItemProcessor implements ItemProcessor<LicenseVO, LicenseVO>{

	@Override
	public LicenseVO process(LicenseVO item) throws Exception {
		System.out.println("읽음 : " + item);
		return item;
	}

}
