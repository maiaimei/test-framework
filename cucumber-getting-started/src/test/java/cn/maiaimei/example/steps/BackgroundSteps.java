package cn.maiaimei.example.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BackgroundSteps {

  @Given("a global administrator named {string}")
  public void a_global_administrator_named(String name) {
    log.info("a global administrator named {}", name);
  }

  @Given("a blog named {string}")
  public void a_blog_named(String name) {
    log.info("a blog named {}", name);
  }

  @Given("a customer named {string}")
  public void a_customer_named(String name) {
    log.info("a customer named {}", name);
  }

  @Given("a blog named {string} owned by {string}")
  public void a_blog_named_owned_by(String blogName, String ownerName) {
    log.info("a blog named {} owned by {}", blogName, ownerName);
  }

  @Given("I am logged in as {string}")
  public void i_am_logged_in_as(String name) {
    log.info("I am logged in as {}", name);
  }

  @When("I try to post to {string}")
  public void i_try_to_post_to(String title) {
    log.info("I try to post to {}", title);
  }

  @Then("I should see {string}")
  public void i_should_see(String message) {
    log.info("I should see {}", message);
  }
}
