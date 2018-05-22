package appsdeveloperblog.com;

import java.io.File;
import java.io.IOException;

public class CreateNewFile {

    public static void main(String[] args) {
        try {
            File file = new File("newfile.txt");
            if(file.createNewFile()){
                System.out.println("A new file is created!");
            }else{
                System.out.println("This file already exists.");
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
