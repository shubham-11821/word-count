package com.raj.wc;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class WcMapper extends Mapper<LongWritable, Text, Text, IntWritable>{
	public void map(LongWritable key, Text values,Context context) throws IOException,InterruptedException
	{
		StringTokenizer tokens = new StringTokenizer(values.toString());
		while(tokens.hasMoreElements())
		{
			context.write(new Text(tokens.nextToken()), new IntWritable(1));
		}
	}

}
