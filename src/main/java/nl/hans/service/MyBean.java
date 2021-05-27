package nl.hans.service;

import org.eclipse.microprofile.metrics.MetricUnits;
import org.eclipse.microprofile.metrics.annotation.SimplyTimed;

import javax.ejb.Stateless;

@Stateless
public class MyBean {
    @SimplyTimed(unit = MetricUnits.MILLISECONDS)
    public String run() {
        return "This is MyBean";
    }
}
