import org.junit.*;
import java.util.ArrayList;
import static org.junit.Assert.*;
import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import static org.assertj.core.api.Assertions.assertThat;
import static org.fluentlenium.core.filter.FilterConstructor.*;


public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();
  public WebDriver getDefaultDriver() {
      return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
  public void rootTest() {
      goTo("http://localhost:4567/");
      assertThat(pageSource()).contains("Add a new task:");
  }

  @Test
  public void taskIsCreated() {
    goTo("http://localhost:4567/");
    fill("#description").with("Do the homework");
    submit(".btn");
    assertThat(pageSource()).contains("Your task has been saved.");
  }

  @Test
  public void taskIsDisplayedTest() {
    goTo("http://localhost:4567");
    fill("#description").with("Do the exercise");
    submit(".btn");
    click("a");
    assertThat(pageSource()).contains("Do the exercise");
  }

  @Test
  public void multipleTasksAreDisplayedTest() {
    goTo("http://localhost:4567");
    fill("#description").with("Do the exercise");
    submit(".btn");
    click("a");
    fill("#description").with("Do the dishes");
    submit(".btn");
    click("a");
    assertThat(pageSource()).contains("Do the exercise");
    assertThat(pageSource()).contains("Do the dishes");
  }
}
