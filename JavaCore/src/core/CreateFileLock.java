package core;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;

/**
 * Creating a File Lock on a File
 * 
 * @author no_name
 *
 */
public class CreateFileLock {

	public static void main(String[] args) {
		try {
			File file = new File("Test.java");
			FileChannel channel = new RandomAccessFile(file, "rw").getChannel();
			FileLock lock = channel.lock();
			try{
				lock = channel.tryLock();
			}catch(OverlappingFileLockException e){
				System.err.println("1 "+e.getMessage());
			}
			
			lock.release();
			
			channel.close();
		} catch (Exception e) {
			System.err.println("2 "+e.getMessage());
		}
	}

}
