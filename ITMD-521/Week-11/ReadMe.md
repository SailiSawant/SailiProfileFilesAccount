# Deliverables -

## Part 1:

## 1.) Create database "usehadoopguide" using table "widgets" by first creating "create.sql script" as shown below:

![week11 3](https://user-images.githubusercontent.com/31320698/32399904-16543f3e-c0c8-11e7-91b4-4cdfc754be68.PNG)

## a.) After using ls command to see whether your create.sql script is present, use command -

	chmod +x create.sql
	./create.sql

![week11 2](https://user-images.githubusercontent.com/31320698/32399489-5dceb604-c0c4-11e7-9328-e78c10790327.PNG)
 

## b.) Login to mysql, and check your databases is created, and describe your table to see the table.

![week11 1](https://user-images.githubusercontent.com/31320698/32399513-972acf00-c0c4-11e7-8134-94978946f460.PNG)

## Part 2:

## c.) Download, Copy and paste the step-2.py file in the data folder of itmd521. After you run this file, 5000 records will be inserted randomly in widgets table.

### Run the following command from home:

	cd /vagrant_data/

### Copy the step-2.py file to home directory using the command :

	cp step-2.py ~

### cd ~ to go to home

### We have the file in our home directory. Run the following command's from home :
        
	sudo apt-get install python3-pip
	sudo apt-get install python3-mysqldb
	python3 step-2.py
	
-- This will insert 5000 records in table widgets.

## Part 3:

### Download, Copy and paste the step-3.sh file in the data folder of itmd521. This file will execute the Sqoop import for all 5000 records from widgets table.

### Run the following command from home:

	cd /vagrant_data/

### Copy the step-3.sh file to home directory using the command :

	cp step-3.sh ~

### cd ~ to go to home

### Now we have the file in our home directory. Run the following command's from home :
	
	chmod +x step-3.sh
	./step-3.sh

### To check the result 

	hadoop fs -cat widgets/part-m-00000

## Part 4:

### Again do the same steps for step-4.sh as done for step-3.sh

### To check the result for both the shell scripts-

	hadoop fs -cat widgets/part-m-00000


### For getting Run MaxWidgetId.java for 5000 records, run the commands:

	hadoop fs -rm -r /user/vagrant/widgets
	chmod +x step-3.sh
	./step-3.sh
	sqoop codegen --connect jdbc:mysql://localhost/hadoopguide --table widgets --username root --password itmd521 --class-name Widget

### Go to cd sqoop-1.4.6.bin__hadoop-2.0.4-alpha

### Open your bashrc file.In your bashrc file kindly see to it your hadoop classpath has the following :

	:/home/vagrant/sqoop-1.4.6.bin__hadoop-2.0.4-alpha/sqoop-1.4.6.jar

### Using cd ~ go to home,

## Part 5:

### Use the commands below to go to the following folder:

	cd hadoop-book/
	cd ch15-sqoop/
	cd src/
	cd main/
	cd java
	
### Compile using the command from the current folder,

	hadoop com.sun.tools.javac.Main MaxWidgetId.java Widget.java

### Create a jar file using the command :

	jar cf sqoop-examples.jar *.class

### Run the job using the command :

	hadoop jar sqoop-examples.jar MaxWidgetId -libjars $SQOOP_HOME/sqoop-1.4.6.jar

### Output for this step can be viewed using the command :

	hadoop fs -cat /user/vagrant/maxwidget/part-r-00000 

## The output will be shown like this : 

![part -5 output](https://user-images.githubusercontent.com/31320698/32505511-091b4e74-c3a8-11e7-8f8f-26c4d99d1864.PNG)

## Part 6 - Modify the "MaxWidgetID.java" file , named it as "AvgWidgetId.java" to find - 

a.) My last name starts with "S", so I will be finding out the average price of each widget

Followed the commands:

	cd ~
	hadoop fs -rm -r /user/vagrant/maxwidget
	hadoop com.sun.tools.javac.Main AvgWidgetId.java Widget.java

### Name the java file - 

	jar cf Average-Widget2.jar *.class

### Compile the jar file - 

	hadoop jar Average-Widget2.jar AvgWidgetId -libjars $SQOOP_HOME/sqoop-1.4.6.jar 

### The output/ result of the average price of each widget is-

	hadoop fs -cat /user/vagrant/maxwidget/part-r-00000 

![week 11 output part 6](https://user-images.githubusercontent.com/31320698/32691720-8b8d3242-c6d1-11e7-8172-642b16367763.PNG)


