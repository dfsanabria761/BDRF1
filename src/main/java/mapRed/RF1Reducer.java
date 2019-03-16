package mapRed;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.Reducer.Context;

public class RF1Reducer extends Reducer<DiaLocalizacion, IntWritable, Text, IntWritable> {
	
	
	public enum Dias{
		LUN, MAR, MIE, JUE, VIE, SAB, DOM
	}
	
	
	@Override
	protected void reduce(DiaLocalizacion key, Iterable<IntWritable> values,
			Context context)
			throws IOException, InterruptedException {
		int tot=0;
		for(IntWritable iw:values){
			tot+=iw.get();
		}
		
		Text texto = new Text(Dias.values()[key.getDia()-1].toString() + " Localización " +key.getLocalizacion()); 
		context.write(texto, new IntWritable(tot));
		
	}

}