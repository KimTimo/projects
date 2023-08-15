package kr.green.batch.service;

import java.io.InputStreamReader;
import java.util.List;

import org.springframework.batch.item.file.ResourceAwareItemReaderItemStream;
import org.springframework.batch.item.support.AbstractItemCountingItemStreamItemReader;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.io.Resource;
import org.springframework.util.ClassUtils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import kr.green.batch.vo.HanjaVO;

public class JsonFileItemReader extends AbstractItemCountingItemStreamItemReader<HanjaVO> implements
			ResourceAwareItemReaderItemStream<HanjaVO>, InitializingBean{

	private Resource resource;
	private String classToBound;

	private List<HanjaVO> items;
	private int index =0;
	private Gson gson = new Gson();
	
	public JsonFileItemReader() {
		setName(ClassUtils.getShortName(JsonFileItemReader.class));
	}
	
	public void setClassToBound(String classToBound) {
		this.classToBound = classToBound;
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		
	}

	@Override
	public void setResource(Resource resource) {
		this.resource = resource;
		
	}

	@Override // 1개를 리턴
	protected HanjaVO doRead() throws Exception {
		return (this.items==null || index>=this.items.size()) ? null : this.items.get(index++);
	}

	@Override // json파일을 읽어서 변수에 대입
	protected void doOpen() throws Exception {
		InputStreamReader isr = null;
		isr = new InputStreamReader(resource.getInputStream());
		items = gson.fromJson(isr, new TypeToken<List<HanjaVO>>() {}.getType());
	}

	@Override
	protected void doClose() throws Exception {
		
	}

}
