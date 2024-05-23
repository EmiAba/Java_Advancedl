package F8_Streams_Files_Dir_Exc;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class _05_Line_Numbers {
    public static void main(String[] args) throws IOException {
        String path="C:\\Users\\user\\Desktop\\Java_Advanced\\src\\F8_Streams_Files_Dir_Exc\\inputLineNumbers.txt";

        List<String> lines= Files.readAllLines(Path.of(path));

        PrintWriter writer= new PrintWriter("C:\\Users\\user\\Desktop\\Java_Advanced\\src\\F8_Streams_Files_Dir_Exc\\output.txt");
        int counter=1;
        for (String line : lines) {
            String output=String.format("%d. %s", counter, line);
            counter++;
            writer.println(output);



        }


        writer.close();

    }
}
