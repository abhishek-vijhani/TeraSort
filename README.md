# TeraSort-using-Hadoop-on-Amazon-EC2-Cluster
TeraSort using Hadoop on Amazon EC2 Cluster

Shared Memory Sort
We have written the code for the Shared Memory TeraSort in Java. 
TeraSort is a popular benchmark that measures the amount of time to sort one terabyte of randomly distributed data on a given computer system. 
We have performed sorting on 128GB and 1 TB datasets. Using the key’s ASCII Value, we have performed sorting. 
We have divided the original dataset into the block size (size of file/ Number of Temporary files). 
After that we have created unsorted chunks for each file and applied Quick Sort on these chunks, 
which provides me with sorted chunks as output. This part of the program has threads applied to it to parallelize the process of sorting. 
Then with the help of k-way external merge sort, I have merged all the Sorted Chunks of earlier phase into a final sorted output file.

Launch aws instance

run the terasort java code.


Hadoop TeraSort
We have written the code for Hadoop Sorting in Java. 
In this we have used Map-Reduce based implementation. 
It contains of two phases Sort and Shuffle Phase, which internally sorts the data without using any code. 
We have provided the mapper with input as key and values, and the Sort and Shuffle phase will categorize the data and sort them according to its Key.
The reducer is used to give the output of the Sort and Shuffle Phase. We have tested the Hadoop code on 128 GB, 1 TB 


We need to configure the aws launch instance.
install java
install idk
set the class path in .bashrc
set the config files.
generate data using gensort.
insert it into hdfs file system.
Run hadoop map reduce on the sort file.

sudo apt-get install python-software-properties
sudo add-apt-repository ppa:webupd8team/java
sudo apt-get update
sudo apt-get install oracle-java8-installer)

Haddop jar sort.jar SortHadoopee input path output path

Spark TeraSort
We have written the code for Spark using the PysparkSpark Shell, which uses Python. 
It also uses the Map-Reduce based implementation. 
When we install Spark on it automatically installs various features like R-Studio, Scala, Python. 
We have implemented sorting using pyspark sortByKey(), functionality, which sorts the data based on Key value (10 Bytes). 
Then we obtained the chunks of the sorted data.

Same configuration.
install spark over hadoop.
start pysaprk shell
start the python program with commands
python sparksort.py input path outeutpath
