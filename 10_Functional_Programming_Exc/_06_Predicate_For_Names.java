package F10_Functional_Programming_Exc;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class _06_Predicate_For_Names {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int requiredLength=Integer.parseInt(scanner.nextLine());

        List<String> names = Arrays.stream(scanner.nextLine().split("\\s+")).toList();
        Predicate<String> predicate= name->name.length()<=requiredLength;

        names.stream()
                .filter(predicate)
                .forEach(System.out::println);



    }
}
