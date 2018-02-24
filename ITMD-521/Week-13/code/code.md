# Part c -

vagrant ssh

wget http://mirrors.gigenet.com/apache/spark/spark-2.2.0/spark-2.2.0-bin-hadoop2.6.tgz

tar -xvzf spark-2.2.0-bin-hadoop2.6.tgz

ls

vim ~/.bashrc

export SPARK_HOME=/home/vagrant/spark-2.2.0-bin-hadoop2.6

export PATH=$PATH:$SPARK_HOME/bin

spark-shell





# Part d -

cd /vagrant_data/

ls

cp categories.avro products.avro ~	

cd ~

ls

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

spark-shell --packages com.databricks:spark-avro_2.11:4.0.0

import com.databricks.spark.avro._

import org.apache.spark.sql.SparkSession

import org.apache.spark.sql.SQLContext

val sqlContext = new SQLContext(sc)

val categ = sqlContext.read.avro("hdfs://localhost/user/root/spark/scala/categoriesdata")

val prod = sqlContext.read.avro("hdfs://localhost/user/root1/spark/scala/productsdata")

categ.take(20).foreach(println)

prod.take(20).foreach(println)






# Part e -

val categrdd = categ.as[(String,String)].rdd

val prodrdd = prod.as[(String,String,String,String,String)].rdd

val prod1 = prodrdd.filter(_._4.toString !="")

val prod2 = prod1.filter(_._4.toFloat < 100.00)

val prodtxtfile = prod2.saveAsTextFile("Result_0")

prod2.count()

cd Result_0

ls

cat part-00000 > Result_0.txt

cp Result_0.txt /vagrant/data






# Part f -

spark-shell --packages com.databricks:spark-avro_2.11:4.0.0

import com.databricks.spark.avro._

import org.apache.spark.sql.SparkSession

import org.apache.spark.sql.SQLContext

val sqlContext = new SQLContext(sc)

val categ = sqlContext.read.avro("hdfs://localhost/user/root/spark/scala/categoriesdata")

val prod = sqlContext.read.avro("hdfs://localhost/user/root1/spark/scala/productsdata")

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

:q

cd Result_1

cat part*.csv > Result_1.txt

cp Result_1.txt /vagrant/data







# Part g -

spark-shell --packages com.databricks:spark-avro_2.11:4.0.0

import com.databricks.spark.avro._

import org.apache.spark.sql.SparkSession

import org.apache.spark.sql.SQLContext

val sqlContext = new SQLContext(sc)

val categ = sqlContext.read.avro("hdfs://localhost/user/root/spark/scala/categoriesdata")

val prod = sqlContext.read.avro("hdfs://localhost/user/root1/spark/scala/productsdata")

import org.apache.spark.sql.functions.{row_number, max, broadcast}

import org.apache.spark.sql.expressions.Window


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

result.show

result.write.format("com.databricks.spark.csv").option("delimiter", "|").save("Result_2")

:q

cd Result_2

cat part*.csv > Result_2.avro

cp Result_2.avro /vagrant/data
