# Deliverables:

## Following are the steps/procedure to get the result:

### Part c - 

1.) Visit online website of spark i.e., spark.apache.org. Click on Download spark, and after that we need to select: "Pre-built for Apache Hadoop 2.6" from the drop down list as shown in red 

![dropdown](https://user-images.githubusercontent.com/31320698/33225758-71fd3e86-d143-11e7-9691-e1b74466ec37.PNG)

2.) Follow the start up of vagrant as we usually do,

	vagrant ssh
	
3.) Then do wget and paste the link which is tar zip file as shown below, and run the command which will install spark on vagrant

![apache](https://user-images.githubusercontent.com/31320698/33225791-fa511f28-d143-11e7-8860-6773f49d589a.PNG)

4.) Run the command below:

	tar -xvzf spark-2.2.0-bin-hadoop2.6.tgz

![tar spark](https://user-images.githubusercontent.com/31320698/33225831-ae8a5b76-d144-11e7-8e2d-a3b995bf85b3.PNG)


5.) After doing ls, we will get:

![ls](https://user-images.githubusercontent.com/31320698/33225814-7b7cd6fa-d144-11e7-98dc-0ee50b05437d.png)


6.) Run the foloowing command to add spark on bash rc file:

	vim ~/.bashrc

![bashrc file](https://user-images.githubusercontent.com/31320698/33225826-a5a5c054-d144-11e7-8548-d9e5e753a217.PNG)

7.) We need to add two export commands on bash rc file:

	export SPARK_HOME=/home/vagrant/spark-2.2.0-bin-hadoop2.6
	export PATH=$PATH:$SPARK_HOME/bin

8.) Spark will be started by-

	spark-shell

![spark shell 1](https://user-images.githubusercontent.com/31320698/33226116-8fba0550-d14b-11e7-8731-cf45a180c08f.PNG)


### Part d - 

1.) There are two folders categories.avro and products.avro, copy these two files in "data" folder in itmd521.

2.) Run the below commands:

	cd /vagrant_data/
	ls
	cp categories.avro products.avro ~	
	cd ~
	ls

![s1](https://user-images.githubusercontent.com/31320698/33226083-ba19d876-d14a-11e7-82ad-ca9765dfb2be.PNG)

3.) Now to create directories for "categories", run the following commands from home -

	mkdir -p spark/scala/categoriesdata
	cp categories.avro spark/scala/categoriesdata
	hadoop fs -mkdir /user/root
	hadoop fs -chown root /user/root
	hadoop fs -mkdir -p /user/root/spark/scala
	cd spark
	cd scala
	cd categoriesdata
	pwd

	hadoop fs -put /home/vagrant/spark/scala/categoriesdata /user/root/spark/scala
	hadoop fs -ls /user/root/spark/scala/categoriesdata
	
 ![categories](https://user-images.githubusercontent.com/31320698/33232056-18e92396-d1c5-11e7-9d49-c84a1d229517.PNG)

4.) Create directory for "products", run the following commands from home - 

	cd ~
	mkdir -p spark/scala/productsdata
	cp products.avro spark/scala/productsdata
	hadoop fs -mkdir /user/root1
	hadoop fs -chown root /user/root1
	hadoop fs -mkdir -p /user/root1/spark/scala
	cd spark
	cd scala
	cd productsdata
	pwd

	hadoop fs -put /home/vagrant/spark/scala/productsdata /user/root1/spark/scala
	hadoop fs -ls /user/root1/spark/scala/productsdata

![products data](https://user-images.githubusercontent.com/31320698/33232130-1ee41048-d1c6-11e7-977a-278f593fe793.PNG)

5.) Start spark shell,

	spark-shell --packages com.databricks:spark-avro_2.11:4.0.0

