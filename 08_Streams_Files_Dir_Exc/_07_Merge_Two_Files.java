package F8_Streams_Files_Dir_Exc;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;

public class _07_Merge_Two_Files {
    public static void main(String[] args) throws IOException {

        String path1 = "C:\\Users\\user\\Desktop\\Java_Advanced\\src\\F8_Streams_Files_Dir_Exc\\inputOne.txt";
        String path2 = "C:\\Users\\user\\Desktop\\Java_Advanced\\src\\F8_Streams_Files_Dir_Exc\\inputTwo.txt";



        String firstFileContent= Files.readString(Path.of(path1));

        String secondFileContent= Files.readString(Path.of(path2));

        PrintWriter writer=new PrintWriter("C:\\Users\\user\\Desktop\\Java_Advanced\\src\\F8_Streams_Files_Dir_Exc\\output.txt");
        writer.println(firstFileContent);
        writer.println(secondFileContent);
        writer.close();

    }
}
