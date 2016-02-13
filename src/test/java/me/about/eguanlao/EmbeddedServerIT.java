package me.about.eguanlao;

import static org.junit.runners.Suite.SuiteClasses;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExternalResource;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

/**
 * Created by ericguanlao on 10/09/2015.
 */
@RunWith(Suite.class)
@SuiteClasses({ ProfileControllerTest.class, NewsFeedControllerTest.class })
public class EmbeddedServerIT {

  @BeforeClass
  public static void init() throws Exception {
    System.out.println("Running 'init' method...");
    EmbeddedServer.getInstance().start();
  }

  @AfterClass
  public static void shutdown() throws InterruptedException {
    System.out.println("Running 'shutdown' method...");
    EmbeddedServer.getInstance().stop();
  }

}
