# Answer Test- 1:

For MaxTemperature*.java I compiled mt.jar changing job.setJobName name according to my initials "S" 

So, I ran for O-Z 1994 :  used /user/ncdc/small/99-1000/output/

### For compiling Text file, bz2 and gz, use -

	Vim MaxTemperature.java

	hadoop com.sun.tools.javac.Main MaxTemperature*.java

	jar cf mt.jar MaxTemperature*.class

 	hadoop jar mt.jar MaxTemperature /user/ncdc/1994/1994.txt /output/sss/20

### For Compiling Small file, use

	 hadoop jar mt.jar MaxTemperature /user/ncdc/small/1994 /output/sss/21


![test-1](https://user-images.githubusercontent.com/31320698/33755363-febb7f78-dbb5-11e7-96c7-59341826eecf.PNG)


	From the above graph we come to know that as the reducers increase less time has taken for execution.

	The maximum time for execution is taking place because the MapReduce Application Master asks to the 
	Resource Manager for Containers needed by the Job: one MapTask container request for each MapTask (map split).

	A container request for a MapTask tries to exploit data locality of the map split. The Application Master asks for:

	1.) A container located on the same Node Manager where the map split is stored (a map split may be stored 
        on multiple nodes due to the HDFS replication factor)
	2.) Otherwise, a container located on a Node Manager in the same rack where the the map split is stored
	3.) Otherwise, a container on any other Node Manager of the cluster.

	So, the Resource manager basically needs time to allocate containers for splitting the data as 
        needed for map reduce jobs.


# Answer Test- 2:


## The graph for Reducer 1 is given below:

