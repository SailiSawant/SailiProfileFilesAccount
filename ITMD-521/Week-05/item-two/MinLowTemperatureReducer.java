// cc MinLowTemperatureReducer Reducer for minimum temperature
// vv MinLowTemperatureReducer

// Programmed by : Saili Sawant

// Objective : To find reducer for minimum temperature from the weather data given

import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class MinLowTemperatureReducer
  extends Reducer<Text, IntWritable, Text, IntWritable>
 {
  
  @Override
  public void reduce(Text key, Iterable<IntWritable> values,
      Context context)
      throws IOException, InterruptedException
 {
    
    int minValue = Integer.MAX_VALUE;
    for (IntWritable value : values)
 {
      minValue = Math.min(minValue, value.get());
    }
    context.write(key, new IntWritable(minValue));
  }
}


