package F8_Streams_Files_Dir_Exc;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;

public class _04_Count_Character_Type {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\user\\Desktop\\Java_Advanced\\src\\F8_Streams_Files_Dir_Exc\\input.txt";
        String content = Files.readString(Path.of(path));
        int countVowels=0;
        int countPunctuation=0;
        int otherSymbols=0;

        content = content.replaceAll("\\s+", "");
        for (char c : content.toCharArray()) {
            if (isVowel(c)) {
                countVowels++;
            } else if (isPunctuation(c)) {
                countPunctuation++;

            } else {
                otherSymbols++;

            }
        }

        PrintWriter writer= new PrintWriter("C:\\Users\\user\\Desktop\\Java_Advanced\\src\\F8_Streams_Files_Dir_Exc\\output.txt");
        writer.println("Vowels: "+ countVowels);
        writer.println("Other symbols: "+ otherSymbols);
        writer.println("Punctuation: "+ countPunctuation);
        writer.close();
    }

    private static boolean isPunctuation(char symbol) {
        return symbol=='!'|| symbol=='?' || symbol=='.'|| symbol==',';
    }


    private static boolean isVowel(char symbol) {
        return symbol=='a'||symbol=='e'||symbol=='i'||symbol=='o'||symbol=='u';
    }
}