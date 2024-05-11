package cn.maiaimei.example.controller;

import cn.maiaimei.example.model.dto.BaseQueryParam;
import cn.maiaimei.example.model.dto.BaseQueryResult;
import cn.maiaimei.example.model.dto.UserInfo;
import cn.maiaimei.example.model.dto.UserQueryParam;
import cn.maiaimei.example.service.impl.UserServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.function.Consumer;
import java.util.function.Supplier;
import lombok.extern.slf4j.Slf4j;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@Slf4j
@WebMvcTest(controllers = UserController.class)
@ExtendWith(SpringExtension.class)
public class UserControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private UserServiceImpl userServiceImpl;

  @Test
  public void testGetUserInfo() throws Exception {
    UserInfo expectedUserInfo = new UserInfo();
    expectedUserInfo.setUsername("Amy");
    expectedUserInfo.setNickname("初冬十月");
    Mockito.when(userServiceImpl.getUserInfo(ArgumentMatchers.anyString()))
        .thenReturn(expectedUserInfo);
    final MvcResult mvcResult = mockMvc.perform(
            MockMvcRequestBuilders.request(HttpMethod.GET, "/user/info")
                .queryParam("username", "Amy"))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(
            MockMvcResultMatchers.jsonPath("$.nickname", Matchers.containsString("初冬十月"))
        )
        .andDo(MockMvcResultHandlers.print())
        .andReturn();
    log.info("{}", mvcResult.getResponse().getContentAsString());
  }

  @Test
  public void testListUsers() throws Exception {
    ObjectMapper objectMapper = new ObjectMapper();
    Mockito.doNothing().when(userServiceImpl).pageList(ArgumentMatchers.any(BaseQueryResult.class),
        ArgumentMatchers.any(BaseQueryParam.class), ArgumentMatchers.any(LambdaQueryWrapper.class),
        ArgumentMatchers.any(Supplier.class), ArgumentMatchers.any(Consumer.class));
    UserQueryParam userQueryParam = new UserQueryParam();
    userQueryParam.setUsername("Amy");
    mockMvc.perform(MockMvcRequestBuilders.request(HttpMethod.POST, "/user/list")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(userQueryParam)))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(
            MockMvcResultMatchers.jsonPath("$.total", Matchers.equalTo(0))
        )
        .andDo(MockMvcResultHandlers.print());
  }

}
