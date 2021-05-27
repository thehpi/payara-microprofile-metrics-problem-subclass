# Payara Microprofile Metrics Problem Subclass 

This repo was created as a reproducer for this ticket

[https://github.com/payara/Payara/issues/5095](https://github.com/payara/Payara/issues/5095)
 
# Description
--------------------

I created two plugins (MyPlugin1 and MyPlugin2) which I inject using 

    @Inject Instance<Plugin> plugins;

Both plugins are extending BasePlugin which has the main 'execute' method which calls the method
'run' which are implemented in the plugin subclasses. These 'run' methods have the @SimplyTimed 
annotation.

The is that the metrics are not collected for the 'run' methods.

If the plugin does not use a subclass (MySimplePlugin) and the 'execute' method has the @SimplyTimed
annotation then it works ok.

Also when another bean in injected and called in the plugin subclasses (MyBean) then the metrics
are collected fine in that bean.

## Expected Outcome

I would expect the @SimplyTimed annotation to work on any CDI managed bean/method.

## Current Outcome

The metrics output does show lines indicating the annotation was found but the actual metric
values are not increased. So it looks like the registration is done, but the interceptor responsible
for increasing the values is not executed.

## Steps to reproduce (Only for bug reports) 

- install java
- install docker
- install docker-compose
- install maven

Build

    ./build.sh

Start payara

    docker-compose up -d

Confirm the error

    ./test.sh

    my-plugin-1: This is plugin One
    my-plugin-1: This is plugin One
    my-plugin-2: This is plugin Two
    application_nl_hans_service_MyBean_run_total{_app="test-rest"} 3
    application_nl_hans_service_MyPlugin1_run_total{_app="test-rest"} 0
    application_nl_hans_service_MyPlugin2_run_total{_app="test-rest"} 0
    application_nl_hans_service_MySimplePlugin_execute_total{_app="test-rest"} 1

Again

    ./test.sh

    my-plugin-1: This is plugin One
    my-plugin-1: This is plugin One
    my-plugin-2: This is plugin Two
    application_nl_hans_service_MyBean_run_total{_app="test-rest"} 6
    application_nl_hans_service_MyPlugin1_run_total{_app="test-rest"} 0
    application_nl_hans_service_MyPlugin2_run_total{_app="test-rest"} 0
    application_nl_hans_service_MySimplePlugin_execute_total{_app="test-rest"} 2

As you can see MyBean is called in all three plugins. MySimplePlugin is called once and metrics work ok.
Buth the other two plugins which are subclasses, it doesn't work.

## Environment ##

- **Payara Version**: 5.2021.3
- **Edition**: Payara Full
- **JDK Version**: 1.8.0_275 OpenJDK
- **Operating System**: Mac
- **Database**: n/a
