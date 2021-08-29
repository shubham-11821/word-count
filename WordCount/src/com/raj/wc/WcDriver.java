package com.raj.wc;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;


public class WcDriver {
	public static void main(String args[]) throws Exception
	{
		Configuration conf = new Configuration();
		Job job = new Job();
		job.setJarByClass(WcDriver.class);
		job.setMapperClass(WcMapper.class);
		job.setReducerClass(WcReducer.class);
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(IntWritable.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);
		
		FileInputFormat.addInputPath(job, new Path("/home/raj/DF/Research/MapReduce/WordCount/input"));
		FileOutputFormat.setOutputPath(job, new Path("/home/raj/DF/Research/MapReduce/WordCount/output"));
		
		System.exit(job.waitForCompletion(true)?0:1);
		
		
	}

}
