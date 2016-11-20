package me.about.eguanlao;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import static org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ProfileControllerTest.class, NewsFeedControllerTest.class})
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
