package F8_Streams_Files_Dir_Exc;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class _03_ALL_Capitals {
    public static void main(String[] args) throws IOException {
        String path="C:\\Users\\user\\Desktop\\Java_Advanced\\src\\F8_Streams_Files_Dir_Exc\\input.txt";

       String content= Files.readString(Path.of(path));
       content=content.toUpperCase();

        BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter("C:\\Users\\user\\Desktop\\Java_Advanced\\src\\F8_Streams_Files_Dir_Exc\\output.txt"));
        bufferedWriter.write(content);
        bufferedWriter.close();

    }
}
