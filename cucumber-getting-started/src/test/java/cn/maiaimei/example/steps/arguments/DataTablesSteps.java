package cn.maiaimei.example.steps.arguments;

import io.cucumber.java.en.Given;
import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;

/**
 * https://github.com/cucumber/cucumber-jvm/tree/main/datatable
 */
@Slf4j
public class DataTablesSteps {

  //@Given("the following users exist:")
  public void test1(List<Map<String, String>> dataTable) {
    for (Map<String, String> data : dataTable) {
      String name = data.get("name");
      String email = data.get("email");
      String twitter = data.get("twitter");
      log.info("execute test1(), fields:[ name = {}, email = {}, twitter = {}]",
          name, email, twitter);
    }
  }

  //@Given("the following users exist:")
  public void test2(List<List<String>> dataTable) {
    for (List<String> data : dataTable) {
      log.info("execute test2(), fields:[ data = {} ]", data);
    }
  }

  @Given("the following users exist:")
  public void test3(Map<String, List<String>> dataTable) {
    for (Map.Entry<String, List<String>> data : dataTable.entrySet()) {
      String name = data.getKey();
      List<String> infos = data.getValue();
      log.info("execute test3(), fields:[ name = {}, infos = {} ]", name, infos);
    }
  }

}
