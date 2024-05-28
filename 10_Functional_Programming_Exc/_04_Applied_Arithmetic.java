package F10_Functional_Programming_Exc;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class _04_Applied_Arithmetic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Function<List<Integer>, List<Integer>> addFunction = list -> list.stream()
                .map(number -> number + 1).collect(Collectors.toList());

        Function<List<Integer>, List<Integer>> multiplyFunction = list -> list.stream()
                .map(number -> number * 2).collect(Collectors.toList());

        Function<List<Integer>, List<Integer>> subtractFunction = list -> list.stream()
                .map(number -> number - 1).collect(Collectors.toList());

        String command = scanner.nextLine();
        while (!command.equals("end")) {
            switch (command) {
                case "add" -> numbers = addFunction.apply(numbers);
                case "multiply" -> numbers = multiplyFunction.apply(numbers);
                case "subtract" -> numbers = subtractFunction.apply(numbers);
                case "print" -> numbers.forEach(number -> System.out.print(number + " "));
            }
            if (!command.equals("print")) {
                System.out.println(); // To separate different command results
            }
            command = scanner.nextLine();
        }


    }
}
