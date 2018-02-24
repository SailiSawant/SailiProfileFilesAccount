//Reducer for web log hits
//Programmed by Saili Sawant

import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import java.util.ArrayList;

public class webReducer extends Reducer<Text, Text, Text, Text> {
        @Override
        public void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
                //Unique links in the arraylist
                ArrayList<String> a1 = new ArrayList<String>();
                ArrayList<String> unit = new ArrayList<String>();
                String b2;
                for (Text value : values) {
                        b2 = value.toString();
                        unit.add(b2);
                        if (a1.contains(b2) != true) {
                                a1.add(b2);
                        }
                }
                int size = a1.size();
                int[] count = new int[size];
                //Calculate the count for each link
                for (int j = 0; j < a1.size(); j++) {
                        b2 = a1.get(j);
                        for (int i = 0; i < unit.size(); i++) {
                                if (b2.compareTo(unit.get(i)) == 0) {
                                        count[j]++;
                                }
                        }
                }
                int c1 = count[0];
                int d1 = 0;
                for (int j = 1; j < size; j++) {
                        if (c1 < count[j]) {
                                c1 = count[j];
                                d1 = j;
                        }
                }

                context.write(key, new Text(a1.get(d1) + ' ' + c1));
        }
}

