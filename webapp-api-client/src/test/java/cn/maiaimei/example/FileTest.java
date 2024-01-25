package cn.maiaimei.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.ResourceUtils;

@Slf4j
@Disabled
public class FileTest {

  @Test
  public void testAbsolutePath() {
    // 绝对路径
    String pathname = "E:\\code\\test-framework\\webapp-api-client\\src\\main\\resources"
        + "\\20240124231450.png";
    final File file = new File(pathname);
    log.info("file is {}", file.exists() ? "exist" : "not exist");
    log.info("file absolute path is {}", file.getAbsolutePath());
    log.info("file path is {}", file.getPath());
    /*
     file is exist
     file absolute path is E:\code\test-framework\webapp-api-client\src\main\resources
     \20240124231450.png
     file path is E:\code\test-framework\webapp-api-client\src\main\resources\20240124231450.png
     */
  }

  @Test
  public void testRelativePath() {
    // 相对路径（相对工程的根目录）
    String pathname = "20240124231450.png";
    final File file = new File(pathname);
    log.info("file is {}", file.exists() ? "exist" : "not exist");
    log.info("file absolute path is {}", file.getAbsolutePath());
    log.info("file path is {}", file.getPath());
    /*
    file is not exist
    file absolute path is E:\code\test-framework\webapp-api-client\20240124231450.png
    file path is 20240124231450.png
     */
  }

  @Test
  public void testClassPathResource() {
    // ClassPathResource
    String pathname = "20240124231450.png";
    final ClassPathResource classPathResource = new ClassPathResource(pathname);
    try {
      final File file = classPathResource.getFile(); // 底层是调用org.springframework.util
      // .ResourceUtils.getFile(java.net.URL, java.lang.String)
      log.info("file is {}", file.exists() ? "exist" : "not exist");
      log.info("file absolute path is {}", file.getAbsolutePath());
      log.info("file path is {}", file.getPath());
      /*
       file is exist
       file absolute path is E:\code\test-framework\webapp-api-client\target\classes
       \20240124231450.png
       file path is E:\code\test-framework\webapp-api-client\target\classes\20240124231450.png
       */
    } catch (IOException e) {
      // java.io.FileNotFoundException: class path resource [test.csv] cannot be resolved to URL 
      // because it does not exist
      log.error(e.getMessage(), e);
    }
  }

  @Test
  public void testResourceUtilsGetFile() {
    List<String> pathnames = new ArrayList<>();
    pathnames.add("20240124231450.png"); // file is not exist
    pathnames.add("classpath:20240124231450.png"); // file is exist
    for (String pathname : pathnames) {
      try {
        final File file = ResourceUtils.getFile(pathname);
        log.info("file is {}", file.exists() ? "exist" : "not exist");
        log.info("file absolute path is {}", file.getAbsolutePath());
        log.info("file path is {}", file.getPath());
      } catch (FileNotFoundException e) {
        log.error(e.getMessage(), e);
      }
    }
  }

  @Test
  public void testGetResourceByClassLoader() {
    String pathname = "20240124231450.png";
    final URL resource = this.getClass().getClassLoader().getResource(pathname);
    try {
      final File file = ResourceUtils.getFile(resource);
      log.info("file is {}", file.exists() ? "exist" : "not exist");
      log.info("file absolute path is {}", file.getAbsolutePath());
      log.info("file path is {}", file.getPath());
    } catch (FileNotFoundException e) {
      log.error(e.getMessage(), e);
    }
  }

}
