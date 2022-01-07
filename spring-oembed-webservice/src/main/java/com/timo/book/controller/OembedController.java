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

    // 프로바이더 데이터 map 생성
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

                    // provider_url내에 oembed.이 포함되어 있을 경우
                    // format=json을 하지 않는다.
                    oembedUrl = str + "?url=" + encode;

                } else if (str.contains("_oembed")) {
                    // instagram은 구현 불가
                    // instagram은 엑세스 토큰이 필요하다
                    // String getFacebookIdPwd = "https://graph.facebook.com/oauth/access"
                    // + "_token?client_id=client_id&" +
                    // "client_secret=client_secret"
                    // + "&grant_type=client_credentials";
                    // RestTemplate restTemplate = new RestTemplate();
                    // ResponseEntity<String> response = restTemplate.getForEntity(getFacebookIdPwd,
                    // String.class);

                    // try {
                    // Object obj = jsonParser.parse(response.getBody());
                    // JSONObject jsonObject = (JSONObject) obj;

                    // String access_token = (String) jsonObject.get("access_token");
                    // String encode2 = URLEncoder.encode(access_token, StandardCharsets.UTF_8);
                    // oembedUrl = str + "?url=" + encode + "&access_token=" + encode2;

                    // } catch (ParseException e) {
                    // e.printStackTrace();
                    // }
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

            // httpclients를 생성해 데이터를 받아온다
            CloseableHttpClient hc = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet(oembedUrl);

            // httpGet Header에 content type을 지정해주고
            httpGet.addHeader("Content-Type", "application/json");

            // request 요청해서 Response 받는다
            CloseableHttpResponse httpResponse = hc.execute(httpGet);

            result = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");

            // Map을 사용하지 않고 그냥, 기본적으로 oembed에서 제공되는 response 값을 기준으로 정렬했다
            // JSONObject resultJson = (JSONObject) jsonParser.parse(result);

            // Map<String, String> map = new HashMap<>();

            // Set set = resultJson.entrySet();
            // Iterator iter = set.iterator();
            // while (iter.hasNext()) {
            // Entry<String, Object> entry = (Entry) iter.next();
            // String key = entry.getKey();
            // String value = (String) entry.getValue();

            // map.put(key, value);

            // }

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
        // providers.json 데이터 가져오기
        // parser : try catch 해줘야 함
        // 현재 방식 -------------------------------------------------
        // 사용자가 입력한 url의 호스트명을 확인해서 split으로 나누고,
        // split.length == 2는 첫번째 문자가 url에 포함되어 있는지 확인
        // split.length == 3은 두번째 문자를 url에 포함되어 있는지 확인
        // 입력한 url 문자에 아래와 같이 포함되는 문자는 url encoding 해준다
        // 해당되는 url + ?format=json&url= + encoding된 문자를 합쳐서 해주면 oembed 완성!

        // 다른 방식 -------------------------------------------------
        // schemes에 해당하는 url의 호스트를 가져와서 matches로 정규식을 사용해 확인 할 수 있다
        // 다만, 분석해본 결과 schemes가 없는 프로바이더들이 있어 사용하지 않았다.

        return "index";
    }

}
