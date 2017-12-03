package core;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DetectASCII {
    public static void main(String[] args) {
        try {
            BufferedReader inStream = new BufferedReader(new InputStreamReader(System.in));
            int a;
            for (int i = 0; i < 26; i++) {
                System.out.println("Please enter a character : ");
                a = (int)System.in.read();
                System.out.println("The integer code for " + (char)a + " is " + (int)a);
                inStream.readLine();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
