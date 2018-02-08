import java.io.IOException;
import java.util.StringTokenizer;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import java.io.*;


public class SortHadoopee {
    
    public static class Hadoopsortmapper extends Mapper<Object, Text, Text, Text>{
        
        private Text mapvalue = new Text();
        private Text mapkey = new Text();
        
        public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
            String eventstring= value.toString();
            mapkey.set(eventstring.substring(1, 10));
            mapvalue.set(eventstring.substring(16));
            context.write(mapkey, mapvalue);
        }
    }
    
    public static class Hadoopsortreducer extends Reducer<Text,Text,Text,Text> {
        
        
        public void reduce(Text key, Text value, Context context) throws IOException, InterruptedException {
            
            context.write(key, value);
        }
    }
    
    public static void main(String[] args) throws Exception {

        final long starttime = System.nanoTime();

        Configuration conf = new Configuration();
        
        Job job = Job.getInstance(conf, "Hadoop Sort");
        job.setJarByClass(SortHadoopee.class);
        job.setMapperClass(Hadoopsortmapper.class);
        job.setCombinerClass(Hadoopsortreducer.class);
        job.setReducerClass(Hadoopsortreducer.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);
        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));

        final long timeduration = System.nanoTime() - starttime;

        if (job.waitForCompletion(true))
        {
            System.out.println("Time elapsed on hadoop" + timeduration);
            System.exit(0);
        }

        else
        {

            System.out.println("Time elapsed on hadoop
                               " + timeduration);
            System.exit(2);

        }
        


    }
}
