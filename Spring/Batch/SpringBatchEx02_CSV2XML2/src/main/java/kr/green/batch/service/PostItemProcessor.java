package kr.green.batch.service;

import org.springframework.batch.item.ItemProcessor;

import kr.green.batch.vo.PostVO;

public class PostItemProcessor  implements ItemProcessor<PostVO, PostVO>{

	@Override
	public PostVO process(PostVO item) throws Exception {
		System.out.println("읽은값 : " + item);
		return item;
	}

}
