package F10_Functional_Programming_Exc;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _05_Reverse_and_Exclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());


int n=Integer.parseInt(scanner.nextLine());
        Collections.reverse(numbers);
numbers.stream()
        .filter(number->number %n != 0)
        .forEach(number -> System.out.print(number + " "));


    }
}
