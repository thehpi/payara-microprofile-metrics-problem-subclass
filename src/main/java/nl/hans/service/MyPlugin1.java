package nl.hans.service;

import org.eclipse.microprofile.metrics.MetricUnits;
import org.eclipse.microprofile.metrics.annotation.SimplyTimed;

import javax.inject.Inject;

public class MyPlugin1 implements Plugin{

  @Inject
  MyBean myBean;
  public String getName() {
    return "my-plugin-1";
  }


  @SimplyTimed(unit = MetricUnits.MILLISECONDS)
  public String execute() {
    myBean.run();
    return "This is plugin One";
  }
}
