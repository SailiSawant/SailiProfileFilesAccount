// cc MaxHighVisibilityMapper Mapper for highest visibility 
// vv MaxHighVisibilityMapper
// Programmed By: Saili Sawant

// Objective: Mapper for Highest visibility

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class MaxHighVisibilityMapper
  extends Mapper<LongWritable, Text, Text, IntWritable> {

  private static final int MISSING = 99999;
  
  @Override
  public void map(LongWritable key, Text value, Context context)
      throws IOException, InterruptedException {
    
    String line = value.toString();
    String year = line.substring(15, 19);
    int weathervisibility;
    
    weathervisibility = Integer.parseInt(line.substring(78, 83));
    String qualityvisibility = line.substring(83, 84);

    if (weathervisibility != MISSING && qualityvisibility.matches("[01459]")) {
      context.write(new Text(year), new IntWritable(weathervisibility));
    }
  }
}

