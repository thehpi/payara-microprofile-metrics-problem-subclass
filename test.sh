#!/bin/bash

# do rest call
curl -s localhost:28080/test-rest/rest/cdi

# get metrics
curl -s localhost:28080/metrics/|grep "^application.*_total{"
