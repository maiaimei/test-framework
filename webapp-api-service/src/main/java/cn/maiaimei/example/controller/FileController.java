package cn.maiaimei.example.controller;

import cn.maiaimei.example.model.FileInfo;
import java.util.List;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
public class FileController {

  @PostMapping("/file/upload")
  public String fileUpload(MultipartFile file) {
    log.info("文件名称：{}，大小：{}字节，类型：{}",
        file.getOriginalFilename(),
        file.getSize(),
        file.getContentType()
    );
    return "上传成功-" + UUID.randomUUID();
  }

  @PostMapping("/files/upload")
  public String filesUpload(MultipartFile[] files) {
    for (MultipartFile file : files) {
      log.info("文件名称：{}，大小：{}字节，类型：{}",
          file.getOriginalFilename(),
          file.getSize(),
          file.getContentType()
      );
    }
    return "上传成功-" + UUID.randomUUID();
  }

  @PostMapping("/files/save")
  public String filesSave(FileInfo fileInfo, MultipartFile file, List<MultipartFile> files) {
    log.info("文件信息：{}", fileInfo);
    log.info("文件名称：{}，大小：{}字节，类型：{}",
        file.getOriginalFilename(),
        file.getSize(),
        file.getContentType()
    );
    for (MultipartFile fi : files) {
      log.info("文件名称：{}，大小：{}字节，类型：{}",
          fi.getOriginalFilename(),
          fi.getSize(),
          fi.getContentType()
      );
    }
    return "上传成功-" + UUID.randomUUID();
  }

}
