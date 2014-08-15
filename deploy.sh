#!/bin/sh

APPNAME=ultra

mkdir -p $CATALINA_HOME/webapps/$APPNAME

cp -r src/main/webapp/* $CATALINA_HOME/webapps/$APPNAME/
cp -r target/classes $CATALINA_HOME/webapps/$APPNAME/WEB-INF/
cp -r lib $CATALINA_HOME/webapps/$CATALINA/WEB-INF/
