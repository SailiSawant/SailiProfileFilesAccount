// cc MaxHighVisibilityReducer Reducer for maximum high visibility
// vv MaxHighVisibilityReducer

// Programmed by : Saili Sawant

// Objective : To find reducer for max high visibility from the weather data given

import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class MaxHighVisibilityReducer
  extends Reducer<Text, IntWritable, Text, IntWritable>
 {
  
  @Override
  public void reduce(Text key, Iterable<IntWritable> values,
      Context context)
      throws IOException, InterruptedException
 {
    
    int maxValue = Integer.MIN_VALUE;
    for (IntWritable value : values)
 {
      maxValue = Math.max(maxValue, value.get());
    }
    context.write(key, new IntWritable(maxValue));
  }
}

