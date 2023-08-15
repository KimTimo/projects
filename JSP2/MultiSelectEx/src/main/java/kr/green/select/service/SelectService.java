package kr.green.select.service;

import java.util.Comparator;
import java.util.List;

import kr.green.select.DongUtil;
import kr.green.select.vo.AreaVO;

public class SelectService {
	private static SelectService instance = new SelectService();
	private SelectService() {}
	public static SelectService getInstance() {
		return instance;
	}
	//---------------------------------------------------------------
	public List<AreaVO> selectItem1(String filename){
		List<AreaVO> list = null;
		list = DongUtil.readItem1(filename);
		return list;
	}
	
	//---------------------------------------------------------------
	public List<AreaVO> selectItem2(String filename, String code){
		List<AreaVO> list = null;
		list = DongUtil.readItem2(filename, code);
		list.sort(new Comparator<AreaVO>() {
			@Override
			public int compare(AreaVO o1, AreaVO o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});
		return list;
	}
	
}
