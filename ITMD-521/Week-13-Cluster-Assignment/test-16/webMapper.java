//Mapper for Web Log Hits
//Author: Saili Sawant

import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import java.lang.String;

public class webMapper extends Mapper<LongWritable, Text, Text, Text> {

        @Override
        public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

                String v1 = value.toString();

                if (!v1.startsWith("#")) {
                        if (!v1.contains("index.") == true) {

                                if (v1.contains(" 200 ") == true) {

                                        String keys = v1.substring(0, 7);
                                        int initial = v1.indexOf("/");// Start of cs_uri_stem
                                                                                                                
                                        int terminate = v1.indexOf(" ", initial); // End of
                                                                                                                           
                                        String s1 = v1.substring(initial, terminate); // Cutting the data and taking out
                                        context.write(new Text(keys), new Text(s1));

                                }

                        }
                }
        }
}


