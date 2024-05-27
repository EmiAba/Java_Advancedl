package F9_Functional_Programming_Lab;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _01_Sort_Even_Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int two=2;
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .filter(n -> n % two == 0)
                .collect(Collectors.toList());

        System.out.println(numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ")));


        Collections.sort(numbers); /// tezi se modificirat
        ///immutaable sa, ne mogat da se promenqt
        System.out.println(numbers.stream()
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(", ")));
    }

}
