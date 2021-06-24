package nl.hans.service;

import org.eclipse.microprofile.metrics.MetricUnits;
import org.eclipse.microprofile.metrics.annotation.SimplyTimed;

import javax.inject.Inject;

public class MySimplePlugin implements Plugin {
  @Inject
  MyBean myBean;

  public String getName() {
    return "MySimplePlugin";
  }

  @SimplyTimed(unit = MetricUnits.MILLISECONDS)
  public String execute() {
    myBean.run();
    return "This is my simple plugin";
  }
}
