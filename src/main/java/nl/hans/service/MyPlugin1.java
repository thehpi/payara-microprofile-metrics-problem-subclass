package nl.hans.service;

import org.eclipse.microprofile.metrics.MetricUnits;
import org.eclipse.microprofile.metrics.annotation.SimplyTimed;

public class MyPlugin1 extends BasePlugin {
  public String getName() {
    return "my-plugin-1";
  }

  @SimplyTimed(unit = MetricUnits.MILLISECONDS)
  public String run() {
    myBean.run();
    return "This is plugin One";
  }
}
