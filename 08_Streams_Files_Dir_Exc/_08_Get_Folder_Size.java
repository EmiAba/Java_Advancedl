package F8_Streams_Files_Dir_Exc;

import java.io.File;

public class _08_Get_Folder_Size {
    public static void main(String[] args) {

        String folderPath = "C:\\Users\\user\\Desktop\\Java_Advanced\\src\\F8_Streams_Files_Dir_Exc\\ Exercises Resources";

        File folder = new File(folderPath);
        int size = 0;

        for (File file : folder.listFiles()) {
            size += file.length();

        }
        System.out.println("Folder size: " + size);
    }
}