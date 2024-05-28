package F9_Functional_Programming_Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class _03_Count_UPERCASE_Words {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String text=scanner.nextLine();
        Predicate<String> startsWithUpperCase=s->Character.isUpperCase(s.charAt(0));


        List<String> list = Arrays.stream(text.split("\\s+"))
                .filter(startsWithUpperCase)
                .toList();
        System.out.println(list.size());
        Consumer<String> printer= System.out::println;
        list.forEach(printer);

    }
}
