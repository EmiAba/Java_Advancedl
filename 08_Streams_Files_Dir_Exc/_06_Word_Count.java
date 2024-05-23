package F8_Streams_Files_Dir_Exc;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class _06_Word_Count {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\user\\Desktop\\Java_Advanced\\src\\F8_Streams_Files_Dir_Exc\\words.txt";
        String path1 = "C:\\Users\\user\\Desktop\\Java_Advanced\\src\\F8_Streams_Files_Dir_Exc\\text.txt";

        String[] words = Files.readString(Path.of(path)).split("\\s+");
        String text = Files.readString(Path.of(path1));

        Map<String, Integer> wordCount = new LinkedHashMap<>();
        for (String word : words) {
            wordCount.put(word, 0);

        }

        for (String word : text.split("\\s+")) {
            if (wordCount.containsKey(word)) {
                int count = wordCount.get(word) + 1;
                wordCount.put(word, count);
            }
        }
        PrintWriter writer=new PrintWriter("C:\\Users\\user\\Desktop\\Java_Advanced\\src\\F8_Streams_Files_Dir_Exc\\result.txt");
        wordCount.entrySet().forEach(entry->writer.println(entry.getKey()+ " - "+ entry.getValue()));
        writer.close();

    }
}
