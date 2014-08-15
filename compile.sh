#!/bin/sh
echo "Compile"
javac -d target/classes -classpath lib/servlet-api.jar src/main/java/com/bodejidi/*.java

javac -d target/test-classes -classpath target/classes:target/test-classes:lib-test/reflections-0.9.9-RC2.jar:lib/servlet-api.jar src/test/java/com/bodejidi/*.java src/test/java/com/bodejidi/unit/TestCase.java
echo "Compile done."
