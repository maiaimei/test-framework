package cn.maiaimei.example.controller;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

  @PostMapping("/v1/files/upload")
  public String filesUpload(MultipartFile[] files) {
    String url = baseUrl + "/v1/files/upload";
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

  @PostMapping("/v2/files/upload")
  public String filesUpload(List<MultipartFile> files) {
    String url = baseUrl + "/v2/files/upload";
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
}
