package F8_Streams_Files_Dir_Exc;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class _02_Sum_Bytes {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader=new BufferedReader(new FileReader("C:\\Users\\user\\Desktop\\Java_Advanced\\src\\F8_Streams_Files_Dir_Exc\\input.txt"));
        int sum=0;


    String line=bufferedReader.readLine();
    while(line!=null){
        for (char c : line.toCharArray()) {
            sum+=c;

        }


        line=bufferedReader.readLine();

    }

       System.out.println(sum);









    }
}
