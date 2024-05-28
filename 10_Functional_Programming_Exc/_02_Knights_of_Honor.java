package F10_Functional_Programming_Exc;

import java.util.Arrays;
import java.util.Scanner;

public class _02_Knights_of_Honor {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(e->"Sir "+ e)
                .forEach(System.out::println);
    }
}
