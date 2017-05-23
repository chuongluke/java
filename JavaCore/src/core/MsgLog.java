package core;

import java.io.FileWriter;
import java.io.IOException;
import java.text.*;
import java.util.*;

/**
 * Creating a Log file
 * 
 * @author no_name
 *
 */
public class MsgLog {

	protected static String defaultLogFile = "msglog.txt";
	
	public static void write(String s) throws IOException{
		write(defaultLogFile, s);
	}
	
	public static void write(String f, String s) throws IOException{
		TimeZone tz = TimeZone.getTimeZone("EST");
		
		Date now = new Date();
		DateFormat df = new SimpleDateFormat("yyyy.mm.dd hh:mm:ss");
		df.setTimeZone(tz);
		String currentTime = df.format(now);
		
		FileWriter aWriter = new  FileWriter(f, true);
		aWriter.write(currentTime + "" + "s" + "\n");
		aWriter.flush();
		aWriter.close();
		
	}
	
	
	public static void main(String[] args) throws IOException {
		write("Ok");
	}
	
}
