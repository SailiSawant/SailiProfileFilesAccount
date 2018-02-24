// cc MaxStationIdMapper Mapper for invalid maximum temperature example
// vv MaxStationIdMapper
import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class MaxStationIdMapper
  extends Mapper<LongWritable, Text, Text, IntWritable> {

 private static final int MISSING = 9999;
  
  @Override
  public void map(LongWritable key, Text value, Context context)
      throws IOException, InterruptedException {
    
    String line = value.toString();
    String stationid = line.substring(4, 10);

    int airTemperature;
    
    if (line.charAt(87) == '+') { // parseInt doesn't like leading plus signs
      airTemperature = Integer.parseInt(line.substring(88, 92));
    } else {
      airTemperature = Integer.parseInt(line.substring(87, 92));
    }
    String quality = line.substring(92,93);

    if (airTemperature == MISSING && quality.matches("[01459]")) {
      context.write(new Text(stationid), new IntWritable(airTemperature));
    }
  }
}
// ^^ MaxStationIdMapper

