package mapRed;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.util.PriorityQueue;

import com.google.common.collect.MinMaxPriorityQueue;

public class RF1Mapper extends Mapper<Object, Text, DiaLocalizacion, IntWritable> {
	
	private Text linea = new Text();
	
	
	@Override
	protected void map(Object key, Text value, Context context)
			throws IOException, InterruptedException {
		linea.set(value);

		String lin=linea.toString();
		String[] cols = lin.split(",");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		try {
			Date date =sdf.parse(cols[1]);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			DiaLocalizacion dl= new DiaLocalizacion(calendar.DAY_OF_WEEK,Integer.parseInt(cols[4]) );
			context.write(dl, new IntWritable(1));
		}catch(Exception e) {
			e.printStackTrace();
		}

	}
}