![spark1](https://user-images.githubusercontent.com/31320698/33232136-37d43542-d1c6-11e7-8fe8-af5b8e7080e3.PNG)


![spark shell 1](https://user-images.githubusercontent.com/31320698/33226116-8fba0550-d14b-11e7-8731-cf45a180c08f.PNG)

6.) To import the packages run the commands -

	import com.databricks.spark.avro._
	import org.apache.spark.sql.SparkSession
	import org.apache.spark.sql.SQLContext
	val sqlContext = new SQLContext(sc)

![import](https://user-images.githubusercontent.com/31320698/33232161-ca80be60-d1c6-11e7-9886-e7b96ea1930f.PNG)

7.) Load the categories.avro data from HDFS into spark -


	val categ = sqlContext.read.avro("hdfs://localhost/user/root/spark/scala/categoriesdata")

![categ](https://user-images.githubusercontent.com/31320698/33232220-cb41e22e-d1c7-11e7-8418-df85733e9bcd.PNG)

8.) Load the products.avro data from HDFS into spark -

	val prod = sqlContext.read.avro("hdfs://localhost/user/root1/spark/scala/productsdata")

![prod](https://user-images.githubusercontent.com/31320698/33232235-0e8bc78e-d1c8-11e7-9d90-4075da03b72e.PNG)

9.) Results :  For first 20 rows of both categories and products :


	categ.take(20).foreach(println)
	prod.take(20).foreach(println)

![results](https://user-images.githubusercontent.com/31320698/33232260-6e980f8e-d1c8-11e7-93ff-ae9d1cf3cdbc.PNG)


### Part e -

1.) Converting categories and products dataset which is in DataFrame format to rdd:

	val categrdd = categ.as[(String,String)].rdd
	val prodrdd = prod.as[(String,String,String,String,String)].rdd

	val prod1 = prodrdd.filter(_._4.toString !="")
	val prod2 = prod1.filter(_._4.toFloat < 100.00)
	val prodtxtfile = prod2.saveAsTextFile("Result_0")
 	prod2.count()

![rdd](https://user-images.githubusercontent.com/31320698/33232285-fad16b3a-d1c8-11e7-90cd-c6cc621afa21.PNG)

2.) This output will get saved as a directory with part-00000, the command is run from Result_0 folder in vagrant:

	cd Result_0
	ls
 	cat part-00000 > Result_0.txt
 	cp Result_0.txt /vagrant/data

![part-r-000 res](https://user-images.githubusercontent.com/31320698/33232321-c90f8162-d1c9-11e7-963d-6e811fe2aa2c.PNG)

### Part f -

1.) Start the spark-shell 
	
	spark-shell --packages com.databricks:spark-avro_2.11:4.0.0

![spark shell new](https://user-images.githubusercontent.com/31320698/33236855-6081f71c-d226-11e7-945c-bda63c6a9950.PNG)

2.) Import all the packages -

	import com.databricks.spark.avro._
	import org.apache.spark.sql.SparkSession
	import org.apache.spark.sql.SQLContext
	val sqlContext = new SQLContext(sc)

3.) Again load the categories.avro and products.avro data from HDFS into spark, use commands -

	val categ = sqlContext.read.avro("hdfs://localhost/user/root/spark/scala/categoriesdata")
	val prod = sqlContext.read.avro("hdfs://localhost/user/root1/spark/scala/productsdata")

4.) Run the following commands -

	val catprodjoin = categ.join(prod, categ("category_id") === prod("_2"))

	import org.apache.spark.sql.functions.{row_number, max, broadcast}

	import org.apache.spark.sql.expressions.Window

	val catprodjoinorder = Window.partitionBy($"category_id").orderBy($"_4".desc)

	val top10 = catprodjoin.withColumn("rn", row_number.over(catprodjoinorder)).where($"rn" <= 10).drop("rn").filter($"_4" < 100)

	val joinfinalcatprod = top10.select($"category_name", $"_3", $"_4")


	val categname = joinfinalcatprod.withColumnRenamed("category_name","category name")

	val prodname = categname.withColumnRenamed("_3","product name")

	val catprod = prodname.withColumnRenamed("_4","product price")

	
catprod.write.format("com.databricks.spark.csv").option("delimiter", "\t").save("Result_3")



