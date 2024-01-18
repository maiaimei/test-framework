package cn.maiaimei.example.steps.arguments;

import io.cucumber.java.en.Given;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DocStringsSteps {

  @Given("a blog post named {string} with Markdown body")
  public void a_blog_post_named_with_markdown_body(String title, String content) {
    log.info("a blog post named {} with Markdown body {}", title, content);
  }
}
