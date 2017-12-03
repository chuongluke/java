package core;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.nio.file.Files;

public class DeseralizingObject {
    public static void main(String[] args) {
        try{
            File file = new File("test.txt");
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
            javax.swing.JButton button = (javax.swing.JButton)in.readObject();
            in.close();

            byte[] bytes = Files.readAllBytes(file.toPath());
            in = new ObjectInputStream(new ByteArrayInputStream(bytes));
            button = (javax.swing.JButton)in.readObject();
            in.close();
        }catch (Exception ioe){
            ioe.printStackTrace();
        }

    }
}
