package com.timo.book.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class OembedController extends JSONParser {

	private static JSONParser jsonParser = null;
	private static List<String> lst = null;
	private static JSONArray jsonArray = null;
	private URL url;

	public static void providerData() throws IOException {
		lst = new ArrayList<String>();
		jsonParser = new JSONParser();

		ClassPathResource classPathResource = new ClassPathResource("dir/providers.json");
		BufferedReader rd = new BufferedReader(new InputStreamReader(classPathResource.getInputStream()));
		try {
			Object obj = jsonParser.parse(rd);

			JSONArray jsonArr = (JSONArray) obj;

			for (int i = 0; i < jsonArr.size(); i++) {
				JSONObject provider_url = (JSONObject) jsonArr.get(i);
				String url = (String) provider_url.get("endpoints").toString();

				// endpoints 데이터의 url만 가져오기
				Object obj2 = jsonParser.parse(url);
				jsonArray = new JSONArray();
				jsonArray = (JSONArray) obj2;
				JSONObject urlData = (JSONObject) jsonArray.get(0);

				String value = (String) urlData.get("url");
				lst.add(value);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 호스트 체크
	public String hostCheck(String str) {
		String result = "";
		try {
			url = new URL(str);

			String[] split = url.getHost().split("\\.");

			// split 데이터가 2개일 경우
			if (split.length == 2) {
				result = split[0];
			} else if (split.length == 3) {
				result = split[1];
			}

		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return result;
	}

	// 프로바이더 url + 포맷 + 인코드 합친 문자 만들기
	public String createAddr(String host, String encode) {
		String oembedUrl = "";

		// 프로바이더 url을 검색해서 해당되는 url이 나오면 멈춘다
		for (String str : lst) {
			// 만약, url에 host(문자) 가 포함되어 있다면 멈추고 해당 데이터를 조합한다
			if (str.contains(host)) {

				// 프로바이더 url + ?format=json&url= + encode data
				if (str.contains("oembed.")) {
					// {format}이 들어있으면 json으로 변환해준다
					if (str.contains("{format}")) {
						str = str.replace("{format}", "json");
					}
					oembedUrl = str + "?url=" + encode;
				} else if (str.contains("_oembed")) {
					oembedUrl = "";
				} else {
					oembedUrl = str + "?format=json&url=" + encode;
				}
				break;
			}
		}

		return oembedUrl;
	}

	// oembed 리턴
	@GetMapping("/oembed/api")
	@ResponseBody
	public String oembedResponse(@RequestParam("userUrlData") String userUrlData, Model model)
			throws ClientProtocolException, IOException {
		String result = "";
		try {
			String host = hostCheck(userUrlData);
			String encode = URLEncoder.encode(userUrlData, StandardCharsets.UTF_8);
			String oembedUrl = createAddr(host, encode);

			CloseableHttpClient hc = HttpClients.createDefault();
			HttpGet httpGet = new HttpGet(oembedUrl);

			httpGet.addHeader("Content-Type", "application/json");

			CloseableHttpResponse httpResponse = hc.execute(httpGet);

			result = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");

		} catch (Exception e) {
			e.printStackTrace();
			result = "";
		}

		return result;
	}

	@GetMapping("/")
	public String home(Model model) throws ClientProtocolException, IOException, URISyntaxException {
		// provider의 url 데이터들 넣어놓기
		providerData();

		return "index";
	}

}
