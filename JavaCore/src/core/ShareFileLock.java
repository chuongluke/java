package core;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;


/**
 * Creating a Shared File Lock on a File
 * 
 * @author no_name
 *
 */
public class ShareFileLock {
	
	public static void main(String[] args) {
		try {
			File file = new File("Test.java");
			FileChannel channel = new RandomAccessFile(file, "rw").getChannel();
			
			FileLock lock = channel.lock(0, Long.MAX_VALUE, true);
			
			try {
				lock = channel.tryLock(0, Long.MAX_VALUE, true);
			} catch (OverlappingFileLockException e) {
				System.err.println(e);
			}
			
			boolean isShared = lock.isShared();
			lock.release();
			channel.close();
		} catch (Exception e) {
			System.err.println(e);
		}
	}

}
