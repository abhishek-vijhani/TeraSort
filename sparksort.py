from pyspark import SparkContext
import sys

if (len(sys.argv) >3):
    print " "

if(len(sys.argv) < 3 ):
    sys.exit(1);


inputPath = sys.argv[1]

outputPath = sys.argv[2]

a= SparkContext("local","Spark Sort")

file = a.textFile(inputPath)

def flatMap(line):
    return line.split(" ")

def map(words):
    return (str(words[:15]),str(words[15:]))

def reduce(a,c):
  
    print "*" * 80+ "Value of B is ", (c[0]+c[1])

    return (a,c)

counts1 = file.flatMap(flatMap).map(map).sortByKey().reduce(reduce)
counts1.saveAsTextFile(outputPath)
