package F10_Functional_Programming_Exc;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class _03_Custom_Min_Function {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        List<Integer> numbers=Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Function<List<Integer>, Integer> functions=arr -> Collections.min(arr);

        Integer minNum=functions.apply(numbers);
        System.out.println(minNum);


    }
}