![test 2-1](https://user-images.githubusercontent.com/31320698/33567684-9ee97ed4-d8e9-11e7-83a0-625f2a448cbf.PNG)

## The graph for Reducer 2 is given below:

![test 2-2](https://user-images.githubusercontent.com/31320698/33567685-a15736b6-d8e9-11e7-8acd-b736864fe520.PNG)

## The graph for Reducer 4 is given below:

![test 2-4](https://user-images.githubusercontent.com/31320698/33567687-a309e6ac-d8e9-11e7-8984-23c448dd2661.PNG)

## The graph for Reducer 8 is given below:

![test 2-8](https://user-images.githubusercontent.com/31320698/33567691-a4bb11a6-d8e9-11e7-9385-73b338a40b85.PNG)

	By observing all these graphs we come to know that Text files for all the reducers took maximum time to 
	execute as map has to partition its output and also because of the sort-shuffle phase in the reduce phase 
	which takes lot of time to run.

## Final Graph for test 2:

![2 final graph](https://user-images.githubusercontent.com/31320698/33568096-e193e0fc-d8ea-11e7-9fca-afafc798fb29.PNG)

	From the Final Line graph, we see that for reducer 1 text file took long enough time because map task has 
	been assigned to it and all the tasks has to run and thats why it took time and as we increase the reducers 
	there is a dip and again there is an increase of time for reducer 8. This is because as the reducers increases 
	jobs get allocated to those reducers and they run smoothly which takes less time to run, as each reducers have 
	certain jobs while reducer 1 has only one reducer to run the jobs and thats why it took long time for it.


# Answer Test- 3:

## The graph for Reducer 1 is given below:

![test 3-1](https://user-images.githubusercontent.com/31320698/33567697-a873da12-d8e9-11e7-9ca7-68369ef4565f.PNG)

## The graph for Reducer 2 is given below:

![test 3-2](https://user-images.githubusercontent.com/31320698/33567701-aa5ca660-d8e9-11e7-963d-b68e1abc9230.PNG)

## The graph for Reducer 4 is given below:

![test 3-4](https://user-images.githubusercontent.com/31320698/33567705-ac599428-d8e9-11e7-86f3-c9ef96342fb3.PNG)

## The graph for Reducer 8 is given below:

![test 3-8](https://user-images.githubusercontent.com/31320698/33567706-ae0c5b84-d8e9-11e7-9a81-6b0f3e154e01.PNG)

        By observing all these graphs, we come to know that bz2 and gz files for all the reducers took maximum 
        time because If the input file is compressed, then the bytes read in from HDFS is reduced, which means less
        time to read data. This time conservation is beneficial to the performance of job execution.If the input files
        are compressed, they will be decompressed automatically as they are read by MapReduce, using the filename
        extension to determine which codec to use. For example, a file ending in .gz can be identified as 
        gzip-compressed file. bz2 is a freely available high-quality data compressor. It typically compresses files 
        to within 10% to 15% of the best available techniques, while being around twice as fast at compression 
        and six times faster at decompression.


# Answer Test- 4:

## The graph for Reducer 1 is given below:

![test 4-1](https://user-images.githubusercontent.com/31320698/33573720-4d48adbc-d8fc-11e7-85fe-c00561e87ae2.PNG)

## The graph for Reducer 2 is given below:

![test 4-2](https://user-images.githubusercontent.com/31320698/33573721-4f415ba0-d8fc-11e7-9020-cb6c13f012bb.PNG)

## The graph for Reducer 4 is given below:

![test 4-4](https://user-images.githubusercontent.com/31320698/33573734-5404d9e6-d8fc-11e7-80e6-12981d12db66.PNG)

## The graph for Reducer 8 is given below:

![test 4-8](https://user-images.githubusercontent.com/31320698/33573736-55c9829a-d8fc-11e7-9a54-d990a781b61c.PNG)

	From the graphs above, reducer 2 and 4 has taken maximum time for bz2 and gz file again because the file 
        gets automatically decompressed and takes long enough to run those files. While for reducer 8 the text file 
        took long time to execute because multiple map task has been assigned to it to run the job.


# Answer Test- 5:

## The graph for Reducer 1 is given below:

![test 5-1](https://user-images.githubusercontent.com/31320698/33573740-584e94b0-d8fc-11e7-9f47-3c49f6e280ce.PNG)

## The graph for Reducer 2 is given below:

![test 5-2](https://user-images.githubusercontent.com/31320698/33573742-5a271dac-d8fc-11e7-882a-f5412699a845.PNG)

## The graph for Reducer 4 is given below:

![test 5-4](https://user-images.githubusercontent.com/31320698/33573744-5c003ac8-d8fc-11e7-93a4-8ca56f9ab1a5.PNG)

## The graph for Reducer 8 is given below:

![test 5-8](https://user-images.githubusercontent.com/31320698/33573746-5e0db7be-d8fc-11e7-988b-b422c6e517de.PNG)

 	From the graphs for test 5, All the reducers took long time run except for reducer 4, because the map task 
        allocated for the reducer 4 didn't take much time to slpit the data and so it ran fast.Therefore, 
        for reducer 4 sort-shuffle phase worked really fast.


# Answer Test- 6:

## The graph for Reducer 1 is given below:

![test 6-1](https://user-images.githubusercontent.com/31320698/33575231-930afc88-d901-11e7-9948-78ad88f63e43.PNG)

## The graph for Reducer 2 is given below:

![test 6-2](https://user-images.githubusercontent.com/31320698/33575235-95079546-d901-11e7-8759-1d940c737141.PNG)

## The graph for Reducer 4 is given below:

![test 6-4](https://user-images.githubusercontent.com/31320698/33575238-964df4ae-d901-11e7-831f-048b93d7bff4.PNG)

## The graph for Reducer 8 is given below:

![test 6-8](https://user-images.githubusercontent.com/31320698/33575244-97a3a72c-d901-11e7-96bb-887b0f675e90.PNG)

	When there is one reducer there is hardly any shuffling atakes place and when it happens its quick
        but as the reducers increase, shuffling will will take place for long time for each of the reducers.
        Also, for the graphs we come to know that least time was taken for text file and maximum for bz2 and
        gz becuase of compressionas and decompression.

Final all files line graph for test 6:

![test 6 fg](https://user-images.githubusercontent.com/31320698/33575665-ff644bb8-d902-11e7-944a-d30fbef66d99.PNG)

	The graph increases gradually, this shows that as reducers increases the time will also increase. 
	In .bzip2 the data needs to be decompressed first to run the job and this codec actually takes more time
	than other formats to decompress and compress a file which is also clearly evident from the matrix and
	the graph. This does not allow data to be read arbitrarily and the number of splits observed here. Hence
	.bzip2 takes the longest time to run the job.


# Answer Test- 7:

## The graph for Reducer 1 is given below:

![test 7-1](https://user-images.githubusercontent.com/31320698/33575251-9d958df8-d901-11e7-869a-4e22b69ddf0e.PNG)

## The graph for Reducer 2 is given below:

![tet 7-2](https://user-images.githubusercontent.com/31320698/33575254-9f591c5e-d901-11e7-940f-4a6a1350ea85.PNG)

## The graph for Reducer 4 is given below:

![test 7-4](https://user-images.githubusercontent.com/31320698/33575257-a0f71944-d901-11e7-8612-a8b6e637be47.PNG)

## The graph for Reducer 8 is given below:

![test 7-8](https://user-images.githubusercontent.com/31320698/33575259-a307ea42-d901-11e7-991f-f6b544169d6f.PNG)

	From the graphs, all the reducers are following the gradual increase of time except for reducer 4, in that
	text file took maximum time this is because the Resource manager basically needs time to allocate containers
	for splitting the data as needed for map reduce jobs for reducer 4.


# Answer Test- 8:

## The graph for Reducer 1 is given below:

![test 8-1](https://user-images.githubusercontent.com/31320698/33577043-5db08804-d907-11e7-9f43-f7b6d16069ba.PNG)

## The graph for Reducer 2 is given below:

![test 8-2](https://user-images.githubusercontent.com/31320698/33577046-5f87bd6e-d907-11e7-8b9f-562a60cc2ad0.PNG)

## The graph for Reducer 4 is given below:

![test 8-4](https://user-images.githubusercontent.com/31320698/33577049-613e94ac-d907-11e7-9321-bd03000e8fb1.PNG)

## The graph for Reducer 8 is given below:

![test 8-8](https://user-images.githubusercontent.com/31320698/33577052-62e761e4-d907-11e7-8315-a28984713097.PNG)

	Generally the time gradually increases for all reducers except reducer 4 and 8 as in this case its decreasing
 	because the shuffle time is less (10 min)


# Answer Test- 9:

## The graph for Reducer 1 is given below:

![test 9-1](https://user-images.githubusercontent.com/31320698/33577055-648d01ca-d907-11e7-802a-a58a88c18407.PNG)

## The graph for Reducer 2 is given below:

![test 9-2](https://user-images.githubusercontent.com/31320698/33577056-662dd018-d907-11e7-87c4-bc4de1f50ed6.PNG)

## The graph for Reducer 4 is given below:

![test 9-4](https://user-images.githubusercontent.com/31320698/33577060-67d01ed0-d907-11e7-9a53-c48b960088b4.PNG)

## The graph for Reducer 8 is given below:

![test 9-8](https://user-images.githubusercontent.com/31320698/33577062-693f1f6e-d907-11e7-9596-b26da8444dbb.PNG)

	For Reducers 1, 4 and 8 the time increases as shown in the graph as shuffle time is more while for reducer 2 
	its decreasing because the shuffle time is less i.e. 11 minutes to be precise.


# Answer Test- 10:

## The following graph is basically the combination of text files for ALL FOUR reducers:

![test 10](https://user-images.githubusercontent.com/31320698/33754583-88f3643e-dbb2-11e7-8968-221477d1bb96.PNG)

	From the graph we come to know that, as reducers increase, less time it will take for the jobs to run and 
        from here also we see that text file for reducer 8 took less time. Since .txt is uncompressed and allows 
        data to be read arbitrarily, it takes lesser time to run the job. It was also observed that the 
        number of splits while performing the job on .txt were more than one. These types of files are 
        local to the map jobs hence they take the least amount of time.


# Answer Test- 11:

## The following graph is basically the combination of text files for ALL FOUR reducers:

![test 11](https://user-images.githubusercontent.com/31320698/33754628-bc78c47a-dbb2-11e7-8bc9-17cf75aca17b.PNG)

	From the graph we come to know that, In text file in reducer 8 the data needs to be decompressed first 
        to run the job and this codec actually takes more time than other formats to decompress and compress 
        a file which is also clearly evident from the matrix and
        the graph. This does not allow data to be read arbitrarily and the number of splits observed here. Hence
        text file takes the longest time to run the job.


# Answer Test- 12:

## The following graph is basically the combination of text files for ALL FOUR reducers:

![test -12](https://user-images.githubusercontent.com/31320698/33754645-d4161600-dbb2-11e7-8a57-db5e985c5b8f.PNG)

	From the graph we come to know that, when number of reducers was changed to 2, 
        drawback as mentioned in former case was eliminated as well as the undue load was balanced among
	2 reducers. Hence because of parallel processing being done by 2 reducers, total
	execution time got decreased.
	Also, the execution time decreased to a slight extent when number of reducers was
	changed to 4. Now the work was divided among 4 reducers and consequently execution
	time was reduced because of parallel processing.


# Answer Test- 13:

## The following graph is basically the combination of text files for ALL FOUR reducers:

![test-13](https://user-images.githubusercontent.com/31320698/33754674-f69f3c1a-dbb2-11e7-8902-5578b863c588.PNG)

	From the graph we come to know that, Map task will be executed at the expense of data
	locality and the output of one map task will be transferred over network to the node
        where one reduce task is running. At 4 reducer, the output will be merged and passed to
        user-defined reduce function. Because there is only one map task and one reduce task,
        no drawback will be created and job will get finished within minimum amount of time.


# Answer Test- 14:

## The following graph is basically the combination of text files for ALL FOUR reducers:

![test-14](https://user-images.githubusercontent.com/31320698/33754702-13e632ba-dbb3-11e7-8864-795a82750e53.PNG)

	From the graph we come to know that, Now if we change the number of reducers to 2, there will be one 
	map task and two reduce tasks executed. Therefore, here increasing the number of reducers instead of
	reducing the work will increase the amount of work. As described earlier, Shuffle and Sort will result 
        in more time taken by job.Similarly, changing the number of reducers to 4 will make the “Shuffle and Sort” 
        more complicated and as a result execution time will increase.


# Answer Test- 15:

## The following graph is basically the combination of text files for ALL FOUR reducers:

![test-15](https://user-images.githubusercontent.com/31320698/33754714-2885ee5e-dbb3-11e7-8e3e-73c32b9d272a.PNG)

	From the graph we come to know that, if we change number of reducers to 2, it decreases the execution time because it
	might have divided the work of processing 5 map outputs among 2 reducers and therefore due to parallelism 
        total execution time got decreased. However, changing the number of reducer to 4 resulted in 5 map tasks and 4 reduce
	tasks which increased the amount of work. Therefore, total execution time increased and then for 8 reducers time of execution again increases.


# Answer Test- 16:

### 1.) Copy the file to data folder:

	cp u_ex141028.log /vagrant/data 
	hadoop fs -copyFromLocal u_ex141028.log sss1/web/sample/

### 2.) Make Directory:
	
	hadoop fs -mkdir -p  sss1/sss1
	hadoop fs -mkdir -p  sss1/web/sample/

	hadoop fs -copyFromLocal u_ex141028.log sss1/web/sample/

### 3.) Compile the files:	

	hadoop com.sun.tools.javac.Main *.java
	jar cf sample.jar *.class
	hadoop jar sample.jar MaxTemperature spg1/web/sample/u_ex141028.log output/web/2
	hadoop fs -cat output/web/2/part-r-00000

### Output:

![o](https://user-images.githubusercontent.com/31320698/33756933-70e1d3d4-dbbd-11e7-9727-740da0b4d0eb.PNG)

## Least time of execution that I decided the single configuration that is optimum for achieving the results by plotting a graph:

![leasttime](https://user-images.githubusercontent.com/31320698/33758647-a91d1572-dbc4-11e7-97fa-534366cfe2c3.PNG)

## From graph, The optimum value is Test 3 with reducer 2, because the volume of data to be transferred was decreased, it took less time to finish the job and we were able to achieve a performance gain by reducer 2.


















