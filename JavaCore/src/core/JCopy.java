/**
 * 
 */
package core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Copy a file
 * 
 * @author 0001
 *
 */
public class JCopy {
   
	public static void main(String[] args) {
		try {
			JCopy c = new JCopy();
			c.copyFile(new File("file.txt"), new File("filecopy.txt"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void copyFile(File in, File out) throws Exception{
		FileInputStream fis = new FileInputStream(in);
		FileOutputStream fos = new FileOutputStream(out);
		
		byte[] buf = new byte[1024];
		
		int i = 0;
		while((i = fis.read(buf)) != -1){
			fos.write(buf, 0, i);
		}
		fis.close();
		fos.close();
	}
}
