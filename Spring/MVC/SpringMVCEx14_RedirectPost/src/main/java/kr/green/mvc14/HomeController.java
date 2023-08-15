package kr.green.mvc14;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );
		return "home";
	}
	
	// GET방식의 전송
	@RequestMapping(value = "/listGet", method = RequestMethod.GET) // GET방식의 요청일 경우에 처리된다.
	public String listGet(Model model) {
		return "redirect:/list?p=10&b=10&s=10"; // 데이터의 전달을 GET방식으로 전달
												// redirect : 다른 주소를 호출한다.
	}
	
	@RequestMapping(value = "/list", method=RequestMethod.GET)
	public String list(@RequestParam int p, @RequestParam int b, @RequestParam int s, Model model ) {
		model.addAttribute("p", p);
		model.addAttribute("s", s);
		model.addAttribute("b", b);
		return "list";
	}
	
	// Redirect시 POST전송을 하는 방법
	@RequestMapping(value = "/listPost", method=RequestMethod.GET)
	public String listPost(Model model, RedirectAttributes redirectAttributes) {
		// Redirect시 POST전송 하려면 map에 넣어서 RedirectAttributes에 담아서 전송하면 된다.
		Map<String, String> map = new HashMap<>();
		map.put("p", 5+"");
		map.put("s", 15 + "");
		map.put("b",20 + "");
		redirectAttributes.addFlashAttribute("map", map);
		return "redirect:/list2";
	}
	
	@RequestMapping(value = "/list2")
	public String list2(@RequestParam Map<String, String> params, HttpServletRequest request, Model model) {
		// POST전송된것을 받으려면 RequestContextUtils.getInputFlashMap(request)로 맵이 존재하는지 판단해서
		// 있으면 POST처리를 하고 없으면 GET으로 받아서 처리를 한다.
		Map<String, ?> flashMap = RequestContextUtils.getInputFlashMap(request);
		if(flashMap!=null) {
			params = (Map<String, String>) flashMap.get("map");
			model.addAttribute("p", params.get("p"));
			model.addAttribute("s", params.get("s"));
			model.addAttribute("b", params.get("b"));
			return "list";
		}else {
			return "redirect:/";
		}

		
		// 아래의 방법으로는 GET/POST 구분할 수 없다.
		/*
		logger.info("전송방식 : " + request.getMethod());
		if(request.getMethod().equals("POST")) {
			Map<String, ?> flashMap = RequestContextUtils.getInputFlashMap(request);
			params = (Map<String, String>) flashMap.get("map");
			model.addAttribute("p", params.get("p"));
			model.addAttribute("s", params.get("s"));
			model.addAttribute("b", params.get("b"));
			return "list";
		}else {
			return "redirect:/";
		}
		*/
	}
	
}
