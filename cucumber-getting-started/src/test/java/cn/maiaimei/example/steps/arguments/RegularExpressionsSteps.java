//package cn.maiaimei.example.steps.arguments;
//
//import io.cucumber.java.en.Given;
//import lombok.extern.slf4j.Slf4j;
//
//@Slf4j
//public class RegularExpressionsSteps {
//
//  //@Given("here is regular expressions: type is integer, sample value is (\\d+)")
//  @Given("here is regular expressions: type is integer, sample value is ([0-9]+)")
//  public void test_int(Integer value) {
//    log.info("here is regular expressions: type is integer, sample value is {}", value);
//  }
//
//  @Given("here is regular expressions: type is float, sample value is (-?\\d+\\.\\d+)")
//  //@Given("here is regular expressions: type is float, sample value is (/-?[0-9]+\\.[0-9]+/)")
//  public void test_float(Float value) {
//    log.info("here is regular expressions: type is float, sample value is {}", value);
//  }
//
//  @Given("here is regular expressions: type is string, sample value is (\".*\")")
//  public void test_string(String value) {
//    log.info("here is regular expressions: type is string, sample value is {}", value);
//  }
//
//  @Given("here is regular expressions: type is word, sample value is (\\S+)")
//  public void test_word(String value) {
//    log.info("here is regular expressions: type is word, sample value is {}", value);
//  }
//
//  @Given("here is regular expressions: type is anonymous, sample value is (.*)")
//  public void test_anonymous(String value) {
//    log.info("here is regular expressions: type is anonymous, sample value is {}", value);
//  }
//
//}
