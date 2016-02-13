package me.about.eguanlao;

import org.openqa.jetty.jetty.Server;

public class EmbeddedServer {

  private static volatile Server server;

  public static Server getInstance() {
    if (server == null) {
      System.out.println("Instantiating embedded server...");
      synchronized (EmbeddedServer.class) {
        server = new Server();
      }
    }
    System.out.println("Returning embedded server instance...");
    return server;
  }

}
