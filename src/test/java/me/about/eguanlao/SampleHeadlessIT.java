package me.about.eguanlao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

public class SampleHeadlessIT {

  private WebDriver webDriver;
  private String baseUrl;
  private StringBuilder verificationErrors = new StringBuilder();
  protected static DesiredCapabilities desiredCapabilities;

  @Before
  public void setUp() throws Exception {

    desiredCapabilities = new DesiredCapabilities();
    desiredCapabilities.setJavascriptEnabled(true);
    desiredCapabilities.setCapability("takesScreenshot", false);
    desiredCapabilities.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, System.getProperty("phantomjs.binary"));

    webDriver = new PhantomJSDriver(desiredCapabilities);
    baseUrl = "http://localhost:" + System.getProperty("http.port");
    System.out.println("********************");
    System.out.println("********************");
    System.out.println("********************");
    System.out.println("********************");
    System.out.println("********************");
    System.out.println("********************");
    System.out.println("baseUrl: " + baseUrl);
    System.out.println("********************");
    System.out.println("********************");
    System.out.println("********************");
    System.out.println("********************");
    webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @After
  public void tearDown() throws Exception {
    webDriver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  @Test
  public void should_find_the_h1_tags() throws Exception {
    webDriver.get(baseUrl + "/index.html");

    List<WebElement> h1Tags = webDriver.findElements(By.tagName("h1"));

    assertThat(h1Tags.size(), is(1));
  }

}
