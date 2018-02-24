// cc MinLowTemperatureWithCombiner Find the minimum temperature, using a combiner function for efficiency
// vv MinLowTemperatureWithCombiner

// Programmed by: Saili Sawant

// Objective: Find the minimum temperature using combiner 
 
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;


public class MinLowTemperatureWithCombiner
 {

  public static void main(String[] args)
 throws Exception
 {
    if (args.length != 2)
 {
      System.err.println("Usage: MinLowTemperatureWithCombiner <input path> " +
          "<output path>");
      System.exit(-1);
    }
    
    Job job = new Job();
    job.setJarByClass(MinLowTemperatureWithCombiner.class);
    job.setJobName("Min low temperature");

    FileInputFormat.addInputPath(job, new Path(args[0]));
    FileOutputFormat.setOutputPath(job, new Path(args[1]));
    
    job.setMapperClass(MinLowTemperatureMapper.class);
    /*[*/job.setCombinerClass(MinLowTemperatureReducer.class)/*]*/;
    job.setReducerClass(MinLowTemperatureReducer.class);

    job.setOutputKeyClass(Text.class);
    job.setOutputValueClass(IntWritable.class);
    
    System.exit(job.waitForCompletion(true) ? 0 : 1);
  }
}


