package cn.maiaimei.example.steps.arguments;

import io.cucumber.java.Transpose;
import io.cucumber.java.en.Given;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ListSteps {

  @Given("The following are accounts displayed in a vertical list")
  public void test_vertical_list(List<String> usernames) {
    log.info("execute test_vertical_list(), fields:[ usernames = {} ]", usernames);
  }

  /**
   * {@link Transpose}，告诉 Cucumber 需要进行数据转换
   */
  @Given("The following are accounts displayed in a horizontal list")
  public void test_horizontal_list(@Transpose List<String> usernames) {
    log.info("execute test_horizontal_list(), fields:[ usernames = {} ]", usernames);
  }
}
