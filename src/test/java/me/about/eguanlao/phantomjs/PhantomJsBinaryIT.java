package me.about.eguanlao.phantomjs;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class PhantomJsBinaryIT {

  @Test
  public void should_find_the_PhantomJS_binary() {
    String binary = System.getProperty("phantomjs.binary");
    assertNotNull(binary);
    assertTrue(new File(binary).exists());
  }
}
