package cn.maiaimei.example.controller;

import cn.maiaimei.example.model.FileInfo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;
import java.util.Map.Entry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
public class FileController {

  @Value("${api-service-base-url}")
  private String baseUrl;

  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private ObjectMapper objectMapper;

  @PostMapping("/file/upload")
  public String fileUpload(MultipartFile file) {
    String url = baseUrl + "/file/upload";
    MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
    body.add("file", file.getResource());
    final HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.MULTIPART_FORM_DATA);
    HttpEntity<?> requestEntity = new HttpEntity<>(body, headers);
    final ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST,
        requestEntity, String.class);
    final String responseEntityBody = responseEntity.getBody();
    log.info("{}", responseEntityBody);
    return responseEntityBody;
  }

  @PostMapping("/files/upload")
  public String filesUpload(MultipartFile[] files) {
    String url = baseUrl + "/files/upload";
    MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
    for (MultipartFile file : files) {
      body.add("files", file.getResource());
    }
    final HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.MULTIPART_FORM_DATA);
    HttpEntity<?> requestEntity = new HttpEntity<>(body, headers);
    final ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST,
        requestEntity, String.class);
    final String responseEntityBody = responseEntity.getBody();
    log.info("{}", responseEntityBody);
    return responseEntityBody;
  }

  @PostMapping("/files/save")
  public String filesSave(FileInfo fileInfo, MultipartFile file) throws JsonProcessingException {
    String url = baseUrl + "/files/save";

    final String fileInfoAsString = objectMapper.writeValueAsString(fileInfo);
    final Map<String, Object> fileInfoAsMap = objectMapper.readValue(fileInfoAsString, Map.class);

    MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
    for (Entry<String, Object> entry : fileInfoAsMap.entrySet()) {
      body.add(entry.getKey(), entry.getValue());
    }
    // 获取客户端上传文件
    body.add("file", file.getResource());
    // 获取文件系统的文件
    body.add("files", new FileSystemResource("C:\\Users\\lenovo\\Desktop\\工作计划跟踪表.xlsx"));
    // 获取类路径下的文件
    body.add("files", new ClassPathResource("20240124231450.png"));

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
}
