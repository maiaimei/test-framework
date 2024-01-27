package cn.maiaimei.example.mapper;

import cn.hutool.core.util.IdUtil;
import cn.maiaimei.example.model.po.UserPO;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import java.time.LocalDateTime;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.security.crypto.password.PasswordEncoder;

@Slf4j
@Disabled
@TestMethodOrder(OrderAnnotation.class)
@SpringBootTest(webEnvironment = WebEnvironment.NONE)
public class UserMapperTest {

  @Autowired
  private UserMapper userMapper;

  @Autowired
  private PasswordEncoder passwordEncoder;

  private static Long id;

  @BeforeAll
  public static void setupAll() {
    id = IdUtil.getSnowflakeNextId();
  }

  @Test
  @Order(1)
  public void insertUser() {
    UserPO user = new UserPO();
    user.setId(id);
    user.setNickname(IdUtil.nanoId(5));
    user.setUsername(IdUtil.nanoId(5));
    user.setPassword(passwordEncoder.encode("12345"));
    user.setDeleted(Boolean.FALSE);
    user.setEnabled(Boolean.TRUE);
    user.setVersion(LocalDateTime.now());
    Assertions.assertEquals(1, userMapper.insert(user));
  }

  @Test
  @Order(2)
  public void listUsers() {
    LambdaQueryWrapper<UserPO> wrapper = new LambdaQueryWrapper<>();
    final List<UserPO> users = userMapper.selectList(wrapper);
    Assertions.assertTrue(users.stream().anyMatch(user -> id.equals(user.getId())));
  }

  @Test
  @Order(3)
  public void updateUser() {
    // UPDATE sys_user SET nickname=? WHERE is_deleted=0 AND (id = ?)
    LambdaUpdateWrapper<UserPO> updateWrapper = new LambdaUpdateWrapper<>();
    updateWrapper.eq(UserPO::getId, id);
    updateWrapper.set(UserPO::getNickname, IdUtil.nanoId(5));
    Assertions.assertEquals(1, userMapper.update(updateWrapper)); // 这里无法应用自动填充功能

    // UPDATE sys_user SET nickname=?, gmt_modified=?, gmt_modified_user_id=? WHERE is_deleted=0 
    // AND (id = ?)
    LambdaQueryWrapper<UserPO> queryWrapper = new LambdaQueryWrapper<>();
    queryWrapper.eq(Boolean.TRUE, UserPO::getId, id);
    queryWrapper.select(UserPO::getVersion);
    UserPO user = userMapper.selectOne(queryWrapper);
    user.setNickname(IdUtil.nanoId(5));
    updateWrapper = new LambdaUpdateWrapper<>();
    updateWrapper.eq(UserPO::getId, id);
    Assertions.assertEquals(1, userMapper.update(user, updateWrapper));

    // UPDATE sys_user SET nickname=?, gmt_modified=?, gmt_modified_user_id=? WHERE id=? AND 
    // is_deleted=0
    user = new UserPO();
    user.setId(id);
    user.setNickname(IdUtil.nanoId(5));
    Assertions.assertEquals(1, userMapper.updateById(user));

    // com.baomidou.mybatisplus.core.exceptions.MybatisPlusException: Prohibition of table update
    // operation
    // updateWrapper = new LambdaUpdateWrapper<>();
    // updateWrapper.set(UserPO::getNickname, IdUtil.nanoId(5));
    // userMapper.update(updateWrapper);
  }

  @Test
  @Order(4)
  public void getUser() {
    final UserPO user = userMapper.selectById(id);
    Assertions.assertNotNull(user);
  }

  @Test
  @Order(5)
  public void deleteUser() {
    // UPDATE sys_user SET is_deleted=1 WHERE id=? AND is_deleted=0
    // Assertions.assertEquals(1, userMapper.deleteById(id));

    // UPDATE sys_user SET gmt_modified=?,gmt_modified_user_id=?, is_deleted=1 WHERE id=? AND 
    // is_deleted=0
    UserPO user = new UserPO();
    user.setId(id);
    Assertions.assertEquals(1, userMapper.deleteById(user));

    // UPDATE sys_user SET is_deleted=1 WHERE is_deleted=0 AND (id = ?)
    // Map<String, Object> columnMap = new HashMap<>();
    // columnMap.put("id", id);
    // Assertions.assertEquals(1, userMapper.deleteByMap(columnMap));

    // UPDATE sys_user SET is_deleted=1 WHERE id IN ( ? ) AND is_deleted=0
    // Assertions.assertEquals(1, userMapper.deleteBatchIds(Collections.singletonList(id)));

    // UPDATE sys_user SET is_deleted=1 WHERE is_deleted=0 AND (id = ?)
    // LambdaQueryWrapper<UserPO> wrapper = new LambdaQueryWrapper<>();
    // wrapper.eq(UserPO::getId, id);
    // Assertions.assertEquals(1, userMapper.delete(wrapper));
  }
}
