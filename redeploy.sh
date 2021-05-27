#!/bin/bash

unset restart
if [ "$1" = "-r" ]
then
	restart=1
	shift
fi

nr=${1:-2}

echo "AS_ADMIN_PASSWORD=admin" > /tmp/pwd

asadmin --user=admin --passwordfile=/tmp/pwd --port=${nr}4848 undeploy test-rest
[ -n "${restart}" ] && (cd .. ; docker-compose restart payara ; sleep 10)
asadmin --user=admin --passwordfile=/tmp/pwd --port=${nr}4848 deploy --upload=true target/test-rest.war

