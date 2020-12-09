#!/usr/bin/env bash
# Environment Variables
# HUB_HOST
# BROWSER
# MODULE

HUB_HOST="selenium-hub"
BROWSER="firefox"
MODULE="testNG_Sanity_lco.xml"

echo "Checking if hub is ready - $HUB_HOST"

while [ "$( curl -s http://$HUB_HOST:4444/wd/hub/status | jq -r .value.ready )" != "true" ]
do
	sleep 1
done

pwd

# start the java command
java -cp "libs/*" org.testng.TestNG testNG_Sanity_lco.xml

#java -cp libs/* \
#    -DHUB_HOST=$HUB_HOST \
#    -DBROWSER=$BROWSER \
#    org.testng.TestNG $MODULE
    