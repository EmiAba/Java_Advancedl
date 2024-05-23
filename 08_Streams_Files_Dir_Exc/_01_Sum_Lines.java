package F8_Streams_Files_Dir_Exc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class _01_Sum_Lines {
    public static void main(String[] args) throws IOException {


String path="C:\\Users\\user\\Desktop\\Java_Advanced\\src\\F8_Streams_Files_Dir_Exc\\input.txt";

        List<String> lines=Files.readAllLines(Path.of(path));

        for (String line : lines) {
            int sum=0;
            for( char symbol: line.toCharArray()){
                sum+=symbol;

            }
            System.out.println(sum);
        }


    }
}
