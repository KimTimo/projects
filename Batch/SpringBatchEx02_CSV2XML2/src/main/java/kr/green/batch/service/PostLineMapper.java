package kr.green.batch.service;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import kr.green.batch.vo.PostVO;

public class PostLineMapper implements FieldSetMapper<PostVO>{

	@Override
	public PostVO mapFieldSet(FieldSet fieldSet) throws BindException {
		PostVO postVO = new PostVO();
		postVO.setZipCode(fieldSet.readString(0));
		postVO.setZipSeq(fieldSet.readString(7));
		postVO.setSido(fieldSet.readString(1));
		postVO.setGungu(fieldSet.readString(8));
		return postVO;
	}

}
