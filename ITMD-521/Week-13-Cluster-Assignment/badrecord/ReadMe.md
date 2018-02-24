# Steps to Run Code for Test 4 - 15 

## Test 7 using MaxTemperature.java	

1. Consider the MaxTemperature.java MaxTemperatureWithCombinerCounter.java MaxTemperatureWithCompression.java NcdcRecordParser.java in data folder of the box you want to run code on.

2.Run the commands : 

	cd /vagrant_data/
	cp MaxTemperature.java MaxTemperatureWithCombinerCounter.java MaxTemperatureWithCompression.java NcdcRecordParser.java ~

3.Now use the following commands :

	cd hadoop-book
	cd ch02-mr-intro
	cd src
	cd main
	cd java
	rm MaxTemperature.java
	cd ~ 

4.Connect to cluster if required.

5.Copy the files to folder using command from home :

	cp MaxTemperature.java MaxTemperatureWithCombinerCounter.java MaxTemperatureWithCompression.java NcdcRecordParser.java hadoop-book/ch02-mr-intro/src/main/java

6.Now use the following commands :

	cd hadoop-book
	cd ch02-mr-intro
	cd src
	cd main
	cd java

7.Run the following commands from java folder :
 
	hadoop com.sun.tools.javac.Main MaxTemperature*.java NcdcRecordParser.java

	jar cf mt.jar MaxTemperature*.class NcdcRecordParser.class

	hadoop jar mt.jar MaxTemperature /user/ncdc/80-90/80-90.txt /output/jrh/test7txt


	    
