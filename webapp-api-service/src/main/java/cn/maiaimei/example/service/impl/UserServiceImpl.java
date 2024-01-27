package cn.maiaimei.example.service.impl;

import cn.maiaimei.example.mapper.UserMapper;
import cn.maiaimei.example.model.dto.UserInfo;
import cn.maiaimei.example.model.po.AuthorityPO;
import cn.maiaimei.example.model.po.RoleAuthorityPO;
import cn.maiaimei.example.model.po.RolePO;
import cn.maiaimei.example.model.po.RoleUserPO;
import cn.maiaimei.example.model.po.UserPO;
import cn.maiaimei.example.service.BaseServiceImpl;
import cn.maiaimei.example.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends BaseServiceImpl<UserMapper, UserPO> implements UserService {

  @Autowired
  private RoleServiceImpl roleServiceImpl;

  @Autowired
  private AuthorityServiceImpl authorityServiceImpl;

  @Autowired
  private RoleUserServiceImpl roleUserServiceImpl;

  @Autowired
  private RoleAuthorityServiceImpl roleAuthorityServiceImpl;

  @Override
  public UserInfo getUserInfo(String username) {
    UserInfo userInfo = null;
    LambdaQueryWrapper<UserPO> userQueryWrapper = new LambdaQueryWrapper<>();
    userQueryWrapper.eq(UserPO::getUsername, username);
    UserPO userPO = getOne(userQueryWrapper);
    if (Objects.nonNull(userPO)) {
      userInfo = new UserInfo();
      userInfo.setId(userPO.getId());
      userInfo.setNickname(userPO.getNickname());
      userInfo.setUsername(userPO.getUsername());
      userInfo.setEnabled(userPO.getEnabled());

      LambdaQueryWrapper<RoleUserPO> roleUserQueryWrapper = new LambdaQueryWrapper<>();
      roleUserQueryWrapper.eq(RoleUserPO::getUserId, userPO.getId());
      roleUserQueryWrapper.select(RoleUserPO::getRoleId);
      List<Long> roleIds = roleUserServiceImpl.listObjs(roleUserQueryWrapper);

      LambdaQueryWrapper<RolePO> roleQueryWrapper = new LambdaQueryWrapper<>();
      roleQueryWrapper.in(RolePO::getId, roleIds);
      roleQueryWrapper.select(RolePO::getCode);
      List<String> roles = roleServiceImpl.listObjs(roleQueryWrapper);
      userInfo.setRoles(roles);

      LambdaQueryWrapper<RoleAuthorityPO> roleAuthorityQueryWrapper = new LambdaQueryWrapper<>();
      roleAuthorityQueryWrapper.in(RoleAuthorityPO::getRoleId, roleIds);
      roleAuthorityQueryWrapper.select(RoleAuthorityPO::getAuthorityId);
      List<Long> authorityIds = roleAuthorityServiceImpl.listObjs(roleAuthorityQueryWrapper);

      LambdaQueryWrapper<AuthorityPO> authorityQueryWrapper = new LambdaQueryWrapper<>();
      authorityQueryWrapper.in(AuthorityPO::getId, authorityIds);
      authorityQueryWrapper.select(AuthorityPO::getCode);
      List<String> authorities = authorityServiceImpl.listObjs(authorityQueryWrapper);
      userInfo.setAuthorities(authorities);
    }
    return userInfo;
  }
}
