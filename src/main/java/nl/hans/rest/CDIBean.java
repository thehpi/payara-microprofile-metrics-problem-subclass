package nl.hans.rest;

import nl.hans.service.Plugin;

import javax.enterprise.inject.Instance;
import javax.inject.Inject;

public class CDIBean {
  @Inject Instance<Plugin> plugins;

  public String runPlugins() {
    StringBuilder builder = new StringBuilder();
    for (Plugin plugin : plugins) {
      builder
              .append(plugin.getName())
              .append(": ")
              .append(plugin.execute())
              .append("\n");
    }

    return builder.toString();
  }
}
