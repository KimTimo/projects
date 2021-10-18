package kr.green.calendar.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import kr.green.calendar.vo.EventVO;
public class EventUtil {
	public static List<EventVO> readEvents(String path){
		List<EventVO> list = null;
		Gson gson = new Gson();
		FileReader fr = null;
		try {
			fr = new FileReader(path + "/events.json");
			list = gson.fromJson(fr, new TypeToken<List<EventVO>>() {}.getType());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
}
