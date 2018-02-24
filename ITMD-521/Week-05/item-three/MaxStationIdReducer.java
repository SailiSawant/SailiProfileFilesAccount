// cc MaxStationIdReducer Reducer for invalid maximum temperature example
// vv MaxStationIdReducer
import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class MaxStationIdReducer
  extends Reducer<Text, IntWritable, Text, IntWritable> {
  
  @Override
  public void reduce(Text key, Iterable<IntWritable> values,
      Context context)
      throws IOException, InterruptedException {
    int count = 0;
    int invalidRec;
    int maxCount = Integer.MIN_VALUE;
    for (IntWritable value : values) {
      invalidRec = value.get();
      count++;
    }
    context.write(key, new IntWritable(count));
  }
}
// ^^ MaxStationIdReducer

