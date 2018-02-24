// Programmed by - Saili Sawant
//Description - Finding out the average price for each widget.

import java.io.IOException;

import com.cloudera.sqoop.lib.RecordParser.ParseError;

import org.apache.hadoop.conf.*;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.*;
import java.math.BigDecimal;

public class AvgWidgetId extends Configured implements Tool {

  public static class MaxWidgetMapper
      extends Mapper<LongWritable, Text, Text, FloatWritable> {
    private Widget maxWidget = null;

    public void map(LongWritable k, Text v, Context context) throws IOException,InterruptedException {
      Widget widget = new Widget();
      try {
        widget.parse(v); // Auto-generated: parse all fields from text.
      } catch (ParseError pe) {
        // Got a malformed record. Ignore it.
        return;
      }

    String widgetname = widget.get_widget_name();
    java.math.BigDecimal price = widget.get_price();  
    
    float newprice = price.floatValue();
    context.write(new Text(widgetname),new FloatWritable(newprice));
  }
}

  public static class MaxWidgetReducer
      extends Reducer<Text, FloatWritable, Text, FloatWritable> {

    // There will be a single reduce call with key '0' which gets
    // the max widget from each map task. Pick the max widget from
    // this list.
    public void reduce(Text k, Iterable<FloatWritable> vals, Context context) throws IOException,InterruptedException  {
      int count = 0;
      float totalPrice = 0;
      float avg = 0;
      
      for (FloatWritable value : vals) {
            
            totalPrice += value.get();
            count ++;
        
      }
      avg = totalPrice/count;
     context.write(k,new FloatWritable(avg));
      
    }
  }

  public int run(String [] args) throws Exception {
    Job job = new Job(getConf());

    job.setJarByClass(AvgWidgetId.class);

    job.setMapperClass(MaxWidgetMapper.class);
    job.setReducerClass(MaxWidgetReducer.class);

    FileInputFormat.addInputPath(job, new Path("widgets"));
    FileOutputFormat.setOutputPath(job, new Path("maxwidget"));

    //job.setMapOutputKeyClass(FloatWritable.class);
    //job.setMapOutputValueClass(Widget.class);

    job.setOutputKeyClass(Text.class);
    job.setOutputValueClass(FloatWritable.class);

    job.setNumReduceTasks(1);

    if (!job.waitForCompletion(true)) {
      return 1; // error.
    }

    return 0;
  }

  public static void main(String [] args) throws Exception {
    int ret = ToolRunner.run(new AvgWidgetId(), args);
    System.exit(ret);
  }
}

