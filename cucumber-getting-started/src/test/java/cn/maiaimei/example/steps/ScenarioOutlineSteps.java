package cn.maiaimei.example.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ScenarioOutlineSteps {

  @Given("there are {int} cucumbers")
  public void initCucumbers(Integer start) {
    log.info("there are {} cucumbers", start);
  }

  @When("I eat {int} cucumbers")
  public void eatCucumbers(Integer eat) {
    log.info("I eat {} cucumbers", eat);
  }

  @Then("I should have {int} cucumbers")
  public void leftCucumbers(Integer left) {
    log.info("I should have {} cucumbers", left);
  }

}
