package cn.maiaimei.example.steps.arguments;

import io.cucumber.java.en.Given;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CucumberExpressionsSteps {

  @Given("here is cucumber expressions: type is integer, sample value is {int}")
  public void test_int(Integer value) {
    log.info("here is cucumber expressions: type is integer, sample value is {}", value);
  }

  @Given("here is cucumber expressions: type is float, sample value is {float}")
  public void test_float(Float value) {
    log.info("here is cucumber expressions: type is float, sample value is {}", value);
  }

  @Given("here is cucumber expressions: type is string, sample value is {string}")
  public void test_string(String value) {
    log.info("here is cucumber expressions: type is string, sample value is {}", value);
  }

  @Given("here is cucumber expressions: type is word, sample value is {word}")
  public void test_word(String value) {
    log.info("here is cucumber expressions: type is word, sample value is {}", value);
  }

  @Given("here is cucumber expressions: type is anonymous, sample value is {}")
  public void test_anonymous(String value) {
    log.info("here is cucumber expressions: type is anonymous, sample value is {}", value);
  }

}
