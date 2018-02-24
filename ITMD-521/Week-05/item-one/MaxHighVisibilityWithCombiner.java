// cc MaxHighVisibilityWithCombiner Find the maximum high visibility, using a combiner function for efficiency
// vv MaxHighVisibilityWithCombiner

// Programmed by: Saili Sawant

// Objective: Find the max high visibility using combiner 
 
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;


public class MaxHighVisibilityWithCombiner
 {

  public static void main(String[] args)
 throws Exception
 {
    if (args.length != 2)
 {
      System.err.println("Usage: MaxHighVisibilityWithCombiner <input path> " +
          "<output path>");
      System.exit(-1);
    }
    
    Job job = new Job();
    job.setJarByClass(MaxHighVisibilityWithCombiner.class);
    job.setJobName("Max High Visibility");

    FileInputFormat.addInputPath(job, new Path(args[0]));
    FileOutputFormat.setOutputPath(job, new Path(args[1]));
    
    job.setMapperClass(MaxHighVisibilityMapper.class);
    /*[*/job.setCombinerClass(MaxHighVisibilityReducer.class)/*]*/;
    job.setReducerClass(MaxHighVisibilityReducer.class);

    job.setOutputKeyClass(Text.class);
    job.setOutputValueClass(IntWritable.class);
    
    System.exit(job.waitForCompletion(true) ? 0 : 1);
  }
}

