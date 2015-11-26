# !/usr/bash

javac -cp *.jar:. TestingLabConverterServletTest.java CityTemperatureServiceProvider.java
java -cp mockobjects-0.6-core.jar:mockobjects-0.6-j1.4-j2ee1.2.jar:selenium-server-standalone-2.11.0.jar:junit-4.11.jar.org.junit.runner.JUnitCore TestingLabConverterServletTest
