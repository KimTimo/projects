package kr.green.batch.service;

import org.springframework.batch.item.ItemProcessor;

import kr.green.batch.vo.HanjaVO;

public class HanjaVOItemProcessor implements ItemProcessor<HanjaVO, HanjaVO>{

	@Override
	public HanjaVO process(HanjaVO item) throws Exception {
		System.out.println("읽음 : " + item);
		return item;
	}

}
