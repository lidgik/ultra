#!/bin/sh

echo "Run test"

CLASSPATH=lib-test/reflections-0.9.9-RC2.jar:target/classes:target/test-classes
CLASSPATH=$CLASSPATH:lib-test/guava-15.0.jar
CLASSPATH=$CLASSPATH:lib-test/javassist-3.18.2-GA.jar
CLASSPATH=$CLASSPATH:lib/servlet-api.jar

java -classpath $CLASSPATH com.bodejidi.unit.TestCase com.bodejidi

echo "Test Done."