![f0](https://user-images.githubusercontent.com/31320698/33236875-2c1547d0-d227-11e7-8016-9c193de23086.PNG)

![f](https://user-images.githubusercontent.com/31320698/33236877-2ffcb860-d227-11e7-8abf-f7eee5dcc70b.PNG)

5.) Moving out from spark, we will run the commands for getting the Results_1. So when we go to "data folder" in itmd521 folder, we will find "Results_1" text file in notepad form.

	:q

	cd Result_1

	cat part*.csv > Result_1.txt

	cp Result_1.txt /vagrant/data

![f2](https://user-images.githubusercontent.com/31320698/33236883-742ab3de-d227-11e7-9d4e-c08d99702dec.PNG)


### Part g -

1.) Start the spark-shell 
	
	spark-shell --packages com.databricks:spark-avro_2.11:4.0.0

![start](https://user-images.githubusercontent.com/31320698/33237314-79325914-d235-11e7-9334-6d9b92936790.PNG)

2.) Import all the packages required -

	import com.databricks.spark.avro._
	import org.apache.spark.sql.SparkSession
	import org.apache.spark.sql.SQLContext
	val sqlContext = new SQLContext(sc)

![importpackage](https://user-images.githubusercontent.com/31320698/33237315-89a63158-d235-11e7-8988-766125eef127.PNG)


3.) Load the categories.avro and products.avro data from HDFS into spark, use commands -

	val categ = sqlContext.read.avro("hdfs://localhost/user/root/spark/scala/categoriesdata")
	val prod = sqlContext.read.avro("hdfs://localhost/user/root1/spark/scala/productsdata")

4.) There are some windows import that we need to run on vagrant -

	import org.apache.spark.sql.functions.{row_number, max, broadcast}
	import org.apache.spark.sql.expressions.Window

5.) Run the following output for result_2,

	val categ1 = categ.withColumn("category_id", 'category_id.cast("Float"))
	val prod1 = prod.withColumn("_4", '_4.cast("Float"))
	val catprodjoin = categ1.join(prod1, categ1("category_id") === prod("_2"))
	val descorder = Window.partitionBy($"category_id").orderBy($"_4".desc)
	val Ascorder = Window.partitionBy($"category_id").orderBy($"_4".asc)
	val maxdf = catprodjoin.withColumn("row_num",row_number.over(descorder)).where($"row_num" === 1).drop("row_num")
	val mindf = catprodjoin.withColumn("row_num",row_number.over(Ascorder)).where($"row_num" === 1).drop("row_num")
	val datafmax = maxdf.select($"category_name",$"_3",$"_4")
	val datafmin = mindf.select($"category_name",$"_3",$"_4")
	val maxvalue = datafmax.withColumnRenamed("category_name","category name").withColumnRenamed("_3","highest_product_name").withColumnRenamed("_4","Highest product price")
	val minvalue = datafmin.withColumnRenamed("category_name","category name").withColumnRenamed("_3","lowest_product_name").withColumnRenamed("_4","Lowest product price")
	val result = maxvalue.join(minvalue, "category name")

![g part result](https://user-images.githubusercontent.com/31320698/33237242-cf5f076c-d233-11e7-972f-d6f00d7bfaa6.PNG)

6.) Output for Result_2 -

	result.show
	result.write.format("com.databricks.spark.csv").option("delimiter", "|").save("Result_2")

![g part result 2](https://user-images.githubusercontent.com/31320698/33237247-ee33bd54-d233-11e7-845c-586ceb296438.PNG)

7.) Moving out from spark, we will run the commands for getting the Results_2.avro, so when we go to "data folder" in itmd521 folder, we will find "Results_2.avro" avro file.

	:q

	cd Result_2
	cat part*.csv > Result_2.avro
	cp Result_2.avro /vagrant/data

![last](https://user-images.githubusercontent.com/31320698/33237277-5ac5fe14-d234-11e7-9d41-86b10ab4cac7.PNG)









 


