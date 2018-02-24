# Steps:

1.) Consider the files in data folder of the box you want to run code on.

2.) Do Vagrant up

3.) Do vagrant ssh

4.) Download webhitsMapper.java webhitsReducer.java and MaxTemperatureWithCombiner.java and Copy the java files to home :

	cd /vagrant_data/
	cp webMapper.java webReducer.java MaxTemperatureWithCombiner.java ~

5.) Clear all existing java files if any.

6.) Connect to cluster if required.

7.) Now use the following commands :

	cd hadoop-book
	cd ch02-mr-intro
	cd src
	cd main
	cd java
	rm MaxTemperatureWithCombiner.java
  	cd ~

8.) Copy the files to folder using command from home :

	cp webhitsMapper.java webhitsReducer.java MaxTemperatureWithCombiner.java hadoop-book/ch02-mr-intro/src/main/java

9.) Now use the following commands :

	cd hadoop-book
	cd ch02-mr-intro
	cd src
	cd main
	cd java

10.) Run the following commands :

	hadoop com.sun.tools.javac.Main *.java
	jar cf file.jar *.class
	hadoop jar file.jar MaxTemperatureWithCombiner /user/large-log/web-server-logs.txt /output/sss/test16txt/reducer2

11.) This Program was run on local with MaxTemperature as driver class and the output is:

![o](https://user-images.githubusercontent.com/31320698/33766416-f3fd1bf0-dbe2-11e7-9fb7-ed920c085c62.PNG)


	    

