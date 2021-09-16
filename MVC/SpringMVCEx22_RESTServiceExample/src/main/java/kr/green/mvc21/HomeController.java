package kr.green.mvc21;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.green.mvc21.vo.MessageList;
import kr.green.mvc21.vo.MessageMap;
import kr.green.mvc21.vo.MessageVO;

@RestController
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	// 일반 텍스트 출력
	@RequestMapping(value = "/", produces = "text/html;charset=UTF-8")
	public String home() {
		logger.info("Welcome to RestTemplate Example.");
		return "Welcome to RestTemplate Example. 한글은?";
	}
	// 객체  출력
	@RequestMapping(value = "/hello/{player}", 
			        produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public MessageVO message(@PathVariable String player) {
		return new MessageVO(player, player + "님 반갑습니다");
	}
	
	// 컬렉션 출력(JSON만 출력)
	@GetMapping(value = "/getList")
	public List<MessageVO> getList(){
		List<MessageVO> list = new ArrayList<>();
		String[] names = "한놈,두식이,석삼,너구리,오징어".split(",");
		for(int i=0;i<names.length;i++) list.add(new MessageVO(names[i], names[i] + "님 반갑습니다" ));
		return list;
	}
	@GetMapping(value = "/getList2", 
	        produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public List<MessageVO> getList2(){
		return IntStream.range(1, 10)
				.mapToObj(i-> new MessageVO(i+"번 학생", i + "번님 반가워요"))
				.collect(Collectors.toList());
	}
	// VO를 별도로 만들어서 출력(XML/JSON)
	@GetMapping(value = "/getList3")
	public MessageList getList3(){
		return new MessageList(IntStream.range(1, 10)
				.mapToObj(i-> new MessageVO(i+"번 학생", i + "번님 반가워요"))
				.collect(Collectors.toList()));
	}
	// 맵 출력(JSON만 출력)
	@GetMapping(value = "/getMap")
	public Map<String, MessageVO> getMap(){
		Map<String, MessageVO> map = new HashMap<>();
		map.put("한사람", new MessageVO("한사람", "프로그래머"));
		map.put("두사람", new MessageVO("두사람", "디자이너"));
		return map;
	}
	// VO를 별도로 만들어서 출력(XML/JSON)
	@GetMapping(value = "/getMap2")
	public MessageMap getMap2(){
		Map<String, MessageVO> map = new HashMap<>();
		map.put("한사람", new MessageVO("한사람", "프로그래머"));
		map.put("두사람", new MessageVO("두사람", "디자이너"));
		return new MessageMap(map);
	}
	
	// 상태 정보(성공/실패)를 같이 전송할때 ResponseEntity를 사용한다.
	@GetMapping(value = "/check", params = {"name","text"})
	public ResponseEntity<MessageVO> check(String name,String text){
		MessageVO messageVO = new MessageVO(name, text);
		ResponseEntity<MessageVO> result = null;
		if(name.length()<3) {
			result = ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(messageVO);
		}else {
			result = ResponseEntity.status(HttpStatus.OK).body(messageVO);
		}
		return result;
	}
}
