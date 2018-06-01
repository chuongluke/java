package data;

import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.MultimediaInfo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

public class Wavcut {

    public static boolean cut(String sourceFile, String targetfile, int start, int end){
        try {
            if(!sourceFile.toLowerCase().endsWith(".wav") || !targetfile.toLowerCase().endsWith(".wav")){
                return false;
            }

            File wav = new File(sourceFile);
            long t1 = getTimeLen(wav);
            if (start < 0 || end <= 0 || start >= t1 || end > t1 || start >= end){
                return false;
            }

            FileInputStream fis = new FileInputStream(wav);

            long wavSize = wav.length() - 44; //Audio data size (44 128kbps bit rate wav file header length)
            long splitSize = (wavSize / t1) * (end - start); //The size of the audio data interception
            long skipSize = (wavSize / t1) * start; //The interception of the audio data skip size

            int splitSizeInt = Integer.parseInt(String.valueOf(splitSize));
            int skipSizeInt = Integer.parseInt(String.valueOf(skipSize));


            ByteBuffer buf1 = ByteBuffer.allocate(4); //Storage file size, 4 represents a int occupancy bytes
            buf1.putInt(splitSizeInt+36);  //In the length of the file information
            byte[] flen = buf1.array();  //Representing the file length

            ByteBuffer buf2 = ByteBuffer.allocate(4);  //To store audio data size, 4 represents a int occupancy bytes
            buf2.putInt(splitSizeInt);  //In the data length information
            byte[] dlen = buf2.array();  //Representative data length

            flen = reverse(flen);  //Array inversion
            dlen = reverse(dlen);

            byte[] head = new byte[44];  //The definition of wav head information array
            fis.read(head, 0, head.length);  //Read the source wav file header information
            for(int i=0; i<4; i++){  //4 represents a int takes a number of bytes
                head[i+4] = flen[i];  //Replace the original header information in the file length
                head[i+40] = dlen[i];  //Replace the original header information in the data length
            }

            byte[] fbyte = new byte[splitSizeInt+head.length];  //Audio data interception
            for(int i=0; i<head.length; i++){  //In the header information is modified
                fbyte[i] = head[i];
            }

            byte[] skipBytes = new byte[skipSizeInt];  //Skip the store when the audio data interception
            fis.read(skipBytes, 0, skipBytes.length);  //Skip does not need the interception of data
            fis.read(fbyte, head.length, fbyte.length-head.length);  //Read data into the destination array to intercept
            fis.close();

            File target = new File(targetfile);
            if(target.exists()){  //If the destination file already exists, then delete the target file
                target.delete();
            }


            FileOutputStream fos = new FileOutputStream(target);
            fos.write(fbyte);
            fos.flush();
            fos.close();
        }catch(IOException e){
            System.out.println(e.getMessage());

            e.printStackTrace();
            return false;
        }
        return true;
    }

    private static byte[] reverse(byte[] array) {
        byte temp;

        int len = array.length;
        for (int i = 0; i < len/2; i++) {
            temp = array[i];
            array[i] = array[len-1-i];
            array[len-1-i] = temp;
        }

        return array;
    }

    public static long getTimeLen(File file){
        long tlen = 0;
        if (file!=null && file.exists()){
            Encoder encoder = new Encoder();

            try {
                MultimediaInfo m = encoder.getInfo(file);
                long ls = m.getDuration();
                tlen = ls/1000;
            }catch (Exception e){
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
        return tlen;
    }

    public static void main(String[] args) {
        System.out.println(cut("resource/TEST.WAV", "resource/test_one.wav", 0, 10));
    }
}
