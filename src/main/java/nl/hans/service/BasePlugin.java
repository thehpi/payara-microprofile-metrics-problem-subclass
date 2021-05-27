package nl.hans.service;

import javax.inject.Inject;

public abstract class BasePlugin implements Plugin {
  @Inject
  MyBean myBean;

  public String execute() {
    return run();
  }

  protected abstract String run();
}
