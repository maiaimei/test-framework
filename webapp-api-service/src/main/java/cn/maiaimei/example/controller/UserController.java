package cn.maiaimei.example.controller;

import cn.maiaimei.example.model.User;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

  @PostMapping
  public String create(User user, MultipartFile file) {
    log.info("用户信息：{}", user);
    log.info("文件名称：{}，大小：{}字节，类型：{}",
        file.getOriginalFilename(),
        file.getSize(),
        file.getContentType()
    );
    return "创建成功-" + UUID.randomUUID();
  }
}
