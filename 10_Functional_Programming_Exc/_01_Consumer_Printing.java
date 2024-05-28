package F10_Functional_Programming_Exc;

import java.util.Arrays;
import java.util.Scanner;
import java.util.jar.JarOutputStream;

public class _01_Consumer_Printing {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .forEach(System.out::println);




    }
}
