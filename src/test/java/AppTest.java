import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import static org.fluentlenium.core.filter.FilterConstructor.*;
import static org.assertj.core.api.Assertions.assertThat;

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
      assertThat(pageSource()).contains("Your Dictionary");
  }

  @Test
  public void addWord(){
    goTo("http://localhost:4567/");
    fill("#title").with("Frog");
    submit(".btn");
    assertThat(pageSource()).contains("Frog");
  }

  @Test
  public void addMultipleWords(){
    goTo("http://localhost:4567/");
    fill("#title").with("Frog");
    submit(".btn");
    fill("#title").with("Donkey");
    submit(".btn");
    assertThat(pageSource()).contains("Frog");
    assertThat(pageSource()).contains("Donkey");
  }

  @Test
  public void selectIndividualWordPage(){
    goTo("http://localhost:4567/");
    fill("#title").with("Frog");
    submit(".btn");
    goTo("http://localhost:4567/words/1");
    assertThat(pageSource()).contains("Frog");
  }

  @Test
  public void addMeaningsToAWord(){
    goTo("http://localhost:4567/");
    fill("#title").with("Frog");
    submit(".btn");
    goTo("http://localhost:4567/words/1");
    fill("#meaning").with("Jumping Animal");
    assertThat(pageSource()).contains("Jumping Animal");
  }
}
