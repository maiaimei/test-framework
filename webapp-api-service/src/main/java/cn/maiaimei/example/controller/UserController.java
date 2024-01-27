package cn.maiaimei.example.controller;

import cn.maiaimei.example.model.dto.UserDTO;
import cn.maiaimei.example.model.dto.UserInfo;
import cn.maiaimei.example.model.dto.UserQueryParam;
import cn.maiaimei.example.model.dto.UserQueryResult;
import cn.maiaimei.example.model.po.UserPO;
import cn.maiaimei.example.service.impl.UserServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

  @Autowired
  private UserServiceImpl userServiceImpl;

  @GetMapping("/info")
  public UserInfo getUserInfo(@RequestParam String username) {
    return userServiceImpl.getUserInfo(username);
  }

  @PostMapping("/list")
  public UserQueryResult listUsers(@RequestBody UserQueryParam userQueryParam) {
    LambdaQueryWrapper<UserPO> wrapper = new LambdaQueryWrapper<>();
    wrapper.eq(StringUtils.hasText(userQueryParam.getNickname()), UserPO::getNickname,
        userQueryParam.getNickname());
    wrapper.eq(StringUtils.hasText(userQueryParam.getUsername()), UserPO::getUsername,
        userQueryParam.getUsername());
    UserQueryResult result = new UserQueryResult();
    userServiceImpl.pageList(result, userQueryParam, wrapper,
        UserDTO::new,
        userDTO -> userDTO.setPassword(null));
    return result;
  }
}
