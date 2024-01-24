package cn.maiaimei.example.controller;

import cn.maiaimei.example.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;
import java.util.Map.Entry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

  @Value("${api-service-base-url}")
  private String baseUrl;

  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private ObjectMapper objectMapper;

  @PostMapping
  public String create(User user, MultipartFile file) throws JsonProcessingException {
    String url = baseUrl + "/user";

    final String userAsString = objectMapper.writeValueAsString(user);
    final Map<String, Object> userAsMap = objectMapper.readValue(userAsString, Map.class);

    MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
    for (Entry<String, Object> entry : userAsMap.entrySet()) {
      body.add(entry.getKey(), entry.getValue());
    }
    body.add("file", file.getResource());

    final HttpHeaders headers = new HttpHeaders();
    // 指定传输数据为二进制类型，比如图片、文件、MP3等。没有此配置也能发送请求且响应成功。这是可选配置？？？
    headers.setContentType(MediaType.MULTIPART_FORM_DATA);

    HttpEntity<?> requestEntity = new HttpEntity<>(body, headers);
    final ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST,
        requestEntity, String.class);
    final String responseEntityBody = responseEntity.getBody();
    log.info("{}", responseEntityBody);
    return responseEntityBody;
  }

  @PostMapping("/create")
  public String createUser(User user) throws JsonProcessingException {
    String url = baseUrl + "/user";

    final String userAsString = objectMapper.writeValueAsString(user);
    final Map<String, Object> userAsMap = objectMapper.readValue(userAsString, Map.class);

    MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
    for (Entry<String, Object> entry : userAsMap.entrySet()) {
      body.add(entry.getKey(), entry.getValue());
    }
    //body.add("file", new FileSystemResource("C:\\Users\\lenovo\\Desktop\\工作计划跟踪表.xlsx"));
    body.add("file", new ClassPathResource("20240124231450.png"));

    final HttpHeaders headers = new HttpHeaders();
    // 指定传输数据为二进制类型，比如图片、文件、MP3等。没有此配置也能发送请求且响应成功。这是可选配置？？？
    //headers.setContentType(MediaType.MULTIPART_FORM_DATA);

    HttpEntity<?> requestEntity = new HttpEntity<>(body, headers);
    final ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST,
        requestEntity, String.class);
    final String responseEntityBody = responseEntity.getBody();
    log.info("{}", responseEntityBody);
    return responseEntityBody;
  }
}
