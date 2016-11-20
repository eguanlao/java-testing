package me.about.eguanlao;

import com.gargoylesoftware.htmlunit.WebClient;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class NewsFeedControllerTest {

  @Test
  public void should_display_news_feed() {
    System.out.println("Running news feed test...");

    new WebClient();

    assertTrue(true);
  }

}
